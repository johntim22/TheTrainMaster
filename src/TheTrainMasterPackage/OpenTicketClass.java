package TheTrainMasterPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class OpenTicketClass implements ActionListener {
    /**
     * This class implements the Open Ticket choice and allows the user to open a ticket for review in an built-in
     * ticket viewer!
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame openticket = new JFrame("Ticket Viewer");
        JTextArea contentofframe = new JTextArea();
        openticket.setResizable(true);
        openticket.setSize(700,500);
        openticket.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFileChooser openfilechooser = new JFileChooser();
        int retrieve = openfilechooser.showOpenDialog(openticket);
        ArrayList<Character> contentofticket = new ArrayList<>();
        if (retrieve== JFileChooser.APPROVE_OPTION) {
            //File ticketfileToOpen = openfilechooser.getSelectedFile();
            try {
                FileInputStream inputstram = new FileInputStream(openfilechooser.getSelectedFile());
                int ret2 = 0;
                while ((ret2=inputstram.read())!=-1){
                    contentofticket.add((char)ret2);
                }
                inputstram.close();
                contentofframe.setText(contentofticket.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        openticket.add(contentofframe);
        openticket.setVisible(true);
    }
}
