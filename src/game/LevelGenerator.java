package game;

import java.io.*;
import java.util.Scanner;

public class LevelGenerator {

    private static final String BASE_FILE_PATH = "/levels/level";

    private final int levelNumber;

    public LevelGenerator(final int levelNumber) {
        this.levelNumber = levelNumber;
    }

    //todo должен откурыть файл нужный
    // операясь на номер уровня levelNumb, достать матрицу чисел
    // метод private string
    private String getFilePath() {
        return BASE_FILE_PATH + levelNumber;
    }

    private int[][] getBlockCodesFromFile() {
        Scanner scan = new Scanner(getFilePath());
        final int matrixWidth = scan.nextInt();
        final int matrixHeight = scan.nextInt();
        final int[][] matrix = new int[matrixWidth][matrixHeight];
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        return matrix;
    }

    public LevelData generateLevelData() {
        return new LevelData(getBlockCodesFromFile());
    }
}
