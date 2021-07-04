
package view;

import controller.CaixaEletronico;

public class Screen_GUI extends javax.swing.JFrame {

    CaixaEletronico caixaEletronico = new CaixaEletronico();

    public Screen_GUI() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfQtde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAbastecer = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jfVal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfSacar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btnSacar = new javax.swing.JButton();

        jButton2.setText("X");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(10, 9, 13));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jTabbedPane3.setBackground(new java.awt.Color(194, 41, 220));

        jPanel1.setBackground(new java.awt.Color(138, 0, 255));
        jPanel1.setLayout(null);

        tfQtde.setText("0");
        tfQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQtdeActionPerformed(evt);
            }
        });
        jPanel1.add(tfQtde);
        tfQtde.setBounds(250, 110, 50, 34);

        jLabel1.setBackground(new java.awt.Color(251, 252, 253));
        jLabel1.setForeground(new java.awt.Color(230, 238, 254));
        jLabel1.setText("Valor da nota:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 90, 130, 17);

        jLabel2.setForeground(new java.awt.Color(230, 238, 254));
        jLabel2.setText("Quantidade:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 90, 90, 17);

        btnAbastecer.setText("Abastecer Caixa");
        btnAbastecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbastecerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbastecer);
        btnAbastecer.setBounds(120, 190, 160, 27);

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(274, 10, 100, 27);

        jfVal.setText("0");
        jPanel1.add(jfVal);
        jfVal.setBounds(70, 110, 30, 34);

        jTabbedPane3.addTab("Abastecer caixa", jPanel1);

        jPanel2.setBackground(new java.awt.Color(138, 0, 255));
        jPanel2.setLayout(null);

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Digite um valor para saque:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(100, 90, 230, 17);

        tfSacar.setText("0");
        jPanel2.add(tfSacar);
        tfSacar.setBounds(100, 110, 70, 34);

        jButton5.setText("Fechar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(274, 10, 100, 27);

        btnSacar.setText("Sacar");
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSacar);
        btnSacar.setBounds(120, 190, 160, 27);

        jTabbedPane3.addTab("Sacar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        setSize(new java.awt.Dimension(400, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQtdeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        caixaEletronico.sacar(Integer.parseInt(tfSacar.getText()));
    }//GEN-LAST:event_btnSacarActionPerformed

    private void btnAbastecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbastecerActionPerformed
        caixaEletronico.abastecer(Integer.parseInt(jfVal.getText()), Integer.parseInt(tfQtde.getText()));
    }//GEN-LAST:event_btnAbastecerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbastecer;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jfVal;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JTextField tfSacar;
    // End of variables declaration//GEN-END:variables
}
