package com.how_hard_can_it_be.primes;

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
    	try 
    	{
			parser.parseArgument(args);
		}
    	catch (CmdLineException exc) 
    	{
    		System.err.println( exc.getMessage());
    		System.err.println("primes [options]");
    		parser.printUsage(System.err);
		}
        System.out.println( "Hello World!" );
    }
}
