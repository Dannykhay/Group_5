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
import java.util.ResourceBundle;

public class UsersTable implements Initializable {
    @FXML
    private TableColumn<UsersTableModel, String> firstName;

    @FXML
    private TableColumn<UsersTableModel, String> email;

    @FXML
    private TableColumn<UsersTableModel, String> gender;
    @FXML
    private TableColumn<UsersTableModel, String> phoneNum;

    @FXML
    private TableColumn<UsersTableModel, Integer> idColum;

    @FXML
    private TableColumn<UsersTableModel, String> lastName;

    @FXML
    private TableColumn<UsersTableModel, String> password;


    @FXML
    private TableView<UsersTableModel> usersTable;

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    ObservableList<UsersTableModel> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            idColum.setCellValueFactory(new PropertyValueFactory<>("IdColum"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            password.setCellValueFactory(new PropertyValueFactory<>("Password"));
            gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
            phoneNum.setCellValueFactory(new PropertyValueFactory<>("PhoneNum"));


            String sql = "SELECT * FROM customer_tb";

            ResultSet result = connectDB.createStatement().executeQuery(sql);

            while (result.next()){
                obList.add(new UsersTableModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6),
                        result.getInt(7)));
            }
            usersTable.setItems(obList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
