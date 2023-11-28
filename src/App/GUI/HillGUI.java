/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.GUI;

import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Phuc Toan
 */
public class HillGUI extends javax.swing.JPanel {

    /**
     * Creates new form HillGUI
     */
    public HillGUI() {
        initComponents();
    }

    public static String encryptHill(String plaintext, int[][] key) {
        if (plaintext.length() % 2 != 0) {
            plaintext += 'X';
        }
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            if (Character.isLetter(plaintext.charAt(i)) && Character.isLetter(plaintext.charAt(i + 1))) {
                int char1 = getCharValue(plaintext.charAt(i));
                int char2 = getCharValue(plaintext.charAt(i + 1));

                int encryptedChar1 = encryptChar(char1, char2, key, 0);
                int encryptedChar2 = encryptChar(char1, char2, key, 1);

                if (Character.isUpperCase(plaintext.charAt(i))) {
                    encryptedChar1 = Character.toUpperCase(getChar(encryptedChar1));
                }
                if (Character.isUpperCase(plaintext.charAt(i + 1))) {
                    encryptedChar2 = Character.toUpperCase(getChar(encryptedChar2));
                }

                encryptedText.append((char) encryptedChar1);
                encryptedText.append((char) encryptedChar2);
            } else {
                encryptedText.append(plaintext.charAt(i));
                encryptedText.append(plaintext.charAt(i + 1));
            }
        }
        // Loại bỏ ký tự 'X' được thêm vào cuối chuỗi khi mã hóa
        if (encryptedText.charAt(encryptedText.length() - 1) == 'X') {
            encryptedText.deleteCharAt(encryptedText.length() - 1);
        }
        return encryptedText.toString();
    }

    public static String decryptHill(String ciphertext, int[][] key) {
        if (ciphertext.length() % 2 != 0) {
            ciphertext += 'X';
        }
        StringBuilder decryptedText = new StringBuilder();

        int[][] inverseKey = getInverseKey(key);

        for (int i = 0; i < ciphertext.length(); i += 2) {
            if (Character.isLetter(ciphertext.charAt(i)) && Character.isLetter(ciphertext.charAt(i + 1))) {
                int char1 = getCharValue(ciphertext.charAt(i));
                int char2 = getCharValue(ciphertext.charAt(i + 1));

                int decryptedChar1 = decryptChar(char1, char2, inverseKey, 0);
                int decryptedChar2 = decryptChar(char1, char2, inverseKey, 1);

                if (Character.isUpperCase(ciphertext.charAt(i))) {
                    decryptedChar1 = Character.toUpperCase(getChar(decryptedChar1));
                }
                if (Character.isUpperCase(ciphertext.charAt(i + 1))) {
                    decryptedChar2 = Character.toUpperCase(getChar(decryptedChar2));
                }

                decryptedText.append((char) decryptedChar1);
                decryptedText.append((char) decryptedChar2);
            } else {
                decryptedText.append(ciphertext.charAt(i));
                decryptedText.append(ciphertext.charAt(i + 1));
            }
        }
        if (decryptedText.charAt(decryptedText.length() - 1) == 'X') {
            decryptedText.deleteCharAt(decryptedText.length() - 1);
        }
        return decryptedText.toString();
    }

    // Các hàm bổ trợ
    private static int encryptChar(int char1, int char2, int[][] key, int column) {
        return key[column][0] * char1 + key[column][1] * char2;
    }

    private static int decryptChar(int char1, int char2, int[][] key, int row) {
        return key[row][0] * char1 + key[row][1] * char2;
    }

    private static int getCharValue(char c) {
        return Character.isUpperCase(c) ? c - 'A' : c - 'a';
    }

    private static char getChar(int value) {
        return (char) ((value % 26 + 26) % 26 + 'a');
    }

    private static int[][] getInverseKey(int[][] key) {
        int determinant = key[0][0] * key[1][1] - key[0][1] * key[1][0];
        int determinantInverse = modInverseHill(determinant, 26);

        int[][] inverseKey = {
            {key[1][1], -key[0][1]},
            {-key[1][0], key[0][0]}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inverseKey[i][j] = mod(inverseKey[i][j] * determinantInverse, 26);
            }
        }

        return inverseKey;
    }
    //Hàm random ngẫu nhiên khóa
    private static final int[] VALID_INVERSES = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};

    public static int[][] generateRandomKey() {
        SecureRandom random = new SecureRandom();
        int[][] keyMatrix;

        do {
            keyMatrix = new int[2][2];

            // Sinh ngẫu nhiên các giá trị cho ma trận key
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    keyMatrix[i][j] = random.nextInt(26); // Số nguyên từ 0 đến 25
                }
            }

            // Tính determinant và inverse
            int determinant = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
            int determinantInverse = modInverseHill(determinant, 26);

            // Kiểm tra xem determinantInverse có thuộc {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25} không
            if (isValidDeterminantInverse(determinantInverse)) {
                // Chọn một phần tử nghịch đảo phù hợp từ VALID_INVERSES
                int chosenInverse = VALID_INVERSES[random.nextInt(VALID_INVERSES.length)];

                // Áp dụng inverse cho ma trận key
                keyMatrix = applyInverse(keyMatrix, determinantInverse, chosenInverse);
            }
        } while (!isValidKey(keyMatrix));

        return keyMatrix;
    }

    private static boolean isValidDeterminantInverse(int determinantInverse) {
        // Kiểm tra xem determinantInverse có thuộc {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25} không
        int[] validValues = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
        for (int value : validValues) {
            if (determinantInverse == value) {
                return true;
            }
        }
        return false;
    }

    public static String keyMatrixToString(int[][] keyMatrix) {
        StringBuilder keyString = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyString.append(keyMatrix[i][j]).append(" ");
            }
        }
        return keyString.toString().trim();
    }

    private static int[][] applyInverse(int[][] key, int determinantInverse, int chosenInverse) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                key[i][j] = mod(key[i][j] * determinantInverse * chosenInverse, 26);
            }
        }
        return key;
    }

    private static int modInverseHill(int a, int m) {
        a = mod(a, m);
        for (int x = 1; x < m; x++) {
            if (mod(a * x, m) == 1) {
                return x;
            }
        }
        throw new RuntimeException("Phần tử nghịch đảo modulo không tồn tại.");
    }

    private static int mod(int a, int m) {
        return (a % m + m) % m;
    }

    private int[][] getKeyMatrix(String key) {

        // Chuyển key thành một mảng số nguyên
        String[] keyValues = key.split("\\s+");
        int[] keyArray = new int[keyValues.length];

        for (int i = 0; i < keyValues.length; i++) {
            keyArray[i] = Integer.parseInt(keyValues[i]);
        }

        // Kiểm tra nếu số lượng phần tử đủ để tạo ma trận 2x2
        if (keyArray.length == 4) {
            int[][] keyMatrix = new int[2][2];
            keyMatrix[0][0] = keyArray[0];
            keyMatrix[0][1] = keyArray[1];
            keyMatrix[1][0] = keyArray[2];
            keyMatrix[1][1] = keyArray[3];
            return keyMatrix;
        } else {
            throw new RuntimeException("Định dạng khóa không hợp lệ. Vui lòng nhập 4 số nguyên, cách nhau bởi khoảng trắng");
        }
    }

    private static boolean isValidKey(int[][] key) {
        // Kiểm tra tính hợp lệ của determinantInverse
        int determinant = key[0][0] * key[1][1] - key[0][1] * key[1][0];
        int determinantInverse = modInverseHill(determinant, 26);

        if (!isValidDeterminantInverse(determinantInverse)) {
            return false;
        }

        // Kiểm tra giá trị của từng phần tử trong ma trận khóa
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (key[i][j] < 0 || key[i][j] >= 26) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtKhoaKofBanMa = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBanMa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnGiaiMa = new javax.swing.JButton();
        btnRandomBanMa = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRo = new javax.swing.JTextArea();
        txtKhoaKofBanRo = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRandomBanRo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel4.setPreferredSize(new java.awt.Dimension(1153, 689));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1153, 689));

        jPanel2.setBackground(new java.awt.Color(244, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản mã", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKhoaKofBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jPanel2.add(txtKhoaKofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 372, 290, 45));

        txtBanMa.setColumns(20);
        txtBanMa.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanMa.setRows(5);
        jScrollPane3.setViewportView(txtBanMa);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 42, 502, 304));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("Khóa dịch k");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 372, 149, 45));

        btnGiaiMa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnGiaiMa.setText("Giải mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGiaiMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 106, 47));

        btnRandomBanMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanMa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanMaMouseClicked(evt);
            }
        });
        jPanel2.add(btnRandomBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 40, 50));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel7.setText("Cách nhập khóa: Nhập ma trận 2x2");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 496, 45));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel8.setText("Ví dụ: {3,2,3,5}");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 496, 45));

        jPanel3.setBackground(new java.awt.Color(244, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản rõ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBanRo.setColumns(20);
        txtBanRo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanRo.setRows(5);
        jScrollPane2.setViewportView(txtBanRo);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 44, 504, 303));

        txtKhoaKofBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jPanel3.add(txtKhoaKofBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 381, 290, 45));

        btnMaHoa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnMaHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 118, 49));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setText("Khóa dịch k");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 382, 149, 45));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setText("Ví dụ: {3,2,3,5}");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 496, 45));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel6.setText("Cách nhập khóa: Nhập ma trận 2x2");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 444, 496, 45));

        btnRandomBanRo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanRo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanRo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanRo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanRoMouseClicked(evt);
            }
        });
        jPanel3.add(btnRandomBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 40, 50));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("HỆ MÃ HILL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(443, 443, 443))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 701));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        String ciphertext = txtBanMa.getText().toUpperCase();
        String key = txtKhoaKofBanMa.getText();

        try {
            int[][] keyMatrix = getKeyMatrix(key);
            if (isValidKey(keyMatrix)) {
                String plaintext = decryptHill(ciphertext, keyMatrix);
                txtBanRo.setText(plaintext);
            } else {
                txtBanRo.setText("Không thể giải mã với ma trận khóa đã cho. Không hợp lệ.");
            }
        } catch (Exception e) {
            txtBanRo.setText("Không thể giải mã với ma trận khóa đã cho. ");
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        String plaintext = txtBanRo.getText().toUpperCase();
        String key = txtKhoaKofBanRo.getText();
        try {
            int[][] keyMatrix = getKeyMatrix(key);
            if (isValidKey(keyMatrix)) {
                String ciphertext = encryptHill(plaintext, keyMatrix);
                txtBanMa.setText(ciphertext);
            } else {
                txtBanMa.setText("Không thể mã hóa với ma trận khóa đã cho. Không hợp lệ.");
            }
        } catch (Exception e) {
            txtBanMa.setText("Không thể mã hóa với ma trận khóa đã cho. ");
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void btnRandomBanRoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanRoMouseClicked
        try {
            txtKhoaKofBanRo.setText("");
            int[][] randomKey;
            boolean isValidKey = false;

            while (!isValidKey) {
                randomKey = generateRandomKey();
                isValidKey = isValidKey(randomKey);

                if (isValidKey) {
                    String keyString = keyMatrixToString(randomKey);
                    txtKhoaKofBanRo.setText(keyString);
                }
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Không thể tạo khóa ngẫu nhiên. " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRandomBanRoMouseClicked

    private void btnRandomBanMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanMaMouseClicked
        try {
            txtKhoaKofBanMa.setText("");
            int[][] randomKey;
            boolean isValidKey = false;

            while (!isValidKey) {
                randomKey = generateRandomKey();
                isValidKey = isValidKey(randomKey);

                if (isValidKey) {
                    String keyString = keyMatrixToString(randomKey);
                    txtKhoaKofBanMa.setText(keyString);
                }
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Không thể tạo khóa ngẫu nhiên. " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRandomBanMaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JLabel btnRandomBanMa;
    private javax.swing.JLabel btnRandomBanRo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtBanMa;
    private javax.swing.JTextArea txtBanRo;
    private javax.swing.JTextField txtKhoaKofBanMa;
    private javax.swing.JTextField txtKhoaKofBanRo;
    // End of variables declaration//GEN-END:variables
}
