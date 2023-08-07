package TheTrainMasterPackage;

public class PreloadedHashData {
    /**
     * This class contains pre-loaded data just for demonstration purposes.
     */
    public static void AddToHash(){
        Database.DestsAndTicks.put("Chalkida/Kanithos",07.30);
        Database.PassengersAndDests.put("Mary Papa", "Chalkida/Kanithos");
        Database.DestsAndPassengers.put("Chalkida/Kanithos","Mary Papa");
        Database.DestsAndTicks.put("Thessaloniki",45.90);
        Database.PassengersAndDests.put("Anastasios Papaioannou","Thessaloniki");
        Database.DestsAndPassengers.put("Thessaloniki","Anastasios Papaioannou");
        Database.DestsAndTicks.put("Patras/Rion",17.00);
        Database.PassengersAndDests.put("Alexandra Sakellari","Patras/Rion");
        Database.DestsAndPassengers.put("Patras/Rion","Alexandra Sakellari");
        Database.DestsAndTicks.put("Patras/Rion",17.00);
        Database.PassengersAndDests.put("Mikaela Pavlaki","Patras/Rion");
        Database.DestsAndPassengers.put("Patras/Rion","Mikaela Pavlaki");
        Database.DestsAndTicks.put("Korinthos/Loutraki",12.50);
        Database.PassengersAndDests.put("Ioannis-Marios Timotheatos","Korinthos/Loutraki");
        Database.DestsAndPassengers.put("Korinthos/Loutraki","Ioannis-Marios Timotheatos");
        //TheTrainMasterPackage.Database.TrainNumberandDestination.put(10001,"Thessaloniki");
        Database.trainNum.addElement(1001);
        Database.ToDestination.addElement("Thessaloniki");
        //TheTrainMasterPackage.Database.TrainNumberandDestination.put(10002,"Chalkida/Kanithos");
        Database.trainNum.addElement(1002);
        Database.ToDestination.addElement("Chalkida/Kanithos");
        //TheTrainMasterPackage.Database.TrainNumberandDestination.put(10003,"Patras/Rion");
        Database.trainNum.addElement(1003);
        Database.ToDestination.addElement("Patras/Rion");
        Database.trainNum.addElement(1004);
        Database.ToDestination.addElement("Korinthos/Loutraki");
        Database.trainNum.addElement(1005);
        Database.ToDestination.addElement("Thessaloniki");
        //TheTrainMasterPackage.Database.TrainNumberandDestination.put(10002,"Chalkida/Kanithos");
        Database.trainNum.addElement(1006);
        Database.ToDestination.addElement("Chalkida/Kanithos");
        //TheTrainMasterPackage.Database.TrainNumberandDestination.put(10003,"Patras/Rion");
        Database.trainNum.addElement(1007);
        Database.ToDestination.addElement("Patras/Rion");
        Database.trainNum.addElement(1008);
        Database.ToDestination.addElement("Korinthos/Loutraki");
    }
}
