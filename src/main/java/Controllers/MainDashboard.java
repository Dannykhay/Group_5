package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboard implements Initializable {

    @FXML
    private ImageView showThirdFood;
    @FXML
    private ImageView appleImg;
    @FXML
    private ImageView bikeImg;
    @FXML
    private ImageView chooseImg;
    @FXML
    private Circle circle;
    @FXML
    private ImageView fruitImg;
    @FXML
    private ImageView leafImg;
    @FXML
    private ImageView mainLogoImg;
    @FXML
    private ImageView bigGuy;
    @FXML
    private ImageView womanImg;
    @FXML
    private Button closeBtn;
    @FXML
    private ImageView showFirstFood;
    @FXML
    private ImageView showSecondFood;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File firstFile = new File("miles_work_image/fistFood.png");
        Image firstImage = new Image(firstFile.toURI().toString());
        showFirstFood.setImage(firstImage);

        File senFile = new File("miles_work_image/secondFood.png");
        Image senImage = new Image(senFile.toURI().toString());
        showSecondFood.setImage(senImage);

        File thirdFile = new File("miles_work_image/niceFood.png");
        Image thirdImage = new Image(thirdFile.toURI().toString());
        showThirdFood.setImage(thirdImage);
//
        File mainFile = new File("miles_work_image/mainLogo.png");
        Image mainImage = new Image(mainFile.toURI().toString());
        mainLogoImg.setImage(mainImage);
//
        File forthFile = new File("miles_work_image/removebg-preview.png");
        Image forthImage = new Image(forthFile.toURI().toString());
        chooseImg.setImage(forthImage);
//
        File firthFile = new File("miles_work_image/leaf.png");
        Image firthImage = new Image(firthFile.toURI().toString());
        leafImg.setImage(firthImage);

        File sixFile = new File("miles_work_image/fruit.png");
        Image sixImage = new Image(sixFile.toURI().toString());
        fruitImg.setImage(sixImage);

        File bikeFile = new File("miles_work_image/bike.png");
        Image bikeImage = new Image(bikeFile.toURI().toString());
        bikeImg.setImage(bikeImage);

        File appleFile = new File("miles_work_image/apple.png");
        Image appleImage = new Image(appleFile.toURI().toString());
        appleImg.setImage(appleImage);

        File bigGuyFile = new File("miles_work_image/motoguy.png");
        Image bigGuyImage = new Image(bigGuyFile.toURI().toString());
        bigGuy.setImage(bigGuyImage);

        File womanFile = new File("miles_work_image/lady.png");
        Image womanImage = new Image(womanFile.toURI().toString());
        womanImg.setImage(womanImage);
    }

    public void dashBoard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }


    public  void signIn() throws IOException {
        LoginController loginController = new LoginController();
        loginController.getLoginPage();
    }

    public void registerButton() throws IOException {
        SignupUserController signupUserController = new SignupUserController();
        signupUserController.signUp();
    }

    public void cancelButton(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

}
