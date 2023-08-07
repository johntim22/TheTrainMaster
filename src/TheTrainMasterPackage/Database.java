package TheTrainMasterPackage;

import javax.swing.*;
import java.util.HashMap;
import java.util.Hashtable;

public class Database{
    /**
     * This class contains all the Data the program needs. There are also the appropriate setters and getters in order
     * to get data from other classes.
     */
    private String PassengersNameonDBase;
    private String PassengerDestonDBase;
    private double TicketPrice;
    protected static Hashtable<String,String> PassengersAndDests = new Hashtable<>();
    protected static HashMap<String,Double> DestsAndTicks = new HashMap<>();
    protected static Hashtable<String,String> DestsAndPassengers = new Hashtable<>();
    //protected static HashMap<Integer,String> TrainNumberandDestination = new HashMap<>(); //for use in Traffic Control System -- ABORTED
    protected static DefaultListModel<Integer> trainNum = new DefaultListModel<>(); //for use in Traffic Control System
    protected static DefaultListModel<String> ToDestination = new DefaultListModel<>(); //for use in Traffic Control System
    protected NewTicketClass newticketclassdb = new NewTicketClass();
    public String getPassengersNameonDBase() {
        return PassengersNameonDBase;
    }
    public void setPassengersNameonDBase(String passengersNameonDBase) {
        newticketclassdb.passennamefordatabase=passengersNameonDBase;
        PassengersNameonDBase = passengersNameonDBase;
    }
    public String getPassengerDestonDBase() {
        return PassengerDestonDBase;
    }
    public void setPassengerDestonDBase(String passengerDestonDBase) {
        newticketclassdb.destinationfordatabase=passengerDestonDBase;
        PassengerDestonDBase = passengerDestonDBase;
    }
    public double getTicketPrice() {
        return TicketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        newticketclassdb.price=ticketPrice;
        TicketPrice = ticketPrice;
    }
    public void AddToHash(){
        PassengersAndDests.put(PassengersNameonDBase, PassengerDestonDBase);
        DestsAndTicks.put(PassengerDestonDBase,TicketPrice);
        DestsAndPassengers.put(PassengerDestonDBase, PassengersNameonDBase);
        //DestsAndTicks.put("Patras/Rion",17.00); //Data added at the TheTrainMasterPackage.MainFlow
        //DestsAndPassengers.put("Patras/Rion","Mary Papa"); //Data added at the TheTrainMasterPackage.MainFlow
        System.out.println(PassengersAndDests.size());
        System.out.println(DestsAndTicks.size());
    }
}