package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanelControl implements Initializable {

    @FXML
    private Button closeBtn;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView homeImg;

    @FXML
    private ImageView orderImg;

    @FXML
    private ImageView userImg;



    public void adminLog() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

    }

    public void usersButton() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/sample/UsersTable.fxml"));
        borderPane.setCenter(anchorPane);
    }

    public void ordersButton() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/sample/OrdersTable.fxml"));
        borderPane.setCenter(anchorPane);
    }

    public void logoutButton() throws IOException {
        AdminLoginController adminLoginPage = new AdminLoginController();
        adminLoginPage.adminLog();

        closeButton();
    }

    public void closeButton(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File homeFile = new File("miles_work_image/home.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeImg.setImage(homeImage);

        File orderFile = new File("miles_work_image/orderguy.png");
        Image orderImage = new Image(orderFile.toURI().toString());
        orderImg.setImage(orderImage);

        File userFile = new File("miles_work_image/users.png");
        Image userImage = new Image(userFile.toURI().toString());
        userImg.setImage(userImage);
    }
}