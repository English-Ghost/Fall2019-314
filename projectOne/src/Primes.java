import java.util.ArrayList; 
import java.math.BigInteger;
/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class Primes {
	
	
	// Pair class implementation.
	private class Pair<T> {
		T firstPair;
		T secondPair;
		
		
		@Override
		public String toString() {
			return firstPair + "," + secondPair;
		}
		
		
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primeList = new ArrayList<BigInteger>();
	ArrayList<Pair<BigInteger>> pairList = new ArrayList<>();
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		primeList.add(x);
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		
		for(int i = 0; i<primeList.size(); i++)
		{
			System.out.println(primeList.get(i));
		}
		
		System.out.println("Total Primes: " + primeList.size());
		/*
		 * for(BigInteger prime: primeList) { System.out.println(prime); }
		 */
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		for(int i = 0; i<pairList.size(); i++) 
		{
			System.out.println(pairList.get(i));
		}
		
		System.out.println("Total Twins: " + pairList.size());
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		
		primeList.clear();
		
		BigInteger newPrime = new BigInteger("0");
		int i = 0;
		
		while(i<count) 
		{ 
			
			if(newPrime.compareTo(BigInteger.ONE) == 1) 
			{
				
				primeList.add(newPrime);
				newPrime = newPrime.nextProbablePrime();
				i++;
				
			}
			else 
			{
				newPrime = newPrime.nextProbablePrime();
			}
			
			
			
		}
		
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		
		for(int i = 1; i<primeList.size(); i++)
		{
			
			BigInteger first = primeList.get(i);
			BigInteger second = primeList.get(i-1);
			BigInteger diff = (first).subtract(second);
			BigInteger bTwo = new BigInteger("2");
			
			
			if( diff.compareTo(bTwo) == 0)
			{
				Pair<BigInteger> newPair = new Pair<BigInteger>();
				
				newPair.firstPair = primeList.get(i-1);
				newPair.secondPair = primeList.get(i);
				
				pairList.add(newPair);
			}
			
		}		
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		
	}
}
