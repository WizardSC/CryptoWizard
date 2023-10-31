/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App.GUI;

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

    private int[][] parseKey(String key) {
        key = key.replaceAll("\\s+", " ").trim(); // Loại bỏ khoảng trắng thừa ở đầu và cuối, thay thế dấu cách liên tiếp bằng một dấu cách duy nhất
        String[] valuesStr = key.split(" ");
        int n = (int) Math.sqrt(valuesStr.length);

        if (n * n != valuesStr.length) {
            return null;
        }

        int[][] keyMatrix = new int[n][n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                keyMatrix[i][j] = Integer.parseInt(valuesStr[index]);
                index++;
            }
        }

        return keyMatrix;
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBanRo = new javax.swing.JTextArea();
        txtKhoaKofBanRo = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel4.setPreferredSize(new java.awt.Dimension(1153, 689));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1153, 689));

        jPanel2.setBackground(new java.awt.Color(244, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản mã", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKhoaKofBanMa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jPanel2.add(txtKhoaKofBanMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 372, 330, 45));

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
        jPanel2.add(btnGiaiMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 106, 47));

        jPanel3.setBackground(new java.awt.Color(244, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bản rõ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 24))); // NOI18N

        txtBanRo.setColumns(20);
        txtBanRo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtBanRo.setRows(5);
        jScrollPane2.setViewportView(txtBanRo);

        txtKhoaKofBanRo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        btnMaHoa.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setText("Khóa dịch k");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Cách nhập khóa: Ví dụ 7 3 18 11 tương tự {7,18},{3,11}");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhoaKofBanRo, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnMaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(365, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtKhoaKofBanRo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnMaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(347, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(224, 224, 224)))
        );

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("HỆ MÃ HILL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(515, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(443, 443, 443))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(603, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        String key = txtKhoaKofBanMa.getText().toUpperCase();
        int[][] keyMatrix = parseKey(key);
        if (keyMatrix != null) {
            String plaintext = decryptHillCipher(ciphertext, keyMatrix);
            txtBanRo.setText(plaintext);
        } else {
            txtBanRo.setText("Không thể giải mã với ma trận khóa đã cho.");
        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        String plaintext = txtBanRo.getText().toUpperCase();
        String key = txtKhoaKofBanRo.getText().toUpperCase();
        int[][] keyMatrix = parseKey(key);

        if (keyMatrix != null) {
            StringBuilder ciphertext = new StringBuilder();

            for (int i = 0; i < plaintext.length(); i += 2) {
                int[] block = {plaintext.charAt(i) - 'A', plaintext.charAt(i + 1) - 'A'};
                int[] encryptedBlock = new int[2];

                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        encryptedBlock[j] += block[k] * keyMatrix[k][j];
                    }
                    encryptedBlock[j] = encryptedBlock[j] % 26; // Lấy phần dư cho 26
                }

                ciphertext.append((char) (encryptedBlock[0] + 'A')).append((char) (encryptedBlock[1] + 'A'));
            }

            txtBanMa.setText(ciphertext.toString());
        } else {
            txtBanMa.setText("Không thể mã hóa với ma trận khóa đã cho.");
        }
    }//GEN-LAST:event_btnMaHoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
