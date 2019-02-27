package main;

/**
 *
 * ##good practices that are utilized in this code from the reading
 *
 * each function is doing single thing so that the code is maintainable
 *
 * all functions are ordered in next level of abstraction
 *
 * if function needs more than two arguments then the required arguments are wrapped in class MatrixMaker and
 * utililzed from creating object in ZeroHandler class
 *
 *  all blocks contain one or two statements so, that the code is more readable and this will ensure that
 *  function is doing single thing
 *
 *  ##### Space Complexity #####
 *  *  MatrixMaker create a 2d array with dimension M * N i.e O( M*N ) for Matrix Maker
 *  *  ZeroHanler create a 2d array with dimension M * N i.e O( M*N ) for ZeroHandler
 *  *  in total the space complexity is O( 2*M*N )
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class MatrixMaker {
    private static final Scanner scanner=new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(MatrixMaker.class.getName());
    private static int noOfRows;
    private static int noOfColumns;
    private static int[][] matrix;
    private static final String INVALID_INPUT_ERROR_MESSAGE="exception occured as input is not in valid format, please input only in numbers between -2,147,483,648 2,147,483,647";

    public static void main(String[] args) {
        noOfRows=inputHandler("enter value for m: no. of rows");
        noOfColumns=inputHandler("enter value for n: no. of columns");

        try {
            matrix = matrixInputHandler();
            ZeroHandler zeroHandler = new ZeroHandler();
            zeroHandler.zeroInMatrixHandler();
        }catch (NegativeArraySizeException negativeArraySizeException){
            logger.warning("array size cannot be negative");
        }


    }

    /**
     * this function takes input from the user for array size and array elements
     * and handles any exceptions
     *
     * @Params  message to display for user
     * @return  void
     */
    public static int inputHandler(String message){
        int input=0;

        displayInputMessage(message);

        try {
            input = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            logger.warning(INVALID_INPUT_ERROR_MESSAGE);
        }


        return input;
    }

    /**
     * this function takes input from the user for array size and array elements
     * and handles any exceptions
     *
     * @Params  void
     * @return  void
     */
    public static int[][] matrixInputHandler(){

        int[][] matrix= new int[noOfRows][noOfColumns];

        for(int rowTraverser=0; rowTraverser < noOfRows; rowTraverser++){
            for(int columnTraverser = 0; columnTraverser < noOfColumns; columnTraverser++){
                matrix[rowTraverser][columnTraverser] = inputHandler("");
            }
        }

        return matrix;
    }

    /**
     * displays message for user input
     *
     * @Params  void
     * @return  void
     */
    public static void displayInputMessage(String message){
        if(message != "") {
            logger.info(message);
        }
    }

    public static int getNoOfRows() {
        return noOfRows;
    }

    public static int getNoOfColumns() {
        return noOfColumns;
    }

    public static int[][] getMatrix() {
        return matrix;
    }

    public static void setNoOfRows(int noOfRows) {
        MatrixMaker.noOfRows = noOfRows;
    }

    public static void setNoOfColumns(int noOfColumns) {
        MatrixMaker.noOfColumns = noOfColumns;
    }

    public static void setMatrix(int[][] matrix) {
        MatrixMaker.matrix = matrix;
    }
}
