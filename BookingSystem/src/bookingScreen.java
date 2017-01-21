
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The screen for searching and making bookings with rooms on the database
 *
 * @author Christopher
 */
public class bookingScreen extends javax.swing.JFrame {

    String host;
    String uName;
    String uPass;

    Connection con;
    Statement stmt;
    ResultSet rs;

    int userID;
    String authorisation;

    /**
     * Creates new form bookingScreen
     *
     * @param ID Will hold the user ID temporarily until stored on the global
     * variable
     * @param author Will hold the user authorization temporarily until stored
     * on the global variable
     *
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public bookingScreen(int ID, String author) throws SQLException {

        host = "jdbc:mysql://localhost/bookingsystem";
        uName = "root";
        uPass = "";
        con = DriverManager.getConnection(host, uName, uPass);
        // access the database
        
        userID = ID;
        authorisation = author;

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking";
        rs = stmt.executeQuery(SQL);
        //This will access the table

        try {
            rs.last();
            ID = rs.getInt("ID") + 1;
        } catch (SQLException ex) {
        }

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

        checkProjector = new javax.swing.JCheckBox();
        btnBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsAvailable = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnLoginScreen = new javax.swing.JButton();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        cmbTime = new javax.swing.JComboBox<>();
        spnCapacity = new javax.swing.JSpinner();
        dateLabel1 = new javax.swing.JLabel();
        dateLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        checkProjector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProjectorActionPerformed(evt);
            }
        });

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        roomsAvailable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roomsAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room name", "Type", "Room capacity", "Projector"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(roomsAvailable);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnLoginScreen.setText("Back to menu");
        btnLoginScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginScreenActionPerformed(evt);
            }
        });

        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });

        dateLabel.setText("Projector:");

        timeLabel.setText("Time:");

        cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00", " " }));

        spnCapacity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        dateLabel1.setText("Date:");

        dateLabel2.setText("Capacity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkProjector))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spnCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLoginScreen)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(btnBook)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel2)
                    .addComponent(btnLoginScreen))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkProjector)
                    .addComponent(dateLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkProjectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProjectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkProjectorActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //fix
        DefaultTableModel model = (DefaultTableModel) roomsAvailable.getModel();

        model.setRowCount(0);

        int capacity = (int) spnCapacity.getValue();
        boolean projector = checkProjector.isSelected();

        JComboBox<String> bookingTime = cmbTime;

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL;
            SQL = String.format("SELECT * FROM room JOIN booking ON booking.roomID = room.id WHERE (room.projector = 0 AND room.capacity <= 21 AND (booking.date <> \"2016-11-16\" AND booking.time <> \"9:00:00\"))");
            //Need way to check if room us taken at time

            /*
                SELECT * FROM room
                JOIN bookings
                ON bookings.roomID = room.id	
                WHERE room.projector = 0
                AND room.capacity <= 20
                AND !(bookings.date = "2016-11-16" AND bookings.time = "10:00:00")
             */
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {

                int data1 = rs.getInt("ID");
                String data2 = rs.getString("type");
                int data3 = rs.getInt("capacity");
                int tempdata4 = rs.getInt("projector");
                boolean data4 = false;
                if (tempdata4 == 1) {
                    data4 = true;
                }

                Object[] row = {data1, data2, data3, data4};

                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginScreenActionPerformed

        this.dispose();

        if (authorisation.equals("a")) {
            try {
                new mainMenuAdmin(userID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                new mainMenu(userID).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(bookingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnLoginScreenActionPerformed

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed

    }//GEN-LAST:event_datePickerActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed

        if (datePicker.getDate() != null) {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
            formater.format(datePicker.getDate());
            System.out.println(formater.format(datePicker.getDate()));
        } else {
            JOptionPane.showMessageDialog(bookingScreen.this, "Enter a date");
        }

    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnLoginScreen;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox checkProjector;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JLabel dateLabel2;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomsAvailable;
    private javax.swing.JSpinner spnCapacity;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
