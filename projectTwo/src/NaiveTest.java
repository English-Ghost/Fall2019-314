import java.math.BigInteger;

public class NaiveTest {
  public static boolean isPrime(BigInteger candidate) {
    if (!candidate.isProbablePrime((100)))
      return false; // Weed out the likely not primes.

    // STOPS AT THE SQRT PLUS ONE
    BigInteger loopStop = candidate.sqrt().add(BigInteger.ONE);

    // IS NON PRIME IF DIVISIBLE BY ANY PRIME
    for (BigInteger outerIndex = BigInteger.TWO; outerIndex.compareTo(loopStop) != 1; outerIndex =
        outerIndex.nextProbablePrime()) {
      // PRIME X INCREMENT BY ONE
      for (BigInteger innerIndex = outerIndex; !innerIndex.equals(loopStop); innerIndex =
          innerIndex.add(BigInteger.ONE)) {
        // IF MULTIPLICATION EQUALS THEN ITS NOT PRIME
        if (candidate.equals(innerIndex.multiply(outerIndex)))
          return false;
      }
    }
    return true;
  }
}
