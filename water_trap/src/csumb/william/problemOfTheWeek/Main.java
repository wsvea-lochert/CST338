/**
 * Rain water trap problem
 * */
package csumb.william.problemOfTheWeek;

public class Main {

    public static void main(String[] args) {

        int myArray[] = {3, 1, 4};
        int mySize = myArray.length;
        int waterBlocks = 0;
        int leftSide[] = new int[mySize];
        int rightSide[] = new int[mySize];

        //left
        leftSide[0] = myArray[0];
        for(int i = 1; i < mySize; i++ )
        {
            leftSide[i] = Math.max(leftSide[i-1], myArray[i]);
        }

        //right
        rightSide[mySize-1] = myArray[mySize-1];
        for (int i = mySize-2; i >= 0; i--)
        {
            rightSide[i] = Math.max(rightSide[i+1], myArray[i]);
        }

        for(int i = 0; i < mySize; i++)
        {
            waterBlocks += Math.min(leftSide[i], rightSide[i]) - myArray[i];
        }

        System.out.println("Total water trapped: " + waterBlocks);

    }
}
