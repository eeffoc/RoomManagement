/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class loginScreen extends javax.swing.JFrame {

    databaseConnect connection;
            
    /**
     * Creates new form admin 
     * @throws java.sql.SQLException will identify an SQL error if/when one occurs
     */
    public loginScreen() throws SQLException {

        if (connection == null){
            connection = new databaseConnect(); 
        }     
        
        initComponents();
        
        connection.getUsers();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogIn = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        textPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking system");

        btnLogIn.setText("Login");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        btnNewUser.setText("New user");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });

        jLabel2.setText("Password:");

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogIn)
                .addGap(18, 18, 18)
                .addComponent(btnNewUser)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewUser)
                    .addComponent(btnLogIn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPasswordActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed

        boolean boolID = false;

        ResultSet rs = connection.getRS();

        String adminID = userName.getText();
        String password = String.valueOf(textPassword.getPassword());
        String authorisation = "u";

        try {
            while (rs.next()) {
                try {
                    if (rs.getString("ID").equals(adminID) && !boolID) {

                        if (password.equals(rs.getString("Password"))) {
                            boolID = true;
                            authorisation = rs.getString("edit_authorisation");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!boolID) {
            try {
                rs.next();
            } catch (SQLException ex) {
                Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {

            if (boolID) {

                if (authorisation.equals("u")){

                    new mainMenu(adminID).setVisible(true);
                    this.dispose();

                }

                else if(authorisation.equals("a")){

                    new mainMenuAdmin(adminID).setVisible(true);
                    this.dispose();

                }

            } else {

                JOptionPane.showMessageDialog(loginScreen.this, "Password incorrect");

                connection.closeConnection();

                new loginScreen().setVisible(true);
                this.dispose();

            }
        } catch (SQLException ex) {
            Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed

        this.dispose();
        try {
            new newUser().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewUserActionPerformed

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
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new loginScreen().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(loginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnSearch4;
    private javax.swing.JButton btnSearch5;
    private javax.swing.JCheckBox checkProjector;
    private javax.swing.JCheckBox checkProjector1;
    private javax.swing.JCheckBox checkProjector2;
    private javax.swing.JCheckBox checkProjector3;
    private javax.swing.JCheckBox checkProjector4;
    private javax.swing.JCheckBox checkProjector5;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JComboBox<String> cmbTime1;
    private javax.swing.JComboBox<String> cmbTime2;
    private javax.swing.JComboBox<String> cmbTime3;
    private javax.swing.JComboBox<String> cmbTime4;
    private javax.swing.JComboBox<String> cmbTime5;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JLabel dateLabel10;
    private javax.swing.JLabel dateLabel11;
    private javax.swing.JLabel dateLabel12;
    private javax.swing.JLabel dateLabel13;
    private javax.swing.JLabel dateLabel14;
    private javax.swing.JLabel dateLabel15;
    private javax.swing.JLabel dateLabel16;
    private javax.swing.JLabel dateLabel17;
    private javax.swing.JLabel dateLabel2;
    private javax.swing.JLabel dateLabel3;
    private javax.swing.JLabel dateLabel4;
    private javax.swing.JLabel dateLabel5;
    private javax.swing.JLabel dateLabel6;
    private javax.swing.JLabel dateLabel7;
    private javax.swing.JLabel dateLabel8;
    private javax.swing.JLabel dateLabel9;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private org.jdesktop.swingx.JXDatePicker datePicker1;
    private org.jdesktop.swingx.JXDatePicker datePicker2;
    private org.jdesktop.swingx.JXDatePicker datePicker3;
    private org.jdesktop.swingx.JXDatePicker datePicker4;
    private org.jdesktop.swingx.JXDatePicker datePicker5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable roomsAvailable;
    private javax.swing.JTable roomsAvailable1;
    private javax.swing.JTable roomsAvailable2;
    private javax.swing.JTable roomsAvailable3;
    private javax.swing.JTable roomsAvailable4;
    private javax.swing.JTable roomsAvailable5;
    private javax.swing.JSpinner spnCapacity;
    private javax.swing.JSpinner spnCapacity1;
    private javax.swing.JSpinner spnCapacity2;
    private javax.swing.JSpinner spnCapacity3;
    private javax.swing.JSpinner spnCapacity4;
    private javax.swing.JSpinner spnCapacity5;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLabel1;
    private javax.swing.JLabel timeLabel2;
    private javax.swing.JLabel timeLabel3;
    private javax.swing.JLabel timeLabel4;
    private javax.swing.JLabel timeLabel5;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
