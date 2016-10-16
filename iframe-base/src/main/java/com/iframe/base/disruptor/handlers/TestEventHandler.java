package com.iframe.base.disruptor.handlers;

import com.iframe.base.disruptor.events.TestEvent;
import com.lmax.disruptor.EventHandler;

/**
 * @author janko
 * @date 2016/10/16
 * @desc
 */
public class TestEventHandler implements EventHandler<TestEvent> {
	public void onEvent(TestEvent event, long sequence, boolean endOfBatch) throws Exception {
//		System.out.println(event.getValue());
	}
}
