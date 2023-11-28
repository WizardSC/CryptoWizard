/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.GUI;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Phuc Toan
 */
public class CaeserGUI extends javax.swing.JPanel {

    private boolean isClicked = false;
    private boolean isClickedBanMa = false;

    public CaeserGUI() {

        initComponents();
        System.out.println("aaaa");
        pnRandomNumberBanRo.setVisible(false);
        pnRandomNumberBanMa.setVisible(false);
    }

    //Hàm random 1 số trong 1 khoảng cho trước
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtKhoaKofBanMa = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBanMa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnGiaiMa = new javax.swing.JButton();
        btnRandomBanMa = new javax.swing.JLabel();
        pnRandomNumberBanMa = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtToiThieuBanMa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtToiDaBanMa = new javax.swing.JTextField();
        btnOkBanMa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtKhoaKofBanRo = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        btnRandomBanRo = new javax.swing.JLabel();
        pnRandomNumberBanRo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtToiThieuBanRo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtToiDaBanRo = new javax.swing.JTextField();
        btnOkBanRo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1108, 702));

        jPanel1.setBackground(new java.awt.Color(244, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1153, 689));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(244, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản mã", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKhoaKofBanMa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jPanel2.add(txtKhoaKofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 246, 45));

        txtBanMa.setColumns(20);
        txtBanMa.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanMa.setLineWrap(true);
        txtBanMa.setRows(5);
        txtBanMa.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtBanMa);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 42, 505, 304));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("Khóa dịch k");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 149, 45));

        btnGiaiMa.setText("Giải mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGiaiMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 535, 109, 43));

        btnRandomBanMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanMa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanMaMouseClicked(evt);
            }
        });
        jPanel2.add(btnRandomBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 40, 40));

        pnRandomNumberBanMa.setBackground(new java.awt.Color(255, 255, 255));
        pnRandomNumberBanMa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnRandomNumberBanMa.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Từ");
        pnRandomNumberBanMa.add(jLabel6);
        pnRandomNumberBanMa.add(txtToiThieuBanMa);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đến");
        pnRandomNumberBanMa.add(jLabel7);
        pnRandomNumberBanMa.add(txtToiDaBanMa);

        btnOkBanMa.setText("OK");
        btnOkBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBanMaActionPerformed(evt);
            }
        });
        pnRandomNumberBanMa.add(btnOkBanMa);

        jPanel2.add(pnRandomNumberBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 260, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 47, 530, 642));

        jPanel3.setBackground(new java.awt.Color(244, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản rõ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBanRo.setColumns(20);
        txtBanRo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanRo.setLineWrap(true);
        txtBanRo.setRows(5);
        txtBanRo.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtBanRo);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 44, 500, 303));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Cách nhập khóa: Vd: 2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 149, 45));

        txtKhoaKofBanRo.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jPanel3.add(txtKhoaKofBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 246, 45));

        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnMaHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 109, 43));

        btnRandomBanRo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRandomBanRo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-dice-30.png"))); // NOI18N
        btnRandomBanRo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRandomBanRo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRandomBanRoMouseClicked(evt);
            }
        });
        jPanel3.add(btnRandomBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 40, 40));

        pnRandomNumberBanRo.setBackground(new java.awt.Color(255, 255, 255));
        pnRandomNumberBanRo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnRandomNumberBanRo.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Từ");
        pnRandomNumberBanRo.add(jLabel4);
        pnRandomNumberBanRo.add(txtToiThieuBanRo);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đến");
        pnRandomNumberBanRo.add(jLabel5);
        pnRandomNumberBanRo.add(txtToiDaBanRo);

        btnOkBanRo.setText("OK");
        btnOkBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBanRoActionPerformed(evt);
            }
        });
        pnRandomNumberBanRo.add(btnOkBanRo);

        jPanel3.add(pnRandomNumberBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 260, 40));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setText("Khóa dịch k");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 149, 45));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 47, 537, 642));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("HỆ MÃ CAESAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    public String caesarCipher(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char encryptedChar = (char) (((currentChar - base + key) % 26) + base);
                result.append(encryptedChar);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        String inputText = txtBanRo.getText();
        if (inputText.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập bản rõ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (txtKhoaKofBanRo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập khóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
                    int key = Integer.parseInt(txtKhoaKofBanRo.getText());
            String encryptedText = caesarCipher(inputText, key);
            txtBanMa.setText(encryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Khóa không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        
    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        try {
            String ciphertext = txtBanMa.getText();
            if (ciphertext.equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập bản mã", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtKhoaKofBanMa.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập khóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int shift = Integer.parseInt(txtKhoaKofBanMa.getText());

            StringBuilder decryptedText = new StringBuilder();

            for (int i = 0; i < ciphertext.length(); i++) {
                char currentChar = ciphertext.charAt(i);

                if (Character.isLetter(currentChar)) {
                    char shiftedChar;

                    if (Character.isLowerCase(currentChar)) {
                        shiftedChar = (char) ('a' + (currentChar - 'a' - shift + 26) % 26);
                    } else {
                        shiftedChar = (char) ('A' + (currentChar - 'A' - shift + 26) % 26);
                    }

                    decryptedText.append(shiftedChar);
                } else {
                    decryptedText.append(currentChar);
                }
            }

            txtBanRo.setText(decryptedText.toString());
        } catch (NumberFormatException ex) {
            txtBanRo.setText("Lỗi: Nhập giá trị không hợp lệ.");
        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnRandomBanRoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanRoMouseClicked
        isClicked = !isClicked;
        if (isClicked) {
            pnRandomNumberBanRo.setVisible(true);

        } else {
            pnRandomNumberBanRo.setVisible(false);
        }

    }//GEN-LAST:event_btnRandomBanRoMouseClicked

    private void btnOkBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBanRoActionPerformed
        int toiThieuBanRo = Integer.parseInt(txtToiThieuBanRo.getText());
        int toiDaBanRo = Integer.parseInt(txtToiDaBanRo.getText());
        if (txtToiThieuBanRo.getText().equals("") || txtToiDaBanRo.getText().equals("")) {
            return;
        }
        int randomNumber = generateRandomNumber(toiThieuBanRo, toiDaBanRo);
        txtKhoaKofBanRo.setText(String.valueOf(randomNumber));
    }//GEN-LAST:event_btnOkBanRoActionPerformed

    private void btnOkBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBanMaActionPerformed
        int toiThieuBanMa = Integer.parseInt(txtToiThieuBanMa.getText());
        int toiDaBanMa = Integer.parseInt(txtToiDaBanMa.getText());
        if (txtToiThieuBanMa.getText().equals("") || txtToiDaBanMa.getText().equals("")) {
            return;
        }
        int randomNumber = generateRandomNumber(toiThieuBanMa, toiDaBanMa);
        txtKhoaKofBanMa.setText(String.valueOf(randomNumber));
    }//GEN-LAST:event_btnOkBanMaActionPerformed

    private void btnRandomBanMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRandomBanMaMouseClicked
        isClickedBanMa = !isClickedBanMa;
        if (isClickedBanMa) {
            pnRandomNumberBanMa.setVisible(true);
        } else {
            pnRandomNumberBanMa.setVisible(false);
        }
    }//GEN-LAST:event_btnRandomBanMaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnOkBanMa;
    private javax.swing.JButton btnOkBanRo;
    private javax.swing.JLabel btnRandomBanMa;
    private javax.swing.JLabel btnRandomBanRo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTextField txtToiThieuBanMa;
    private javax.swing.JTextField txtToiThieuBanRo;
    // End of variables declaration//GEN-END:variables
}
