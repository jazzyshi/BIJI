package com.jz.bigdata.gof.build;/**
 * Created by jazzyshi on 2019/9/11.
 */

/**
 * @ClassName AreaShip
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/11 17:46
 * @Version 1.0
 **/
public class AreaShip {
    String ranliao;
    String waibaozhuang;
    String weixin;


    @Override
    public String toString() {
        return ""+ranliao+" "+waibaozhuang+" "+weixin;
    }

    public String getRanliao() {
        return ranliao;
    }

    public void setRanliao(String ranliao) {
        this.ranliao = ranliao;
    }

    public String getWaibaozhuang() {
        return waibaozhuang;
    }

    public void setWaibaozhuang(String waibaozhuang) {
        this.waibaozhuang = waibaozhuang;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
}
