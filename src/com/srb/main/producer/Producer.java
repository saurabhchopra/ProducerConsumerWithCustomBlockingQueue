package com.srb.main.producer;

import com.srb.main.queue.CustomBlockingQueue;

public class Producer implements Runnable {
	private CustomBlockingQueue blockingQueue;

	/**
	 * @param blockingQueue
	 */
	public Producer(CustomBlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	/**
	 * @param object
	 * @throws InterruptedException
	 */
	public void produce(Object object) throws InterruptedException {
		blockingQueue.enqueue(object);
		Thread.sleep(10000);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			try {
				String value = "Item " + i;
				System.out.println("Item produce " + value);
				produce(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
