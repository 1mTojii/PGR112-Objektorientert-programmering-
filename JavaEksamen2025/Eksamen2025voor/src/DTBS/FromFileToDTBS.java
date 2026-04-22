package DTBS;

import Scrapyard.n.Vehicles.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FromFileToDTBS {
    public static void FromFileToDBs() throws FileNotFoundException{
        File file = new File("C:\\Users\\nikol\\IdeaProjects\\Eksamen2025voor\\src\\FilerEKS\\vehicles.txt");
        List<Scrapyard> scrapyardList = new ArrayList<>();
        List<Vehicles> vehiclesList = new ArrayList<>();
        Scanner filescanner=new Scanner(file);
        DTBSservices dtbsServices = new DTBSservices();

        int ScrapyardLooper = Integer.parseInt(filescanner.nextLine());
        for (int i = 0; i < ScrapyardLooper; i++) {
            Scrapyard scrapyard = new Scrapyard();
            scrapyard.setScrapyardID(Integer.parseInt(filescanner.nextLine()));
            scrapyard.setScrapyardName(filescanner.nextLine());
            scrapyard.setScrapyardAddress(filescanner.nextLine());
            scrapyard.setPhoneNumber(filescanner.nextLine());
            filescanner.nextLine();
            try {
                dtbsServices.insertScrapyard(scrapyard);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }scrapyardList.add(scrapyard);}


            int VehicleLooper = Integer.parseInt(filescanner.nextLine());
                  for (int i = 0; i < VehicleLooper; i++) {
                        int vID = Integer.parseInt(filescanner.nextLine());
                        int sID = Integer.parseInt(filescanner.nextLine());
                        String vName = filescanner.nextLine();

                        switch (vName) {
                            case "FossilCar":
                                String brand = filescanner.nextLine();
                                String model = filescanner.nextLine();
                                int yearModel = Integer.parseInt(filescanner.nextLine());
                                String registrationNumber = filescanner.nextLine();
                                String chassisNumber = filescanner.nextLine();
                                boolean driveable = Boolean.parseBoolean(filescanner.nextLine());
                                int numberOfSellableWheels = Integer.parseInt(filescanner.nextLine());
                                String fuelType = filescanner.nextLine();
                                int fuelCapacity = Integer.parseInt(filescanner.nextLine());

                                FossilCar FosCar = new FossilCar(vID, sID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, fuelType, fuelCapacity);
                                vehiclesList.add(FosCar);
                                try{
                                    dtbsServices.insertFossilCar(FosCar);
                                } catch (RuntimeException | SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                vehiclesList.add(FosCar);
                                filescanner.nextLine();
                                break;

                            case "ElectricCar":
                                String brandE = filescanner.nextLine();
                                String modelE = filescanner.nextLine();
                                int yearModelE = Integer.parseInt(filescanner.nextLine());
                                String registrationNumberE = filescanner.nextLine();
                                String chassisNumberE = filescanner.nextLine();
                                boolean driveableE = Boolean.parseBoolean(filescanner.nextLine());
                                int numberOfSellableWheelsE = Integer.parseInt(filescanner.nextLine());
                                int batteryCapacity = Integer.parseInt(filescanner.nextLine());
                                int chargeLevel = Integer.parseInt(filescanner.nextLine());
                                ElectricCar ElCar = new ElectricCar(vID, sID, brandE, modelE, yearModelE, registrationNumberE, chassisNumberE, driveableE, numberOfSellableWheelsE, batteryCapacity, chargeLevel);
                                vehiclesList.add(ElCar);
                                try{
                                    dtbsServices.insertElectricCar(ElCar);
                                } catch (RuntimeException | SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                filescanner.nextLine();
                                break;
                            case"Motorcycle":
                                String brandBike = filescanner.nextLine();
                                String modelBike = filescanner.nextLine();
                                int yearModelBike = Integer.parseInt(filescanner.nextLine());
                                String registrationNumberBike = filescanner.nextLine();
                                String chassisNumberBike = filescanner.nextLine();
                                boolean driveableBike = Boolean.parseBoolean(filescanner.nextLine());
                                int numberOfSellableWheelsBike = Integer.parseInt(filescanner.nextLine());
                                boolean hasSideCar = Boolean.parseBoolean(filescanner.nextLine());
                                int engineCapacity = Integer.parseInt(filescanner.nextLine());
                                boolean isModified  = Boolean.parseBoolean(filescanner.nextLine());
                                int numberOfWheels = Integer.parseInt(filescanner.nextLine());
                                Motorcycle Bike = new Motorcycle(vID, sID, brandBike, modelBike, yearModelBike, registrationNumberBike, chassisNumberBike, driveableBike, numberOfSellableWheelsBike,hasSideCar, engineCapacity, isModified, numberOfWheels);
                                vehiclesList.add(Bike);
                                try{
                                    dtbsServices.insertMotorcycles(Bike);
                                } catch (RuntimeException | SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                vehiclesList.add(Bike);
                                filescanner.nextLine();
                                break;
                            default:
                                System.out.println("Awh ggs :(");

                    }}
        System.out.println(scrapyardList);
        System.out.println(vehiclesList);
                    }

            }
