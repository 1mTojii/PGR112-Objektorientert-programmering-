package Scrapyard.n.Vehicles;

public class Motorcycle extends Vehicles{


    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
    public Motorcycle(int vID, int sID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfSellableWheels, boolean hasSideCar, int engineCapacity, boolean modified, int numberOfWheels) {
        super(vID, sID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels);
        this.hasSideCar = hasSideCar;
        this.engineCapacity = engineCapacity;
        this.numberOfWheels = numberOfWheels;
        this.isModified = modified;
    }
    boolean hasSideCar;
    int engineCapacity;
    int numberOfWheels;
    boolean isModified;

    @Override
    public String toString() {
        return "Motorcycle" +
                ", hasSideCar" + hasSideCar +
                ", engineCapacity" + engineCapacity +
                ", numberOfWheels" + numberOfWheels +
                ", isModified" + isModified + super.toString();
    }
}
