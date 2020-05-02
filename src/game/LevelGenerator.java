package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelGenerator {

    private static final String BASE_FILE_PATH = "./src/levels/level";

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
        final String filePath = getFilePath();

        Scanner scan = null;
        try {
            scan = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final int matrixWidth = scan.nextInt();

        final int matrixHeight = scan.nextInt();
        final int[][] matrix = new int[matrixWidth][matrixHeight];
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                matrix[j][i] = scan.nextInt();
            }
        }
        return matrix;
    }

    public LevelData generateLevelData() {
        return new LevelData(getBlockCodesFromFile());
    }
}
