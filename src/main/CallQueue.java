package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CallQueue
implements Iterable<Caller>
{
	private Queue<Caller> callQueue = new LinkedList<Caller>();
	
	/**
	 * Adds a caller to the specified queue
	 * @param caller the caller to add
	 */
	public void addCaller(Caller caller)
	{
		callQueue.add(caller);
	}
	
	public Caller removeCaller()
	{
		return callQueue.poll();
	}

	/**
	 * Returns an iterator over the queue
	 * @return an iterator
	 */
	@Override
	public Iterator<Caller> iterator() 
	{
		return callQueue.iterator();
	}
}
