package com.jz.bigdata.algorithm.test;

import java.util.ArrayList;

public class TT {

    public static ArrayList<Integer> mergeArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        // 在这里写代码
        int length = arr1.size() + arr2.size();
        ArrayList<Integer> temp = new ArrayList<>();
        int a1 = 0;
        int a2 = 0;
        int begin = 0;
        while(length >0){

            if(a2 == arr2.size()){
                if(a1 < arr1.size()){
                    temp.add(arr1.get(a1++));
                }
            }else{
                if(a1 < arr1.size() && arr1.get(a1) < arr2.get(a2)){
                    temp.add(arr1.get(a1++));
                }
            }
            if(a1 == arr1.size()){
                if (a2 < arr2.size()) {
                    temp.add(arr2.get(a2++));
                }
            }else {
                if (a2 < arr2.size() && arr1.get(a1) >= arr2.get(a2)) {
                    temp.add(arr2.get(a2++));
                }
            }
            length--;
        }
        return temp;
    }



    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(5);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);


        ArrayList<Integer> result = mergeArray(arr1, arr2);
        for (Integer num : result) {
            System.out.println(num);
        } // 期望输出 1 2 3 4 5 6
    }
}
