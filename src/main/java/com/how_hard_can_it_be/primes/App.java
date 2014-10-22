package com.how_hard_can_it_be.primes;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws CmdLineException
    {
    	Options options = new Options();
    	CmdLineParser parser = new CmdLineParser( options);
    	parser.parseArgument(args);
        System.out.println( "Hello World!" );
    }
}
