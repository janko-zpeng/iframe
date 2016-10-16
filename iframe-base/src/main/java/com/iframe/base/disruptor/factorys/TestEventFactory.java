package com.iframe.base.disruptor.factorys;

import com.iframe.base.disruptor.events.TestEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author janko
 * @date 2016/10/16
 * @desc
 */
public class TestEventFactory  implements EventFactory<TestEvent> {
	public TestEvent newInstance() {
		return new TestEvent();
	}
}
