package com.jz.bigdata.myinternet.mymongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class MongoDemo {

    public static void main(String[] args){

        List<ServerAddress> seeds = new ArrayList<>();
        seeds.add(new ServerAddress("host10",27017));
        seeds.add(new ServerAddress("host20",27017));
        seeds.add(new ServerAddress("host30",27017));
        //连接到mongodb服务
//        MongoClient mongoClient = new MongoClient("192.168.170.10",27017);
        MongoClient mongoClient = new MongoClient(seeds);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("jazzyshi");

        //创建结合
       // mongoDatabase.createCollection("collection1");
        //获取结合
        MongoCollection<Document> collection = mongoDatabase.getCollection("collection1");
        //插入文档
        Document document = new Document("title","MongoDB")
                            .append("description","主题秒杀")
                            .append("author","jazzyshi");
        collection.insertOne(document);
        //获取结合并检索所有文档
        collection = mongoDatabase.getCollection("collection1");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
        //更新文档
        collection.updateMany(Filters.eq("author","jazzyshi"),
                new Document("$set",new Document("author","jazzyshi1")));
        //检查更新结果
        collection = mongoDatabase.getCollection("collection1");
        FindIterable<Document> findIterable1 = collection.find();
        MongoCursor<Document> mongoCursor1 = findIterable1.iterator();
        while (mongoCursor1.hasNext()){
            System.out.println(mongoCursor1.next());
        }
        //删除文档
        collection.deleteMany(Filters.eq("author","jazzyshi1"));

    }
}
