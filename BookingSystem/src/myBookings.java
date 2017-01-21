import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christopher
 */
public class myBookings extends javax.swing.JFrame {

    /**
     * Creates new form myBookings
     */
    String host;
    String uName;
    String uPass;

    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    int ID;
    String author;

    /**
     *
     * @param userID temporarily holds user ID until moved to a global variable
     * @param authorisation temporarily holds user authorization until moved to a global variable
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public myBookings(int userID, String authorisation) throws SQLException {

        host = "jdbc:mysql://localhost/bookingsystem";
        uName = "root";
        uPass = "";
        con = DriverManager.getConnection(host, uName, uPass);

        ID = userID;
        author = authorisation;

        initComponents();
        DoConnect();
    }

    /**
     *
     * @throws SQLException wlll identify an SQL error if/when one occurs
     */
    public void DoConnect() throws SQLException {

        boolean boolID = false;            
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking WHERE date >= CURDATE() and userID = " + ID;
        rs = stmt.executeQuery(SQL);
        //This will access the table

        System.out.println(ID);

        while (rs.next()) {

            getRecordDetails();

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrevious = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jCmbType = new javax.swing.JComboBox<>();
        spnCap = new javax.swing.JSpinner();
        lblProjector = new javax.swing.JLabel();
        chkProj = new javax.swing.JCheckBox();
        btnLoginScreen = new javax.swing.JButton();
        textTime = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        lblCapacity = new javax.swing.JLabel();
        lblProjector1 = new javax.swing.JLabel();
        lblProjector2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        textID1 = new javax.swing.JTextField();
        textDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
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

        jCmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Board room", "Training room" }));
        jCmbType.setEnabled(false);

        spnCap.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnCap.setEnabled(false);

        lblProjector.setText("Projector");

        chkProj.setEnabled(false);

        btnLoginScreen.setText("Back to menu");
        btnLoginScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginScreenActionPerformed(evt);
            }
        });

        textTime.setEnabled(false);
        textTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTimeActionPerformed(evt);
            }
        });

        lblType.setText("Type");

        lblCapacity.setText("Capacity");

        lblProjector1.setText("Date");

        lblProjector2.setText("Time");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        textID1.setEnabled(false);
        textID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textID1ActionPerformed(evt);
            }
        });

        textDate.setEnabled(false);
        textDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblType)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCapacity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141)
                        .addComponent(btnLoginScreen))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblProjector)
                                    .addComponent(lblProjector1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkProj)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblProjector2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textTime, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(textID1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(493, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoginScreen)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblType)
                            .addComponent(jCmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkProj)
                            .addComponent(lblProjector))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProjector1)
                    .addComponent(lblProjector2)
                    .addComponent(textTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(btnLast))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrevious)
                        .addComponent(btnFirst)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(textID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        try {

            if (rs.previous()) {        //If there is another record after the current record

                getRecordDetails();

            } else {
                //Go back to the current record and display message to the screen
                rs.next();
                JOptionPane.showMessageDialog(myBookings.this, "Start of database");
            }

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(myBookings.this, "Start of database");

        }

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {

            rs.first();     // Go to the first record in recordset 

            getRecordDetails();

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(myBookings.this, err.getMessage());

        }

    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        try {

            if (rs.next()) {        //If there is another record after the current record

                getRecordDetails();

            } else {
                //Go back to the current record and display message to the screen
                rs.previous();
                JOptionPane.showMessageDialog(myBookings.this, "End of database");
            }

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(myBookings.this, "End of database");

        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

        try {

            rs.last();     // Go to the first record in recordset 

            getRecordDetails();

        } catch (SQLException err) {        //Catch any SQL errors, and keep the system running

            JOptionPane.showMessageDialog(myBookings.this, err.getMessage());

        }

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginScreenActionPerformed

        this.dispose();

        if (author.equals("a")) {
            try {
                new mainMenuAdmin(ID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                new mainMenu(ID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnLoginScreenActionPerformed

    private void textTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTimeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {

            rs.deleteRow();     //Delete the current row

            //Close the database
            stmt.close();
            rs.close();

            //Reopen the database
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM booking where userID = " + ID;
            rs = stmt.executeQuery(SQL);
            //This will access the table

            JOptionPane.showMessageDialog(this, "Record Deleted");

            this.dispose();

            if (author.equals("a")) {
                try {
                    new mainMenuAdmin(ID).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    new mainMenu(ID).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(adminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void textDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateActionPerformed

    private void textID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textID1ActionPerformed

    private void getRecordDetails() throws SQLException {

        int id_col = rs.getInt("ID");
        int id_room = rs.getInt("roomID");
        Date date = rs.getDate("date");
        Time time = rs.getTime("time");

        String bookid = Integer.toString(id_col);
        String idRoom = Integer.toString(id_room);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String bookingDate = formatter.format(date);
        formatter = new SimpleDateFormat("HH:mm:ss");
        String bookingTime = formatter.format(time);

        textID1.setText(bookid);
        textDate.setText(bookingDate);
        textTime.setText(bookingTime);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLoginScreen;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JCheckBox chkProj;
    private javax.swing.JComboBox<String> jCmbType;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblProjector;
    private javax.swing.JLabel lblProjector1;
    private javax.swing.JLabel lblProjector2;
    private javax.swing.JLabel lblType;
    private javax.swing.JSpinner spnCap;
    private javax.swing.JTextField textDate;
    private javax.swing.JTextField textID1;
    private javax.swing.JTextField textTime;
    // End of variables declaration//GEN-END:variables
}
