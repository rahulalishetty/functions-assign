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
 *
 *  ##### Space Complexity #####
 *  *  MatrixMaker create a 2d array with dimension M * N i.e O( M*N ) for Matrix Maker
 *  *  ZeroHanler create a 2d array with dimension M * N i.e O( M*N ) for ZeroHandler
 *  *  in total the space complexity is O( 2*M*N )
 */

import java.util.Arrays;

public class ZeroHandler {

    private static int[][] matrix;
    private static int[][] updatedMatrix;
    private static MatrixMaker matrixMaker;
    private static int noOfRows;
    private static int noOfColumns;

    /**
     * starting point of updation of zeros in matrix
     * first initializes the required resources from matrix maker class
     * and loops through the array elemets of matrix to search for the zero elements
     *
     * #####this is unit testable function
     *
     * @return  returns the array of updated matrix with zeros
     */
    public int[][] zeroInMatrixHandler(){

        intializeRequiredArrays();

        for(int rowTraverser=0; rowTraverser < noOfRows ; rowTraverser++){
            for(int columnTraverser = 0; columnTraverser < noOfColumns; columnTraverser++){
                matrixElementHandler(rowTraverser, columnTraverser);
            }
        }

        return updatedMatrix;
    }

    /**
     * initialises the matrix reference, updatedMatrix with -1
     *
     * @return  void
     */
    public static void intializeRequiredArrays(){
        matrixMaker = new MatrixMaker();

        matrix = matrixMaker.getMatrix();
        noOfRows = matrixMaker.getNoOfRows();
        noOfColumns = matrixMaker.getNoOfColumns();

        updatedMatrix= new int[noOfRows][noOfColumns];

        for(int[] row: updatedMatrix){
            Arrays.fill(row, -1);
        }
    }

    /**
     * this function takes decision to make row and column 0 depending upon the
     * array element
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void matrixElementHandler(int rowTraverser, int columnTraverser){
        if(checkIfElementIsZero(rowTraverser, columnTraverser)){
            makeRowAndColumnZero(rowTraverser, columnTraverser);
        }else {
            updateInUpdatedMatrix(rowTraverser, columnTraverser);
        }
    }

    /**
     * checks if the element is 0 or not
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  return true if the element is 0 else false
     */
    public static boolean checkIfElementIsZero(int rowTraverser, int columnTraverser){
        return matrix[rowTraverser][columnTraverser] == 0;
    }

    /**
     * it handles the process of making row and column zero
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void makeRowAndColumnZero(int rowTraverser, int columnTraverser){
        makeLeftElementsInRowZero(rowTraverser, columnTraverser);
        makeRightElementsInRowZero(rowTraverser, columnTraverser);
        makeTopElementsInColumnZero(rowTraverser, columnTraverser);
        makeBottomElementsInColumnZero(rowTraverser, columnTraverser);
    }

    /**
     * this function handles updation of non-zero values in updatedArray
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void updateInUpdatedMatrix(int rowTraverser, int columnTraverser){
        if(updatedMatrix[rowTraverser][columnTraverser] != 0){
            updatedMatrix[rowTraverser][columnTraverser] = matrix[rowTraverser][columnTraverser];
        }
    }

    /**
     * updates zero in updatedMatrix for left elements in row of current element
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void makeLeftElementsInRowZero(int rowTraverser, int columnTraverser){
        for(int i=0;i<=columnTraverser;i++){
            updatedMatrix[rowTraverser][i] = 0;
        }
    }

    /**
     * updates zero in updatedMatrix for right elements in row of current element
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void makeRightElementsInRowZero(int rowTraverser, int columnTraverser){
        for(int i=columnTraverser ;i < noOfColumns;i++){
            updatedMatrix[rowTraverser][i] = 0;
        }
    }

    /**
     * updates zero in updatedMatrix for top elements in column of current element
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void makeTopElementsInColumnZero(int rowTraverser, int columnTraverser){
        for(int i=0; i <= rowTraverser;i++){
            updatedMatrix[i][columnTraverser] = 0;
        }
    }

    /**
     * updates zero in updatedMatrix for bottom elements in column of current element
     *
     * @Params  rowTraverser, columnTraverser the indices of current element
     * @return  void
     */
    public static void makeBottomElementsInColumnZero(int rowTraverser, int columnTraverser){
        for(int i=rowTraverser ; i < noOfRows ;i++){
            updatedMatrix[i][columnTraverser] = 0;
        }
    }

}
