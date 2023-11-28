/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

/**
 *
 * @author Administrator
 */
import java.util.Arrays;

public class PlayfairCipher {

    private final char[][] matrix;
    private final char paddingChar;
    private final String key;

    public PlayfairCipher(String key) {
        this.key = key.toUpperCase();
        this.paddingChar = 'X';
        this.matrix = generateMatrix();
    }

    private char[][] generateMatrix() {
        char[][] matrix = new char[5][5];
        String paddedKey = padKey(key);
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        String keyAlphabet = paddedKey + alphabet;

        // Create matrix
        int row = 0;
        int col = 0;
        for (int i = 0; i < keyAlphabet.length(); i++) {
            char c = keyAlphabet.charAt(i);
            if (!isCharInMatrix(matrix, c)) {
                matrix[row][col] = c;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        return matrix;
    }

    private String padKey(String key) {
        StringBuilder paddedKey = new StringBuilder(key);

        for (int i = 0; i < paddedKey.length(); i++) {
            char c = paddedKey.charAt(i);
            if (c == 'J') {
                paddedKey.setCharAt(i, 'I');
            }
        }

        for (int i = 0; i < paddedKey.length() - 1; i += 2) {
            if (paddedKey.charAt(i) == paddedKey.charAt(i + 1)) {
                paddedKey.insert(i + 1, paddingChar);
            }
        }

        if (paddedKey.length() % 2 != 0) {
            paddedKey.append(paddingChar);
        }

        return paddedKey.toString();
    }

    private boolean isCharInMatrix(char[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] findCharInMatrix(char[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();

        String processedText = preprocessText(plaintext);

        for (int i = 0; i < processedText.length(); i += 2) {
            char c1 = processedText.charAt(i);
            char c2 = processedText.charAt(i + 1);

            int[] pos1 = findCharInMatrix(matrix, c1);
            int[] pos2 = findCharInMatrix(matrix, c2);

            int row1 = pos1[0];
            int col1 = pos1[1];
            int row2 = pos2[0];
            int col2 = pos2[1];

            if (row1 == row2) {
                col1 = (col1 + 1) % 5;
                col2 = (col2 + 1) % 5;
            } else if (col1 == col2) {
                row1 = (row1 + 1) % 5;
                row2 = (row2 + 1) % 5;
            } else {
                int temp = col1;
                col1 = col2;
                col2 = temp;
            }

            ciphertext.append(matrix[row1][col1]);
            ciphertext.append(matrix[row2][col2]);
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        String processedText = preprocessText(ciphertext);

        for (int i = 0; i < processedText.length(); i += 2) {
            char c1 = processedText.charAt(i);
            char c2 = processedText.charAt(i + 1);

            int[] pos1 = findCharInMatrix(matrix, c1);
            int[] pos2 = findCharInMatrix(matrix, c2);

            int row1 = pos1[0];
            int col1 = pos1[1];
            int row2 = pos2[0];
            int col2 = pos2[1];

            if (row1 == row2) {
                col1 = (col1 - 1 + 5) % 5;
                col2 = (col2 - 1 + 5) % 5;
            } else if (col1 == col2) {
                row1 = (row1 - 1 + 5) % 5;
                row2 = (row2 - 1 + 5) % 5;
            } else {
                int temp = col1;
                col1 = col2;
                col2 = temp;
            }

            plaintext.append(matrix[row1][col1]);
            plaintext.append(matrix[row2][col2]);
        }

        return plaintext.toString();
    }

    private String preprocessText(String text) {
        StringBuilder processedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toUpperCase(text.charAt(i));
            if (Character.isLetter(c)) {
                processedText.append(c);
            }
        }

        for (int i = 0; i < processedText.length() - 1; i += 2) {
            if (processedText.charAt(i) == processedText.charAt(i + 1)) {
                processedText.insert(i + 1, paddingChar);
            }
        }

        if (processedText.length() % 2 != 0) {
            processedText.append(paddingChar);
        }

        return processedText.toString();
    }

    public static void main(String[] args) {
        String key = "PLAYFAIR";
        PlayfairCipher cipher = new PlayfairCipher(key);

        String plaintext = "HELLO";
        String ciphertext = cipher.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = cipher.decrypt(ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
