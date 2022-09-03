package Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.ResourceBundle;


public class SignupUserController implements Initializable {

    @FXML
    private TextField confirmPassTf;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField firstNameTf;
    @FXML
    private TextField lastNameTf;
    @FXML
    private Label passwordNotMatch;
    @FXML
    private TextField passwordTf;
    @FXML
    private TextField phoneNumberTf;
    @FXML
    private TextField userNameTf;
    @FXML
    private Label registerMsg;
    @FXML
    private Button closeBtn;
    @FXML
    private ComboBox<String> genderCombo;

   // private ResultSet result;
    public void signUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignupForm4User.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 620);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNIFIED);
        stage.setScene(scene);
        stage.show();
    }

    public void backToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 450);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        closeBtnOnAction();
    }
    public void setRegisterBtn() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        if (!Objects.equals(passwordTf.getText(), confirmPassTf.getText())) {
            passwordNotMatch.setText("Password does not match");
        } else if (firstNameTf.getText().isBlank() || lastNameTf.getText().isBlank() || passwordTf.getText().isBlank() ||
                emailTf.getText().isBlank() || phoneNumberTf.getText().isBlank() || genderCombo.getItems().isEmpty() ||
                userNameTf.getText().isBlank()) {

            registerMsg.setText("Please Fill In All Fields");
        } else {

            try {
                String sqlInsertQuery = "INSERT INTO customer_tb(firstname, lastname, user_name, phone_number, password, email, gender) VALUE (?, ?, ?, ?, ?, ?, ?)";
                //for database
                PreparedStatement statement = connectDB.prepareStatement(sqlInsertQuery);
                statement.setString(1, firstNameTf.getText());
                statement.setString(2, lastNameTf.getText());
                statement.setString(3, userNameTf.getText());
                statement.setString(4, String.valueOf(Integer.parseInt(phoneNumberTf.getText())));
                statement.setString(5, passwordTf.getText());
                statement.setString(6, emailTf.getText());
                statement.setString(7, genderCombo.getValue());
                statement.execute();

                //clear all fields after submitting
                firstNameTf.clear();
                lastNameTf.clear();
                emailTf.clear();
                phoneNumberTf.clear();
                userNameTf.clear();
                passwordTf.clear();
                confirmPassTf.clear();
                genderCombo.getSelectionModel().clearSelection();


            } catch (NumberFormatException e) {
                registerMsg.setText("Please enter  phone number");
                //e.getCause();
            } catch (NullPointerException e){
                registerMsg.setText("hi");
            } catch(SQLIntegrityConstraintViolationException e){
                registerMsg.setText("hello");

            }
            catch (Exception e){
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You Have Successfully Join The Trending Mukase");
            alert.showAndWait();
//            registerMsg.setText("Successfully Sign up");
        }

//        closeBtnOnAction();
    }

    public void closeBtnOnAction(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    //    Platform.exit();
    }

    ObservableList<String> genderBoxList = FXCollections.observableArrayList("Male", "Female");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderCombo.getItems().addAll(genderBoxList);
    }
}
