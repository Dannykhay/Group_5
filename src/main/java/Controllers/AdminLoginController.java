package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {

    @FXML
    private TextField usernameTf;

    @FXML
    private Button cancelBtn;
    @FXML
    private Label loginMsg;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private ImageView lockImageView;

    public void adminLog() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 510);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
    public void setLoginBtn(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try{
            String sqlSelectAdmin = "SELECT * FROM admin_tb WHERE user_name = ? AND password = ?";
            //for database
            PreparedStatement statement = connectDB.prepareStatement(sqlSelectAdmin);
            statement.setString(1, usernameTf.getText());
            statement.setString(2, passwordTf.getText());
            ResultSet result = statement.executeQuery();

            if (result.next()){
                adminAdd();
                cancelButton();
            } else {
                    loginMsg.setText("Wrong username and password");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void adminAdd() throws IOException {
        AdminPanelControl adminPanelControl = new AdminPanelControl();
        adminPanelControl.adminLog();

        cancelButton();
    }


    public void cancelButton(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File lockfile = new File("miles_work_image/login.png");
        Image lockImage = new Image(lockfile.toURI().toString());
        lockImageView.setImage(lockImage);
    }
}
