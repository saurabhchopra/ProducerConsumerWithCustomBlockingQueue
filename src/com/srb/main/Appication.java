package com.srb.main;

import com.srb.main.consumer.Consumer;
import com.srb.main.producer.Producer;
import com.srb.main.queue.CustomBlockingQueue;

public class Appication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomBlockingQueue blockingQueue = new CustomBlockingQueue();
		Thread producer = new Thread(new Producer(blockingQueue));
		Thread consumer = new Thread(new Consumer(blockingQueue));
		producer.start();
		consumer.start();
	}
}
