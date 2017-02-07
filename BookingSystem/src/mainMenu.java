
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author up772320
 */
public class mainMenu extends javax.swing.JFrame {

    /**
     * Creates new form mainMenu
     */
    
    int curRow = 0;
    String userID;
    
    String authorisation;
    
    /**
     *
     * @param tempID - temporarily holds tempID until moved to global variable
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public mainMenu(String tempID) throws SQLException {
        
        userID = tempID;
        authorisation = "u";
        
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

        btnUserScreen = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnUserScreen1 = new javax.swing.JButton();
        btnUserScreen2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUserScreen.setText("My details");
        btnUserScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserScreenActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnUserScreen1.setText("My bookings");
        btnUserScreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserScreen1ActionPerformed(evt);
            }
        });

        btnUserScreen2.setText("Make booking");
        btnUserScreen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserScreen2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogOut)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUserScreen)
                        .addGap(28, 28, 28)
                        .addComponent(btnUserScreen2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btnUserScreen1)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogOut)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserScreen)
                    .addComponent(btnUserScreen1)
                    .addComponent(btnUserScreen2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserScreenActionPerformed
         
        try {
            new userScreen(userID).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
         
    }//GEN-LAST:event_btnUserScreenActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed

        try {
            new loginScreen().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnUserScreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserScreen1ActionPerformed
        
        try {
            new myBookings(userID, authorisation).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
            
    }//GEN-LAST:event_btnUserScreen1ActionPerformed

    private void btnUserScreen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserScreen2ActionPerformed
       
        try {
            new bookingScreen(userID, authorisation).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnUserScreen2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUserScreen;
    private javax.swing.JButton btnUserScreen1;
    private javax.swing.JButton btnUserScreen2;
    // End of variables declaration//GEN-END:variables
}
