package com.jz.bigdata.myinternet.mysocketio.thenetty.udp;/**
 * Created by jazzyshi on 2019/11/8.
 */

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThreadLocalRandom;


/**
 * @ClassName ServerHandler
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/8 10:02
 * @Version 1.0
 **/
public class ServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    // 谚语列表
    private static final String[] DICTIONARY = {
            "只要功夫深，铁棒磨成针。",
            "旧时王谢堂前燕，飞入寻常百姓家。",
            "洛阳亲友如相问，一片冰心在玉壶。",
            "一寸光阴一寸金，寸金难买寸光阴。",
            "老骥伏枥，志在千里。烈士暮年，壮心不已!"
    };

    private String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoteId];
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
        String req = datagramPacket.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if("cha".equals(req)){
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语查询结果："+nextQuote(),CharsetUtil.UTF_8),datagramPacket.sender()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
