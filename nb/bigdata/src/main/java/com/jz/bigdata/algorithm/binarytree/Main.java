package com.jz.bigdata.algorithm.binarytree;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Node nodeD = new Node("D",null,null);
        Node nodeE = new Node("E",null,null);
        Node nodeF = new Node("F",null,null);
        Node nodeB = new Node("B",nodeD,nodeE);
        Node nodeC = new Node("C",null,nodeF);
        Node nodeA = new Node("A",nodeB,nodeC);

        BinaryTree binaryTree = new BinaryTree(nodeA);
//        System.out.println(binaryTree.size());
//        System.out.println(binaryTree.height());
//        System.out.println(binaryTree.find("B"));

        //binaryTree.preSort();
        //binaryTree.middleSort();
        //binaryTree.postSort();
        //binaryTree.levelSort();
        //binaryTree.middleSortByStack();
     //   HttpGet request = new HttpGet("http://www.baidu.com");
        HttpClient httpClient = new DefaultHttpClient();


        HttpPost request = new HttpPost("http://www.oschina.net/");
        request.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        String response = httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);

    }


}
