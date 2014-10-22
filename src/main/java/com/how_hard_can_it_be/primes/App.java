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
    		System.out.println( "Hello World!" );
    	}
    }
}
