package Scrapyard.n.Vehicles;

public class ElectricCar extends Vehicles {




    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    int batteryCapacity;
    int chargeLevel;

    public ElectricCar(int vID,int sID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, boolean driveable, int numberOfSellableWheels, int chargeLevel, int batteryCapacity) {
        super(vID, sID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels);
       this.batteryCapacity = batteryCapacity;
       this.chargeLevel = chargeLevel;
    }
    @Override
    public String toString() {
        return "ElectricCar" +
                ", batteryCapacity=" + batteryCapacity +
                ", chargeLevel=" + chargeLevel +
                super.toString();
    }


}
