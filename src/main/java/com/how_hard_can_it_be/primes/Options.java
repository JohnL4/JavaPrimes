package com.how_hard_can_it_be.primes;

import org.kohsuke.args4j.Option;

public class Options {
	
	@Option( name="--ceil", usage="The biggest prime number to find")
	public Integer ceiling = 100;
	
	@Option( name="--noprint", usage="Suppress printing of found primes")
	public Boolean noPrint = false; // Print by default
	
	@Option( name="--toFile", usage="Name of a binary file to which to write primes")
	public String toFile;
	
	@Option( name="--fromFile", usage="Name of a binary file from which to read primes")
	public String fromFile;
	
}
