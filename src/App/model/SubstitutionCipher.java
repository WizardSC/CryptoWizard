package App.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SubstitutionCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  
    public static String encrypt(String plaintext, String key) {
        // ham ma hoa chinh
        StringBuilder ciphertext = new StringBuilder();
        plaintext = plaintext.toLowerCase();
      
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
          
            if (Character.isLetter(c)) {
                int index = ALPHABET.indexOf(c);
                if (index != -1) {
                    char encryptedChar = key.charAt(index);
                    ciphertext.append(encryptedChar);
                }
            } else {
                ciphertext.append(c);
            }
        }
      
        return ciphertext.toString();
    }
  
    /*
    public static void main(String[] args) {
        String plaintext = "hello world";
        String key = "qwertyuiopasdfghjklzxcvbnm";
        String encryptedText = encrypt(plaintext, key);
      
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Key: " + key);
        System.out.println("Encrypted text: " + encryptedText);
    }
    */
    /*
    public static String readTextFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
      
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        return content.toString();
    }
    */
  
    public static boolean isKeyValid(String key) {
        // ham kiem tra key co hop le khong?
        if (key.length() != 26) {
            return false;
        }
      
        for (char c : ALPHABET.toCharArray()) {
            if (key.indexOf(c) == -1) {
                return false;
            }
        }
      
        return true;
    }
  
    /*
    public static void main(String[] args) {
        String filePath = "D:\\1_SGU_TAI_LIEU\\Nam_4_HK1\\4_ATBM-HTTT\\BT_TongHop\\CryptoWizard\\src\\App\\file\\key.txt";
        String key = readTextFromFile(filePath);
      
        System.out.println("Key: " + key);
      
        if (isKeyValid(key)) {
            System.out.println("The key is valid.");
        } else {
            System.out.println("The key is not valid.");
        }
    }
    */
}
