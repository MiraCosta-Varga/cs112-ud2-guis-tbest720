package cs112.ud2;

import java.util.ArrayList;

public class LogoManager {
    private static final ArrayList<Logo> logoList = new ArrayList<>();
    public static void addLogo(Logo logo) {
        logoList.add(logo);
        System.out.println(logo + "added to logoList Array");
    }

    public static ArrayList<Logo> getLogos() {
        return new ArrayList<>(logoList); // Return a copy to prevent external modification
    }

    public static void printLogoList(ArrayList<Logo> logoList) {
        System.out.println("_______________________________");
        System.out.println("Logos Added to logoList Array: ");

        for (Logo logo : logoList) {
            System.out.println(logo);
        }

        System.out.println("_______________________________\n");
    }


}
