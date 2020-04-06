package com.jz.bigdata.other.bitset;

import org.bson.io.BsonOutput;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class DemoBitSet {

    public static void main(String[] args) {
        ranDomBigData();

    }


    public static void ranDomBigData(){
        BitSet bitSet = new BitSet(100000000);
        for(int i=0;i<10000000;i++){
            bitSet.set(i);
        }
        for (int i = 0; i < bitSet.size(); i++) {
            if(bitSet.get(i)){
                System.out.println(i);
            }
        }
    }


    /**
     * 字节数组转化为BitSet
     * @param bytes
     * @return
     */
    public static BitSet byteArray2BitSet(byte[] bytes){
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index=0;
        for(int i =0 ;i< bytes.length;i++){
            for(int j=7;j>=0;j--){
                bitSet.set(index++,(bytes[i] & (1 << j)) >> j == 1 ? true:false);
            }
        }
        return bitSet;
    }

    /**
     * 把bitSet转化为byte数组
     * @param bitSet
     * @return
     */
    public static byte[] bitSet2ByteArray(BitSet bitSet){

        byte[] byteArray = new byte[bitSet.size()/8];
        for(int i=0;i<bitSet.size();i++){
            int index= i/8;
            int offset = 7- i % 8;
            System.out.println(i+"="+bitSet.get(i));
            byteArray[index] |= (bitSet.get(i)?1:0) << offset;
        }
        return byteArray;
    }
    /**
     * 进行数字排序
     */
    public static void sortArray(){
        int[] array = new int[]{423,700,9999,356,6400,1,2,3,3,2,2,2};
        //虽然可以动态扩容，但尽量在构造时指定估算大小，默认为64
        BitSet bitSet = new BitSet(1 << 14);
        for(int temp : array){
            bitSet.set(temp);
        }
        //剔除重复数字后的元素个数
        int bitLen = bitSet.cardinality();
        //进行排序，即把bit为true的元素复制到另一个数组
        int[] orderArray = new int[bitLen];
        int k=0;
        for(int i=bitSet.nextSetBit(0);i>=0;i=bitSet.nextSetBit(i+1)){
            orderArray[k++] = i;
        }
        System.out.println(Arrays.toString(orderArray));

    }

    /**
     *  求素数 有无限个。一个大于1的自然数，如果除了1和它本身外，
     *  不能被其他自然数整除(除0以外）的数称之为素数(质数） 否则称为合数
     */
    public static void computePrime(){
        BitSet sieve = new BitSet(1024);
        int size = sieve.size();

        for(int i=2;i<size;i++){
            sieve.set(i);
        }

        int finalBit = (int)Math.sqrt(sieve.size());
        for(int i=2;i<finalBit;i++){
            if(sieve.get(i)){
               for(int j= 2 * i;j<size;j+=i){
                   sieve.clear(j);
               }
            }
        }
        int counter = 0;
        for(int i = 0;i<size;i++){
            if(sieve.get(i)){
                System.out.printf("%5d",i);
                if(++counter % 15 == 0){
                    System.out.println();
                }
            }
        }
    }

    /**
     *求一个字符串中包含的char
     */
    public static void containChars(String str){

        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());
        for(int i=0;i<str.length();i++){
            System.out.println((int)str.charAt(i));
            bitSet.set(str.charAt(i)); //set bit for char
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = bitSet.size();
        for(int i=0;i<size;i++){
            if(bitSet.get(i)){
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    //简单操作
    public static void operate(){
        BitSet bitSet1 = new BitSet(16);
        BitSet bitSet2 = new BitSet(16);

        //set some bits
        for(int i=0;i<16;i++){
            if(i % 2 == 0) bitSet1.set(i);
            if(i % 5 == 0) bitSet2.set(i);
        }
        System.out.println(bitSet1);
        System.out.println(bitSet1.size());
        System.out.println(bitSet1.length());
        System.out.println(bitSet2);
        System.out.println(bitSet2.size());
        System.out.println(bitSet2.length());
//        //add bits
//        bitSet2.and(bitSet1);
//        System.out.println("and="+bitSet2);
//        //or bits
//        bitSet2.or(bitSet1);
//        System.out.println("or="+bitSet2);
        //XOR bits
//        bitSet2.xor(bitSet1);
//        System.out.println(bitSet2);
    }
    //简单操作
    public static void operate1(){
        String names[] = { "Java", "Source", "and", "Support" };
        BitSet bits = new BitSet();
        for (int i = 0, n = names.length; i < n; i++) {
            if ((names[i].length() % 2) == 0) {
                bits.set(i);
            }
        }

        System.out.println(bits);
        System.out.println("Size : " + bits.size());
        System.out.println("Length: " + bits.length());
        for (int i = 0, n = names.length; i < n; i++) {
            if (bits.get(i)) {
                System.out.println(names[i] + " is odd");
            }
        }
        BitSet bites = new BitSet();
        bites.set(0);
        bites.set(1);
        bites.set(2);
        bites.set(3);
        bites.andNot(bits);
        System.out.println(bites);

    }
}
