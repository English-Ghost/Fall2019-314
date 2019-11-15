import java.util.ArrayList; 
import java.math.BigInteger;
/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class Primes {
	
	
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
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primeList = new ArrayList<BigInteger>();
	ArrayList<Pair<BigInteger>> pairList = new ArrayList<>();
	ArrayList<BigInteger> hexList = new ArrayList<BigInteger>();
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		primeList.add(x);
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		
		// goes through the list and prints prime
		for(int i = 0; i<primeList.size(); i++)
		{
			System.out.println(primeList.get(i));
		}
		
		// prints the size of the list
		System.out.println("Total Primes: " + primeList.size());
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		
		// goes through the pair list and prints pairs
		for(int i = 0; i<pairList.size(); i++) 
		{
			System.out.println(pairList.get(i));
		}
		
		// prints the size of the pair list
		System.out.println("Total Twins: " + pairList.size());
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		
		// clears the list if it is called again
		primeList.clear();
		
		// starts the find for primes
		BigInteger newPrime = new BigInteger("0");
		int i = 0;
		
		// until the amount needed
		while(i<count) 
		{ 
			
			// if newPrime is not 1 then add to list and generate next prime
			if(newPrime.compareTo(BigInteger.ONE) == 1) 
			{
				
				primeList.add(newPrime);
				newPrime = newPrime.nextProbablePrime();
				i++;
				
			}
			else // just generate next prime
			{
				newPrime = newPrime.nextProbablePrime();
			}
			
			
			
		}
		
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		
		pairList.clear();
		
		for(int i = 1; i<primeList.size(); i++)
		{
			
			// This is to make the math look prettier and easier to understand
			BigInteger first = primeList.get(i);
			BigInteger second = primeList.get(i-1);
			BigInteger diff = (first).subtract(second);
			BigInteger bTwo = new BigInteger("2");
			
			// if the diff is 2 then its a twin prime
			if( diff.compareTo(bTwo) == 0)
			{
				
				// create a new pair
				Pair<BigInteger> newPair = new Pair<BigInteger>();
				
				// set values of pair to twin primes
				newPair.firstPair = primeList.get(i-1);
				newPair.secondPair = primeList.get(i);
				
				// add to the list
				pairList.add(newPair);
			}
			
		}		
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		
	}
}
