// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;


public class FileAccess {
    static Scanner x;
    static FileWriter fileWriter;
  public static boolean loadPrimes(Primes primes, String filename) {
      
      //creating a scanner to read the file
      
      // creating a primes object
      primes = new Primes();
      
      //clearing the PrimeList
      primes.clearPrimes();
      //checking to see if the file can be read
      try {
          
       x = new Scanner(new File(filename));
      }
      
      catch(FileNotFoundException e){
          System.out.println("File not found");
          return false;
          
      }
      
      // reading from the file
      while(x.hasNext()) {
          // while reading from the list add the primes to primeList
          String num = x.next();
          int number = Integer.parseInt(num);
          primes.addPrime(BigInteger.valueOf(number));
          
      }
        return true;
  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
      
      //clearing the PrimeList
      primes.clearCrosses();
      //checking to see if the file can be read
      try {
        x = new Scanner (new File(filename));
    } catch (FileNotFoundException e) {
        
        e.printStackTrace();
    }
      x.useDelimiter(",");
      
      while(x.hasNext()) {
        String first = x.next();
        String second = x.next();
        int number1 = Integer.parseInt(first);
        int number2 = Integer.parseInt(second);
        Pair<BigInteger> hex = new Pair<BigInteger>(BigInteger.valueOf(number1), BigInteger.valueOf(number2));
        primes.addCross(hex);
          
      }
        return true;
    }
  
  
  
  public static boolean savePrimes(Primes primes, String filename)
  {

      try {
         fileWriter = new FileWriter(filename);
    } catch (IOException e) {
    
        e.printStackTrace();
    }
      
        for (BigInteger list : primes.iteratePrimes()) {

            
            try {
                fileWriter.write(list + System.lineSeparator());
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            //fileWriter.write(list);
        }
      
    return true;
  }
  
  public static boolean saveCrosses(Primes primes, String filename) throws IOException
  {
     fileWriter = new FileWriter(filename); 
     
     for(Pair<BigInteger> list: primes.iterateCrosses()) {
         
         fileWriter.write(list.left() + "," + list.right() + System.lineSeparator()); 
     }
     
     fileWriter.flush();
     fileWriter.close();
     
      
      
    return true;
  }
}