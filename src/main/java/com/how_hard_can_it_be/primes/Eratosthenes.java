package com.how_hard_can_it_be.primes;

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
        boolean isPrime[] = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        
        int rootN = (int) Math.floor(Math.sqrt(n));
        
        for (int i = 2; i < rootN; i++)
            if (isPrime[i])
                for (int j = 2 * i; j < n; j += i)
                    isPrime[j] = false;
        
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                retval.add( i);
        
        return retval.toArray(new Integer[0]);
    }

}