package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A queue of callers, implementing methods to add and remove elements as well as iterate over them
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
public class CallQueue
implements Iterable<Caller>
{
	private Queue<Caller> callQueue = new LinkedList<Caller>();
	
	/**
	 * Adds a caller to the queue
	 * @param caller the caller to add
	 * @see CallQueue#add(String, String)
	 */
	public void add(Caller caller)
	{
		callQueue.add(caller);
	}
	
	/**
	 * Creates a new caller with the specified name and phone number and adds it to the queue
	 * @param name the name of the caller to add
	 * @param phoneNumber the phone number of the caller to add
	 * @see CallQueue#addCaller(Caller)
	 */
	public void add(String name, String phoneNumber)
	{
		callQueue.add(new Caller(name, phoneNumber));
	}
	
	/**
	 * Removes and returns the first caller in queue
	 * @return the first caller in the queue
	 */
	public Caller poll()
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