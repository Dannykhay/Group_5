package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private ImageView lockImageView;

    @FXML
    private TextField usernameField;
    @FXML
    private Label loginMessageLab;
    @FXML
    private PasswordField passwordfield;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        File lockfile = new File("miles_work_image/login.png");
        Image lockImage = new Image(lockfile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void getLoginPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 450);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public void adminLogin() throws IOException {
            AdminLoginController enterAdminLogin = new AdminLoginController();
            enterAdminLogin.adminLog();

            cancelButton();
    }
    public void goRegister() throws IOException {
        SignupUserController sign = new SignupUserController();
        sign.signUp();

        cancelButton();
    }
    public void loginButtonOnAction(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            String sqlSelectUser = "SELECT * FROM customer_tb WHERE user_name = ? AND password = ?";
            //for database
            PreparedStatement statement = connectDB.prepareStatement(sqlSelectUser);
            statement.setString(1, usernameField.getText());
            statement.setString(2, passwordfield.getText());
            ResultSet result = statement.executeQuery();

            if(result.next()){
                seeFood();

                cancelButton();

            }
            else if (usernameField.getText().isBlank() || passwordfield.getText().isBlank()){
                loginMessageLab.setText("Please enter email and password");
            }
            else {
                loginMessageLab.setText("Incorrect Credential");
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void seeFood() throws IOException {
        AfterLoginControl afterLoginControl = new AfterLoginControl();
        afterLoginControl.loginButton();
    }

    public void cancelButton(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}