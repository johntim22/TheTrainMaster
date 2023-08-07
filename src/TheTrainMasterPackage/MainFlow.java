package TheTrainMasterPackage;

public class MainFlow {
    /**
     * TheTrainMasterPackage.MainFlow class will "boot" the program.
     * @param Args
     */
    public static void main(String[] Args){
        System.out.println("---LOG---");
        System.out.println("ENTERED");
        //System.out.println("USERS ADDED");
        PreloadedHashData.AddToHash();
        System.out.println("HASHMAP DATA ADDED");
        System.out.println("LOGIN APPEARED");
        SplashScreen.SplashScreen();
        LoginDialogClass.Dialog();
    }
}
