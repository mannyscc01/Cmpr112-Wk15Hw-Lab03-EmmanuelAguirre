// Programmer: Emmanuel Aguirre
// Class:      Cmpr-112
// Professor:  Durendal
// File:       SharedArrayTest.java 

// Wk15 HW Lab03 Thread


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest 
{
	public static void main(String [] arg)
	{
		//a SimpleArray object has been initialized
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		//the SimpleArray object is passed in to two ArrayWriter objects
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		
		//a static method is called from Executors and assigned to an
		//ExecutorService object
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		executor.shutdown();
		
		try
		{
			boolean tasksEnded = executor.awaitTermination(1,  TimeUnit.MINUTES);
			if(tasksEnded)
				System.out.println(sharedSimpleArray);
			else
				System.out.println("Timed out while waiting for tasks to finish");
		}
		catch (InterruptedException ex)
		{
			System.out.println("Interrupted while waiting for tasks to finish");
		}
	}

}

// Please see slide 43-51
