/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

public class HillCipherDecrypt {

    private static int inverseMod(int det) {
        int[] possibleValues = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
        for (int value : possibleValues) {
            if ((det * value) % 26 == 1) {
                return value;
            }
        }
        return -1;
    }

    private static int[][] matrixInverse(int[][] matrix) {
        int det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int detInverse = inverseMod(det);
        if (detInverse == -1) {
            return null;
        }
        int[][] inverse = new int[2][2];

        inverse[0][0] = (matrix[1][1] * detInverse + 26) % 26;
        inverse[0][1] = (-matrix[0][1] * detInverse + 26) % 26;
        inverse[1][0] = (-matrix[1][0] * detInverse + 26) % 26;
        inverse[1][1] = (matrix[0][0] * detInverse + 26) % 26;
        return inverse;
    }
    //Bản gốc
//    private static String decryptHillCipher(String ciphertext, int[][] key) {
//        int[][] inverseKey = matrixInverse(key);
//        if (inverseKey == null) {
//            return "Không thể giải mã với ma trận khóa đã cho.";
//        }
//        StringBuilder plaintext = new StringBuilder();
//        for (int i = 0; i < ciphertext.length(); i += 2) {
//            int[] block = {ciphertext.charAt(i) - 'A', ciphertext.charAt(i + 1) - 'A'};
//            int[] decryptedBlock = {((block[0] * inverseKey[0][0] + block[1] * inverseKey[1][0]) + 26) % 26,
//                                    ((block[0] * inverseKey[0][1] + block[1] * inverseKey[1][1]) + 26) % 26};
//            plaintext.append((char) (decryptedBlock[0] + 'A')).append((char) (decryptedBlock[1] + 'A'));
//        }
//        return plaintext.toString();
//    }

    private static String decryptHillCipher(String ciphertext, int[][] key) {
        int[][] inverseKey = matrixInverse(key);
        if (inverseKey == null) {
            return "Không thể giải mã với ma trận khóa đã cho.";
        }
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            int[] block = {ciphertext.charAt(i) - 'A', ciphertext.charAt(i + 1) - 'A'};
            int[] decryptedBlock = new int[2];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    decryptedBlock[j] += block[k] * inverseKey[k][j];
                }
                decryptedBlock[j] = (decryptedBlock[j] % 26 + 26) % 26; // Chia lấy phần dư cho 26
            }
            plaintext.append((char) (decryptedBlock[0] + 'A')).append((char) (decryptedBlock[1] + 'A'));
        }
        return plaintext.toString();
    }

//    private static String decryptHillCipher(String ciphertext, int[][] key) {
//    int[][] inverseKey = matrixInverse(key);
//    if (inverseKey == null) {
//        return "Không thể giải mã với ma trận khóa đã cho.";
//    }
//    StringBuilder plaintext = new StringBuilder();
//    for (int i = 0; i < ciphertext.length(); i += 2) {
//        int[] block = {ciphertext.charAt(i) - 'A', ciphertext.charAt(i + 1) - 'A'};
//        int[] decryptedBlock = new int[2];
//        for (int j = 0; j < 2; j++) {
//            for (int k = 0; k < 2; k++) {
//                decryptedBlock[j] += block[k] * inverseKey[k][j];
//            }
//            decryptedBlock[j] = (decryptedBlock[j] + 26) % 26;
//        }
//        plaintext.append((char) (decryptedBlock[0] + 'A')).append((char) (decryptedBlock[1] + 'A'));
//    }
//    return plaintext.toString();
//}
    public static void main(String[] args) {
        String ciphertext = "dple";
        // viết thêm upper để input là chữ in hoa
        ciphertext = ciphertext.toUpperCase();

        //int[][] key = {{7,3}, {18,11}};
        int[][] key = {{3,3}, {2,5}};

        String plaintext = decryptHillCipher(ciphertext, key);
        System.out.println("Chuỗi đã giải mã: " + plaintext);
    }
}
