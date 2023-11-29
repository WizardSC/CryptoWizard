/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.GUI;

import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author Administrator
 */
public class AffineGUI extends javax.swing.JPanel {

    public AffineGUI() {
        initComponents();
    }

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

    // Kiểm tra khóa, điều kiện a (1 < a, gcd(a, 26) = 1)
    public static boolean isValidKey(int a) {
        return a > 1 && a < Integer.MAX_VALUE && gcd(a, ALPHA_SIZE) == 1;
    }

// Tìm Ước chung lớn nhất của hai số
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Mã hóa Affine
    public static String encrypt(String plaintext, int a, int b) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                int charIndex = Character.toUpperCase(ch) - 'A';
                int encryptedIndex = (a * charIndex + b) % ALPHA_SIZE;
                char encryptedChar = (char) ((encryptedIndex + ALPHA_SIZE) % ALPHA_SIZE + 'A');
                // Bạn cũng có thể sử dụng 'a' thay vì 'A' nếu bạn muốn giữ nguyên kí tự viết thường
                if (Character.isLowerCase(ch)) {
                    encryptedChar = Character.toLowerCase(encryptedChar);
                }
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
                char decryptedChar = (char) ((decryptedIndex + ALPHA_SIZE) % ALPHA_SIZE + 'A'); // Giữ nguyên kiểu chữ cái gốc
                if (Character.isLowerCase(ch)) {
                    decryptedChar = Character.toLowerCase(decryptedChar);
                }
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBanMa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnGiaiMa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAofBanMa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBofBanMa = new javax.swing.JTextField();
        btnResetBanMa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRo = new javax.swing.JTextArea();
        txtBofBanRo = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtAofBanRo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnResetBanRo = new javax.swing.JLabel();
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
        txtBanMa.setRows(5);
        jScrollPane3.setViewportView(txtBanMa);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 42, 502, 304));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("Khóa dịch k");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 149, 45));

        btnGiaiMa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnGiaiMa.setText("Giải mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGiaiMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 106, 47));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel7.setText("Nhập a");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 80, 45));

        txtAofBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtAofBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAofBanMaActionPerformed(evt);
            }
        });
        jPanel2.add(txtAofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 100, 45));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel8.setText("Nhập b");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 80, 45));

        txtBofBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtBofBanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBofBanMaActionPerformed(evt);
            }
        });
        jPanel2.add(txtBofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 100, 45));

        btnResetBanMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-reset-24.png"))); // NOI18N
        btnResetBanMa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetBanMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetBanMaMouseClicked(evt);
            }
        });
        jPanel2.add(btnResetBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(244, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản rõ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBanRo.setColumns(20);
        txtBanRo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanRo.setRows(5);
        jScrollPane2.setViewportView(txtBanRo);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 44, 504, 303));

        txtBofBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtBofBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBofBanRoActionPerformed(evt);
            }
        });
        jPanel3.add(txtBofBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 100, 45));

        btnMaHoa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnMaHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 118, 49));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel4.setText("Nhập b");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 80, 45));

        txtAofBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtAofBanRo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAofBanRoActionPerformed(evt);
            }
        });
        jPanel3.add(txtAofBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 100, 45));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel6.setText("Khóa dịch k");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 149, 45));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel5.setText("Nhập a");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 80, 45));

        btnResetBanRo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/icons8-reset-24.png"))); // NOI18N
        btnResetBanRo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetBanRo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetBanRoMouseClicked(evt);
            }
        });
        jPanel3.add(btnResetBanRo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("HỆ MÃ AFFINE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(443, 443, 443))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
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

        String plaintext = txtBanMa.getText();
        String aInput = txtAofBanMa.getText();
        String bInput = txtBofBanMa.getText();
        if (plaintext.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông điệp cần giải mã", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (aInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hệ số a", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hệ số b", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            int a = Integer.parseInt(aInput);
            int b = Integer.parseInt(bInput);
            if (b <= 0) {
                JOptionPane.showMessageDialog(null, "Hệ số b phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtBofBanRo.setText("");
                return;
            }
            if (isValidKey(a)) {

                String decryptedText = decrypt(plaintext, a, b);
                txtBanRo.setText(decryptedText);
            } else {
                JOptionPane.showMessageDialog(null, "Hệ số a không hợp lệ. Vui lòng nhập một giá trị khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtBanRo.setText("Không thể giải mã với khóa đã nhập.");
                txtAofBanMa.setText("");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị số cho hệ số a và hệ số b.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed

        String plaintext = txtBanRo.getText();
        String aInput = txtAofBanRo.getText();
        String bInput = txtBofBanRo.getText();
        if (plaintext.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông điệp cần mã hóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (aInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hệ số a", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hệ số b", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int a = Integer.parseInt(aInput);
            int b = Integer.parseInt(bInput);
            if (b <= 0) {
                JOptionPane.showMessageDialog(null, "Hệ số b phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtBofBanRo.setText("");
                return;
            }
            if (isValidKey(a)) {
                String encryptedText = encrypt(plaintext, a, b);
                txtBanMa.setText(encryptedText);
            } else {
                JOptionPane.showMessageDialog(null, "Hệ số a không hợp lệ. Vui lòng nhập một giá trị khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtBanMa.setText("Không thể mã hóa với khóa đã nhập.");
                txtAofBanRo.setText("");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị số cho hệ số a và hệ số b.", "Lỗi", JOptionPane.ERROR_MESSAGE);

//            txtBanMa.setText("Không thể mã hóa với khóa đã nhập.");
        }

    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void txtBofBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBofBanRoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBofBanRoActionPerformed

    private void txtAofBanRoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAofBanRoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAofBanRoActionPerformed

    private void txtAofBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAofBanMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAofBanMaActionPerformed

    private void txtBofBanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBofBanMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBofBanMaActionPerformed

    private void btnResetBanRoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetBanRoMouseClicked
        txtBanRo.setText("");
        txtAofBanRo.setText("");
        txtBofBanRo.setText("");
    }//GEN-LAST:event_btnResetBanRoMouseClicked

    private void btnResetBanMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetBanMaMouseClicked
        txtBanMa.setText("");
        txtAofBanMa.setText("");
        txtBofBanMa.setText("");
    }//GEN-LAST:event_btnResetBanMaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JLabel btnResetBanMa;
    private javax.swing.JLabel btnResetBanRo;
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
    private javax.swing.JTextField txtAofBanMa;
    private javax.swing.JTextField txtAofBanRo;
    private javax.swing.JTextArea txtBanMa;
    private javax.swing.JTextArea txtBanRo;
    private javax.swing.JTextField txtBofBanMa;
    private javax.swing.JTextField txtBofBanRo;
    // End of variables declaration//GEN-END:variables
}
