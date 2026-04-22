package Scrapyard.n.Vehicles;

public class FossilCar extends Vehicles {
    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    int fuelAmount;
    String fuelType;

    public FossilCar(int vID, int sID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfSellableWheels, String fuelType, int fuelAmount) {
        super(vID, sID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels);
        this.fuelAmount = fuelAmount;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Fossil car" +
                "fuelType=" + fuelType +
                "fuelAmount=" + fuelAmount +
                super.toString();

    }
}




