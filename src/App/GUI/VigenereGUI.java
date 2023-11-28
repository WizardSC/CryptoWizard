/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.GUI;

import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import App.readFile.readFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Phuc Toan
 */
public class VigenereGUI extends javax.swing.JPanel {

    private boolean isClickedBanRo = false;
    private boolean isClickedBanMa = false;
    private int randomNumberBanRo;
    private String tempKeyofBanRo;
    private String tempKeyofBanMa;

    public VigenereGUI() {
        initComponents();
        pnRandomNumberBanRo.setVisible(false);
        pnRandomNumberBanMa.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBanMa = new javax.swing.JTextArea();
        btnGiaiMa = new javax.swing.JButton();
        txtKhoaKofBanMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRandomBanMa = new javax.swing.JLabel();
        pnRandomNumberBanMa = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtToiDaBanMa = new javax.swing.JTextField();
        btnOkBanMa = new javax.swing.JButton();
        btnChooseFileBanMa = new javax.swing.JButton();
        btnLuuKhoaBanMa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRo = new javax.swing.JTextArea();
        txtKhoaKofBanRo = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRandomBanRo = new javax.swing.JLabel();
        pnRandomNumberBanRo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtToiDaBanRo = new javax.swing.JTextField();
        btnOkBanRo = new javax.swing.JButton();
        btnChooseFileBanRo = new javax.swing.JButton();
        btnLuuKhoaBanRo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel4.setPreferredSize(new java.awt.Dimension(1153, 689));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1153, 689));

        jPanel2.setBackground(new java.awt.Color(244, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản mã", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBanMa.setColumns(20);
        txtBanMa.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanMa.setLineWrap(true);
        txtBanMa.setRows(5);
        txtBanMa.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtBanMa);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 502, 304));

        btnGiaiMa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnGiaiMa.setText("Giải mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGiaiMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 106, 47));

        txtKhoaKofBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jPanel2.add(txtKhoaKofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 300, 45));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel5.setText("Khóa dịch k");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 149, 45));

        btnRandomBanMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanMa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanMaMouseClicked(evt);
            }
        });
        jPanel2.add(btnRandomBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 40, 40));

        pnRandomNumberBanMa.setBackground(new java.awt.Color(255, 255, 255));
        pnRandomNumberBanMa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnRandomNumberBanMa.setLayout(new java.awt.GridLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nhập m:");
        pnRandomNumberBanMa.add(jLabel7);

        txtToiDaBanMa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pnRandomNumberBanMa.add(txtToiDaBanMa);

        btnOkBanMa.setText("OK");
        btnOkBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBanMaActionPerformed(evt);
            }
        });
        pnRandomNumberBanMa.add(btnOkBanMa);

        jPanel2.add(pnRandomNumberBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 190, 40));

        btnChooseFileBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnChooseFileBanMa.setText("Đọc khóa từ File");
        btnChooseFileBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileBanMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnChooseFileBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, 47));

        btnLuuKhoaBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnLuuKhoaBanMa.setText("Lưu khóa vào File");
        btnLuuKhoaBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKhoaBanMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnLuuKhoaBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, 47));

        jPanel3.setBackground(new java.awt.Color(244, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản rõ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBanRo.setColumns(20);
        txtBanRo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanRo.setLineWrap(true);
        txtBanRo.setRows(5);
        txtBanRo.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtBanRo);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 42, 504, 303));

        txtKhoaKofBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jPanel3.add(txtKhoaKofBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 281, 45));

        btnMaHoa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnMaHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 118, 49));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setText("Khóa dịch k");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 149, 45));

        btnRandomBanRo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanRo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanRo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanRo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanRoMouseClicked(evt);
            }
        });
        jPanel3.add(btnRandomBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 40, 40));

        pnRandomNumberBanRo.setBackground(new java.awt.Color(255, 255, 255));
        pnRandomNumberBanRo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnRandomNumberBanRo.setLayout(new java.awt.GridLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nhập m:");
        pnRandomNumberBanRo.add(jLabel6);

        txtToiDaBanRo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pnRandomNumberBanRo.add(txtToiDaBanRo);

        btnOkBanRo.setText("OK");
        btnOkBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBanRoActionPerformed(evt);
            }
        });
        pnRandomNumberBanRo.add(btnOkBanRo);

        jPanel3.add(pnRandomNumberBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 190, 40));

        btnChooseFileBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnChooseFileBanRo.setText("Đọc khóa từ File");
        btnChooseFileBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileBanRoActionPerformed(evt);
            }
        });
        jPanel3.add(btnChooseFileBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, 40));

        btnLuuKhoaBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnLuuKhoaBanRo.setText("Lưu khóa vào File");
        btnLuuKhoaBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKhoaBanRoActionPerformed(evt);
            }
        });
        jPanel3.add(btnLuuKhoaBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, 40));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("HỆ MÃ VIGENERE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private static int generateRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1; // Chỉnh sửa ở đây
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

// Hàm mã hóa Vigenere
    private String encryptVigenere(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);

            if (Character.isLetter(plainChar)) {
                char base = Character.isUpperCase(plainChar) ? 'A' : 'a';
                char keyChar = key.charAt(i % keyLength);
                int shift = keyChar - base;
                int encryptedChar = (plainChar - base + shift + 26) % 26 + base;
                encryptedText.append((char) encryptedChar);
            } else {
                encryptedText.append(plainChar);
            }
        }

        return encryptedText.toString();
    }

// Hàm giải mã Vigenere
    private String decryptVigenere(String cipherText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherChar = cipherText.charAt(i);

            if (Character.isLetter(cipherChar)) {
                char base = Character.isUpperCase(cipherChar) ? 'A' : 'a';
                char keyChar = key.charAt(i % keyLength);
                int shift = keyChar - base;
                int decryptedChar = (cipherChar - base - shift + 26) % 26 + base;
                decryptedText.append((char) decryptedChar);
            } else {
                decryptedText.append(cipherChar);
            }
        }

        return decryptedText.toString();
    }
    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        String ciphertext = txtBanMa.getText().toUpperCase();
        String key = txtKhoaKofBanMa.getText().toUpperCase();
        if (ciphertext.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập bản rõ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if ( key.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập khóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            char charToDecrypt = ciphertext.charAt(i);

            if (Character.isLetter(charToDecrypt)) {
                char base = Character.isUpperCase(charToDecrypt) ? 'A' : 'a';
                char keyChar = key.charAt(j % key.length());
                int shift = keyChar - 'A';
                int decryptedChar = ((charToDecrypt - base - shift + 26) % 26) + base;
                plaintext.append((char) decryptedChar);
                j = (j + 1) % key.length();
            } else {
                plaintext.append(charToDecrypt);
            }
        }

        txtBanRo.setText(plaintext.toString());
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        String plaintext = txtBanRo.getText().toUpperCase();
        String key = txtKhoaKofBanRo.getText().toUpperCase();
        if (plaintext.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập bản rõ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if ( key.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập khóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char charToEncrypt = plaintext.charAt(i);

            if (Character.isLetter(charToEncrypt)) {
                char base = Character.isUpperCase(charToEncrypt) ? 'A' : 'a';
                char keyChar = key.charAt(j % key.length());
                int shift = keyChar - 'A';
                int encryptedChar = ((charToEncrypt - base + shift) % 26) + base;
                ciphertext.append((char) encryptedChar);
                j = (j + 1) % key.length();
            } else {
                ciphertext.append(charToEncrypt);
            }
        }

        txtBanMa.setText(ciphertext.toString());
    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void btnRandomBanRoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanRoMouseClicked
        isClickedBanRo = !isClickedBanRo;
        if (isClickedBanRo) {
            pnRandomNumberBanRo.setVisible(true);
        } else {
            pnRandomNumberBanRo.setVisible(false);
        }
    }//GEN-LAST:event_btnRandomBanRoMouseClicked

    private void btnRandomBanMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanMaMouseClicked
        isClickedBanMa = !isClickedBanMa;
        if (isClickedBanMa) {
            pnRandomNumberBanMa.setVisible(true);
        } else {
            pnRandomNumberBanMa.setVisible(false);
        }
    }//GEN-LAST:event_btnRandomBanMaMouseClicked

    private void btnOkBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBanRoActionPerformed
        String inputToiDaBanRo = txtToiDaBanRo.getText();

        // Kiểm tra xem người dùng đã nhập hay chưa
        if (inputToiDaBanRo.isEmpty()) {
            return; // Nếu chưa nhập, không làm gì cả
        }

        try {
            int toiDaBanRo = Integer.parseInt(inputToiDaBanRo);

            // Nếu chuyển đổi thành công, tiếp tục xử lý
            String randomString = generateRandomString(toiDaBanRo);

            // Hiển thị chuỗi ngẫu nhiên trong txtKhoaKofBanRo
            txtKhoaKofBanRo.setText(randomString);
            tempKeyofBanRo = txtKhoaKofBanRo.getText();

        } catch (NumberFormatException e) {
            // Xử lý khi người dùng nhập không phải là số
            // Có thể hiển thị một thông báo lỗi hoặc thực hiện hành động khác tùy thuộc vào yêu cầu của bạn
            JOptionPane.showMessageDialog(this, "Hãy nhập một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkBanRoActionPerformed

    private void btnOkBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBanMaActionPerformed
        String inputToiDaBanMa = txtToiDaBanMa.getText();

        // Kiểm tra xem người dùng đã nhập hay chưa
        if (inputToiDaBanMa.isEmpty()) {
            return; // Nếu chưa nhập, không làm gì cả
        }

        try {
            int toiDaBanMa = Integer.parseInt(inputToiDaBanMa);

            // Nếu chuyển đổi thành công, tiếp tục xử lý
            String randomString = generateRandomString(toiDaBanMa);

            // Hiển thị chuỗi ngẫu nhiên trong txtKhoaKofBanMa
            txtKhoaKofBanMa.setText(randomString);
            tempKeyofBanMa = txtKhoaKofBanMa.getText();

        } catch (NumberFormatException e) {
            // Xử lý khi người dùng nhập không phải là số
            // Có thể hiển thị một thông báo lỗi hoặc thực hiện hành động khác tùy thuộc vào yêu cầu của bạn
            JOptionPane.showMessageDialog(this, "Hãy nhập một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkBanMaActionPerformed

    private void btnChooseFileBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileBanRoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("src/App/file/Vigenere");
        int result = fileChooser.showOpenDialog(jPanel3);
        //SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        readFile readFileText = new readFile();

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String key = readFileText.readTextFromFile(selectedFile.getPath());
            txtKhoaKofBanRo.setText(key.toUpperCase());
        }
        tempKeyofBanRo = txtKhoaKofBanRo.getText();

    }//GEN-LAST:event_btnChooseFileBanRoActionPerformed

    private void btnLuuKhoaBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKhoaBanRoActionPerformed
        JFileChooser fileChooser = new JFileChooser("src/App/file/Vigenere");

        int result = fileChooser.showSaveDialog(this); // this là JPanel hoặc JFrame chứa nút

        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn tệp được chọn bởi người dùng
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Lấy khóa từ trường text hoặc từ đâu đó trong ứng dụng
            String key = tempKeyofBanRo;
            try (FileWriter writer = new FileWriter(selectedFilePath + ".txt")) {
                writer.write(key);
                writer.close();
                JOptionPane.showMessageDialog(this, "Khóa đã được lưu vào " + selectedFilePath + ".txt", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu khóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            tempKeyofBanRo = "";
            txtKhoaKofBanRo.setText("");
        }
    }//GEN-LAST:event_btnLuuKhoaBanRoActionPerformed

    private void btnChooseFileBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileBanMaActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("src/App/file/Vigenere");

        int result = fileChooser.showOpenDialog(jPanel3);
        //SubstitutionCipher substitutionCipher = new SubstitutionCipher();

        readFile readFileText = new readFile();

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String key = readFileText.readTextFromFile(selectedFile.getPath());
            txtKhoaKofBanMa.setText(key.toUpperCase());
        }
        tempKeyofBanRo = txtKhoaKofBanMa.getText();
    }//GEN-LAST:event_btnChooseFileBanMaActionPerformed

    private void btnLuuKhoaBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKhoaBanMaActionPerformed
        JFileChooser fileChooser = new JFileChooser("src/App/file/Vigenere");

        int result = fileChooser.showSaveDialog(this); // this là JPanel hoặc JFrame chứa nút

        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn tệp được chọn bởi người dùng
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Lấy khóa từ trường text hoặc từ đâu đó trong ứng dụng
            String key = tempKeyofBanMa;
            try (FileWriter writer = new FileWriter(selectedFilePath + ".txt")) {
                writer.write(key);
                writer.close();
                JOptionPane.showMessageDialog(this, "Khóa đã được lưu vào " + selectedFilePath + ".txt", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu khóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            tempKeyofBanMa = "";
            txtKhoaKofBanMa.setText("");
        }
    }//GEN-LAST:event_btnLuuKhoaBanMaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFileBanMa;
    private javax.swing.JButton btnChooseFileBanRo;
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnLuuKhoaBanMa;
    private javax.swing.JButton btnLuuKhoaBanRo;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnOkBanMa;
    private javax.swing.JButton btnOkBanRo;
    private javax.swing.JLabel btnRandomBanMa;
    private javax.swing.JLabel btnRandomBanRo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnRandomNumberBanMa;
    private javax.swing.JPanel pnRandomNumberBanRo;
    private javax.swing.JTextArea txtBanMa;
    private javax.swing.JTextArea txtBanRo;
    private javax.swing.JTextField txtKhoaKofBanMa;
    private javax.swing.JTextField txtKhoaKofBanRo;
    private javax.swing.JTextField txtToiDaBanMa;
    private javax.swing.JTextField txtToiDaBanRo;
    // End of variables declaration//GEN-END:variables
}
