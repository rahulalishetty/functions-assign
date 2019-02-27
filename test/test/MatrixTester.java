package test;

import main.MatrixMaker;
import main.ZeroHandler;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTester{

    @Test
    public void testValidCase() {
        MatrixMaker matrixMaker = new MatrixMaker();
        ZeroHandler zeroHandler = new ZeroHandler();
        matrixMaker.setNoOfRows(4);
        matrixMaker.setNoOfColumns(4);

        int[][] matrixInput = {
        {1, 2, 3, 0},
        {2, 3, 4, 1},
        {4, 3, 0, 1},
        {2, 8, 1, 0}};

        int[][] expectedResult = {
                {0, 0, 0, 0},
                {2, 3, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        matrixMaker.setMatrix(matrixInput);
        int[][] resultMatrix = zeroHandler.zeroInMatrixHandler();

        String resultMatrixString = Arrays
                .stream(resultMatrix)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        String expectedMatrixString = Arrays
                .stream(expectedResult)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expectedMatrixString, resultMatrixString);
    }

    @Test
    public void testValidCaseOne() {
        MatrixMaker matrixMaker = new MatrixMaker();
        ZeroHandler zeroHandler = new ZeroHandler();
        matrixMaker.setNoOfRows(1);
        matrixMaker.setNoOfColumns(1);

        int[][] matrixInput = {{123456}};

        int[][] expectedResult = {{123456}};

        matrixMaker.setMatrix(matrixInput);
        int[][] resultMatrix = zeroHandler.zeroInMatrixHandler();

        String resultMatrixString = Arrays
                .stream(resultMatrix)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        String expectedMatrixString = Arrays
                .stream(expectedResult)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expectedMatrixString, resultMatrixString);
    }

    @Test
    public void testValidCaseTwo() {
        MatrixMaker matrixMaker = new MatrixMaker();
        ZeroHandler zeroHandler = new ZeroHandler();
        matrixMaker.setNoOfRows(4);
        matrixMaker.setNoOfColumns(4);

        int[][] matrixInput = {
                {0, 2, 3, 1},
                {2, 1234, 1234, 1},
                {4, 1234, 1234, 1},
                {2, 1, 1, 0}};

        int[][] expectedResult = {
                {0, 0, 0, 0},
                {0, 1234, 1234, 0},
                {0, 1234, 1234, 0},
                {0, 0, 0, 0}
        };

        matrixMaker.setMatrix(matrixInput);
        int[][] resultMatrix = zeroHandler.zeroInMatrixHandler();

        String resultMatrixString = Arrays
                .stream(resultMatrix)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        String expectedMatrixString = Arrays
                .stream(expectedResult)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expectedMatrixString, resultMatrixString);
    }
}