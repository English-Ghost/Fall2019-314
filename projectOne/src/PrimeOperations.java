import java.util.ArrayList;
import java.math.BigInteger;

/*
 * Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {


  // Pair class implementation.
  private class Pair<T> {

    // two peas in a pod
    T firstPair;
    T secondPair;


    // makes output easier
    @Override
    public String toString() {
      return firstPair + "," + secondPair;
    }
  }

  // Member variables for containing out lists of integers, twin primes, hexagon crosses, and the
  // pairs of twin primes that make up the hex crosses.
  ArrayList<BigInteger> primeList = new ArrayList<BigInteger>();
  ArrayList<Pair<BigInteger>> pairList = new ArrayList<>();
  ArrayList<Pair<Pair<BigInteger>>> hexList = new ArrayList<>();

  // Add a prime to the prime list if and only iff it is not already in the list. (ignore
  // duplicates)
  public void addPrime(BigInteger x) {

    // if prime isn't in the list already add it
    if (!(primeList.contains(x))) {
      primeList.add(x);
    }
  }

  // Output the prime list. Each prime should be on a separate line and the total number of primes
  // should be on the following line.
  public void printPrimes() {

    // goes through the list and prints prime
    for (int i = 0; i < primeList.size(); i++) {
      System.out.println(primeList.get(i));
    }

    // prints the size of the list
    System.out.println("Total Primes: " + primeList.size());
  }

  // Output the twin prime list. Each twin prime should be on a separate line with a comma
  // separating them, and the total number of twin primes should be on the following line.
  public void printTwins() {

    // goes through the pair list and prints pairs
    for (int i = 0; i < pairList.size(); i++) {
      System.out.println(pairList.get(i));
    }

    // prints the size of the pair list
    System.out.println("Total Twins: " + pairList.size());
  }

  // Output the hexagon cross list. Each should be on a separate line listing the two twin primes
  // and the corresponding hexagon cross, with the total number on the following line.
  public void printHexes() {

    // goes through the list of hexes
    for (int i = 0; i < hexList.size(); i++) {

      // just easy acces to the pairs of pairs
      Pair firstHex = hexList.get(i).firstPair;
      Pair secondHex = hexList.get(i).secondPair;

      // math for the first mid and second mid
      BigInteger firstMid = ((BigInteger) firstHex.firstPair).add(BigInteger.ONE);
      BigInteger secondMid = ((BigInteger) secondHex.firstPair).add(BigInteger.ONE);


      // print statement with easy look
      System.out.print("Prime Pairs: ");
      System.out.print(firstHex.firstPair + "," + firstHex.secondPair);
      System.out.print(" and ");
      System.out.print(secondHex.firstPair + "," + secondHex.secondPair);
      System.out.print(" Seperated by ");
      System.out.print(firstMid + "," + secondMid);
      System.out.print("\n");

    }

    // prints size of the list
    System.out.print("Total Hexes: " + hexList.size());
  }

  // Generate and store a list of primes.
  public void generatePrimes(int count) {

    // clears the list if it is called again
    primeList.clear();

    // starts the find for primes
    BigInteger newPrime = new BigInteger("0");
    int i = 0;

    // until the amount needed
    while (i < count) {

      // if newPrime is not 1 then add to list and generate next prime
      if (newPrime.compareTo(BigInteger.ONE) == 1) {

        primeList.add(newPrime);
        newPrime = newPrime.nextProbablePrime();
        i++;

      } else { // generates the next prime
        newPrime = newPrime.nextProbablePrime();
      }
    }
  }

  // Generate and store a list of twin primes.
  public void generateTwinPrimes() {

    // clears the pairs
    pairList.clear();

    // for every prime
    for (int i = 1; i < primeList.size(); i++) {

      // This is to make the math look prettier and easier to understand
      BigInteger first = primeList.get(i);
      BigInteger second = primeList.get(i - 1);
      BigInteger diff = (first).subtract(second);
      BigInteger bigTwo = new BigInteger("2");

      // if the diff is 2 then its a twin prime
      if (diff.compareTo(bigTwo) == 0) {

        // create a new pair
        Pair<BigInteger> newPair = new Pair<BigInteger>();

        // set values of pair to twin primes
        newPair.firstPair = primeList.get(i - 1);
        newPair.secondPair = primeList.get(i);

        // add to the list
        pairList.add(newPair);
      }
    }
  }

  // Generate and store the hexagon crosses, along with the two twin primes that generate the
  // hexagon cross.
  public void generateHexPrimes() {

    // clears the hex list
    hexList.clear();

    // constant bigTwo
    BigInteger bigTwo = new BigInteger("2");

    // for all pairs
    for (int i = 0; i < pairList.size(); i++) {

      // for all pairs that haven't be accessed
      for (int y = i + 1; y < pairList.size(); y++) {

        // easy storage for values
        BigInteger firstOne = pairList.get(i).firstPair;
        BigInteger secondOne = pairList.get(y).firstPair;
        BigInteger secondTwo = pairList.get(y).secondPair;

        // math for questioning values
        BigInteger firstMid = firstOne.add(BigInteger.ONE);
        BigInteger secondMid = firstMid.multiply(bigTwo);
        BigInteger questioningOne = secondMid.subtract(BigInteger.ONE);
        BigInteger questioningTwo = secondMid.add(BigInteger.ONE);

        // determines if hex pair
        if (questioningOne.compareTo(secondOne) == 0 && questioningTwo.compareTo(secondTwo) == 0) {

          // creates two hex pairs to be put in a pair
          Pair hexPairOne = new Pair();
          Pair hexPairTwo = new Pair();

          // store the pairs in their right pairs
          hexPairOne.firstPair = firstOne;
          hexPairOne.secondPair = pairList.get(i).secondPair;
          hexPairTwo.firstPair = secondOne;
          hexPairTwo.secondPair = secondTwo;

          // final pair
          Pair totHexPair = new Pair();

          // adds pairs together to be a pair
          totHexPair.firstPair = hexPairOne;
          totHexPair.secondPair = hexPairTwo;

          // ads to list
          hexList.add(totHexPair);

        }
      }
    }
  }
}
