import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex14Test {


    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("Testing findValWhat")
    public void findValWhatTest() {

        int[][] arrWhat = new int[][]
                {
                        {0, 1, 2, 3, 5, 5, 5, 5},
                        {0, 4, 7, 7, 7, 8, 9, 9},
                        {9, 9, 9, 9, 9, 9, 9, 9},
                        {10, 10, 13, 15, 16, 18, 21, 21},
                        {11, 11, 14, 16, 17, 18, 21, 23},
                        {12, 12, 15, 16, 18, 19, 21, 25},
                        {15, 15, 15, 17, 18, 20, 21, 25},
                        {16, 17, 19, 20, 22, 23, 27, 30},
                };

        assertTrue(Ex14.findValWhat(arrWhat, 16));
        assertTrue(Ex14.findValWhat(arrWhat, 25));
        assertTrue(Ex14.findValWhat(arrWhat, 5));
        assertTrue(Ex14.findValWhat(arrWhat, 4));
        assertTrue(Ex14.findValWhat(arrWhat, 9));
        assertTrue(Ex14.findValWhat(arrWhat, 23));
        assertTrue(Ex14.findValWhat(arrWhat, 16));
        assertTrue(Ex14.findValWhat(arrWhat, 30));
        assertTrue(Ex14.findValWhat(arrWhat, 27));
        assertTrue(Ex14.findValWhat(arrWhat, 0));
        assertFalse(Ex14.findValWhat(arrWhat, 57));
        assertFalse(Ex14.findValWhat(arrWhat, -2));
        assertFalse(Ex14.findValWhat(arrWhat, 6));
    }

    @Test
    @DisplayName("Testing findValTest")
    public void findValTestTest() {

        int[][] arrTest = new int[][]
                {
                        {0, 2, 1, 2, 0, 5, 5, 5},
                        {21, 21, 7, 7, 7, 21, 21, 21},
                        {21, 21, 21, 21, 21, 21, 21, 21},
                        {21, 21, 23, 42, 41, 23, 21, 21},
                        {60, 56, 57, 58, 53, 52, 47, 51},
                        {61, 65, 70, 72, 73, 78, 82, 98},
                        {112, 121, 112, 134, 123, 100, 98, 111},
                        {136, 136, 136, 134, 147, 150, 154, 134},
                };

        assertFalse(Ex14.findValTest(arrTest, -1));
        assertFalse(Ex14.findValTest(arrTest, 55));
        assertFalse(Ex14.findValTest(arrTest, 200));
        assertFalse(Ex14.findValTest(arrTest, 48));
        assertTrue(Ex14.findValTest(arrTest, 7));
        assertTrue(Ex14.findValTest(arrTest, 5));
        assertTrue(Ex14.findValTest(arrTest, 53));
        assertTrue(Ex14.findValTest(arrTest, 47));
        assertTrue(Ex14.findValTest(arrTest, 147));
        assertTrue(Ex14.findValTest(arrTest, 21));
        assertTrue(Ex14.findValTest(arrTest, 111));
        assertTrue(Ex14.findValTest(arrTest, 70));
        assertTrue(Ex14.findValTest(arrTest, 2));

    }
//
//    @Test
//    @DisplayName("Testing strictlyIncreasing")
//    public void strictlyIncreasingTest(){
//        int[] arr1 = {1,2,4,4,5};
//        int[] arr2 = {1,2,4,4,5,6};
//        int[] arr3 = {1,2,4,4,5,1,2};
//        int[] arr4 = {1,2,4,4,5,6,2,3,4};
//        int[] arr5 = {1,2,3,4,5};
//        int[] arr6 = {1,3,2};
//        int[] arr7 = {5,4,3,2,1};
//        int[] arr8 = {1,3};
//        int[] arr9 = {3,1};
//        int[] arr10 = {1};
//
//        assertEquals(4, Ex14.strictlyIncreasing(arr1));
//        assertEquals(6, Ex14.strictlyIncreasing(arr2));
//        assertEquals(5, Ex14.strictlyIncreasing(arr3));
//        assertEquals(9, Ex14.strictlyIncreasing(arr4));
//        assertEquals(1, Ex14.strictlyIncreasing(arr6));
//        assertEquals(0, Ex14.strictlyIncreasing(arr7));
//        assertEquals(10, Ex14.strictlyIncreasing(arr5));
//        assertEquals(1, Ex14.strictlyIncreasing(arr8));
//        assertEquals(0, Ex14.strictlyIncreasing(arr9));
//        assertEquals(0, Ex14.strictlyIncreasing(arr10));
//    }
//
//    @Test
//    @DisplayName("Testing longestFlatSequence")
//    public void longestFlatSequenceTest(){
//
//    }

}
