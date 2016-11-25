
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * The class will create an interface for the user. In this interface, the admin
 * can view all users on the system and edit their details if it is required.
 * The admin can also add new users on the system.
 *
 * @author Christopher
 */
public final class roomsScreen extends javax.swing.JFrame {

    String host;        // A string to store where the database is
    String uName;       // A string to store the default user to access the database
    String uPass;       // A string to store the default password to access the database

    Connection con;     // A connection variable to refer to the database connection made
    Statement stmt;     // A statement to store the SQL being run in the database 
    ResultSet rs;       // A resultSet which stores the results of a run query
    int curRow = 0;     // An integer to store the row the user is currently in
    int userID;     //An interger to store the users ID         

    public roomsScreen(int tempID) throws SQLException {

        // Connecting to a set database and storing that connection in connection con for reference.
        host = "jdbc:mysql://localhost/bookingsystem";
        uName = "root";
        uPass = "";
        con = DriverManager.getConnection(host, uName, uPass);

        // Storing userID for reference
        userID = tempID;

        // Making the interface visible to users
        initComponents();

        //Connecting the system to the database, collecting all the user data through the query
        DoConnect();

    }

    //Runs the sql statemtn to collect user details, and then gets each ready to view.
    @SuppressWarnings("empty-statement")
    public void DoConnect() throws SQLException {

        //Runs SQL statement on the database
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM room";
        rs = stmt.executeQuery(SQL);
        //This will access the table

        while (rs.next()) {      //Loop while there is data to search

            int typeIndex = 0;

            //Get the users details from the database
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String type = rs.getString("type");

            if (type.equals("Board Room")) {
                typeIndex = 0;
            } else {
                typeIndex = 1;
            }

            int capacity = rs.getInt("capacity");
            boolean projector = rs.getBoolean("projector");

            textID.setText(id);
            jCmbType.setSelectedIndex(typeIndex);
            spnCap.setValue(capacity);
            chkProj.setSelected(projector);
            // Put all user details to interface text boxes

        }
    }

    private void getRecordDetails() throws SQLException {

        int typeIndex = 0;

        //Get the  recordsets details
        int id_col = rs.getInt("ID");
        String id = Integer.toString(id_col);
        String type = rs.getString("type");

        if (type.equals("Board Room")) {
            typeIndex = 0;
        } else {
            typeIndex = 1;
        }

        int capacity = rs.getInt("capacity");
        boolean projector = rs.getBoolean("projector");

        textID.setText(id);
        jCmbType.setSelectedIndex(typeIndex);
        spnCap.setValue(capacity);
        chkProj.setSelected(projector);

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
        textID = new javax.swing.JTextField();
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
        lblType = new javax.swing.JLabel();
        lblCapacity = new javax.swing.JLabel();
        jCmbType = new javax.swing.JComboBox<>();
        spnCap = new javax.swing.JSpinner();
        lblProjector = new javax.swing.JLabel();
        chkProj = new javax.swing.JCheckBox();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lblType.setText("Type");

        lblCapacity.setText("Capacity");

        jCmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Board room", "Training room" }));

        spnCap.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblProjector.setText("Projector");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(lblType)
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblCapacity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnCap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblProjector)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkProj)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoginScreen)
                        .addGap(17, 17, 17))))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoginScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(jCmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjector)
                    .addComponent(chkProj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
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
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    //When the "first" button is pressed
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {

            rs.first();     // Go to the first record in recordset 

            getRecordDetails();

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(roomsScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnFirstActionPerformed

    //When the "next" button is pressed
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {

            if (rs.next()) {        //If there is another record after the current record

                getRecordDetails();

            } else {
                //Go back to the current record and display message to the screen
                rs.previous();
                JOptionPane.showMessageDialog(roomsScreen.this, "End of database");
            }

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(roomsScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnNextActionPerformed

    //When the "previous" button is pressed
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        try {

            if (rs.previous()) {        //If there is another record before the current record

                getRecordDetails();

            } else {
                rs.next();
                JOptionPane.showMessageDialog(roomsScreen.this, "Start of database");
            }

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(roomsScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnPreviousActionPerformed

    //When the "last" button is pressed
    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {

            rs.last();      // Go to the last record in the table

            getRecordDetails();

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(roomsScreen.this, err.getMessage());

        }

    }//GEN-LAST:event_btnLastActionPerformed

    //When the "update" button is pressed
    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed

        //Get the  recordsets details
        String type = "";
        
        //Temporary Strings to hold the updated user details
        String ID = textID.getText();
        int typeIndex = jCmbType.getSelectedIndex();
        
        if (typeIndex == 0) {
            type = "Board Room";
        } else {
            type = "Conference Room";
        }
        
        int capacity = (int) spnCap.getValue();
        boolean projector = chkProj.isSelected();

        
        int newID = Integer.parseInt(ID);

        try {
            //Update the recordset in the database
            rs.updateInt("ID", newID);
            rs.updateString("type", type);
            rs.updateInt("capacity", capacity);
            rs.updateBoolean("projector", projector);
            rs.updateRow();
            JOptionPane.showMessageDialog(roomsScreen.this, "Updated");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    //When the "delete" button is pressed
    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed

        try {

            rs.deleteRow();     //Delete the current row

            //Close the database
            stmt.close();
            rs.close();

            //Reopen the database
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM room";
            rs = stmt.executeQuery(SQL);
            //This will access the table

            int typeIndex;
            
            // Get record set details
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            String type = rs.getString("type");

            if (type.equals("Board Room")) {
                typeIndex = 0;
            } else {
                typeIndex = 1;
            }

            int capacity = rs.getInt("capacity");
            boolean projector = rs.getBoolean("projector");

            // Put recordset details to the screen
            textID.setText(id);
            jCmbType.setSelectedIndex(typeIndex);
            spnCap.setValue(capacity);
            chkProj.setSelected(projector);

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
            Logger.getLogger(adminScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    //When the "new record" button is pressed
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
            rs.last();      // Go to last user iin recordset
            int ID = rs.getInt("ID") + 1;       // Get the ID and add one to it

            textID.setText(Integer.toString(ID));       // Covert the ID to a string

            curRow = rs.getRow();       //Set the current row to the row moved to
            int typeIndex;
            
            String type = rs.getString("type");

            if (type.equals("Board Room")) {
                typeIndex = 0;
            } else {
                typeIndex = 1;
            }

            int capacity = rs.getInt("capacity");
            boolean projector = rs.getBoolean("projector");

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNewRecordActionPerformed

    //When the "save" button is pressed
    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed

        // Store all entered data into temporary varialbes
       String type = "";
        
        //Temporary Strings to hold the updated user details
        String ID = textID.getText();
        int typeIndex = jCmbType.getSelectedIndex();
        
        if (typeIndex == 0) {
            type = "Board Room";
        } else {
            type = "Conference Room";
        }
        
        int capacity = (int) spnCap.getValue();
        boolean projector = chkProj.isSelected();
        
        int newID = Integer.parseInt(ID);

        try {

            rs.moveToInsertRow();   //Move to the end of record set

            //Update recordset with the new record
            rs.updateInt("ID", newID);
            rs.updateString("type", type);
            rs.updateInt("capacity", capacity);
            rs.updateBoolean("projector", projector);
            rs.insertRow();

            //Close the database
            stmt.close();
            rs.close();

            //Reconnect to the database
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM room";
            rs = stmt.executeQuery(SQL);
            //This will access the table

            //Get recordset details
            rs.next();
            int id_col = rs.getInt("ID");
            String id = Integer.toString(id_col);
            type = rs.getString("type");

            if (type.equals("Board Room")) {
                typeIndex = 0;
            } else {
                typeIndex = 1;
            }

            capacity = rs.getInt("capacity");
            projector = rs.getBoolean("projector");

            //Put recordset details to the screen
            textID.setText(id);
            jCmbType.setSelectedIndex(typeIndex);
            spnCap.setValue(capacity);
            chkProj.setSelected(projector);

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
            Logger.getLogger(adminScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveRecordActionPerformed

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
            
            //add if
            jCmbType.setSelectedIndex(1);
            spnCap.setValue(rs.getInt("capacity"));
            textID.setText(Integer.toString(rs.getInt("ID")));
            chkProj.setSelected(rs.getBoolean("projector"));
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btnCancelRecordActionPerformed

    private void btnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginScreenActionPerformed

        try {
            this.dispose();     //Close the current screen
            new mainMenuAdmin(userID).setVisible(true);     //Open the main menu

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLoginScreenActionPerformed

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
    private javax.swing.JCheckBox chkProj;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jCmbType;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblProjector;
    private javax.swing.JLabel lblType;
    private javax.swing.JSpinner spnCap;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables
}
