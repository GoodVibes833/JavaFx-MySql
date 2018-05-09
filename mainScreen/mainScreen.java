package JavaFinalFx.mainScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainScreen implements Initializable{


    @FXML
    private Label label;

    @FXML
    private Button btnOverView;

    @FXML
    private Button btnPersonalInfo;

    @FXML
    private Button btnTestResults;


    public void goToOverview(ActionEvent event) throws IOException {

        Stage stage;
        Pane myPane;
        Scene scene;
        stage = new Stage();
        myPane = FXMLLoader.load(getClass().getResource("../Model/Overview.fxml"));
        scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    public void goToPersonalInfo(ActionEvent event) throws IOException {

        Stage stage;
        Pane myPane;
        Scene scene;
        stage = new Stage();
        myPane = FXMLLoader.load(getClass().getResource("../Model/FXMLUser.fxml"));
        scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    public void goToTestresult(ActionEvent event) throws IOException {

        Stage stage;
        Pane myPane;
        Scene scene;
        stage = new Stage();
        myPane = FXMLLoader.load(getClass().getResource("../Model/ForInstructors.fxml"));
        scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
