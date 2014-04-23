/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Control;
import domain.SportsBooking;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mads
 */
public class GUIsportsBook extends javax.swing.JFrame {

    /**
     * Creates new form GUIsportsBook
     */
    Control con = new Control();
    SportsBooking sp;

    public GUIsportsBook() {
        initComponents();
//        DateFormat sysdate = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        con.deleteOldSportsBooking(sysdate.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxSportsBooking = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonBook = new javax.swing.JButton();
        jComboBoxTime = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxInstructor = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5status = new javax.swing.JLabel();
        jXDatePickerSportDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jLabelStatusSportsBook = new javax.swing.JLabel();
        jLabelSportsBookStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxSportsBooking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tennis", "Badminton", "Golf", "Swimming" }));
        jComboBoxSportsBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSportsBookingActionPerformed(evt);
            }
        });

        jLabel1.setText("Sports activity");

        jButtonBook.setText("Book");
        jButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookActionPerformed(evt);
            }
        });

        jComboBoxTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00" }));
        jComboBoxTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTimeActionPerformed(evt);
            }
        });

        jLabel2.setText("Time");

        jLabel3.setText("Do you want an instructor? ");

        jLabel4.setText("ID (i.e. 333-3)");

        jXDatePickerSportDate.setFormats(new String[] {"yyyy-MM-dd"});

        jLabel5.setText("Date");

        jLabelStatusSportsBook.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelStatusSportsBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSportsBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBook)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxSportsBooking, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldID))
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jXDatePickerSportDate, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(jComboBoxTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxInstructor)
                            .addComponent(jLabel3))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSportsBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxInstructor))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePickerSportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel5status, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelStatusSportsBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSportsBookStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSportsBookingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxSportsBookingActionPerformed
    {//GEN-HEADEREND:event_jComboBoxSportsBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSportsBookingActionPerformed

    private void jComboBoxTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTimeActionPerformed

    private void jButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookActionPerformed
        // TODO add your handling code here:
        int trainer;
        String sportsType = (String) jComboBoxSportsBooking.getSelectedItem();
        String Time = (String) jComboBoxTime.getSelectedItem();
        Time = ":" + Time.substring(0, 5);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        jXDatePickerSportDate.setFormats(dateFormat);
        DateFormat sysDate = new SimpleDateFormat("yyyy-MM-dd");
        String Date = sysDate.format(jXDatePickerSportDate.getDate());
        String ID = jTextFieldID.getText();
        String reservationsNumber = ID.substring(0, 3);
        //String Date1 = sysDate.format(jXDatePickerSportDate.getDate());
        String Date1 = Date.substring(2, 10); 
        int counter = con.countSportsBooking(Date1, ID);
        
        Date = Date.concat(Time);
        
       
        
        if (counter < 4) {

            if (jCheckBoxInstructor.isSelected()) {
                trainer = 1;
            } else {
                trainer = 0;
            }

            System.out.println(ID + " " + sportsType + " " + Date + " " + Date1 + " " + " " + trainer);
            con.createNewSPBooking(reservationsNumber, ID, sportsType, Date, trainer);
            boolean status = con.saveSPBooking();
            if (status)
            {
                jLabelSportsBookStatus.setText("Sports booking saved");
            }
            else
            {
                 jLabelSportsBookStatus.setText("Sports booking not saved");
            }
           
        } else {
            JOptionPane.showMessageDialog(rootPane, "You have to many bookings");
            jLabelSportsBookStatus.setText("Sports booking not saved");
        }
    }//GEN-LAST:event_jButtonBookActionPerformed

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
            java.util.logging.Logger.getLogger(GUIsportsBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIsportsBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIsportsBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIsportsBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIsportsBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBook;
    private javax.swing.JCheckBox jCheckBoxInstructor;
    private javax.swing.JComboBox jComboBoxSportsBooking;
    private javax.swing.JComboBox jComboBoxTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5status;
    private javax.swing.JLabel jLabelSportsBookStatus;
    private javax.swing.JLabel jLabelStatusSportsBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldID;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerSportDate;
    // End of variables declaration//GEN-END:variables
}
