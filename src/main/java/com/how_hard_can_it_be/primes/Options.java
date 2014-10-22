package com.how_hard_can_it_be.primes;

import org.kohsuke.args4j.Option;

public class Options {
	
	@Option( name="--ceil", usage="The biggest prime number to find")
	public Integer ceiling = 100;
	
	@Option( name="--noprint", usage="Suppress printing of found primes")
	public Boolean noPrint = false; // Print by default
	
}
