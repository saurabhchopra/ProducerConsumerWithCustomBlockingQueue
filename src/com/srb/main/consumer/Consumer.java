package com.srb.main.consumer;

import com.srb.main.queue.CustomBlockingQueue;

public class Consumer implements Runnable {
	private CustomBlockingQueue blockingQueue;

	/**
	 * @param blockingQueue
	 */
	public Consumer(CustomBlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public Object consume() throws InterruptedException {
		Thread.sleep(20000);
		return blockingQueue.dequeue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Item Consume " + consume().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
