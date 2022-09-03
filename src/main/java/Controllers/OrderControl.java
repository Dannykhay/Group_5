package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class OrderControl implements Initializable {

    ObservableList<Integer> quantityBoxList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<String> locationBoxList = FXCollections.observableArrayList("CCB", "AS", "AD Block", "FOE", "FBMS", "Ceremonial Grounds");
    ObservableList<Float> priceBoxList = FXCollections.observableArrayList(10f, 15f, 20f, 30f);
    ObservableList<String> foodNameBoxList = FXCollections.observableArrayList("Beck Eatry(Jollof)", "Anti Agie(Bean)", "Hajia(Waakye)", "Aweley(Kenkey Joint)");



    @FXML
    private ComboBox<Integer> quantityBox;
    @FXML
    private ComboBox<String> locationBox;
    @FXML
    private ComboBox<Float> priceBox;
    @FXML
    private ComboBox<String> foodNameBox;
    @FXML
    private Label orderMsg;
    @FXML
    private TextField selectedFoodTf;

    @FXML
    private TextField selectedPriceTf;

    @FXML
    private TextField selectedQtyTf;

    @FXML
    private TextField totPayTf;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField locSelectedTf;
    @FXML
    private TextField phoneNumberTf;

    float tot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quantityBox.getItems().addAll(quantityBoxList);
        locationBox.getItems().addAll(locationBoxList);
        priceBox.getItems().addAll(priceBoxList);
        foodNameBox.getItems().addAll(foodNameBoxList);
        quantityBox.getSelectionModel().getSelectedItem();


    }


    public void orderManage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }


    public void submitOrder() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        //generate date and time for orders
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

        if (quantityBox.getItems().isEmpty() || locationBox.getItems().isEmpty() || phoneNumberTf.getText().isBlank()) {
            orderMsg.setText("Please Fill In All Fields");

        } else {

            //calculate total amount for order
            tot = priceBox.getValue() * quantityBox.getValue();
            try {
                String sqlInsertQuery = "INSERT INTO order_tb(location, quantity, phone_number, price, vendor_name, order_date, order_time, total_amount) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
                //for database
                PreparedStatement statement = connectDB.prepareStatement(sqlInsertQuery);


                statement.setString(1, locationBox.getValue());
                statement.setString(2, String.valueOf(quantityBox.getValue()));
                statement.setString(3, String.valueOf(Integer.parseInt(phoneNumberTf.getText())));
                statement.setString(4, String.valueOf(priceBox.getValue()));
                statement.setString(5, foodNameBox.getValue());
                statement.setString(6, String.valueOf(sqlDate));
                statement.setString(7, String.valueOf(sqlTime));
                statement.setString(8, String.valueOf(tot));
                statement.execute();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Successful");
                alert.setHeaderText(null);
                alert.setContentText("Thank you for buying from us");
                alert.showAndWait();


            } catch (NumberFormatException e){
                orderMsg.setText("Incorrect Phone Number entered");

            }catch (Exception e) {
                e.printStackTrace();
            }



            //clear text and selected items after submitting
            priceBox.getSelectionModel().clearSelection();
            priceBox.setPromptText("Select Price");
            quantityBox.getSelectionModel().clearSelection();
            quantityBox.setPromptText("Select Quantity");
            locationBox.getSelectionModel().clearSelection();
            locationBox.setPromptText("Select Delivery Location");
            foodNameBox.getSelectionModel().clearSelection();
            locationBox.setPromptText("Choose Food");
            phoneNumberTf.clear();
        }



    }
            //Preview order before submit
    public void previewOrderButton(){
        selectedPriceTf.setText(String.valueOf(priceBox.getSelectionModel().getSelectedItem()));
        selectedFoodTf.setText(foodNameBox.getSelectionModel().getSelectedItem());
        selectedQtyTf.setText(String.valueOf(quantityBox.getSelectionModel().getSelectedItem()));
        locSelectedTf.setText(locationBox.getSelectionModel().getSelectedItem());
        totPayTf.setText(String.valueOf(tot));
    }

    public void cancelButton(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
