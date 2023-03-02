package org.jfree.data;

import static org.junit.Assert.*;

//import java.security.InvalidParameterException;

//import org.jmock.Expectations;
//import org.jmock.Mockery;
import org.junit.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RangeTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
    private Range twoPosExampleRange;
    private Range twoNegExampleRange;
    private Range exampleRange;
    private Range zeroRange;
    private Range nonIntCenter;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	twoPosExampleRange = new Range(3, 5);
    	twoNegExampleRange = new Range(-5, -3);
    	exampleRange = new Range(-1, 1);
    	zeroRange = new Range(1, 1);
    	nonIntCenter = new Range(1,2);
    }

    //Testing getUpperBound() function
    //The path if(lower > upper) == true is infeasible as the constructor does not allow lower>upper
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void twoPosUpperBound() {
    	assertEquals("The upper bound of (3, 5) should be 5", 5, twoPosExampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void twoNegUpperBound() {
    	assertEquals("The upper bound of (-5, -3) should be -3", -3, twoNegExampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void testUpperBound() {
    	assertEquals("The upper bound of (-1, 1) should be 1", 1, exampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void zeroUpperBound() {
    	assertEquals("The upper bound of (1, 1) should be 1", 1, zeroRange.getUpperBound(), 
    			.00000001d);
    }
    
    
   /* @Test
    public void upperBoundFail() {
    	Range range = new Range(3,Math.sqrt(-1000));
    	
    	try {
			range.getUpperBound();
			fail("This should throw an exception");
		} catch (Exception e) {
			assertEquals("The exception thrown is IllegalArgException", IllegalArgumentException.class,
					e.getClass());
		}
    	
    }
    */
    
    //Testing getLowerBound() function
    //The path if(lower > upper) == true is infeasible as the constructor does not allow lower>upper
    @Test
    public void twoPosLowerBound() {
    	assertEquals("The lower bound of (3, 5) should be 3", 3, twoPosExampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void twoNegLowerBound() {
    	assertEquals("The lower bound of (-5, -3) should be -5", -5, twoNegExampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void testLowerBound() {
    	assertEquals("The lower bound of (-1, 1) should be -1", -1, exampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void zeroLowerBound() {
    	assertEquals("The lower bound of (1, 1) should be 1", 1, zeroRange.getLowerBound(),
    			.00000001d);
    }


    //Testing getLength() function
    //The path if(lower > upper) == true is infeasible as the constructor does not allow lower>upper
    @Test
    public void testValidLength() {
    	assertEquals("The length of the example range should be 2", 2, exampleRange.getLength(),
    			.00000001d);
    }
    @Test
    public void testZeroLength() {
    	assertEquals("The length of the (1, 1) should be 0", 0, zeroRange.getLength(),
    			.00000001d);
    }
    
    //Testing getCentralValue() function
    @Test
    public void testIntegerCentral() {
    	assertEquals("The central value of -1 and 1 should be 0",
    	        0, exampleRange.getCentralValue(), .000000001d);
    }
    @Test
    public void testNonIntegerCentral() {
    	assertEquals("The central value of 1 and 2 should be 1.5",
    	        1.5, nonIntCenter.getCentralValue(), .000000001d);
    }
    @Test
    public void testZeroCentral() {
    	assertEquals("The central value of 1 and 1 should be 1",
    	        1, zeroRange.getCentralValue(), .000000001d);
    }
    
    //testing contains() function
    @Test
    public void testContainsValid() {
    	assertEquals("This function should return true because 4 is in range (3, 5)", true, 
    			twoPosExampleRange.contains(4));
    }
    @Test
    public void testContainsInvalid() {
    	assertEquals("This function should return false because 1 is not in range(3, 5)", false,
    			twoPosExampleRange.contains(1));
    }
    @Test
    public void testContainsBoundry() {
    	assertEquals("This function should return true because 3 is contained in (3,5)",
    			true, twoPosExampleRange.contains(3));
    }
    @Test
    public void testContainsLarger() {
    	Range range = new Range(1,2);
    	assertEquals("This function should return false", false, range.contains(5));
    }
    
    //testings intersects(double a, double b)
    @Test
    public void testIntersecstsTrue() {
    	Range range = new Range(1,3);
    	assertEquals("This function should return true",true,range.intersects(2, 4));
    }
    @Test
    public void testIntersecstsFalse() {
    	Range range = new Range(1,3);
    	assertEquals("This function should return flasee",false,range.intersects(5, 10));
    }
    @Test
    public void testIntersecstsTrue2() {
    	Range range = new Range(1,3);
    	assertEquals("This function should return true",true,range.intersects(0, 4));
    }
    
    //testing intersects(Range range)
    @Test
    public void testIntersectsRange() {
    	Range range = new Range(1,3);
    	assertEquals("This function should return true",true,range.intersects(range));
    }
    
    //tesing isNaNRange()
    @Test
    public void testNaNRangeFalse() {
    	Range range = new Range(1,3);
    	assertEquals("This function should return false",false,range.isNaNRange());
    }
    @Test
    public void testNaNRangeFalse1() {
    	Range range = new Range(Math.sqrt(-1),3);
    	assertEquals("This function should return false",false,range.isNaNRange());
    }
   @Test
    public void testNaNRangeTrue() {
    	Range range = new Range(Math.sqrt(-1),Math.sqrt(-1));
    	assertEquals("This function should return true",true,range.isNaNRange());
    }
    @Test
    public void testNaNRangeFalse2() {
    	Range range = new Range(3,Math.sqrt(-1));
    	assertEquals("This function should return false",false,range.isNaNRange());
    }
    
  //testing shift(Range base, double delta)
    @Test
    public void testPositiveShift()
    {
    	Range input = new Range(1.0, 3.0);
    	Range expected = new Range(2.0, 4.0);
    	Range actual = Range.shift(input, 1.0);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNegativeShift()
    {
    	Range input = new Range(1.0, 3.0);
    	Range expected = new Range(0.0, 2.0);
    	Range actual = Range.shift(input, -1.0);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNoShift()
    {
    	Range input = new Range(1.0, 3.0);
    	Range expected = new Range(1.0, 3.0);
    	Range actual = Range.shift(input, 0.0);
    	assertEquals(expected, actual);
    }
    //testing shift(Range base, double delta, allowZeroCrossing)
    @Test
    public void testAllowZeroCrossingNoCross()
    {
    	Range input = new Range(1.0, 2.0);
    	Range expected = new Range(2.0, 3.0);
    	Range actual = Range.shift(input, 1.0, true);
    	assertEquals(expected, actual);
    }
    @Test
    public void testAllowZeroCrossingCross()
    {
    	Range input = new Range(1.0, 2.0);
    	Range expected = new Range(-1.0, 0.0);
    	Range actual = Range.shift(input, -2.0, true);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNoAllowZeroCrossingNoCross()
    {
    	Range input = new Range(1.0, 2.0);
    	Range expected = new Range(2.0, 3.0);
    	Range actual = Range.shift(input, 1.0, false);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNoAllowZeroCrossingCross()
    {
    	Range input = new Range(1.0, 2.0);
    	Range expected = new Range(0.0, 0.0);
    	Range actual = Range.shift(input, -2.0, false);
    	assertEquals(expected, actual);
    }
    //testing scale(Range base, double factor)
    @Test
    public void testPositiveFactor()
    {
    	Range input = new Range(1.0, 2.0);
    	Range expected = new Range(2.0, 4.0);
    	Range actual = Range.scale(input, 2.0);
    	assertEquals(expected, actual);	
    }
    @Rule
    	public ExpectedException thrown = ExpectedException.none();
    	
    @Test
    public void testNegativeFactor() throws IllegalArgumentException
    {
    	Range input = new Range(1.0, 2.0);
    	thrown.expect(IllegalArgumentException.class);
    	Range.scale(input, -1.0);
    }
    //testing equals(Object obj)
    @Test
    public void testEquivalentRanges()
    {
    	Range input = new Range(1.0, 2.0);
    	Range input2 = new Range(1.0, 2.0);
    	boolean expected = true;
    	boolean actual = input.equals(input2);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNonEquivalentUpperBound()
    {
    	Range input = new Range(1.0, 2.0);
    	Range input2 = new Range(2.0, 2.0);
    	boolean expected = false;
    	boolean actual = input.equals(input2);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNonEquivalentLowerBound()
    {
    	Range input = new Range(1.0, 2.0);
    	Range input2 = new Range(1.0, 4.0);
    	boolean expected = false;
    	boolean actual = input.equals(input2);
    	assertEquals(expected, actual);
    }
    @Test
    public void testNonRange()
    {
    	Range range = new Range(1.0, 2.0);
    	Object input = new Object();
    	boolean expected = false;
    	boolean actual = range.equals(input);
    	assertEquals(expected, actual);
    }
    //testing hashCode()
    @Test
    public void testPositiveRange()
    {
    	Range input = new Range(1.0, 2.0);
    	int expected = 33;
    	int actual = input.hashCode();
    	//System.out.println(actual);
    	assertEquals(expected,actual);
    }
    @Test
    public void testNegativeRange()
    {
    	Range input = new Range(-4.0, -2.0);
    	int expected = 0;
    	int actual = input.hashCode();
    	//System.out.println(actual);
    	assertEquals(expected,actual);
    }
    //testing toString()
    @Test
    public void testValidRange()
    {
    	Range input = new Range(1.0, 2.0);
    	String expected = "Range[1.0,2.0]";
    	String actual = input.toString();
    	assertEquals(expected, actual);
    }

    
   
    
    
  //TESTING CONSTRAIN NEW
    @Test
    public void testConstrainUpperBound() {
    	assertEquals("This function should return 1 because the the value given is greater than the upper bound.",
    			1, exampleRange.constrain(2),.0000001d);
    }
    
    @Test
    public void testConstrainLowerBound() {
    	assertEquals("This function should return -1 because the the value given is below the lower bound.",
    			-1, exampleRange.constrain(-2),.0000001d);
    }
    
    @Test
    public void testConstrainWithinBound() {
    	assertEquals("This function should return 0 because the value, 0, is within the bound.",
    			0, exampleRange.constrain(0),.0000001d);
    }
  
    
    //TESTING COMBINE (NEW)
    @Test
    public void testCombineNoNull() {
    	assertEquals("This function should return (-5, 5) because the lowest value is -5, and greatest is 5",
    			new Range(-5, 5), Range.combine(twoNegExampleRange, twoPosExampleRange));
    }
    
    @Test
    public void testCombine1Null() {
    	assertEquals("This function should return (3, 5) because Range 1 is null",
    			new Range(3, 5), Range.combine(null, twoPosExampleRange));
    }
    
    @Test
    public void testCombine2Null() {
    	assertEquals("This function should return (3, 5) because Range 2 is null",
    			new Range(3, 5), Range.combine(twoPosExampleRange, null));
    }
    
    //TESTING COMBINEIGNORINGNAN (NEW)
    @Test
    public void testCombineNan1Null2Nan() {
    	assertEquals("This function should return null because Range 1 is null and Range 2 contains Nan values.",
    			null, Range.combineIgnoringNaN(null, new Range(Double.NaN, Double.NaN)));
    }
    @Test
    public void testCombineNan1Null2Valid() {
    	assertEquals("This function should return (-1,1) because Range 1 is null and Range 2 is valid.",
    			new Range(-1,1), Range.combineIgnoringNaN(null, exampleRange));
    }
    
    @Test
    public void testCombineNan2Null1Nan() {
    	assertEquals("This function should return null because Range 2 is null and Range 1 contains Nan values.",
    			null, Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), null));
    }
    @Test
    public void testCombineNan2Null1Valid() {
    	assertEquals("This function should return (-1,1) because Range 2 is null and Range 1 is valid.",
    			new Range(-1,1), Range.combineIgnoringNaN(exampleRange, null));
    }
    
    @Test
    public void testCombineNan1Null2Null() {
    	assertEquals("This function should return null because Range 2 is null and Range 1 is null.",
    			null, Range.combineIgnoringNaN(null, null));
    }
    
    @Test
    public void testCombineNanValid() {
    	assertEquals("This function should return (-5, 5) because the lowest value is -5, and greatest is 5",
    			new Range(-5, 5), Range.combineIgnoringNaN(twoNegExampleRange, twoPosExampleRange));
    }
    @Test
    public void testCombineNanBothNaN() {
    	assertEquals("This function should return null because both ranges are null",
    			null, Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN)));
    }
    @Test
    public void testCombineNan1Valid2NaN() {
    	assertEquals("This function should return (-1,1) because range 1 was valid but 2 was nan",
    			new Range(-1,1), Range.combineIgnoringNaN(exampleRange, new Range(Double.NaN, Double.NaN)));
    }
    @Test
    public void testCombineNan1NaN2Valid() {
    	assertEquals("This function should return (-1,1) because range 2 was valid but 1 was nan",
    			new Range(-1,1), Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), exampleRange));
    }
    
    //TESTING EXPANDTOINCLUDE{
    
    @Test
    public void testExpandToIncludeNull() {
    	assertEquals("This function should return a range of (1,1) because the given range was null.",
    			new Range(1,1), Range.expandToInclude(null, 1));
    }
    @Test
    public void testExpandToIncludeBelowRange() {
    	assertEquals("This function should return a range of (-2,1) because the given value was below current range.",
    			new Range(-2,1), Range.expandToInclude(exampleRange, -2));
    }
    @Test
    public void testExpandToIncludeAboveRange() {
    	assertEquals("This function should return a range of (-1,2) because the given value was above current range.",
    			new Range(-1,2), Range.expandToInclude(exampleRange, 2));
    }
    @Test
    public void testExpandToIncludeInRange() {
    	assertEquals("This function should return a range of (-1,1) because the given value was in range",
    			new Range(-1,1), Range.expandToInclude(exampleRange, 0));
    }
    
    //TESTING EXPAND
    @Test
    public void testExpandNormal() {
    	assertEquals("This function should return a range of (3, -3)",
    			new Range(-3, 3), Range.expand(exampleRange, 1, 1));
    }
    @Test
    public void testExpandNegative() {
    	assertEquals("This function should return a range of (2,2)", 
    			new Range(2,2), Range.expand(exampleRange, -2, 0));
    }

    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
