package TheTrainMasterPackage;

import javafx.geometry.VerticalDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketCalcClass implements ActionListener {
    /**
     * With this class the user is allowed to calculate the price of a ticket without creating it. So a passenger can
     * be informed about the price of its journey before issuing an actual ticket.
     */
    protected double price123;
    protected String pricestr;
    @Override
    public void actionPerformed(ActionEvent e) {
        price123=0;
        System.out.println(price123);
        JFrame ticketcal = new JFrame("Ticket Price Calculator");
        ticketcal.setSize(500,150);
        ticketcal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel promtTicketCalc = new JLabel("Select a destination and then a discount category.");
        JComboBox dests = new JComboBox();
        dests.addItem("---Select Destination---");
        dests.addItem("Thessaloniki");
        dests.addItem("Korinthos/Loutraki");
        dests.addItem("Chalkida/Kanithos");
        dests.addItem("Patras/Rion");
        JButton reset = new JButton("Reset");
        JButton showhalfprice = new JButton("-50%");
        JButton showquarterpr = new JButton("-25%");
        pricestr = String.valueOf(price123);
        JLabel pricecpormt = new JLabel("Calculated price in EUR:");
        JLabel priceb = new JLabel(pricestr);
        ticketcal.setLayout(new FlowLayout());
        ticketcal.add(promtTicketCalc);
        ticketcal.add(dests);
        ticketcal.add(reset); reset.setEnabled(false);
        ticketcal.add(showquarterpr);
        ticketcal.add(showhalfprice);
        ticketcal.add(pricecpormt);
        ticketcal.add(priceb);
        dests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dests.getSelectedItem().equals("Thessaloniki")){
                    price123 = 45.90 ;
                    pricestr = String.valueOf(price123);
                    priceb.setText(pricestr);
                    priceb.repaint();
                    System.out.println(price123);
                    reset.setEnabled(true);
                }
                else if (dests.getSelectedItem().equals("Korinthos/Loutraki")){
                    price123 = 12.50;
                    pricestr = String.valueOf(price123);
                    priceb.setText(pricestr);
                    priceb.repaint();
                    System.out.println(price123);
                    reset.setEnabled(true);
                }
                else if (dests.getSelectedItem().equals("Chalkida/Kanithos")){
                    price123 = 07.30;
                    pricestr = String.valueOf(price123);
                    priceb.setText(pricestr);
                    priceb.repaint();
                    System.out.println(price123);
                    reset.setEnabled(true);
                }
                else if (dests.getSelectedItem().equals("Patras/Rion")){
                    price123 = 17.00;
                    pricestr = String.valueOf(price123);
                    priceb.setText(pricestr);
                    priceb.repaint();
                    System.out.println(price123);
                    reset.setEnabled(true);
                }
                else {
                    price123=0;
                    pricestr = String.valueOf(price123);
                    priceb.setText(pricestr);
                    priceb.repaint();
                    System.out.println(price123);
                    showhalfprice.setEnabled(true);
                    showquarterpr.setEnabled(true);
                    reset.setEnabled(true);
                }
            }
        });
        showquarterpr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                price123=price123-(25*price123/100);
                showquarterpr.setEnabled(false);
                showhalfprice.setEnabled(false);
                pricestr = String.valueOf(price123);
                priceb.setText(pricestr);
                priceb.repaint();
                System.out.println(price123);
                reset.setEnabled(true);
            }
        });
        showhalfprice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                price123 = price123/2;
                showhalfprice.setEnabled(false);
                showquarterpr.setEnabled(false);
                pricestr = String.valueOf(price123);
                priceb.setText(pricestr);
                priceb.repaint();
                System.out.println(price123);
                reset.setEnabled(true);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                price123=0;
                pricestr = String.valueOf(price123);
                priceb.setText(pricestr);
                priceb.repaint();
                System.out.println(pricestr);
                System.out.println("Reseted");
                showhalfprice.setEnabled(true);
                showquarterpr.setEnabled(true);
                reset.setEnabled(false);
            }
        });
        ticketcal.setVisible(true);
    }
}
