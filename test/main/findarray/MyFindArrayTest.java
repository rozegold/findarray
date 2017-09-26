package main.findarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyFindArrayTest {


    private FindArray subject;
    private int[] inputArr1 = {4, 9, 3, 7, 8};
    private int[] inputArr1a = {3, 7};
    private int[] inputArr2 = {1, 3, 5};
    private int[] inputArr2a = {1};
    private int[] inputArr3 = {7, 8, 9};
    private int[] inputArr3a = {8, 9, 10};
    private int[] inputArr4 = {4, 9, 3, 7, 8, 3, 7, 1};
    private int[] inputArr4a = {3, 7};
    private int[] inputArr5 = {4, 9};
    private int[] inputArr5a = {4, 9};

    @Before
    public void setUp() throws Exception {

        subject = new MyFindArray();
    }

    @Test
    public void testForAnyInputArrayAsNull() {
        assertEquals(-1, subject.findArray(null, inputArr1a));
        assertEquals(-1, subject.findArray(inputArr1, null));
    }

    @Test
    public void testForAnySubInputArrayLargerThanFirstInputArray() {
        assertEquals(-1, subject.findArray(inputArr1a, inputArr1));
    }

    @Test
    public void testForInputArraysOfSameLength() {
        assertEquals(-1, subject.findArray(inputArr5, inputArr1a));
        assertEquals(0, subject.findArray(inputArr5, inputArr5));
    }

    @Test
    public void shouldCheckRestOfTheElementsInAnArray(){
        assertEquals(true, subject.checkRestOfTheElements(inputArr5, inputArr5, 0));
        assertEquals(false, subject.checkRestOfTheElements(inputArr5, inputArr1a, 0));
    }

    @Test
    public void shouldCheckIfInputArrayContainsSubArraysFirstNumber(){
        assertEquals(3, subject.inputArrayContainsSubArraysFirstNumber(inputArr1, 7, 0));
        assertEquals(-1, subject.inputArrayContainsSubArraysFirstNumber(inputArr1, 1, 0));
    }

    @Test
    public void shouldReturnIndexOfSubArray(){
        assertEquals(2, subject.findArray(inputArr1, inputArr1a));
        assertEquals(0, subject.findArray(inputArr2, inputArr2a));
        assertEquals(-1, subject.findArray(inputArr3, inputArr3a));
    }

    @Test
    public void shouldReturnLastIndexIfSubArrayIsRepeated() {
        assertEquals(5, subject.findArray(inputArr4, inputArr4a));
    }


}