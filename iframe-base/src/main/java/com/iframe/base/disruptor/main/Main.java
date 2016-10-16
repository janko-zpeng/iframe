package com.iframe.base.disruptor.main;

import com.iframe.base.disruptor.events.TestEvent;
import com.iframe.base.disruptor.factorys.TestEventFactory;
import com.iframe.base.disruptor.handlers.TestEventHandler;
import com.iframe.base.disruptor.producers.LogTimesProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author janko
 * @date 2016/10/16
 * @desc
 */
public class Main {
	public static void main(String[] args) {

		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();
		// The factory for the event
		TestEventFactory factory = new TestEventFactory();
		// Specify the size of the ring buffer, must be power of 2.
		int bufferSize = 1024;
		// Construct the Disruptor
		Disruptor<TestEvent> disruptor = new Disruptor<TestEvent>(factory, bufferSize, executor);
		// Connect the handler
		disruptor.handleEventsWith(new TestEventHandler());
		// Start the Disruptor, starts all threads running
		disruptor.start();
		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<TestEvent> ringBuffer = disruptor.getRingBuffer();

		LogTimesProducer producer = new LogTimesProducer(ringBuffer);

		ByteBuffer bb = ByteBuffer.allocate(8);
		long a = System.currentTimeMillis();
		for (long l = 0; l < 1024 * 1024; l++) {
			bb.putLong(0, l);
			producer.count();
		}

		long c = System.currentTimeMillis();
		System.out.println(c - a);

	}
}
