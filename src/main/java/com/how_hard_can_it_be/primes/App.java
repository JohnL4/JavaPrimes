package com.how_hard_can_it_be.primes;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Options options = new Options();
    	CmdLineParser parser = new CmdLineParser( options);
    	boolean goodCommandLine;
    	try 
    	{
			parser.parseArgument(args);
			goodCommandLine = true;
		}
    	catch (CmdLineException exc) 
    	{
    		goodCommandLine = false;
    		System.err.println( exc.getMessage());
    		System.err.println("primes [options]");
    		parser.printUsage(System.err);
		}
    	if (goodCommandLine)
    	{
    	    if (options.sumPrimes)
    	    {
    	        sumPrimes( options.ceiling);
    	    }
    	    else if (options.numberToFactor > 3)
    	    {
    	        findFactor( options.numberToFactor);
    	    }
    	    else if (options.triangularNumberFactorCount > 0)
    	    {
    	        findFirstTriangularNumberFactorCountGreaterThan( options.triangularNumberFactorCount);
    	    }
    	    else
    	    {
    	        findPrimes( options.ceiling, options.noPrint);
    	    }
    	}
    }

    private static void findFirstTriangularNumberFactorCountGreaterThan(int aTriangularNumberFactorCount)
    {
        long triangularNumber = 0;
        int i = 1;
        List<Factor> factors = new LinkedList<Factor>();
        do
        {
            triangularNumber += i++;
            factors = factors( triangularNumber);
        } while (factors.size() <= aTriangularNumberFactorCount - 2);
        factors.add( 0, new Factor( 1, 1));
        factors.add( new Factor( (int) triangularNumber, 1));
        System.out.println( String.format( "%d has %d factors:", triangularNumber, factors.size()));
        for (Factor factor : factors)
        {
            if (factor.getCount() == 1)
                System.out.print( String.format( "%8d%12s", factor.getFactor(), ""));
            else
                System.out.print( String.format( "%8d ^ %-8d ", factor.getFactor(), factor.getCount()));
        }
        System.out.println();
    }

    private static void findFactor( long aNumberToFactor)
    {
        List<Factor> factors = factors( aNumberToFactor);
        for (Factor factor : factors)
        {
            if (factor.getCount() == 1)
                System.out.println( String.format( "\t%d", factor.getFactor()));
            else
                System.out.println( String.format( "\t%d ^ %d", factor.getFactor(), factor.getCount()));
        }
    }

    private static List<Factor> factors(long aNumberToFactor)
    {
        List<Factor> factors = new LinkedList<Factor>();
        int rootNumber = (int) Math.round( Math.sqrt( aNumberToFactor));
        PrimeFinder primeFinder = new Eratosthenes();
        Integer[] primes = primeFinder.primesNotGreaterThan( rootNumber);
        long remainingToFactor = aNumberToFactor;
        for (Integer prime : primes)
        {
            // The number of times the current prime factor occurs.
            int factorCount = 0;
            while (remainingToFactor % prime == 0)
            {
                factorCount++;
                remainingToFactor /= prime;
            }
            if (factorCount >= 1)
                factors.add( new Factor( prime, factorCount));
        }
        return factors;
    }

    private static void sumPrimes( int aCeiling)
    {
        PrimeFinder primeFinder = new Eratosthenes();
        Integer[] primes = primeFinder.primesNotGreaterThan( aCeiling);
        long sum = 0;
        for (int prime : primes)
        {
            sum += prime;
        }
        System.out.println( String.format( "\tSum of %d primes <= %d is: %d", primes.length, aCeiling, sum));
    }
    
    private static void findPrimes(int aCeiling, boolean aNoPrintFlag)
    {
        PrimeFinder primeFinder = new Eratosthenes();
        Instant startTime = Instant.now();
        Integer[] primes = primeFinder.primesNotGreaterThan( aCeiling);
        Instant stopTime = Instant.now();
        Duration computeTime = Duration.between(startTime, stopTime);
        if (aNoPrintFlag) 
        {
        	System.err.println( "\t1st prime: " + primes[0]);
        	if (primes.length >= 1001)
        		System.err.println( "\t1001st prime: " + primes[1000]);
        	if (primes.length >= 10000)
        		System.err.println( "\t10001st prime: " + primes[10000]);
        }
        else
        {
            System.out.println("Primes:");
            for (Integer p : primes)
            {
                System.out.print(String.format("%-7d ", p));
            }
            System.out.println();
        }
        System.err.println( String.format( "Found %d primes in %d msec", primes.length, computeTime.toMillis()));
    }
}
