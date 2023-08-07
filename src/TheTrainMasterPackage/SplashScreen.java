package TheTrainMasterPackage;

import javax.swing.*;

public class SplashScreen {
    /**
     * The program begins with a simple Splash-Screen which is implemented in this class.
     */
    public static void SplashScreen(){
        //JOptionPane.showMessageDialog(null,"Press OK to start the program and wait untill it loads.", "Please Wait",JOptionPane.PLAIN_MESSAGE);
        JWindow window = new JWindow();
        window.getContentPane().add(
                new JLabel (new ImageIcon("C:\\Users\\John\\OneDrive - The American College of Greece\\ITC3234 Final Project Files\\TheTrainMaster\\Support Files\\splashimage.jpg"), SwingConstants.CENTER));
        window.setBounds(240,100, 930, 465);
        window.setVisible(true);
        try {
            Thread.sleep(3000); //make Java wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        //JFrame frame = new JFrame();
        //frame.add(new JLabel("Welcome"));
        //frame.setVisible(true);
        //frame.setSize(300,100);
        window.dispose();
    }
}
