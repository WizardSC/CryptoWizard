/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

/**
 *
 * @author Administrator
 */
public class AffineCipher {

    private static final int ALPHA_SIZE = 26;

    // Hàm Euclid mở rộng để tính đảo ngược modulo
    private static int[] extendedEuclidean(int a, int b) {
        int[] vals = new int[3];
        int q, r, x, y;
        if (b == 0) {
            vals[0] = a;
            vals[1] = 1;
            vals[2] = 0;
        } else {
            r = a % b;
            q = (a - r) / b;
            vals = extendedEuclidean(b, r);
            x = vals[2];
            y = vals[1] - q * vals[2];
            vals[1] = x;
            vals[2] = y;
        }
        return vals;
    }

    // Kiểm tra khóa, điều kiện a (1 < a < 26, gcd(a, 26) = 1)
    public static boolean isValidKey(int a) {
        return a > 0 && a < ALPHA_SIZE && extendedEuclidean(a, ALPHA_SIZE)[0] == 1;
    }
    
    // Mã hóa Affine
    public static String encrypt(String plaintext, int a, int b) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                int charIndex = Character.toUpperCase(ch) - 'A';
                int encryptedIndex = (a * charIndex + b) % ALPHA_SIZE;
                char encryptedChar = (char) (encryptedIndex + 'A');
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }

    // Giải mã Affine
    public static String decrypt(String ciphertext, int a, int b) {
        StringBuilder plaintext = new StringBuilder();
        int[] vals = extendedEuclidean(a, ALPHA_SIZE);
        int inverseA = vals[1];
        for (char ch : ciphertext.toCharArray()) {
            if (Character.isLetter(ch)) {
                int charIndex = Character.toUpperCase(ch) - 'A';
                int decryptedIndex = (inverseA * (charIndex - b + ALPHA_SIZE)) % ALPHA_SIZE;
                if (decryptedIndex < 0) {
                    decryptedIndex += ALPHA_SIZE; // Đảm bảo decryptedIndex không âm
                }
                char decryptedChar = (char) (decryptedIndex + 'A');
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }

}
