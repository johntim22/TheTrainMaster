package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassengersListClass extends Database implements ActionListener {
    /**
     * This class allows the user to search for a passenger either by Destination or by their name. The search function
     * for this class is directly connected to the TheTrainMasterPackage.Database using Inheritance.
     */
    JLabel searchres;
    JLabel searchres2;

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame passlistframe = new JFrame("Passengers List");
        passlistframe.setSize(500,250);
        passlistframe.setResizable(false);
        JLabel prompt = new JLabel("Please select the destination for which you want to see passenger statistics:");
        JComboBox destinationforstats = new JComboBox();
        destinationforstats.addItem("---Select Destination---");
        destinationforstats.addItem("Thessaloniki");
        destinationforstats.addItem("Korinthos/Loutraki");
        destinationforstats.addItem("Chalkida/Kanithos");
        destinationforstats.addItem("Patras/Rion");
        JButton searchtab1go = new JButton("Search");
        searchres = new JLabel("---Search results will appear here---");
        searchres2 = new JLabel("---Verification results will be shown here---");
        JLabel prompt2 = new JLabel("Please enter the name of the passenger:");
        JTextField passnamever = new JTextField(12);
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        JButton searchtab2go = new JButton("Verify");
        tabs.setBounds(0, 0,500,250);
        tabs.add("See Passengers by Destination", tab1);
        tabs.add("Verify by Passenger's Name", tab2);
        tab1.add(prompt);
        tab1.add(destinationforstats);
        tab1.add(searchtab1go);
        tab1.add(searchres);
        tab1.setLayout(new FlowLayout(FlowLayout.LEFT));
        tab2.add(prompt2);
        tab2.add(passnamever);
        tab2.add(searchtab2go);
        tab2.add(searchres2);
        tab2.setLayout((new FlowLayout(FlowLayout.LEFT)));
        passlistframe.add(tabs);
        passlistframe.setLayout(null);
        passlistframe.setVisible(true);
        searchtab2go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passnameverstr = passnamever.getText().toString();
                if (PassengersAndDests.containsKey(passnameverstr)) {
                    searchres2.setText("Passenger exists and travels to " + PassengersAndDests.get(passnameverstr) + ".");
                    searchtab2go.repaint();
                }
                else {
                    searchres2.setText("Sorry, the passenger you entered does not exist. Please check your input.");
                    searchtab2go.repaint();
                }
            }
        });
        searchtab1go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deststats = destinationforstats.getSelectedItem().toString();
                if (destinationforstats.getSelectedItem().equals("---Select Destination---")){
                    searchres.setText("---Search results will appear here---");
                }
                else {
                    searchres.setText("Passengers travelling to " + deststats + " are " + DestsAndPassengers.get(deststats) + ".");
                    searchres.repaint();
                }
            }
        });
    }
}
