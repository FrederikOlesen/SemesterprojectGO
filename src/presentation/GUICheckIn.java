/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Control;
import javax.swing.JOptionPane;

/**
 *
 * @author frederikolesen
 */
public class GUICheckIn extends javax.swing.JFrame {

    Control con = new Control();

    public GUICheckIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldresNumber = new javax.swing.JTextField();
        jButtonCheckIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldresNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldresNumber.setText(" Enter Reservationsnumber");
        jTextFieldresNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldresNumberMouseClicked(evt);
            }
        });
        jTextFieldresNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldresNumberActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldresNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 252, -1));

        jButtonCheckIn.setText("Check In");
        jButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //This method search after the reservationnumber, and generates sportsID.
    private void jButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInActionPerformed
        int resNumber = Integer.parseInt(jTextFieldresNumber.getText());
        //Searchs after reservationnumber. 
        String name = con.findNameFromResNo(resNumber);
        //Generates sportsID.
        con.createCustomerID(resNumber);
        if (" ".equals(name)) {
            JOptionPane.showMessageDialog(rootPane, "Invalid reservation number");
            JOptionPane.showMessageDialog(rootPane, "Contact hotel management!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Welcome to Hotel Casablanca " + name);
        }//error handling messages to inform the user about incorrect information
    }//GEN-LAST:event_jButtonCheckInActionPerformed

    private void jTextFieldresNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldresNumberActionPerformed

    }//GEN-LAST:event_jTextFieldresNumberActionPerformed

    private void jTextFieldresNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldresNumberMouseClicked
        jTextFieldresNumber.setText("");
    }//GEN-LAST:event_jTextFieldresNumberMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCheckIn;
    private javax.swing.JTextField jTextFieldresNumber;
    // End of variables declaration//GEN-END:variables
}
