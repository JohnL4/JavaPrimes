package com.how_hard_can_it_be.primes;

/**
 * A factor of a number.
 * @author John Lusk
 *
 */
public class Factor
{
    private int factor;
    private int count;
    
    /**
     * 
     * @param aFactor The factor
     * @param aCount The number of times the factor occurs in the number being factored.
     */
    public Factor( int aFactor, int aCount)
    {
        factor = aFactor;
        count = aCount;
    }
    
    public int getFactor()
    {
        return factor;
    }
    public int getCount()
    {
        return count;
    }
    
    
    
}
