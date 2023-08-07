package TheTrainMasterPackage;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialogClass{
    /**
     * This class displays and validates the Login Dialog allowing the users to enter the program.
     * The role of the user is determined by its username which is directly connected to an enum containing user types.
     */
    public enum userType {Tickets, Operator, Administrator}
    public static JFrame MainFrame1 = new JFrame("The Train Master");
    public static JInternalFrame logindial = new JInternalFrame();
    public static userType userToLog;
    public static void Dialog() {
        //JFrame MainFrame1 = new JFrame("The Train Master");
        MainFrame1.setSize(300, 300);
        MainFrame1.setResizable(false);
        MainFrame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //JInternalFrame logindial = new JInternalFrame();
        logindial.setTitle("Login Form");
        logindial.setSize(200, 200);
        logindial.setResizable(false);
        logindial.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel usernameenter = new JPanel();
        JPanel passenter = new JPanel();
        JPanel buttonpanel = new JPanel();
        JTextField userENT = new JTextField(12);
        JTextField passENT = new JTextField(12);
        JButton OK = new JButton("Enter");
        JButton ABORT = new JButton("Cancel");
        usernameenter.setBorder(new TitledBorder("Enter your username here"));
        passenter.setBorder(new TitledBorder("Enter your password here"));
        buttonpanel.setBorder(new TitledBorder("Please select a function"));
        usernameenter.add(userENT);
        passenter.add(passENT);
        buttonpanel.add(OK);
        buttonpanel.add(ABORT);
        MainFrame1.getContentPane().add(logindial);
        MainFrame1.setVisible(true);
        logindial.getContentPane().setLayout(new GridLayout(3, 1));
        logindial.getContentPane().add(usernameenter);
        logindial.getContentPane().add(passenter);
        logindial.getContentPane().add(buttonpanel);
        logindial.setVisible(true);
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String TypedUser = userENT.getText();
                String TypedPass = passENT.getText();
                System.out.println("User= " + TypedUser);
                System.out.println("Pass= " + TypedPass);
                if (TypedPass.contentEquals("") || TypedUser.contentEquals("")) {
                    JOptionPane.showMessageDialog(logindial, "Please make sure all information is filled!", "Attention Required", JOptionPane.ERROR_MESSAGE);
                } else if (TypedPass.contentEquals("908070") && TypedUser.contentEquals("John")) {
                    System.out.println("John, logged in");
                    //use enum to set usertype
                    userToLog = userType.Tickets;
                    System.out.println(userToLog);
                    MainWindow.Window1();
                    //use an new class inheriting from this one to create a GUI depending on userType
                } else if (TypedPass.contentEquals("12345") && TypedUser.contentEquals("Jeremy")) {
                    System.out.println("Jeremy, logged in");
                    userToLog = userType.Operator;
                    System.out.println(userToLog);
                    MainWindow.Window1();
                }
                else if (TypedPass.contentEquals("admin")&&TypedUser.contentEquals("Admin")) {
                    userToLog = userType.Administrator;
                    System.out.println(userToLog);
                    MainWindow.Window1();
                }
                else {
                    JOptionPane.showMessageDialog(logindial, "Your username and/or password are not correct.", "Attention Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        ABORT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showConfirmDialog(logindial, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
        });
    }
}