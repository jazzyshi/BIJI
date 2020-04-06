//package com.jz.bigdata.hadoop;
//
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FSDataOutputStream;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IOUtils;
//
//import java.io.*;
//
//public class HDFSDemo {
//    static Configuration conf = null;
//    static FileSystem fs = null;
//
//    public static void conn() throws IOException {
//
//        conf = new Configuration(false);
//        conf.set("fs.defaultFS","hdfs://mycluster");
//        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//        fs = FileSystem.get(conf);
//    }
//    public static void close() throws Exception{
//        fs.close();
//    }
//    public static void testConf(){
//        System.out.println(conf.get("fs.defaultFS"));
//    }
//    public static void mkdir() throws Exception{
//
//        Path dir = new Path("/sxt");
//        if(!fs.exists(dir)){
//            fs.mkdirs(dir );
//        }
//    }
//    public static void uploadFile() throws Exception{
//
//        Path file = new Path("/sxt/ok.txt");
//        FSDataOutputStream output = fs.create(file );
//
//        InputStream input = new BufferedInputStream(new FileInputStream(new File("c:\\nginx")) ) ;
//
//        IOUtils.copyBytes(input, output, conf, true);
//
//    }
//
//    public static void main(String[] args) throws IOException {
//         conn();
//    }
//
//}
