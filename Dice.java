// Programmer: Emmanuel Aguirre
// Class:      Cmpr-112
// Professor:  Durendal
// File:       Dice.java 

// Wk15 HW Lab03 Thread

public class Dice implements Runnable
{ 
 private final int HISTORY_SIZE = 25; 
 private int [] history = new int[HISTORY_SIZE]; 
 private int myCurrentValue;
 private int numThrows;  
 
 public Dice() 
 {  
  myCurrentValue = 0;  
  for(int i =0 ;i < HISTORY_SIZE; i++)   
   history[i]=0;  
  numThrows=0;
 }   
 
 @Override
 public void run()
 {
  for(int i = 0; i<25; i++)
  {
   Throw();
  }
  //thread's static method currentThread is being used
  System.out.print(Thread.currentThread().getName() + ": ");
  printHistory();
  System.out.println();
  
 }

 public void Throw() 
 {  
  //Math's static method random() is being used
  myCurrentValue = (1 + (int)((Math.random()) * 6)); 
  numThrows++;
  keepTrackHistory(); 
 }  
 
 public int getValue()
 {
  return myCurrentValue;
 }
 
 public void keepTrackHistory() 
 {  
  for(int i = 0; i<HISTORY_SIZE; i++)  
  {   
   if(history[i]==0)   
   {    
    history[i] = myCurrentValue;    
    break;   
   }  
  } 
 } 
 
 public void printHistory() 
 {  
  for(int i=0 ; i< HISTORY_SIZE; i++)  
  {   
   if(history[i]==0)    
    break;   
   System.out.print(history[i] + " ");  
   }  
  System.out.println(); 
  }
 }
//-- end of Dice.java -------------------------------------------------

 