// This class is for all our configuration data. By putting it all in one place, we can easily make
// changes to the program without having to hunt down where in the code a constant is defined.

public class Config {
  public final static String DATAPATH = "data/"; // If you don't know what the static keyword does,
                                                 // you better go look it up now.
  // APLICATION NAME
  public final static String APPLICATIONNAME = "Howdy there partner";
  // FILE NAMES
  public final static String PRIMEFILE = "primes.txt";
  public final static String CROSSFILE = "crosses.txt";
  // Prime file: One prime per line.
  // Cross file: Two primes per line, separated by a comma.
}
