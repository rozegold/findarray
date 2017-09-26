package main.findarray;

public class MyFindArray implements FindArray {


    @Override
    public int findArray(int[] inputArray, int[] subArray) {

        if (null == inputArray || null == subArray) {
            return -1;
        }
        int inputArrLength = inputArray.length;
        int subArrayLength = subArray.length;

        if (inputArrLength < subArrayLength) {
            return -1;
        }

        if (inputArrLength == subArrayLength)
            if (inputArray[0] != subArray[0])
                return -1;

        int firstNumber = subArray[0];
        int startIndex = 0;

        startIndex = inputArrayContainsSubArraysFirstNumber(inputArray, firstNumber, startIndex);

        int resultIndex = -1;

        if (startIndex < 0) return startIndex;


        while (inputArrLength - subArrayLength - startIndex >= 0) {
            if (!checkRestOfTheElements(inputArray, subArray, startIndex)) {
                startIndex = inputArrayContainsSubArraysFirstNumber(inputArray, firstNumber, ++startIndex);
                if (startIndex < 0)
                    break;
            } else {
                resultIndex = startIndex;
                startIndex++;
            }
        }
        return (resultIndex >= 0) ? resultIndex : -1;
    }

    @Override
    public boolean checkRestOfTheElements(int[] inputArray, int[] subArray, int startIndex) {
        int subArrLength = subArray.length;

        for (int i = 0; i < subArrLength; i++) {
            if (inputArray[i + startIndex] != subArray[i])
                return false;
        }
        return true;
    }

    @Override
    public int inputArrayContainsSubArraysFirstNumber(int[] inputArray, int firstNumber, int start) {

        int inputArrLength = inputArray.length;
        int end = inputArrLength - 1;

        if (inputArray[start] == firstNumber)
            return start;

        if (inputArray[end] == firstNumber)
            return end;

        for (int i = start; i < end; i++) {
            if (inputArray[i] == firstNumber)
                return i;
        }

        return -1;
    }

}
