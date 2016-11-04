/*
 * To change this license header, choose License Headers in Project Properties.
 * To   change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class adminScreen extends javax.swing.JFrame {

    String host;
    String uName;
    String uPass;

    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    int userID;
    String authorisation = "";    
    /**
     * Creates new form Workers
     */
    public adminScreen(int tempID) throws SQLException {

        host = "jdbc:mysql://localhost/worker";
        uName = "root";
        uPass = "";
        con = DriverManager.getConnection(host, uName, uPass);
        userID = tempID;
        
        initComponents();
        DoConnect();
    
    }
    
    @SuppressWarnings("empty-statement")
    public void DoConnect() throws SQLException {

        boolean boolID = false;

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM Worker";
        rs = stmt.executeQuery(SQL);
        //This will access the table
        
        while (rs.next()){
  
            if (rs.getInt("ID") == userID && !boolID) {
                
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String setAuthorisation = rs.getString("edit_authorisation");
                
                System.out.println(rs.getString("edit_authorisation"));

                String id = Integer.toString(id_col);

                textID.setText(id);
                textFirstName.setText(first_name);
                textLastName.setText(last_name);
                textAuthorisation.setText(setAuthorisation);

                boolID = true;
            }
        }
    }

    private void goToEnd() throws SQLException {

        rs.last();
        int ID = rs.getInt("ID") + 1;

        textID.setText(Integer.toString(ID));

        curRow = rs.getRow();
        textFirstName.setText("");
        textLastName.setText("");
        textAuthorisation.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        textFirstName = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        textLastName = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        btnNewRecord = new javax.swing.JButton();
        btnSaveRecord = new javax.swing.JButton();
        btnCancelRecord = new javax.swing.JButton();
        btnLoginScreen = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        lblPassword1 = new javax.swing.JLabel();
        textAuthorisation = new javax.swing.JTextField();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFirstNameActionPerformed(evt);
            }
        });

        textID.setEnabled(false);
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnUpdateRecord.setText("Update");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        btnDeleteRecord.setText("Delete");
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnNewRecord.setText("New Record");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        btnSaveRecord.setText("Save new record");
        btnSaveRecord.setEnabled(false);
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecordActionPerformed(evt);
            }
        });

        btnCancelRecord.setText("Cancel new record");
        btnCancelRecord.setEnabled(false);
        btnCancelRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRecordActionPerformed(evt);
            }
        });

        btnLoginScreen.setText("Back to menu");
        btnLoginScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginScreenActionPerformed(evt);
            }
        });

        lblPassword.setText("Password");

        lblPassword1.setText("Authentication");

        textAuthorisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAuthorisationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoginScreen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(textLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lblPassword)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAuthorisation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeleteRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSaveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnCancelRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoginScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword1)
                    .addComponent(textAuthorisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnFirst)
                    .addComponent(btnLast))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateRecord)
                    .addComponent(btnDeleteRecord)
                    .addComponent(btnNewRecord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveRecord)
                    .addComponent(btnCancelRecord))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void textFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFirstNameActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {

            rs.first();
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String first_name = rs.getString("First_Name");
            String last_name = rs.getString("Last_Name");
            String setAuthorisation = rs.getString("edit_authorisation");

            textID.setText(id);
            textFirstName.setText(first_name);
            textLastName.setText(last_name);
            textAuthorisation.setText(setAuthorisation);

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {
            if (rs.next()) {

                int id_col = rs.getInt("ID");
                String id = Integer.toString(id_col);
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String setAuthorisation = rs.getString("edit_authorisation");

                textID.setText(id);
                textFirstName.setText(first_name);
                textLastName.setText(last_name);
                textAuthorisation.setText(setAuthorisation);
              

            } else {
                rs.previous();
                JOptionPane.showMessageDialog(adminScreen.this, "End of database");
            }
        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        try {
            if (rs.previous()) {

                int id_col = rs.getInt("ID");
                String id = Integer.toString(id_col);
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String setAuthorisation = rs.getString("edit_authorisation");

                textID.setText(id);
                textFirstName.setText(first_name);
                textLastName.setText(last_name);
                textAuthorisation.setText(setAuthorisation);

            } else {
                rs.next();
                JOptionPane.showMessageDialog(adminScreen.this, "Start of database");
            }
        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {

            rs.last();
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String first_name = rs.getString("First_Name");
            String last_name = rs.getString("Last_Name");
            String setAuthorisation = rs.getString("edit_authorisation");

            textID.setText(id);
            textFirstName.setText(first_name);
            textLastName.setText(last_name);
            textAuthorisation.setText(setAuthorisation);

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed

        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String setAuthorisation = textAuthorisation.getText();

        int newID = Integer.parseInt(ID);

        try {
            rs.updateInt("ID", newID);
            rs.updateString("First_Name", first);
            rs.updateString("last_Name", last);
            rs.updateString("edit_authorisation", setAuthorisation);
            rs.updateRow();
            JOptionPane.showMessageDialog(adminScreen.this, "Updated");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed

        try {

            rs.deleteRow();

            stmt.close();
            rs.close();

            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Worker";
            rs = stmt.executeQuery(SQL);
            //This will access the table

            rs.next();
            int id_col = rs.getInt("ID");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");            
            String setAuthorisation = rs.getString("edit_authorisation");

            String id = Integer.toString(id_col);

            textID.setText(id);
            textFirstName.setText(first_name);
            textLastName.setText(last_name);            
            textAuthorisation.setText(setAuthorisation);

            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            btnSaveRecord.setEnabled(false);
            btnCancelRecord.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Record Deleted");

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed

        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnUpdateRecord.setEnabled(false);
        btnDeleteRecord.setEnabled(false);
        btnNewRecord.setEnabled(false);

        btnSaveRecord.setEnabled(true);
        btnCancelRecord.setEnabled(true);

        try {
            goToEnd();
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed

        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String password = jPassword.getText();
        String setAuthorisation = textAuthorisation.getText();

        int newID = Integer.parseInt(ID);

        try {

            rs.moveToInsertRow();

            rs.updateInt("ID", newID);
            rs.updateString("First_Name", first);
            rs.updateString("Last_Name", last);
            rs.updateString("Password", password);
            rs.updateString("edit_authorisation", setAuthorisation);
            rs.insertRow();

            stmt.close();
            rs.close();

            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Worker";
            rs = stmt.executeQuery(SQL);
            //This will access the table

            rs.next();
            int id_col = rs.getInt("ID");
            String first_name2 = rs.getString("first_name");
            String last_name2 = rs.getString("last_name");
            String setAuthorisation2 = rs.getString("edit_authorisation");
            
            String id = Integer.toString(id_col);

            textID.setText(id);
            textFirstName.setText(first_name2);
            textLastName.setText(last_name2);

            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            btnSaveRecord.setEnabled(false);
            btnCancelRecord.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Record Saved");

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveRecordActionPerformed

    private void btnCancelRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecordActionPerformed

        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        btnUpdateRecord.setEnabled(true);
        btnDeleteRecord.setEnabled(true);
        btnNewRecord.setEnabled(true);

        btnSaveRecord.setEnabled(false);
        btnCancelRecord.setEnabled(false);

        try {
            rs.absolute(curRow);

            textFirstName.setText(rs.getString("First_Name"));
            textLastName.setText(rs.getString("Last_Name"));
            textID.setText(Integer.toString(rs.getInt("ID")));            
            textAuthorisation.setText(rs.getString("edit_authorisation"));
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnCancelRecordActionPerformed

    private void btnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginScreenActionPerformed

        try {
            this.dispose();
            new mainMenu(userID, "a").setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLoginScreenActionPerformed

    private void textAuthorisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAuthorisationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAuthorisationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLoginScreen;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JTextField textAuthorisation;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textLastName;
    // End of variables declaration//GEN-END:variables
}
