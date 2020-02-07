package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A switchboard class meant to be used by telephone operators to manage caller queues
 * @author Alessandro Cavicchioli
 * @version 1.0
 */
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
		printInstructions();
		boolean exit = false;
		while(!exit)
		{
			System.out.println("Input a command");
			String input = scanner.nextLine();
			switch(input.toLowerCase())
			{
			case "answer":
				answerCall();
				break;
			case "forward":
				forwardCall();
				break;
			case "list":
				printCallQueue();
				break;
			case "help":
				printInstructions();
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
				printInstructions();
				break;
			}
		}
	}
	
	/**
	 * Displays the instructions to use the switchboard
	 */
	private void printInstructions()
	{
		System.out.println("Input \"answer\" to answer a call, \"forward\" to forward a call, or"
				+ " \"list\" to view a list of the awaiting callers. Input \"help\" to see this help"
				+ " or \"exit\" to exit");
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
				scanner.next(); //Removes the token that hasNextInt() saw, including the separator
			}
			
		}
	}
	
	/**
	 * Prompts the user for caller data and a queue to use, then creates a caller
	 * with the specified data and adds it to the queue
	 */
	private void answerCall()
	{
		int index = promptForQueue();
		System.out.println("Input the name of the caller");
		String name = scanner.nextLine();
		System.out.println("Input the phone number of the caller");
		String phoneNumber = scanner.nextLine();
		
		callQueues.get(index).add(name, phoneNumber);
	}
	
	/**
	 * Prompts the user for the queue to use, then forwards the first caller in it and prints its data
	 */
	private void forwardCall()
	{
		int index = promptForQueue();
		Caller caller = callQueues.get(index).poll();
		
		System.out.println(caller.toString());
	}
	
	/**
	 * Prompts the user for the queue to use, then prints the data of all callers in it
	 */
	private void printCallQueue()
	{
		int index = promptForQueue();
		for(Caller caller : callQueues.get(index))
		{
			System.out.println(caller.toString());
			System.out.println();
		}
	}	
}