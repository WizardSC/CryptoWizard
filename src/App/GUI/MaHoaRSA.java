/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

/**
 *
 * @author Administrator
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
//import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

public class MaHoaRSA {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // Tạo cặp khóa RSA
        KeyPair keyPair = generateKeyPair();

        // Lấy khóa công khai
        PublicKey publicKey = keyPair.getPublic();

        // Lấy khóa bí mật
        PrivateKey privateKey = keyPair.getPrivate();

        // In ra khóa công khai
        System.out.println("Khóa công khai (Public Key):");
        printPemKey(publicKey);

        // In ra khóa bí mật
        System.out.println("Khóa bí mật (Private Key):");
        printPemKey(privateKey);

        // Thông điệp cần mã hóa
        byte[] plaintext = "PHÚC TOÀN".getBytes("UTF-8");
        byte[] encryptedData = RSAEncrypt(plaintext, publicKey);

        // Hiển thị thông điệp đã mã hóa dưới dạng Base64
        System.out.println("Thông điệp đã mã hóa: " + Base64.getEncoder().encodeToString(encryptedData));

        // Giải mã
        byte[] decryptedData = RSADecrypt(encryptedData, privateKey);
        String decryptedMessage = new String(decryptedData, "UTF-8");
        System.out.println("Thông điệp đã giải mã: " + decryptedMessage);
    }

    // ham tao cap khoa ngau nhien
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    // ham ma hoa voi khoa cong khai
    public static byte[] RSAEncrypt(byte[] data, PublicKey publicKey) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    // ham giai ma voi khoa bi mat
    public static byte[] RSADecrypt(byte[] data, PrivateKey privateKey) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    // ham in ra cap khoa
    public static String printPemKey(Object key) throws Exception {
        PemObject pemObject;
        if (key instanceof PublicKey) {
            pemObject = new PemObject("PUBLIC KEY", ((PublicKey) key).getEncoded());
        } else if (key instanceof PrivateKey) {
            pemObject = new PemObject("PRIVATE KEY", ((PrivateKey) key).getEncoded());
        } else {
            throw new IllegalArgumentException("Unsupported key type");
        }

        StringWriter stringWriter = new StringWriter();
        try (PemWriter pemWriter = new PemWriter(stringWriter)) {
            pemWriter.writeObject(pemObject);
        }

        return stringWriter.toString();
    }
    
    // ham luu khoa vao file text
    public static void saveKeyToFile(Key key, String filePath) throws IOException {
        // Chuyển đổi dữ liệu khóa thành chuỗi Base64
        byte[] encodedKey = key.getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(encodedKey);

        // Ghi chuỗi Base64 vào file
        try (Writer writer = new FileWriter(filePath)) {
            writer.write(base64Key);
        }

        System.out.println("Khóa đã được lưu vào file " + filePath);
    }
    
    // ham doc khoa cong khai tu file text
    public static PublicKey readPublicKeyFromFile(String filePath) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] decodedKeyBytes = Base64.getDecoder().decode(keyBytes);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    // ham doc khoa bi mat tu file text
    public static PrivateKey readPrivateKeyFromFile(String filePath) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] decodedKeyBytes = Base64.getDecoder().decode(keyBytes);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}
