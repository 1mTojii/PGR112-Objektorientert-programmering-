package Scrapyard.n.Vehicles;


public abstract class Vehicles {
    public int getvID() {
        return vID;
    }

    public void setvID(int vID) {
        this.vID = vID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public boolean isDriveable() {
        return driveable;
    }

    public void setDriveable(boolean driveable) {
        this.driveable = driveable;
    }

    public int getNumberOfSellableWheels() {
        return numberOfSellableWheels;
    }

    public void setNumberOfSellableWheels(int numberOfSellableWheels) {
        this.numberOfSellableWheels = numberOfSellableWheels;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }


    int vID;
    String brand;
    String model;
    int yearModel;
    String registrationNumber;
    String chassisNumber;
    boolean driveable;
    int numberOfSellableWheels;
    int sID;

    public Vehicles(int vID, int sID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfSellableWheels) {
        this.vID = vID;
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.driveable = driveable;
        this.numberOfSellableWheels = numberOfSellableWheels;
        this.sID = sID;
    }

    @Override
    public String toString() {
        return "vID=" + vID +
                ", brand=" + brand +
                ", model=" + model +
                ", yearModel=" + yearModel +
                ", registrationNumber=" + registrationNumber +
                ", chassisNumber=" + chassisNumber +
                ", driveable=" + driveable +
                ", numberOfSellableWheels" + numberOfSellableWheels +
                ", sID" + sID + "\n";
    }

}
