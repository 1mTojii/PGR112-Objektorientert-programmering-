package Scrapyard.n.Vehicles;

public class Scrapyard {


    int scrapyardID;
    String scrapyardName;
    String scrapyardAddress;
    String phoneNumber;

    public Scrapyard() {

    }

    public int getScrapyardID() {
        return scrapyardID;
    }

    public void setScrapyardID(int scrapyardID) {
        this.scrapyardID = scrapyardID;
    }

    public String getScrapyardName() {
        return scrapyardName;
    }

    public void setScrapyardName(String scrapyardName) {
        this.scrapyardName = scrapyardName;
    }

    public String getScrapyardAddress() {
        return scrapyardAddress;
    }

    public void setScrapyardAddress(String scrapyardAddress) {
        this.scrapyardAddress = scrapyardAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "sID=" + scrapyardID +
                ", sName" + scrapyardName +
                ", sAddress" + scrapyardAddress +
                ", phoneNumber" + phoneNumber + "\n";

    }


}
