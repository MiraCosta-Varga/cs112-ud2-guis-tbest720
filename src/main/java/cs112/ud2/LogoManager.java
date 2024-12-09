package cs112.ud2;

import java.util.ArrayList;

public class LogoManager {
    private static final ArrayList<Logo> logoList = new ArrayList<>();



    public static void initializeDefaultLogoList() {
        //Initalizing default logos to be added into program at start
        Logo logo1 = null;
        Logo logo2 = null;
        Logo logo3 = null;
        Logo logo4 = null;
        Logo logo5 = null;
        Logo logo6 = null;

        try{
            logo1 = new Logo("000143-500",2);
            logo2 = new Logo("541332-001",4);
            logo3 = new Logo("558942-002",1);
            logo4 = new Logo("558942-501",1);
            logo5 = new Logo("558942-502",4);
            logo6 = new Logo("558942-503",10);

        }catch (InvalidNumberOfStops inos){
            inos.getMessage();
        }
        //Set Thread codes for each logo
        //Logo1
        logo1.setThreadCode(0,0);
        logo1.setThreadCode(1,1);
        //Logo2
        logo2.setThreadCode(0,1);
        logo2.setThreadCode(1,1);
        logo2.setThreadCode(2,2);
        logo2.setThreadCode(3,1);
        //Logo3
        logo3.setThreadCode(0,1);
        //Logo4
        logo4.setThreadCode(0,1);
        //Logo5
        logo5.setThreadCode(0,2);
        logo5.setThreadCode(1,3);
        logo5.setThreadCode(2,1);
        logo5.setThreadCode(3,1);
        //logo6
        logo6.setThreadCode(0, 1);
        logo6.setThreadCode(1, 1);
        logo6.setThreadCode(2, 2);
        logo6.setThreadCode(3, 2);
        logo6.setThreadCode(4, 3);
        logo6.setThreadCode(5, 3);
        logo6.setThreadCode(6, 4);
        logo6.setThreadCode(7, 4);
        logo6.setThreadCode(8, 0);
        logo6.setThreadCode(9, 5);

        logoList.add(logo1);
        logoList.add(logo2);
        logoList.add(logo3);
        logoList.add(logo4);
        logoList.add(logo5);
        logoList.add(logo6);

        System.out.println("Default Logos added successfully!");
        for (Logo logo : logoList) {
            System.out.println(logo);
        }

    }



    public static void addLogo(Logo logo) {
        logoList.add(logo);
        System.out.println(logo + "added to logoList Array");
    }

    public static ArrayList<Logo> getLogos() {
        return new ArrayList<>(logoList);
    }

    /**PRINT LOGO LIST
     * Prints the provided {@code ArrayList} of logos to the console.
     *
     * @param logoList The {@code ArrayList} of {@code Logo} objects to be printed.
     */

    public static void printLogoList(ArrayList<Logo> logoList) {
        System.out.println("_______________________________");
        System.out.println("Logos Added to logoList Array: ");

        for (Logo logo : logoList) {
            System.out.println(logo);
        }

        System.out.println("_______________________________\n");
    }

    /**
     * Retrieves a {@code Logo} object from the {@code logoList} by its ID.
     *
     * @param logoID The unique ID of the {@code Logo} to retrieve.
     * @return The {@code Logo} object with the matching ID, or {@code null} if not found.
     */
    public static Logo getLogoByID(String logoID) {

        for (Logo logoTemp : logoList) {
            if(logoTemp.getLogoID().equals(logoID)){
                return logoTemp;
            }
        }
        return null;
    }


}
