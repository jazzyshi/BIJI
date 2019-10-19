package com.shijizhuo.gof.structure.flyweight;

/**
 * Created by jzshi on 2019/7/2.
 */
public class Client {
    public static void main(String[] args) {
        PieceFlyWeight piece1 = PieceFlyWeightFactory.getPiece("黑色");
        PieceFlyWeight piece2 = PieceFlyWeightFactory.getPiece("黑色");
        System.out.println(piece1);
        System.out.println(piece2);
        OutPutLocation out1 = new OutPutLocation("1.5","1.5");
        OutPutLocation out2 = new OutPutLocation("3.2","3.2");
        piece1.display(out1);
        System.out.println(piece1);
        System.out.println(piece2);
        piece1.display(out2);
    }
}
