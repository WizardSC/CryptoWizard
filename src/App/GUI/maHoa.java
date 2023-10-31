/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

/**
 *
 * @author Phuc Toan
 */
import java.io.*;
import java.util.Scanner;

public class maHoa {
    // Hàm để mã hóa văn bản sử dụng ma trận Hill
    public static String encrypt(String plaintext, int[][] keyMatrix) {
        int n = keyMatrix.length;
        int[] vector = new int[n];

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += n) {
            for (int j = 0; j < n; j++) {
                if (i + j < plaintext.length()) {
                    vector[j] = plaintext.charAt(i + j) - 'A';
                } else {
                    vector[j] = 0; // Thêm padding nếu cần để đủ kí tự xếp vào ma trận
                }
            }

            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += keyMatrix[j][k] * vector[k];
                }
                encryptedText.append((char) ((sum % 26) + 'A'));
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int[][] keyMatrix;

        while (true) {
            // Nhập ma trận khóa
            System.out.println("Nhập kích thước ma trận khóa (2 hoặc 3): ");
            n = scanner.nextInt();

            if (n == 2 || n == 3) {
                keyMatrix = new int[n][n];
                System.out.println("Nhập ma trận khóa (nhập theo cột) kích thước " + n + "x" + n + ": ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        keyMatrix[i][j] = scanner.nextInt();
                    }
                }
                break; // Thoát khỏi vòng lặp khi kích thước hợp lệ
            } else {
                System.out.println("Kích thước ma trận không hợp lệ. Vui lòng nhập lại!");
            }
        }

        scanner.nextLine(); // Đọc dòng trống

        // Nhập văn bản cần mã hóa từ console
        System.out.println("Nhập văn bản cần mã hóa: ");
        String plaintext = scanner.nextLine();

        // In ra bản rõ
        System.out.println("Bản rõ: " + plaintext);

        // Mã hóa và hiển thị kết quả
        String encryptedText = encrypt(plaintext, keyMatrix);
        System.out.println("Văn bản đã mã hóa: " + encryptedText);
    }
}


