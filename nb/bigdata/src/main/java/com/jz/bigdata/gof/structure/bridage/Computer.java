package com.jz.bigdata.gof.structure.bridage;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName Computer
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/16 15:15
 * @Version 1.0
 **/
public class Computer {

    protected Brand brand;

    public Computer(Brand brand){
        this.brand = brand;
    }

    public void sale(){
        brand.sale();
    }
}

class DestTop extends Computer{

    public DestTop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale(){
        super.sale();
        System.out.println("销售台式机");
    }
}

class NoteBook extends Computer{

    public NoteBook(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}
