package com.iframe.base.disruptor.producers;

import com.iframe.base.disruptor.events.TestEvent;
import com.lmax.disruptor.RingBuffer;
import com.sun.corba.se.impl.ior.ByteBuffer;
import lombok.*;

/**
 * @author janko
 * @date 2016/10/16
 * @desc
 */

@Getter
@Setter
@NoArgsConstructor
public class LogTimesProducer {

	private RingBuffer<TestEvent> ringBuffer;

	public LogTimesProducer(RingBuffer<TestEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}


	public void count(){
		long seq = ringBuffer.next();

		try {
			TestEvent testEvent = ringBuffer.get(seq);
			testEvent.setValue(1);
		}finally {
			ringBuffer.publish(seq);
		}
	}
}
