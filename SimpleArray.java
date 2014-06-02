// Programmer: Emmanuel Aguirre
// Class:      Cmpr-112
// Professor:  Durendal
// File:       SimpleArray.java 

// Wk15 HW Lab03 Thread


import java.util.Arrays;
import java.util.Random;

public class SimpleArray 
{
	private final int[] array;
	private int writeIndex = 0;
	//an object from class Random has been instantiated
	private final static Random generator = new Random();
	
	public SimpleArray( int size )
	{
		array = new int[size];
	}
	
	public void add ( int value )
	{
		int position = writeIndex;
		try
		{
			//the static method sleep from Thread is being called
			Thread.sleep(generator.nextInt(500));
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		array[position] = value;
		System.out.printf("%s wrote %2d to element %2d\n", writeIndex);
		
	}
	
	public String toString()
	{
		return "\nContents of SimpleArray:\n" + Arrays.toString(array);
	}
}
