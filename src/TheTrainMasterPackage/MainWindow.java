package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainWindow extends LoginDialogClass{
    /**
     * This class contains the Main Window of the program from which access can be provided to all of its functions.
     * It is directly connected by Inheritance to TheTrainMasterPackage.LoginDialogClass providing direct access to the enum!
     */
    //extending TheTrainMasterPackage.LoginDialogClass we get the appropriate details for the user and the GUI
    //PERSONAL NOTE: NEVER FORGET TO CREATE A METHOD
    public static JLabel imagebg;
    public static void Window1() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date date = new Date();
        NewTicketClass newticketsclass = new NewTicketClass();
        PassengersListClass passlistclass = new PassengersListClass();
        TrainsTimetableClass trainsTimetableClass = new TrainsTimetableClass();
        TrafficControlSystem trafficControlSystem = new TrafficControlSystem();
        OpenTicketClass openTicketClass = new OpenTicketClass();
        TicketCalcClass ticketCalcClass = new TicketCalcClass();
        EmergencyClass emergencyClass = new EmergencyClass();
        logindial.dispose();
        System.out.println("PROGRAM ENTERED TheTrainMasterPackage.MainWindow()");
        MainFrame1.setSize(500,500);
        if (userToLog==userType.Tickets || userToLog==userType.Operator) {
            imagebg = new JLabel(new ImageIcon("C:\\Users\\John\\OneDrive - The American College of Greece\\ITC3234 Final Project Files\\TheTrainMaster\\Support Files\\train_st.jpg"));
        }
        if (userToLog==userType.Administrator){
            imagebg = new JLabel(new ImageIcon(("C:\\Users\\John\\OneDrive - The American College of Greece\\ITC3234 Final Project Files\\TheTrainMaster\\Support Files\\green_admin.jpg")));
        }
        JMenuBar topmenu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu passes = new JMenu("Passengers");
        JMenu trains = new JMenu("Trains");
        JMenu help = new JMenu("Help");
        JMenuItem close = new JMenuItem("Exit");
        JMenuItem sos = new JMenuItem("Emergency");
        JMenuItem about = new JMenuItem("About");
        JMenuItem gtsupp = new JMenuItem("Get Support");
        JMenuItem newTicket = new JMenuItem("New Ticket (with Auto-Save)");
        JMenuItem openTicket = new JMenuItem("Open Ticket (for Review)"); //openTicket.setEnabled(false);
        JMenuItem ticketcalculator = new JMenuItem("Ticket Calculator"); //ticketcalculator.setEnabled(false);
        JMenuItem passList = new JMenuItem("Passengers List");
        JMenuItem trainTimetable = new JMenuItem("Trains Timetable");
        JMenuItem TrafficControlSystem = new JMenuItem("Traffic Control System");
        topmenu.add(file);
        topmenu.add(passes);
        topmenu.add(trains);
        topmenu.add(help);
        passes.add(passList);
        passList.addActionListener(passlistclass);
        trains.add(trainTimetable);
        trains.add(TrafficControlSystem);
        TrafficControlSystem.addActionListener(trafficControlSystem);
        help.add(gtsupp);
        gtsupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "For help on how to use this software please " +
                        "refer to the Programmer's Documentation.","Support",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        help.add(sos);
        sos.addActionListener(emergencyClass);
        help.add(about); //about.setEnabled(false);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "The Train Master v0.1 BETA\nProgrammed by" +
                        " Ioannis-Marios Timotheatos (228344)\nITC3234 Final Project - Fall Semester 2019\n\n" +
                        "Implemented in Java","About The Train Master",JOptionPane.PLAIN_MESSAGE);
            }
        });
        file.add(newTicket);
        newTicket.addActionListener(newticketsclass);
        trainTimetable.addActionListener(trainsTimetableClass);
        openTicket.addActionListener(openTicketClass);
        file.add(openTicket);
        file.add(ticketcalculator);
        ticketcalculator.addActionListener(ticketCalcClass);
        file.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        JPanel downpanel = new JPanel();
        JLabel downlabel = new JLabel("Welcome! Please select a function from the top menu! Today is " + dateFormat.format(date));
        downpanel.add(downlabel);
        MainFrame1.getContentPane().add(BorderLayout.NORTH, topmenu);
        MainFrame1.getContentPane().add(BorderLayout.SOUTH, downpanel);
        MainFrame1.getContentPane().add(BorderLayout.CENTER, imagebg);
        //Setting usage permissions below according to the role
        if (userToLog==userType.Tickets){
            passList.setEnabled(false);
            TrafficControlSystem.setEnabled(false);
            sos.setEnabled(false);
        }
        if (userToLog==userType.Operator){
            newTicket.setEnabled(false);
            openTicket.setEnabled(false);
            ticketcalculator.setEnabled(false);
        }
        //We do not need an if statement for the case Admin is logged in as for Admin all choices are permitted.
    }
}
