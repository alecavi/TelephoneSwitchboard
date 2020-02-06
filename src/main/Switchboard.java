package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Switchboard 
{	
	public static final Scanner scanner = new Scanner(System.in);
	
	private List<CallQueue> callQueues;
	
	/**
	 * Creates a switchboard with the specified number of parallel queues
	 * @param queuesCount
	 */
	public Switchboard(int queuesCount)
	{
		callQueues = new ArrayList<CallQueue>();
		for(int i=0; i<queuesCount; i++)
		{
			callQueues.set(i, new CallQueue());
		}
	}
	
	/**
	 * Enters the switchboard CLI menu
	 */
	public void menu()
	{
		
	}
	
	/**
	 * Prompts the user for a number representing an existing queue until one is input
	 * @return the input number
	 */
	private int promptForQueue()
	{
		while(true)
		{
			System.out.println("Input a queue index (between 0 and" + callQueues.size() + ")");
			if(scanner.hasNextInt())
			{
				int index = scanner.nextInt();
				scanner.next(); //Cleans up the token separator that nextInt() does not remove
				
				if(index > 0 && index < callQueues.size())
				{
					return index;
				}
				else
				{
					System.out.println("There is no queue with the specified index");
				}
			}
			else
			{
				System.out.println("Input a valid integer");
				scanner.next(); //Removes the token that hasNextInt(), including the separator
			}
			
		}
	}
	
	/**
	 * Prompts the user for caller data and a queue to use, then creates a caller
	 * with the specified data and adds it to the queue
	 */
	private void answerCall()
	{
		System.out.println("Input the queue");
		int index = promptForQueue();
	}
}































