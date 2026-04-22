package DTBS;

import Scrapyard.n.Vehicles.*;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DTBSservices {
    //queries for non driveable v
    private final static String GET_ALL_NON_DRIVEABLE_FOSSILCARS="SELECT * FROM FOSSILCAR WHERE DRIVEABLE = 0";
    private final static String GET_ALL_NON_DRIVEABLE_ELECTRICCAR="SELECT * FROM ELECTRICCAR WHERE DRIVEABLE = 0";
    private final static String GET_ALL_NON_DRIVEABLE_MOTORCYCLE="SELECT * FROM MOTORCYCLE WHERE DRIVEABLE = 0";
    //queries for driveable v
    private final static String GET_ALL_DRIVEABLE_FOSSILCAR = "SELECT * FROM FOSSILCAR WHERE DRIVEABLE = 1";
    private final static String GET_ALL_DRIVEABLE_ELECTRICCAR = "SELECT * FROM ELECTRICCAR WHERE DRIVEABLE = 1";
    private final static String GET_ALL_DRIVEABLE_MOTORCYCLE = "SELECT * FROM MOTORCYCLE WHERE DRIVEABLE = 1";
    //queries for v fuel
    private final static String GET_ALL_FUEL = "SELECT SUM(FUELAMOUNT) FROM FOSSILCAR";
    //queries for v
    private final static String GET_ALL_FOSSILCAR = "SELECT * FROM FOSSILCAR";
    private final static String GET_ALL_ELECTRICCAR = "SELECT * FROM ELECTRICCAR";
    private final static String GET_ALL_MOTORCYCLE = "SELECT * FROM MOTORCYCLE";
    //queries for å inserte values in i db
    private final static String INSERT_INTO_SCRAPYARD = "INSERT IGNORE INTO Scrapyard VALUES (?,?,?,?)";
    private final static String INSERT_FOSSILCAR = "INSERT IGNORE INTO Fossilcar VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final static String INSERT_ELECTRICCAR = "INSERT IGNORE INTO ElectricCar VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final static String INSERT_MOTORCYCLE = "INSERT IGNORE INTO Motorcycle VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private final MysqlDataSource DTS;

    public DTBSservices() {
        DTS = new MysqlDataSource();
        DTS.setServerName(DTBSpropertyprovider.properties.getProperty("host"));
        DTS.setPortNumber(Integer.parseInt(DTBSpropertyprovider.properties.getProperty("port")));
        DTS.setDatabaseName(DTBSpropertyprovider.properties.getProperty("database_name"));
        DTS.setUser(DTBSpropertyprovider.properties.getProperty("username"));
        DTS.setPassword(DTBSpropertyprovider.properties.getProperty("password"));
    }

    public void insertScrapyard(Scrapyard scrapyard) throws SQLException {
        try (Connection connection = DTS.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(INSERT_INTO_SCRAPYARD)) {
            pStatement.setInt(1, scrapyard.getScrapyardID());
            pStatement.setString(2, scrapyard.getScrapyardName());
            pStatement.setString(3, scrapyard.getScrapyardAddress());
            pStatement.setString(4, scrapyard.getPhoneNumber());
            pStatement.executeUpdate();
        }

    }

    public void insertElectricCar(ElectricCar electricCar) throws SQLException {
        try (Connection connection = DTS.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(INSERT_ELECTRICCAR)) {
            pStatement.setInt(1, electricCar.getvID());
            pStatement.setString(2, electricCar.getBrand());
            pStatement.setString(3, electricCar.getModel());
            pStatement.setInt(4, electricCar.getYearModel());
            pStatement.setString(5, electricCar.getRegistrationNumber());
            pStatement.setString(6, electricCar.getChassisNumber());
            pStatement.setBoolean(7, electricCar.isDriveable());
            pStatement.setInt(8, electricCar.getNumberOfSellableWheels());
            pStatement.setInt(9, electricCar.getsID());
            pStatement.setInt(10, electricCar.getBatteryCapacity());
            pStatement.setInt(11, electricCar.getChargeLevel());
            pStatement.executeUpdate();
        }
                /*int vID;
             String brand;
             String model;
             int yearModel;
             String registrationNumber;
             String chassisNumber;
             boolean driveable;
             int numberOfSellableWheels;
             int sID;*/
    }

    public void insertFossilCar(FossilCar fosCar) throws SQLException {
        try (Connection connection = DTS.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(INSERT_FOSSILCAR)) {
            pStatement.setInt(1, fosCar.getvID());
            pStatement.setString(2, fosCar.getBrand());
            pStatement.setString(3, fosCar.getModel());
            pStatement.setInt(4, fosCar.getYearModel());
            pStatement.setString(5, fosCar.getRegistrationNumber());
            pStatement.setString(6, fosCar.getChassisNumber());
            pStatement.setBoolean(7, fosCar.isDriveable());
            pStatement.setInt(8, fosCar.getNumberOfSellableWheels());
            pStatement.setInt(9, fosCar.getsID());
            pStatement.setString(10, fosCar.getFuelType());
            pStatement.setInt(11, fosCar.getFuelAmount());
            pStatement.executeUpdate();
        }
    }

    public void insertMotorcycles(Motorcycle bike) throws SQLException {
        try (Connection connection = DTS.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(INSERT_MOTORCYCLE)) {
            pStatement.setInt(1, bike.getvID());
            pStatement.setString(2, bike.getBrand());
            pStatement.setString(3, bike.getModel());
            pStatement.setInt(4, bike.getYearModel());
            pStatement.setString(5, bike.getRegistrationNumber());
            pStatement.setString(6, bike.getChassisNumber());
            pStatement.setBoolean(7, bike.isDriveable());
            pStatement.setInt(8, bike.getNumberOfSellableWheels());
            pStatement.setInt(9, bike.getsID());
            pStatement.setBoolean(10, bike.isDriveable());
            pStatement.setInt(11, bike.getEngineCapacity());
            pStatement.setInt(12, bike.getNumberOfWheels());
            pStatement.setBoolean(13, bike.isModified());
            pStatement.executeUpdate();
        }
    }

    public List<Vehicles> getAllVehicleInfo() throws SQLException {
        List<Vehicles> vehiclesList = new ArrayList<>();
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_FOSSILCAR)) {
            while (resultSet.next()) {
                vehiclesList.add(new FossilCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getString("FuelType"),
                        resultSet.getInt("FuelAmount")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_ELECTRICCAR)) {
            while (resultSet.next()) {
                vehiclesList.add(new ElectricCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getInt("BatteryCapacity"),
                        resultSet.getInt("ChargeLevel")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_MOTORCYCLE)) {
            while (resultSet.next()) {
                vehiclesList.add(new Motorcycle(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getBoolean("HasSidecar"),
                        resultSet.getInt("EngineCapacity"),
                        resultSet.getBoolean("IsModified"),
                        resultSet.getInt("NumberOfWheels")));
            }
            return vehiclesList;
        }
    }
    public int getFuelAmount() throws SQLException {
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_FUEL)) {
            if (resultSet.next()) {
                int fuelAmount = resultSet.getInt("SUM(FUELAMOUNT)");
                return fuelAmount;
            }

        }

        return 0;
    }
    public List<Vehicles> getAllDriveableVehicleInfo() throws SQLException {
        List<Vehicles> vehiclesList = new ArrayList<>();
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_DRIVEABLE_FOSSILCAR)) {
            while (resultSet.next()) {
                vehiclesList.add(new FossilCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getString("FuelType"),
                        resultSet.getInt("FuelAmount")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_DRIVEABLE_ELECTRICCAR)) {
            while (resultSet.next()) {
                vehiclesList.add(new ElectricCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getInt("BatteryCapacity"),
                        resultSet.getInt("ChargeLevel")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_DRIVEABLE_MOTORCYCLE)) {
            while (resultSet.next()) {
                vehiclesList.add(new Motorcycle(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getBoolean("HasSidecar"),
                        resultSet.getInt("EngineCapacity"),
                        resultSet.getBoolean("IsModified"),
                        resultSet.getInt("NumberOfWheels")));
            }
            return vehiclesList;
        }
    }
    public List<Vehicles> getAllNonDriveableVehicleInfo() throws SQLException {
        List<Vehicles> vehiclesList = new ArrayList<>();
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_NON_DRIVEABLE_FOSSILCARS)) {
            while (resultSet.next()) {
                vehiclesList.add(new FossilCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getString("FuelType"),
                        resultSet.getInt("FuelAmount")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_NON_DRIVEABLE_ELECTRICCAR)) {
            while (resultSet.next()) {
                vehiclesList.add(new ElectricCar(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getInt("BatteryCapacity"),
                        resultSet.getInt("ChargeLevel")));
            }
        }
        try (Connection connection = DTS.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_NON_DRIVEABLE_MOTORCYCLE)) {
            while (resultSet.next()) {
                vehiclesList.add(new Motorcycle(resultSet.getInt("VehicleID"),
                        resultSet.getInt("ScrapyardID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("YearModel"),
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getString("ChassisNumber"),
                        resultSet.getBoolean("Driveable"),
                        resultSet.getInt("NumberOfSellableWheels"),
                        resultSet.getBoolean("HasSidecar"),
                        resultSet.getInt("EngineCapacity"),
                        resultSet.getBoolean("IsModified"),
                        resultSet.getInt("NumberOfWheels")));
            }
            return vehiclesList;
        }
    }

}






