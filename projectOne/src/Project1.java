public class Project1 {
	public static void main(String args[])
	{
		
		System.out.println("Runs!!!!");
		// Instantiate Primes Class
		Primes p = new Primes();
		
		System.out.println("Gets here 1");
		
		// Generate Primes and test.
		p.generatePrimes(21);
		p.printPrimes();
		
		System.out.println("Gets here 2");
		
		// Generate and test Twin Primes
		Primes testtwo = new Primes();
		testtwo.generatePrimes(100);
		testtwo.printPrimes();
		testtwo.generateTwinPrimes();
		testtwo.printTwins();
		
		System.out.println("Gets here 3");
		
		// Generate and test Hexagonal crosses
		Primes testThree = new Primes();
		testThree.generatePrimes(2000);
		testThree.printPrimes();
		testThree.generateTwinPrimes();
		testThree.generateHexPrimes();
		testThree.printHexes();
		
		System.out.println("Gets here 4");
	}
}
