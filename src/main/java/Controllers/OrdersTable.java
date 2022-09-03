package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class OrdersTable implements Initializable {
    @FXML
    private TableColumn<OrdersTableModel, Date> dateColum;
    @FXML
    private TableColumn<OrdersTableModel, String> usernameColum;
    @FXML
    private TableColumn<OrdersTableModel, Integer> idColumn;
    @FXML
    private TableColumn<OrdersTableModel, String> locationColum;
    @FXML
    private TableColumn<OrdersTableModel, Integer> momoColum;
    @FXML
    private TableView<OrdersTableModel> orderTable;
    @FXML
    private TableColumn<OrdersTableModel, Float> priceColum;
    @FXML
    private TableColumn<OrdersTableModel, Integer> quantityColum;
    @FXML
    private TableColumn<OrdersTableModel, Time> timeColum;
    @FXML
    private TableColumn<OrdersTableModel, Float> totalAmtColum;
    @FXML
    private TableColumn<OrdersTableModel, String> vendorColum;


    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    ObservableList<OrdersTableModel> ListAll = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            usernameColum.setCellValueFactory(new PropertyValueFactory<>("UserName"));
            locationColum.setCellValueFactory(new PropertyValueFactory<>("Location"));
            vendorColum.setCellValueFactory(new PropertyValueFactory<>("VendorName"));
            quantityColum.setCellValueFactory(new PropertyValueFactory<>("Qty"));
            momoColum.setCellValueFactory(new PropertyValueFactory<>("MomoNum"));
            priceColum.setCellValueFactory(new PropertyValueFactory<>("Price"));
            totalAmtColum.setCellValueFactory(new PropertyValueFactory<>("TotalAmount"));
            timeColum.setCellValueFactory(new PropertyValueFactory<>("Time"));
            dateColum.setCellValueFactory(new PropertyValueFactory<>("Date"));

            orderTable.setItems(ListAll);

            String sql = "SELECT * FROM order_tb";

            ResultSet result = connectDB.createStatement().executeQuery(sql);

            while (result.next()){
                ListAll.add(new OrdersTableModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getInt(5), result.getInt(6),
                        result.getFloat(7), result.getFloat(8), result.getTime(9), result.getDate(10)));
            }
            orderTable.setItems(ListAll);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
