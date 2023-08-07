package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficControlSystem extends Database implements ActionListener {
    /**
     * This class is directly connected by Inheritance to TheTrainMasterPackage.Database and let the station master to control the traffic
     * in the train station. Operator can add or remove trains and by this function they have q full view over the
     * platforms of the station.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("ENTERED --> Traffic Control System");
        JFrame trafficcontrol = new JFrame("Station Traffic Control System");
        trafficcontrol.setSize(500,500);
        trafficcontrol.setResizable(false);
        trafficcontrol.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel promttop1 = new JLabel("Trains at the station right now:");
        //DefaultListModel<Integer> trainNum2 = new DefaultListModel<>();
        //for (Integer x : trainNum){
            //System.out.println(x);
            //trainNum2.addElement(trainNum.get(x));
        //}
        JList TrainNumbers = new JList(trainNum);
        JList TODestination = new JList(ToDestination);
        JButton add = new JButton("Add arrived train");
        JButton remove = new JButton("Remove departing train");
        JPanel downpanel = new JPanel();
        downpanel.setLayout(new FlowLayout());
        downpanel.add(add);
        downpanel.add(remove);
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        center.add(TrainNumbers);
        center.add(TODestination);
        trafficcontrol.getContentPane().add(BorderLayout.CENTER, center);
        trafficcontrol.getContentPane().add(BorderLayout.NORTH, promttop1);
        trafficcontrol.getContentPane().add(BorderLayout.SOUTH, downpanel);
        trafficcontrol.setVisible(true);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainNumNewSTR;
                int trainNumNewINT;
                trainNumNewSTR = JOptionPane.showInputDialog(trafficcontrol, "Please" +
                        " insert the number of the arriving train:", "New Train", JOptionPane.PLAIN_MESSAGE);
                if (trainNumNewSTR == null || trainNumNewSTR.contentEquals("")) {
                    JOptionPane.showMessageDialog(trafficcontrol, "You" +
                            " did not type any input.\nNo changes have been" +
                            " made.", "Attention Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    try{
                        trainNumNewINT = Integer.parseInt(trainNumNewSTR);
                        trainNum.addElement(trainNumNewINT);
                        System.out.println("OK");
                    }
                    catch (Exception InputNotValid){
                        JOptionPane.showMessageDialog(trafficcontrol,"Your input was invalid!" +
                                "\nNo changes have been made.","Attention Required",JOptionPane.ERROR_MESSAGE);
                        System.out.println("Handled");
                    }
                }
                String DestSTRList = JOptionPane.showInputDialog(trafficcontrol,"Please enter the destination the" +
                        " train imported will have at its next route:","New Train",JOptionPane.PLAIN_MESSAGE);
                if (DestSTRList == null || DestSTRList.contentEquals("")) {
                    JOptionPane.showMessageDialog(trafficcontrol, "You" +
                            " did not type any input.\nNo changes have been" +
                            " made.", "Attention Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    ToDestination.addElement(DestSTRList);
                    System.out.println("OK");
                }
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainNumToRemStr;
                int trainNumToRem;
                trainNumToRemStr = JOptionPane.showInputDialog(trafficcontrol,"Please insert" +
                        " the number of the departing train:","Remove Train",JOptionPane.PLAIN_MESSAGE);
                if (trainNumToRemStr == null ||  trainNumToRemStr.contentEquals("")){
                    JOptionPane.showMessageDialog(trafficcontrol, "You" +
                            " did not type any input.\nNo changes have been" +
                            " made.", "Attention Required", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    try {
                        trainNumToRem = Integer.parseInt(trainNumToRemStr);
                        System.out.println("OK");
                        trainNum.removeElement(trainNumToRem);
                        trainNum.addElement(000);
                    } catch (Exception InputNotValid) {
                        JOptionPane.showMessageDialog(trafficcontrol,"Your input was invalid!" +
                                "\nNo changes have been made.","Attention Required",JOptionPane.ERROR_MESSAGE);
                        System.out.println("Handled");
                    }
                }
            }
        });
    }
}
