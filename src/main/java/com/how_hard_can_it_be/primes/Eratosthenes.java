package com.how_hard_can_it_be.primes;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Sieve of Eratosthenes.
 * @author john
 *
 */
public class Eratosthenes implements PrimeFinder
{

    public Integer[] primesNotGreaterThan( int aCeiling)
    {
        List<Integer> retval = new LinkedList<Integer>();
        int n = aCeiling + 1;
//        boolean isPrime[] = new boolean[n];
        // BitSet is a nice space-saver, but if you're trying to find primes below 10^9, you will
        // probably want to increase your max. heap size.
        BitSet isPrime = new BitSet(n);
        for (int i = 0; i < n; i++)
        {
            isPrime.set(i);
        }
        isPrime.clear(0);
        isPrime.clear(1);
//        isPrime[0] = isPrime[1] = false;
        
        int rootCeiling = (int) Math.floor(Math.sqrt(aCeiling));
        
        for (int i = 2; i <= rootCeiling; i++)
            if (isPrime.get(i))
            {
                // This little cross-out trick comes from http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Implementation
                // i^2 + k*i < n
                // k < (n - i^2)/i
                int iSquared = i*i;
                for (int k = 0; k <= (aCeiling - iSquared) / i; k++)
                {
                    int j = iSquared + k * i;
//                for (int j = 2 * i; j < n; j += i)
                    isPrime.clear(j); // [j] = false;
                }
            }
        for (int i = 2; i < n; i++)
            if (isPrime.get(i))
                retval.add( i);
        
        return retval.toArray(new Integer[0]);
    }

}
