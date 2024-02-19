package online_ticket_booking;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Bus {

    JFrame frame;
    private JTextField busID;
    private JTextField BusPlate;
    private JTextField agencyID;
    private JTextField FreeSeats;
    private JTextField destination;
    private JTable table;

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bus window = new Bus();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Bus() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(300, 20, 813, 671);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        table.setBounds(10, 464, 840, 21);
        frame.getContentPane().add(table);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 433, 840, 120);
        frame.getContentPane().add(scrollPane);
        
        JButton retrieveBtn = new JButton("Retrieve Data");
        retrieveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveData1();
            }
        });
        retrieveBtn.setBackground(new Color(0, 150, 50));
        retrieveBtn.setForeground(Color.WHITE); 
        retrieveBtn.setBounds(10, 550, 200, 30);
        frame.getContentPane().add(retrieveBtn);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem bus = new JMenuItem("bus");
        menu.add(bus);

        JMenuItem agency = new JMenuItem("agency");
        menu.add(agency);
        
        JMenuItem booking = new JMenuItem("booking");
        menu.add(booking);

        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);


        bus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                Bus busFrame = new Bus(); 
                busFrame.frame.setVisible(true); 
            }
        });

        agency.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose(); 
                Agency agencyFrame = new Agency(); 
                agencyFrame.frame.setVisible(true); 
            }
        });

        booking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                frame.dispose(); 
                orders bookingFrame = new orders();
                bookingFrame.frame.setVisible(true);
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
//                    dispose();
                    LoginForm obj = new LoginForm();
                   // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                    frame.dispose();
                }
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });

        
     



        JLabel lblNewLabel = new JLabel("BUS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
        lblNewLabel.setForeground(new Color(0, 0, 50));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(100, 0, 490, 40);
        frame.getContentPane().add(lblNewLabel);

        JLabel buslb = new JLabel("busID");
        buslb.setFont(new Font("Tahoma", Font.BOLD, 16));
        buslb.setBounds(10, 116, 205, 40);
        frame.getContentPane().add(buslb);

        JLabel busplb = new JLabel("BusPlate");
        busplb.setFont(new Font("Tahoma", Font.BOLD, 16));
        busplb.setBounds(10, 174, 205, 40);
        frame.getContentPane().add(busplb);

        JLabel agelb = new JLabel("agencyID");
        agelb.setFont(new Font("Tahoma", Font.BOLD, 16));
        agelb.setBounds(10, 236, 205, 40);
        frame.getContentPane().add(agelb);

        JLabel freelb = new JLabel("FreeSeats");
        freelb.setFont(new Font("Tahoma", Font.BOLD, 16));
        freelb.setBounds(10, 293, 205, 40);
        frame.getContentPane().add(freelb);

        JButton Insertbtn = new JButton("INSERT");
        Insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "INSERT INTO bus VALUES(?,?,?,?,?)";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setInt(1, Integer.parseInt(busID.getText()));
                        stm.setString(2, BusPlate.getText());
                        stm.setString(3, agencyID.getText());
                        stm.setString(4, FreeSeats.getText());
                        stm.setString(5, destination.getText());

                        stm.executeUpdate(); // Execute the update

                        JOptionPane.showMessageDialog(Insertbtn, "Data inserted successfully!");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Insertbtn, "An error occurred. Please check the console for details.");
                }
            }
        });
        Insertbtn.setBackground(new Color(0, 0, 50));
        Insertbtn.setForeground(Color.WHITE);
        Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Insertbtn.setBounds(470, 10, 109, 40);
        frame.getContentPane().add(Insertbtn);

        

        JButton Updatebtn = new JButton("UPDATE");
        Updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "UPDATE bus SET BusPlate=?, agencyID=?, FreeSeats=?, destination=? WHERE busID=?";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setString(1, BusPlate.getText());
                        stm.setString(2, agencyID.getText());
                        stm.setString(3, FreeSeats.getText());
                        stm.setString(4, destination.getText());
                        stm.setInt(5, Integer.parseInt(busID.getText()));

                        int rowsAffected = stm.executeUpdate(); // Execute the update

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(Updatebtn, "Record updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(Updatebtn, "No record found with the given busID.");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Updatebtn, "An error occurred. Please check the console for details.");
                }
            }
        });
        Updatebtn.setBackground(new Color(0, 0, 50));
        Updatebtn.setForeground(Color.WHITE);
        Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Updatebtn.setBounds(570, 10, 109, 40);
        frame.getContentPane().add(Updatebtn);

        JButton Deletebtn = new JButton("DELETE");
        Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "DELETE FROM bus WHERE busID = ?";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setInt(1, Integer.parseInt(busID.getText()));

                        int rowsAffected = stm.executeUpdate(); // Execute the update

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(Deletebtn, "Record deleted successfully!");
                        } else {
                            JOptionPane.showMessageDialog(Deletebtn, "No record found with the given busID.");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Deletebtn, "An error occurred. Please check the console for details.");
                }
            }
        });
        Deletebtn.setBackground(new Color(0, 0, 50));
        Deletebtn.setForeground(Color.WHITE);
        Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Deletebtn.setBounds(680, 10, 109, 40);
        frame.getContentPane().add(Deletebtn);

        JLabel deslb = new JLabel("destination");
        deslb.setFont(new Font("Tahoma", Font.BOLD, 16));
        deslb.setBounds(10, 345, 205, 40);
        frame.getContentPane().add(deslb);

        busID = new JTextField();
        busID.setBounds(250, 121, 273, 28);
        frame.getContentPane().add(busID);
        busID.setColumns(10);

        BusPlate = new JTextField();
        BusPlate.setColumns(10);
        BusPlate.setBounds(250, 184, 273, 28);
        frame.getContentPane().add(BusPlate);

        agencyID = new JTextField();
        agencyID.setColumns(10);
        agencyID.setBounds(250, 245, 273, 28);
        frame.getContentPane().add(agencyID);

        FreeSeats = new JTextField();
        FreeSeats.setColumns(10);
        FreeSeats.setBounds(250, 302, 273, 28);
        frame.getContentPane().add(FreeSeats);

        destination = new JTextField();
        destination.setColumns(10);
        destination.setBounds(250, 351, 273, 28);
        frame.getContentPane().add(destination);
    }

    private void retrieveData1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

            String sql = "SELECT * FROM Bus";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery(); // Execute the query

                // Create a table model and populate it with the data from the ResultSet
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("bus ID");
                model.addColumn("Bus Plate");
                model.addColumn("agency ID");
                model.addColumn("Free Seats");
                model.addColumn("destination");

                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("busID"),
                            rs.getString("BusPlate"),
                            rs.getString("agencyID"),
                            rs.getString("FreeSeats"),
                            rs.getString("destination")
                    });
                }

                // Set the model to the JTable
                table.setModel(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An error occurred while retrieving data. Please check the console for details.");
        }
    }

    protected void retrieveData() {
        // TODO Auto-generated method stub

    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    public void dispose() {
        // TODO Auto-generated method stub

    }

}
