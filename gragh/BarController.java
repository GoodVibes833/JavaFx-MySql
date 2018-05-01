package JavaFinalFx.gragh;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import JavaFinalFx.DbConnection;
import JavaFinalFx.userInfo.FXMLUserController;
import JavaFinalFx.userInfo.UserDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static JavaFinalFx.userInfo.FXMLUserController.*;

public class BarController implements Initializable {


    @FXML
    private BarChart<?,?> barChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private Button back;

    @FXML
    private Button showgragh;

    @FXML
    private  Button graghAge;

    @FXML
    private Button graghSalary;

    private ObservableList<UserDetails> data;
    private DbConnection dc;
    ActionEvent event;
    private ComboBox comboBox;
    int index;
    Connection conn;







    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DbConnection();
        System.out.println("connected");
        conn = dc.Connect();

    try {

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Registration1");

        XYChart.Series set1 = new XYChart.Series<>();
        ArrayList<Object> arr = new ArrayList<>();

        while (rs.next()) {
            arr.add(new UserDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
        }

        for (int i = 0; i < arr.size(); i++) {
            String ApersonInfo = arr.get(i).toString();//[1 dd dd 12 dd dd 22]
            String[] ApersonInfointoArr = ApersonInfo.split(" ");//[1,dd,dd,12,dd,dd,22]
            String xValueName = ApersonInfointoArr[1];
            int yValue = Integer.parseInt(ApersonInfointoArr[3]);
            System.out.print("\n" + xValueName);
            System.out.print(" " + yValue);
            set1.getData().add(new XYChart.Data<>(xValueName, yValue));
        }

        barChart.getData().addAll(set1);

    } catch (SQLException ex) {
        System.err.println("Error" + ex);
    }



}



}


