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
  public static boolean loadPrimes(Primes primes, String filename) {

    // clearing the primeList
    primes.clearPrimes();
    primes.clearTwins();
    primes.clearCrosses();

    // creating a buffer and file reader in order to read from a file
    try {
      // keeping track of the current line
      FileReader fReader = new FileReader(Config.DATAPATH + filename);
      BufferedReader bReader = new BufferedReader(fReader);

      String currentLine;

      while ((currentLine = bReader.readLine()) != null) {

        primes.addPrime(new BigInteger(currentLine));

      }
    } catch (IOException e) {

      return false;
    }
    return true;


  }

  public static boolean loadCrosses(Primes primes, String filename) {

    // clearing the cross list
    primes.clearCrosses();
    // checking to see if the file can be read

    try {

      FileReader fReader = new FileReader(Config.DATAPATH + filename);
      BufferedReader bReader = new BufferedReader(fReader);

      String currentLine;
      while ((currentLine = bReader.readLine()) != null) {

        String currentLineOfList[] = currentLine.split(",");
        Pair<BigInteger> crossPair = new Pair<BigInteger>(new BigInteger(currentLineOfList[0]),
            new BigInteger(currentLineOfList[1]));
        primes.addCross(crossPair);


      }

    }

    catch (IOException e) {
      return false;
    }
    return true;

  }


  public static boolean savePrimes(Primes primes, String filename) {
    try {
      FileWriter fWrite = new FileWriter(Config.DATAPATH + filename);
      BufferedWriter bWrite = new BufferedWriter(fWrite);
      Iterable<BigInteger> it = primes.iteratePrimes();
      for (BigInteger BI : it) {

        bWrite.write(BI + System.getProperty("line.separator"));
      }
      bWrite.close();
    } catch (IOException e) {
      return false;
    }
    return true;
  }

  public static boolean saveCrosses(Primes primes, String filename) {
    try {
      FileWriter fWrite = new FileWriter(Config.DATAPATH + filename);
      BufferedWriter bWrite = new BufferedWriter(fWrite);
      Iterable<Pair<BigInteger>> it = primes.iterateCrosses();
      for (Pair<BigInteger> BI : it) {

        bWrite.write(BI + System.getProperty("line.separator"));
      }

      bWrite.close();
    } catch (IOException e) {
      return false;
    }

    return true;

  }
}
