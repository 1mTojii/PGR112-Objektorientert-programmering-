import java.util.Scanner;
import java.sql.SQLException;
import java.io.FileNotFoundException;


import DTBS.DTBSservices;
import DTBS.FromFileToDTBS;




public class Program {
    FromFileToDTBS FFTDBS = new FromFileToDTBS();
    DTBSservices DTBSS = new DTBSservices();
    public void run() throws SQLException, FileNotFoundException {
        Scanner Menu = new Scanner(System.in);
        int option = 0;
        while (option !=6) {
            System.out.println("Welcome to my scrapyard program. \n" +
                    "you have 6 choices\n" +
                    "1- import all data to database\n" +
                    "2- read all data about cars from database\n" +
                    "3- check how much fuel are in the vehicles \n" +
                    "4- check wich cars are driveable\n" +
                    "5- check wich cars are not driveable\n" +
                    "6- quit");
            option = Integer.parseInt(Menu.nextLine());
            switch (option) {
                case 1 ->{
                    System.out.println("Here!");
                    FFTDBS.FromFileToDBs();
                }
                case 2 -> {
                    System.out.println("Here!");
                    System.out.println(DTBSS.getAllVehicleInfo());

                }
                case 3 -> {
                    System.out.println("Here!");
                    System.out.println(DTBSS.getFuelAmount());

                }
                case 4 -> {
                    System.out.println("Here!");
                    System.out.println(DTBSS.getAllDriveableVehicleInfo());
                }
                case 5 -> {
                    System.out.println("Here!");
                    System.out.println(DTBSS.getAllNonDriveableVehicleInfo());
                }
                case 6 -> {
                    System.out.println("Bye!");
                }
            }
        }
    }

}
