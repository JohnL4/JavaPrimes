package com.how_hard_can_it_be.primes;

import java.time.Duration;
import java.time.Instant;

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
    		PrimeFinder primeFinder = new Eratosthenes();
    		Instant startTime = Instant.now();
    		Integer[] primes = primeFinder.primesNotGreaterThan( options.ceiling);
    		Instant stopTime = Instant.now();
    		Duration computeTime = Duration.between(startTime, stopTime);
    		if (options.noPrint) 
    		{
    			System.out.println( "\t1st prime: " + primes[0]);
    			if (primes.length >= 1001)
    				System.out.println( "\t1001st prime: " + primes[1000]);
    			if (primes.length >= 10000)
    				System.out.println( "\t10001st prime: " + primes[10000]);
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
    		System.out.println( String.format( "Found %d primes in %d msec", primes.length, computeTime.toMillis()));
    	}
    }
}
