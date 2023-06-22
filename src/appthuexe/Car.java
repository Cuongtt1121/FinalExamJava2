package appthuexe;

public class Car {
    private int Carid;
    private String Brand;
    private String Model;
    private String License;
    private double Price;
    private String Status;

    public Car(int carid, String brand, String model, String license, double price, String status) {
        Carid = carid;
        Brand = brand;
        Model = model;
        License = license;
        Price = price;
        Status = status;
    }

    public int getCarid() {
        return Carid;
    }

    public void setCarid(int carid) {
        Carid = carid;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBien() {
        return License;
    }

    public void setBien(String license) {
        License = license;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
