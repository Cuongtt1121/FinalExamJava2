package appthuexe.controller;

import appthuexe.Customer;
import appthuexe.Main;
import appthuexe.repository.CusRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public TableView<Customer> tbViewHome;
    public TableColumn<Customer, Integer> CusId;
    public TableColumn<Customer, String>  CusName;
    @FXML
    public TableColumn<Customer, String> CusTel;
    public TableColumn<Customer, String> Brand;
    public TableColumn<Customer, String> Model;
    public  TableColumn<Customer, String> License;
    public TableColumn<Customer, Date> DateReturned;
    public TableColumn<Customer, Double> Price;

    public void ThueXe(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("thuexe.fxml"));
        Main.mainStage.setScene(new Scene(root, 1235,475));
    }

    public void ThemXe(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("themxe.fxml"));
        Main.mainStage.setScene(new Scene(root, 1235,475));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CusId.setCellValueFactory(new PropertyValueFactory<>("CusId"));
        CusName.setCellValueFactory(new PropertyValueFactory<>("CusName"));
        CusTel.setCellValueFactory(new PropertyValueFactory<>("CusTel"));
        Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        License.setCellValueFactory(new PropertyValueFactory<>("license"));
        DateReturned.setCellValueFactory(new PropertyValueFactory<>("DateReturned"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        try {
            ObservableList<Customer> listCus = FXCollections.observableArrayList();
            listCus.addAll(CusRepository.getInstance().getAll());
            tbViewHome.setItems(listCus);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
