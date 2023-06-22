package appthuexe.repository;

import appthuexe.Customer;
import databaseconn.Connector;

import java.sql.*;
import java.util.ArrayList;

public class CusRepository implements IRepository<Customer> {
    private static CusRepository instance;
    private CusRepository(){

    }
    public static CusRepository getInstance(){
        if (instance == null){
            instance = new CusRepository();
        }
        return instance;
    }

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> ListCustomer = new ArrayList<>();

        try {
            Connection conn = Connector.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql = "select * from customers";
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("cusid");
                String cusName = rs.getString("cusname");
                String cusTel = rs.getString("custel");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                Double price = rs.getDouble("price");
                Date date = rs.getDate("NgayTra");
                String bien = rs.getString("bien");
                Customer cus = new Customer(id,cusName,cusTel,brand,model,bien,date,price);
                ListCustomer.add(cus);
            }

        }catch (Exception e){
            System.out.println("error" + e.getMessage());
        }
        return ListCustomer;
    }

    @Override
    public Boolean create(Customer customer) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into customers(cusname,custel,brand,model,bien,ngaytra,price) values(?,?,?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,customer.getCusName());
            stt.setString(2,customer.getCusTel());
            stt.setString(3,customer.getBrand());
            stt.setString(4,customer.getModel());
            stt.setString(5,customer.getBien());
            stt.setString(6,customer.getBien());
            stt.setDouble(7,customer.getPrice());
            stt.executeUpdate();
        }catch (Exception e){
            System.out.println("error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Customer customer) {
        return null;
    }

    @Override
    public Boolean delete(Customer customer) {
        return null;
    }

    @Override
    public Customer find(String brand) {
        return null;
    }


}
