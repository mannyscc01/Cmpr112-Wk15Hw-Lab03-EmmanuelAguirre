// Programmer: Emmanuel Aguirre
// Class:      Cmpr-112
// Professor:  Durendal
// File:       ArrayWriter.java 

// Wk15 HW Lab03 Thread


import java.lang.Runnable;


public class ArrayWriter implements Runnable
{
	//a SimpleArray object has been declared
	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriter (int value, SimpleArray array)
	{
		startValue = value;
		sharedSimpleArray = array;
		
	}
	
	public void run()
	{
		for(int i = startValue; i<startValue+3; i++)
		{
			sharedSimpleArray.add(i);
		}
	}
	
}
