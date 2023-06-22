package appthuexe.repository;

import appthuexe.Car;
import databaseconn.Connector;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarRepository implements IRepository<Car> {
    private static CarRepository instance;
    private CarRepository(){

    }
    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }
//    public ArrayList<String> getlistLicense(){
//        ArrayList<String> ListLicense = new ArrayList<>();
//        try {
//            Connection conn = Connector.getInstance().getConn();
//            Statement stt = conn.createStatement();
//
//
//        }catch (Exception e){
//            System.out.println("error" + e.getMessage());
//        }
//    }

    @Override
    public ArrayList<Car> getAll() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            Connection conn = Connector.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql = "select * from car";
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("carid");
                String brand = rs.getString("brand");
                String model = rs.getNString("model");
                Double price = rs.getDouble("price");
                String bien = rs.getString("bien");
                String status = rs.getString("status");
                Car car = new Car(id,brand,model,bien,price,status);
                cars.add(car);
            }

        }catch (Exception e){
            System.out.println("error" + e.getMessage());
        }
        return cars;

    }

    @Override
    public Boolean create(Car car) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into car(brand,model,bien,price,status) values(?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,car.getBrand());
            stt.setString(2,car.getModel());
            stt.setString(3,car.getBien());
            stt.setDouble(4,car.getPrice());
            stt.setString(5,car.getStatus());
            stt.executeUpdate();
            return true;

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return false;
    }

    @Override
    public Boolean update(Car car) {
        try {
        Connection conn = Connector.getInstance().getConn();
        String sql = "update car set brand=?,model=?,bien=?,price=?,status=? where carid=?";
        PreparedStatement stt = conn.prepareStatement(sql);
        stt.setString(1,car.getBrand());
        stt.setString(2,car.getModel());
        stt.setString(3,car.getBien());
        stt.setDouble(4,car.getPrice());
        stt.setString(5,car.getStatus());
        stt.setInt(6,car.getCarid());
        stt.executeUpdate();
        return true;
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
        return false;
    }

    @Override
    public Boolean delete(Car car) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "delete from car where carid=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1,car.getCarid());
            stt.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Car find(String brand) {
        try{
            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from car where brand=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,brand);
            ResultSet rs = stt.executeQuery();
            while (rs.next()){
                int carid = rs.getInt("carid");
                String brandcar = rs.getString("brand");
                String model = rs.getString("model");
                String bien = rs.getString("bien");
                Double price = rs.getDouble("price");
                String status = rs.getString("status");

                Car car = new Car(carid,brandcar,model,bien,price,status);
                return car;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

