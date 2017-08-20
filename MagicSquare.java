import java.util.Scanner;
/**
 * Created with BlueJ
 * User: Ryan Regier
 * Date: whenever I made this in class but currently it is 8/19/17
 * Time: uhhh rn it is 10:51 PM?
 * Version: 1.0, only took 1 try ;)
 * Sorry about the weird indentation but BlueJ freaks out sometimes and Crtl-Shift-i didn't fix it ;(
 * Later ppl.
 */
public class MagicSquare
{
    public static void main(){
        Scanner scan = new Scanner(System.in);
        int size = 0;
        int num = 0;
        do {
            System.out.println("What is the size of your square?");
            size = scan.nextInt();
        }while(size % 2 == 0 || size == 1);
        System.out.println();
        int row = size - size; //put in row 0
        int col = size / 2; //put in column 1
        int prevr = 0, prevc = 0;
        int[][] arr = new int[size][size]; //array size 
        while(num < (size * size))
        {
            num++; //increments number, needed to set first number to 1
            print(row, col, size, num);
            System.out.println();
            arr[row][col] = num; //num in array place
            prevr = row;
            prevc = col;
            row--; // **********************
            col++; //increments up one row, right oone col
            if(col < 0)
            {
                col = 1;
            }

            if(row < 0)
            {
                row = size - 1;
                col = col;
            }
            if(row > (size - 1)) //checks for out of bounds then wraps
            {
                row = size - 1;
                col = col;
            }
            if(col > size - 1) //read above comment but for col
            {
                col = size - size;
                row = row;
            } 
            if(arr[row][col] != 0) //if space is full return to old position and move down a row
            {
                row = prevr + 1;
                col = prevc;
            }
            // if row and col meet all requirements return to top of while and increment number and put new number in array;
        }
        for(int r = 0; r < arr.length; r++){ //print array
            for(int c = 0; c < arr.length; c++){
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }

    } 

    public static void print(int row, int col, int size, int num) //used to test for printing each number the coordinates the number goes in
    {
        int[][] temp = new int[size][size]; //temp array for testing
        temp[row][col] = num;
        System.out.print(temp[row][col]); //print value
        System.out.print(" " + "("+row + "," + col + ")"); //coordinate printing
    }
}

