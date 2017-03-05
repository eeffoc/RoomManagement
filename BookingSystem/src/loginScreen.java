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

        jPanel11 = new javax.swing.JPanel();
        btnNewUser = new javax.swing.JButton();
        btnLogIn = new javax.swing.JButton();
        textPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking system");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel11.setLayout(null);

        btnNewUser.setBackground(new java.awt.Color(0, 102, 204));
        btnNewUser.setText("New user?");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });
        jPanel11.add(btnNewUser);
        btnNewUser.setBounds(190, 310, 150, 40);

        btnLogIn.setBackground(new java.awt.Color(0, 102, 204));
        btnLogIn.setText("Login");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        jPanel11.add(btnLogIn);
        btnLogIn.setBounds(20, 310, 150, 40);

        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });
        jPanel11.add(textPassword);
        textPassword.setBounds(110, 210, 160, 30);

        jLabel2.setText("Password:");
        jPanel11.add(jLabel2);
        jLabel2.setBounds(40, 210, 80, 40);

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        jPanel11.add(userName);
        userName.setBounds(110, 170, 160, 30);

        jLabel1.setText("User ID:");
        jPanel11.add(jLabel1);
        jLabel1.setBounds(50, 160, 50, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo.PNG"))); // NOI18N
        jPanel11.add(jLabel4);
        jLabel4.setBounds(40, 10, 210, 140);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/720x1280-samsung-lg-nokia-wallpapers-mobile-21523leol.jpg"))); // NOI18N
        jPanel11.add(jLabel3);
        jLabel3.setBounds(0, 0, 360, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPasswordActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
