package com.jz.bigdata.myinternet.mydisruptor.base;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Disruptor 3.0提供了lambda式的API。这样可以把一些复杂的操作放在Ring Buffer，
 * 所以在Disruptor3.0以后的版本最好使用Event Publisher或者Event Translator来发布事件
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author 北京尚学堂（alienware）
 * @since 2015年11月23日
 */
public class LongEventProducerWithTranslator {

	private final RingBuffer<LongEvent> ringBuffer;

	//一个translator可以看做一个事件初始化器，publicEvent方法会调用它
	//填充Event
	private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = 
			new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
				@Override
				public void translateTo(LongEvent event, long sequeue, ByteBuffer buffer) {
					event.setValue(buffer.getLong(0));
				}
			};
	

	public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void onData(ByteBuffer buffer){
		ringBuffer.publishEvent(TRANSLATOR, buffer);
	}
	
	
	
}
