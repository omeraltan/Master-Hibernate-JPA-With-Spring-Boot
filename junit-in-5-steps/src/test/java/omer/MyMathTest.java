package omer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    public void calculateSum_ThreeMemberArray(){
        assertEquals(6, math.calculateSum(new int[]{1,2,3}));
    }

    @Test
    public void calculateSum_ZeroLengthArray(){
        assertEquals(0, math.calculateSum(new int[]{}));
    }



}
