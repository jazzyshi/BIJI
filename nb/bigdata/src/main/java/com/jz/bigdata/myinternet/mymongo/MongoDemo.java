package com.jz.bigdata.myinternet.mymongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDemo {

    public static void main(String[] args){
        //连接到mongodb服务
        MongoClient mongoClient = new MongoClient("192.168.170.10",27017);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("jazzyshi");

        //创建结合
        mongoDatabase.createCollection("collection1");
        //获取结合
        MongoCollection<Document> collection = mongoDatabase.getCollection("collection1");
        //插入文档
        Document document = new Document("title","MongoDB")
                            .append("description","主题秒杀")

    }
}
