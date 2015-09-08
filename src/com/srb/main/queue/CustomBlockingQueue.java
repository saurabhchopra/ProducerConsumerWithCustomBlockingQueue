package com.srb.main.queue;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue {
	private List list = new LinkedList();
	private int size = 10;

	/**
	 * @param item
	 * @throws InterruptedException
	 */
	public synchronized void enqueue(Object item) throws InterruptedException {
		while (list.size() == size) {
			wait();
		}
		if (list.size() == 0) {
			notifyAll();
		}
		list.add(item);
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Object dequeue() throws InterruptedException {
		while (list.size() == 0) {
			wait();
		}
		if (list.size() == size) {
			notifyAll();
		}
		return list.remove(0);
	}
}
