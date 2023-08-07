package TheTrainMasterPackage;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainsTimetableClass implements ActionListener {
    /**
     * This class contains a timetable which tickets issuer must always consult before issuing a ticket.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date date = new Date();
        JFrame TimeTableFrame = new JFrame("Trains Timetable");
        TimeTableFrame.setSize(500, 350);
        TimeTableFrame.setResizable(false);
        TimeTableFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        String data[][]={ {"2001","Thessaloniki","18:30","FULL"}, //We create an array which will contain the raws
                {"2002","Chalkida/Kanithos","19:30","OPEN"},
                {"2003","Patras/Rion","20:30","OPEN"},
                {"2004", "Korinthos/Loutraki", "21:00","OPEN"},
                {"2005","Thessaloniki","21:30","OPEN"},
                {"2006","Chalkida/Kanithos","22:30","CANCELED"},
                {"2007","Patras/Rion","23:30","CANCELED"},
                {"2008", "Korinthos/Loutraki", "23:59","OPEN"},
                {"4001", "Thessaloniki", "05:30 (+1)", "SCHEDULED"},
                {"4002", "Patras/Rion", "06:00 (+1)", "SCHEDULED"},
                {"4003", "Thessaloniki", "07:15 (+1)", "SCHEDULED"},
                {"4004", "Chalkida/Kanithos","08:30 (+1)", "SCHEDULED"}};
        String column[]={"TRAIN NUMBER","DESTINATION","DEPARTS","AVAILABILITY"}; //This Array will contain the columns
        final JTable trainstable001=new JTable(data,column); //Raws-Columns
        trainstable001.setCellSelectionEnabled(true);
        ListSelectionModel select= trainstable001.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpaneconttable =new JScrollPane(trainstable001); //The ScrollPane will include the JTable
        JPanel timetablepanel = new JPanel();
        TimeTableFrame.add(timetablepanel);
        JLabel promtttc = new JLabel("Trains to depart in the near future:");
        JLabel promtbtc = new JLabel("Please always consult this table before issuing a ticket!");
        promtbtc.setForeground(Color.red);
        timetablepanel.add(promtttc);
        timetablepanel.add(promtbtc);
        timetablepanel.add(scrollpaneconttable);
        TimeTableFrame.setVisible(true);
    }
}
