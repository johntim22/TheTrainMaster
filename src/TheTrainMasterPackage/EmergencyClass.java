package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergencyClass implements ActionListener {
    /**
     * This class implements the Emerency button and enters the station into Emergency Mode.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog entersos = new JDialog();
        entersos.setSize(650, 100);
        entersos.setTitle("Attention Required");
        JLabel promtsos1 = new JLabel("You are about to enter Emergency Mode." +
                " Please authenticate by entering the secret 4-digit PIN.");
        promtsos1.setForeground(Color.WHITE);
        JTextField pinenter = new JTextField(4);
        JButton entersossos = new JButton("LOCK STATION");
        entersossos.setForeground(Color.WHITE);
        entersossos.setContentAreaFilled(false);
        entersos.setLayout(new FlowLayout());
        entersos.add(promtsos1);
        entersos.add(pinenter);
        entersos.add(entersossos);
        entersos.getContentPane().setBackground(Color.RED);
        entersos.setVisible(true);
        entersossos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pinenter.getText().equals("1234")) {
                    JOptionPane.showMessageDialog(null, "The PIN you entered is correct " +
                            "and you are going to enter Emergency Mode now." +
                            " All Data in the TheTrainMasterPackage.Database will be lost", "Attention" +
                            " Required", JOptionPane.WARNING_MESSAGE);
                    Database.ToDestination.removeAllElements();
                    Database.trainNum.removeAllElements();
                    Database.DestsAndPassengers.clear();
                    Database.PassengersAndDests.clear();
                    Database.DestsAndTicks.clear();
                    System.out.println("Done");
                    entersos.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "The PIN you entered is " +
                            "not correct and you are not able " +
                            "to enter Emergency Mode.", "Attention Required", JOptionPane.WARNING_MESSAGE);
                    entersos.dispose();
                }
            }
        });
    }
}
