
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * In this interface, the admin can view all users on the system and edit their
 * details if it is required while also being able to add new users on the
 * system.
 *
 * @author Christopher
 */
public final class adminScreen extends javax.swing.JFrame {

        

     databaseConnect connection;
        
        
    ResultSet rs;       
    int curRow = 0;     
    String userID;     
    
    /**
     *
     * @param tempID stores the ID temporarily, until passed to the global
     * variable
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public adminScreen(String tempID) throws SQLException {

       connection = new databaseConnect();
        ResultSet rs;
        
        userID = tempID;

        initComponents();

        DoConnect();

    }

    //Runs the sql statemtn to collect user details, and then gets each ready to view.
    /**
     * Runs the selected SQL statement on the database, which in this case, the
     * table will get all users from the user table, and stop when it has found
     * the current user.
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    @SuppressWarnings("empty-statement")
    public void DoConnect() throws SQLException {

        connection.getUsers();
        //This will access the table
        
        rs = connection.getRS();

        while (rs.next()) {      //Loop while there is data to search

            if (rs.getString("ID").equals(userID)) {     // If the id is equal to the user ID

                //Get the users details from the database
                String id = rs.getString("ID");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String setAuthorisation = rs.getString("edit_authorisation");

                textID.setText(id);
                textFirstName.setText(first_name);
                textLastName.setText(last_name);
                textAuthorisation.setText(setAuthorisation);
                // Put all user details to interface text boxes

            }
        }
    }

    /**
     * Will get the requested data of the from the record set of the database.
     *
     * @throws SQLException
     */
    private void getRecordDetails() throws SQLException {

        //Get the  recordsets details
        String id = rs.getString("ID");
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String setAuthorisation = rs.getString("edit_authorisation");

        //Put the first recordsets details on the screens
        textID.setText(id);
        textFirstName.setText(first_name);
        textLastName.setText(last_name);
        textAuthorisation.setText(setAuthorisation);

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
        back = new javax.swing.JButton();
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

        back.setText("Back to menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        lblPassword.setText("Password");

        lblPassword1.setText("Authorisation");

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
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(back)
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

    /**
     * When this method is triggered, the system will move to the first on the
     * record set
     *
     * @param evt - when the "first" button is pressed do this.
     */
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {

            rs.first();     // Go to the first record in recordset 

            getRecordDetails();

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnFirstActionPerformed

    /**
     * When this method is triggered, the system will move to the next data on
     * the record set
     *
     * @param evt - when the "next" button is pressed do this.
     */
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {

            if (rs.next()) {        //If there is another record after the current record

                getRecordDetails();

            } else {
                //Go back to the current record and display message to the screen
                rs.previous();
                JOptionPane.showMessageDialog(adminScreen.this, "End of database");
            }

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        try {

            if (rs.previous()) {        //If there is another record before the current record

                getRecordDetails();

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

            rs.last();      // Go to the last record in the table

            getRecordDetails();

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(adminScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed

        //Temporary Strings to hold the updated user details
        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String setAuthorisation = textAuthorisation.getText();
        
        try {
            //Update the recordset in the database
            rs.updateString("ID", ID);
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

            rs.deleteRow();     //Delete the current row

            //Close the database
            connection.closeConnection();

            //Reopen the database
            connection.getUsers();
            rs = connection.getRS();
            //This will access the table

            // Get record set details
            rs.next();
            String id = rs.getString("ID");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String setAuthorisation = rs.getString("edit_authorisation");

            // Put recordset details to the screen
            textID.setText(id);
            textFirstName.setText(first_name);
            textLastName.setText(last_name);
            textAuthorisation.setText(setAuthorisation);

            //Set the buttons relevant clickable
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

        // Make relevant buttons clickable
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

            curRow = rs.getRow();       //Set the current row to the row moved to
            textFirstName.setText("");      //Set the text of
            textLastName.setText("");
            textAuthorisation.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed

        // Store all entered data into temporary varialbes
        String first = textFirstName.getText();
        String last = textLastName.getText();
        String ID = textID.getText();
        String password = jPassword.getText();
        String setAuthorisation = textAuthorisation.getText();

        try {

            rs.moveToInsertRow();   //Move to the end of record set

            //Update recordset with the new record
            rs.updateString("ID", ID);
            rs.updateString("First_Name", first);
            rs.updateString("Last_Name", last);
            rs.updateString("Password", password);
            rs.updateString("edit_authorisation", setAuthorisation);
            rs.insertRow();

            //Close the database
            connection.closeConnection();

            //Reconnect to the database
            connection.getUsers();
            rs = connection.getRS();
            //This will access the table

            //Get recordset details
            rs.next();
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String first_name2 = rs.getString("first_name");
            String last_name2 = rs.getString("last_name");
            String setAuthorisation2 = rs.getString("edit_authorisation");

            //Put recordset details to the screen
            textID.setText(id);
            textFirstName.setText(first_name2);
            textLastName.setText(last_name2);

            //Set necessary buttons to clickable
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

        } catch (SQLException ex) {     //Catch any SQL errors and keep running
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveRecordActionPerformed

    /**
     *
     * When this method is triggered, the system will remove data from the forms
     * and display the last view data from the record set
     *
     * @param evt - when the "cancel record" button is pressed do this.
     */
    private void btnCancelRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecordActionPerformed

        //Set relevant buttons to clickable
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
            //Go back to the last viewed record and show the details of last viewed record
            rs.absolute(curRow);
            textFirstName.setText(rs.getString("First_Name"));
            textLastName.setText(rs.getString("Last_Name"));
            textID.setText(rs.getString("ID"));
            textAuthorisation.setText(rs.getString("edit_authorisation"));
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnCancelRecordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        try {
            this.dispose();     //Close the current screen
            new mainMenuAdmin(userID).setVisible(true);     //Open the main menu
        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_backActionPerformed

    private void textAuthorisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAuthorisationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAuthorisationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnCancelRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
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
