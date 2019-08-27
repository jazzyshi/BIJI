package com.hansight;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.admin.indices.stats.*;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseException;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{


    static Properties pro = new Properties();

    static String regexIP     = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
    static String regixDigit  = "[0-9]{1,}";
    static Map<String, DateTimeFormatter> formatterMap = new HashMap<>();
    static String portdefault = "9300";
    static String deviceIPS   = "";
    static String indexPrefix = "";
    static String indexType   = "";
    static String sTime   = "";
    static String eTime     = "";
    static TransportClient client;
    static IndicesAdminClient adminClient;
    static RestClient restClient;
    static int waitSecondes = 1;

    static String clusterName = "";
    static String clusterNodes = "";

    static {
        FileInputStream in = null;
        try {
            in = new FileInputStream("app.properties");
            pro.load(in);
            in.close();

            deviceIPS = pro.getProperty("device_ips");
            indexPrefix = pro.getProperty("index_prefix");
            indexType = pro.getProperty("index_type");
            clusterName = pro.getProperty("cluster_name");
            clusterNodes = pro.getProperty("cluster_nodes");
            sTime = pro.getProperty("start_time");
            eTime   = pro.getProperty("end_time");
            waitSecondes = Integer.parseInt(pro.getProperty("wait_secondes"));

            formatterMap.put("event_",DateTimeFormatter.ofPattern("yyyyMMdd"));
            formatterMap.put("incident_alarm_",DateTimeFormatter.ofPattern("yyyyMM"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        client = getTransportClient();

        adminClient = client.admin().indices();

        restClient = getRestClient();

    }


    public static void main( String[] args ) {


        try {
            System.out.println("开始创建客户端!");

            if (null == client) {
                System.out.println("创建客户端失败!");
                return;
            }
            System.out.println("创建客户端成功!");

            //获取要清楚的设备
            String[] dArray = deviceIPS.split(",|，");
            //获取所有索引
            List<String> iLists = getIndexName(sTime,eTime,indexPrefix);
            for (String s : iLists){
                if(!indexExists(s)){
                    System.out.println(s+"不存在");
                    continue;
                }

                boolean isClose = isIndexClose(s);
                if(isClose){
                    if(openIndex(s)){
                        Thread.sleep(waitSecondes * 1000);
                        while(!isIndexSearch(s)){
                            System.out.println(s+"持续loading中。。。请再等待"+waitSecondes+"s");
                        }
                        System.out.println(s+"打开完成");

                    }
                }

                delete(dArray,s);

                //把原先关闭的索引再关闭上
                if(isClose){
                    System.out.println(s+"关闭索引");
                    closeIndex(s);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != client){
                client.close();
            }
            if(null != adminClient){
                adminClient = null;
            }
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static RestClient getRestClient() {

        String[] temp = clusterNodes.split(",|，");

        HttpHost[] aa = new HttpHost[temp.length];

        for (int i=0 ; i < temp.length; i++) {
            String[] ipAndPort = temp[0].trim().split(":|：");
            String ip =  ipAndPort[0].trim();
            aa[i] = new HttpHost(ip,9200);
        }

        return RestClient.builder(aa).build();

    }

    public static boolean indexExists(String index){
        IndicesExistsRequest request = new IndicesExistsRequest(index);
        IndicesExistsResponse response = adminClient.exists(request).actionGet();
        if (response.isExists()) {
            return true;
        }
        return false;
    }

    /**
     * 索引统计
     *
     * @param index
     */
    public static void indexStatus(String index) {

        IndicesStatsResponse response = adminClient.prepareStats(index).all().get();
        ShardStats[] shardStatsArray = response.getShards();
        for (ShardStats shardStats : shardStatsArray) {
            System.out.println("shardStats "+ shardStats.getDataPath());
        }
//        Map<String, IndexStats> indexStatsMap = response.getIndices();
//        for (String key : indexStatsMap.keySet()) {
//            System.out.println("indexStats "+indexStatsMap.get(key));
//        }
//        CommonStats commonStats = response.getTotal();
//        System.out.println("total commonStats "+ commonStats.getGet().current());
//        commonStats = response.getPrimaries();
//        System.out.println("primaries commonStats {}"+ commonStats.toString());
    }

    /**
     * 关闭索引
     *
     * @param index
     * @return
     */
    public static boolean closeIndex(String index) {
        CloseIndexResponse response = adminClient.prepareClose(index).get();
        return response.isAcknowledged();
    }


    /**
     * 打开索引
     *
     * @param index
     * @return
     */
    public static boolean openIndex(String index) {

        OpenIndexResponse response = adminClient.prepareOpen(index).get();
        System.out.println(index+"开始打开");
        return response.isAcknowledged();
    }

    /**
     * 判断索引是否关闭
     * @param index
     * @return
     * @throws Exception
     */
    public static boolean isIndexClose(String index) throws Exception {
        String method = HttpGet.METHOD_NAME;
        String endpoint = String.format("/%s/_stats", index);
        try {
            restClient.performRequest(method, endpoint);
        } catch (ResponseException e) {
            try {
                Response response = e.getResponse();
                JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
                JSONObject error = jsonObject.getJSONObject("error");
                if ("closed".equals(error.get("reason"))) {
                    System.out.println(index+"处于关闭状态");
                    return true;
                } else {
                    System.out.println(index+"正在加载中");
                    throw new Exception(String.valueOf(error.get("reason")));
                }
            } catch (IOException e1) {
                throw new Exception(e);
            }
        } catch (IOException e) {
            throw new Exception(e);
        }
        return false;
    }

    public static boolean isIndexSearch(String index) throws Exception {
        String method = HttpGet.METHOD_NAME;
        String endpoint = String.format("/%s/_search", index);
        try {
            restClient.performRequest(method, endpoint);
        } catch (ResponseException e) {
            Response response = e.getResponse();
            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            System.out.println(jsonObject);
            return false;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
        return true;
    }


    public static List<String> getIndexName(String ssTime, String eeTime, String indexP) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long startTime = 0L;
        long endTime = 0l;
        try {
            startTime = sdf.parse(ssTime).getTime();
            endTime   = sdf.parse(eeTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> rsList = new ArrayList<>();
        long temp;
        if(endTime < startTime){
            temp = startTime;
            startTime = endTime;
            endTime = temp;
        }

        while (startTime <= endTime) {
            rsList.add(getIndex(indexP, startTime));
            startTime = startTime + 1000 * 60 * 60 * 24L;
        }
        return rsList;
    }

    /**
     * Description: get index, format is indexPrefix + yyyyMMdd
     *
     * @Date: 2018/1/20
     */
    public static String getIndex(String indexPrefix, Long timestamp) {
        if (formatterMap.get(indexPrefix) != null) {
            LocalDate dt = (timestamp == null ? LocalDate.now() : LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()).toLocalDate());
            return indexPrefix + dt.format(formatterMap.get(indexPrefix));
        } else {
            return indexPrefix;
        }
    }

    private static void search() {

        //构建一个query 即查询条件
        QueryBuilder match = QueryBuilders.matchQuery("event_name","waf_traffic");
        //根据查询条件构建一个查询问句
        SearchRequestBuilder search = client.prepareSearch("event_20190627")
                .setQuery(match)
                .setTypes("event")  //指定类型 可选
                .setFrom(0).setSize(10); //分页 可选

        //搜索返回搜索结果
        SearchResponse response = search.get();
        //命中的文档
        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());

    }

    /**
     * 获取操作连接
     * @return
     */
    public static TransportClient getTransportClient() {


        if(null == clusterName || clusterName.trim().length() == 0 || null == clusterNodes || clusterNodes.trim().length() == 0){
            System.out.println("集群名称或节点为空");
            return null;
        }

        if(null == deviceIPS || "".equals(deviceIPS)){
            System.out.println("要删除的设备IP为空，退出!!");
            return null;

        }
        String[] ipArray =  deviceIPS.split(",|，");
        for(String aa : ipArray){
            if(!aa.trim().matches(regexIP)){
                System.out.println("要删除的设备IP不合法，退出!!");
                return null;
            }
        }

        // 集群设置
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)//集群名称
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        //添加集群地址和tcp服务端口 IP是由集群的各个node的ip组成的数组
        try {


            for (String clusterNode : clusterNodes.split(",|，")) {
                String[] ipAndPort = clusterNode.trim().split(":|：");
                String ip =  ipAndPort[0].trim();
                String port = portdefault;
                if(ipAndPort.length == 2){
                    port = ipAndPort[1].trim();
                }

                if(!ip.matches(regexIP)){
                    System.out.println("IP格式不对");
                    break;
                }
                if(!port.matches(regixDigit)){
                    System.out.println("端口必须为数字");
                    break;
                }

                client.addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(ip), Integer.parseInt(port)));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    //删除数据
    public static void delete(String[] allDeviceIps,String indexName){

        System.out.println(indexName+"清理数据开始。。。。。。。");


        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(indexName).setTypes(indexType)
                .setSize(2000)
                .setScroll(new TimeValue(6000));

        BulkRequestBuilder bulkRequest = client.prepareBulk();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        for(String ip : allDeviceIps){
            queryBuilder.should(QueryBuilders.termQuery("dev_address", ip.trim()));
        }


        searchRequestBuilder.setQuery(queryBuilder);

        SearchResponse response = null;

        try {
            response = searchRequestBuilder.execute().get();

            while (response.getHits().getHits().length > 0) {

                System.out.println(indexName+"清理条数："+response.getHits().getHits().length);

                for(SearchHit hit : response.getHits()){
                    String id = hit.getId();
                    bulkRequest.add(client.prepareDelete(indexName, indexType, id).request());
                }

                BulkResponse bulkResponse = bulkRequest.get();
                if (bulkResponse.hasFailures()) {
                    for(BulkItemResponse item : bulkResponse.getItems()){
                        System.out.println("删除失败："+item.getFailureMessage());
                    }
                } else {
                    System.out.println(indexName+"删除成功");
                }

                //需不需要清空（一会测试）
                bulkRequest = client.prepareBulk();

                response = client.prepareSearchScroll(response.getScrollId())
                        .setScroll(new TimeValue(6000))
                        .execute()
                        .actionGet();
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            if(e.toString().contains("No search context found for")){
                delete(allDeviceIps,indexName);
            }
        }

        System.out.println(indexName+"清理数据结束。。。。。。。");

    }

}
