package com.jz.bigdata.other.demobreak;

/**
 * 调出双重循环
 */
public class Break {
    public static void main(String[] args) {
        outjzhsi:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if(j==2){
                    break outjzhsi;
                }
            }
        }
        System.out.println("干");
    }
}
