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
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primeList = new ArrayList<BigInteger>();
	ArrayList<Pair> pairList = new ArrayList<Pair>();
	
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
		for(int i = 0; i<pairList.size(); i++) {
			System.out.println("(")
		}
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		
		BigInteger newPrime = new BigInteger("0");
		int i = 0;
		
		/*
		 * BigInteger addOne = new BigInteger("1"); BigInteger divideTwo = new
		 * BigInteger("2");
		 */
		
		while(i<count) 
		{ 
			/*
			 * for(BigInteger y = new BigInteger("2"); y.compareTo(y.divide(divideTwo))<=0;y
			 * = y.add(addOne)) { if(y.mod(y).equals(BigInteger.ZERO)) { primeList.add(y); }
			 * }
			 */
			
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
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
	}
}
