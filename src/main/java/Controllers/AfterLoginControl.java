package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfterLoginControl implements Initializable {

    @FXML
    private ImageView firstImg;

    @FXML
    private ImageView firthImg;

    @FXML
    private ImageView forthImg;

    @FXML
    private Button logoutBtn;

    @FXML
    private ImageView secondImg;

    @FXML
    private ImageView sixImg;

    @FXML
    private ImageView thirdImg;
    @FXML
    private ImageView guyManImg;
    @FXML
    private ImageView woodImg;
    @FXML
    private ImageView smallVegImg;
    @FXML
    private ImageView LargeVegImg;

    @FXML
    private Label usernameLb;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        File firstFile = new File("miles_work_image/fistFood.png");
        Image firstImage = new Image(firstFile.toURI().toString());
        firstImg.setImage(firstImage);

        File seFile = new File("miles_work_image/secondFood.png");
        Image seImage = new Image(seFile.toURI().toString());
        secondImg.setImage(seImage);

        File thFile = new File("miles_work_image/fistFood.png");
        Image thImage = new Image(thFile.toURI().toString());
        thirdImg.setImage(thImage);

        File forthFile = new File("miles_work_image/beans.png");
        Image forthImage = new Image(forthFile.toURI().toString());
        forthImg.setImage(forthImage);

        File firthFile = new File("miles_work_image/fufu.png");
        Image firthImage = new Image(firthFile.toURI().toString());
        firthImg.setImage(firthImage);

        File sixFile = new File("miles_work_image/kenkey.png");
        Image sixImage = new Image(sixFile.toURI().toString());
        sixImg.setImage(sixImage);

        File guyFile = new File("miles_work_image/moto.png");
        Image guyImage = new Image(guyFile.toURI().toString());
        guyManImg.setImage(guyImage);

        File woodFile = new File("miles_work_image/wood.png");
        Image woodImage = new Image(woodFile.toURI().toString());
        woodImg.setImage(woodImage);


        File smallFile = new File("miles_work_image/fruit1-removebg-preview.png");
        Image smallImage = new Image(smallFile.toURI().toString());
        smallVegImg.setImage(smallImage);

        File largeFile = new File("miles_work_image/forFruit.png");
        Image largeImage = new Image(largeFile.toURI().toString());
        LargeVegImg.setImage(largeImage);

    }

    public void loginButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AfterLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void logoutButtonOnMain() throws IOException {
        MainDashboard mainDashboard = new MainDashboard();
        mainDashboard.dashBoard();
        cancelButton();
    }

    public void order() throws IOException {
        OrderControl orderControl = new OrderControl();
        orderControl.orderManage();
    }

    public void cancelButton(){
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
    }
}
