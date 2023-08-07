package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewTicketClass implements ActionListener {
    /**
     * This class implements the New Ticket choice allowing the user to create a ticket for a passenger.
     * This class in enriched with an Auto-Save method. After the creation of the ticket the users is asked to save it
     * automatically without the need of a "Save" button.
     */
    public double price;
public String passennamefordatabase;
public String destinationfordatabase;

    @Override
    public void actionPerformed(ActionEvent e) {
        price=0;
        JOptionPane.showMessageDialog(MainWindow.MainFrame1, "Please consult the Trains Timetable before " +
                "creating a ticket!","Attention Required",JOptionPane.INFORMATION_MESSAGE);
        JFrame newTicketFrame = new JFrame("New Ticket Creator");
        newTicketFrame.setSize(500,250);
        newTicketFrame.setResizable(false);
        JLabel selectdesmsg = new JLabel("Please select destination:");
        JLabel enterName = new JLabel("Please enter passenger's name:");
        JLabel passCat = new JLabel("Please select passenger's category:");
        JTextField passName = new JTextField();
        JComboBox destinations = new JComboBox();
        JRadioButton fullprice = new JRadioButton("Full Price Ticket");
        fullprice.setSelected(true);
        JRadioButton student = new JRadioButton("Student Ticket (-50%)");
        student.setEnabled(false);
        JLabel totalprice = new JLabel("Total Price: 00.00 EUR");
        destinations.addItem("---Select Destination---");
        destinations.addItem("Thessaloniki");
        destinations.addItem("Korinthos/Loutraki");
        destinations.addItem("Chalkida/Kanithos");
        destinations.addItem("Patras/Rion");
        JButton submit = new JButton("Create ticket");
        JButton cancel = new JButton("Cancel");
        newTicketFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel dateoftravel = new JLabel("Journey's date:");
        JLabel timeoftravel = new JLabel("Train departs at:");
        //JTextField dateoftravelt = new JTextField();
        //JTextField timeoftravelt = new JTextField();
        SpinnerDateModel datechooser = new SpinnerDateModel();
        JSpinner dateoftravelt = new JSpinner(datechooser);
        JSpinner.DateEditor dateeditor1 = new JSpinner.DateEditor(dateoftravelt, "dd/MM/yyyy");
        dateoftravelt.setEditor(dateeditor1);
        SpinnerDateModel timechooser = new SpinnerDateModel();
        JSpinner timeoftravelt = new JSpinner(timechooser);
        JSpinner.DateEditor timeeditor1 = new JSpinner.DateEditor(timeoftravelt, "HH:MM");
        timeoftravelt.setEditor(timeeditor1);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTicketFrame.dispose();
            }
        });
        destinations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (destinations.getSelectedItem().equals("Thessaloniki")){
                    totalprice.setText("Total Price: 45.90 EUR"); //Setting new text for the JLabel
                    totalprice.repaint(); //Repainting the JLabel
                    price=45.90;
                }
                else if (destinations.getSelectedItem().equals("Korinthos/Loutraki")){
                    totalprice.setText("Total Price: 12.50 EUR");
                    totalprice.repaint();
                    price=12.50;
                }
                else if (destinations.getSelectedItem().equals("Chalkida/Kanithos")){
                    totalprice.setText("Total Price: 07.30 EUR");
                    totalprice.repaint();
                    price=07.30;
                }
                else if (destinations.getSelectedItem().equals("Patras/Rion")){
                    totalprice.setText("Total Price: 17.00 EUR");
                    totalprice.repaint();
                    price=17.00;
                }
                else {totalprice.setText("Total Price: 00.00 EUR"); totalprice.repaint(); price=0;}
            }
        });
        newTicketFrame.getContentPane().setLayout(new GridLayout(7,2));
        newTicketFrame.getContentPane().add(selectdesmsg);
        newTicketFrame.getContentPane().add(destinations);
        newTicketFrame.getContentPane().add(enterName);
        newTicketFrame.getContentPane().add(passName);
        newTicketFrame.getContentPane().add(passCat);
        newTicketFrame.getContentPane().add(fullprice);
        newTicketFrame.getContentPane().add(student);
        newTicketFrame.getContentPane().add(totalprice);
        newTicketFrame.getContentPane().add(dateoftravel);
        newTicketFrame.getContentPane().add(dateoftravelt);
        newTicketFrame.getContentPane().add(timeoftravel);
        newTicketFrame.getContentPane().add(timeoftravelt);
        newTicketFrame.getContentPane().add(submit);
        newTicketFrame.getContentPane().add(cancel);
        newTicketFrame.setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ticket creation started");
                if (price==0){
                    JOptionPane.showMessageDialog(newTicketFrame,"No destination selected!","Attention Required", JOptionPane.WARNING_MESSAGE);
                }
                String passnamestr = passName.getText();
                System.out.println(passnamestr);
                if (passnamestr.contentEquals("")){
                    JOptionPane.showMessageDialog(newTicketFrame,"No passeneger's name entered!","Attention Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JFileChooser saveticket = new JFileChooser();
                    int get = saveticket.showSaveDialog(newTicketFrame);
                    if (get == JFileChooser.APPROVE_OPTION){
                        try{
                            FileOutputStream ticketwriter = new FileOutputStream(saveticket.getSelectedFile());
                            String title = "OSE TICKET"; //Making a string
                            String passennametoprint = "\n\nTicket issued for: " + passName.getText();
                            passennamefordatabase = passName.getText();
                            destinationfordatabase= (destinations.getSelectedItem()).toString();
                            String dest = "\nTicket to: " + destinations.getSelectedItem();
                            String timeof = "\nTime of Departure: " + timeoftravelt.getValue(); //Correction required
                            String dayof = "\nDate of departure: " + dateoftravelt.getValue(); //Correction required
                            String pricestr = "\nPrice (in EUR): " + Double.toString(price);
                            String securitycode="\nTicket Security Code: " + Math.random();
                            byte[] b=title.getBytes(); //Converting string into an array of bytes
                            byte[] c=dest.getBytes();
                            byte[] d=timeof.getBytes();
                            byte[] f=dayof.getBytes();
                            byte[] g=pricestr.getBytes();
                            byte[] h=passennametoprint.getBytes();
                            byte[] k=securitycode.getBytes();
                            ticketwriter.write(b); //Write the bytes into a file
                            ticketwriter.write(c);
                            ticketwriter.write(d);
                            ticketwriter.write(f);
                            ticketwriter.write(g);
                            ticketwriter.write(h);
                            ticketwriter.write(k);
                            ticketwriter.close(); //Close the writer
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        //String s = "Test Text"; //Making a string
                        //byte[] b=s.getBytes(); //Converting string into an array of bytes
                        //ticketwriter.write(b); //Write the bytes into a file
                        //ticketwriter.close(); //Close the writer
                        JOptionPane.showMessageDialog(newTicketFrame,"Ticket saved successfully!","Creation Completed",JOptionPane.INFORMATION_MESSAGE);}
                    //Add to TheTrainMasterPackage.Database Method goes here
                    Database database = new Database();
                    database.setPassengerDestonDBase(destinationfordatabase);
                    database.setPassengersNameonDBase(passennamefordatabase);
                    database.setTicketPrice(price);
                    database.getPassengerDestonDBase();
                    database.getPassengersNameonDBase();
                    database.getTicketPrice();
                    database.AddToHash();
                    newTicketFrame.dispose();
                    }
            }
        });
    }
}
