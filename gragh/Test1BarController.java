package JavaFinalFx.gragh;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import JavaFinalFx.DbConnection;
import JavaFinalFx.overview.AllDetails;
import JavaFinalFx.userInfo.UserDetails;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Test1BarController implements Initializable {


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

    @FXML
    private ObservableList<AllDetails> data;

    @FXML
    private ComboBox comboBox;

    private DbConnection dc;
    ActionEvent event;
    Connection conn;

    int numOfTest;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DbConnection();
        System.out.println("connected test1");
        conn = dc.Connect();


}

    public void clear(){
        barChart.getData().clear();
    }

    public void gragh(){
        clear();
        try {

        if(comboBox.getValue().equals("test1")){
            numOfTest= 6;
        }
        if(comboBox.getValue().equals("test2")){
            numOfTest= 7;
        }
        if(comboBox.getValue().equals("test3")){
            numOfTest= 8;
        }
        if(comboBox.getValue().equals("test4")){
            numOfTest= 9;
        }
        if(comboBox.getValue().equals("test5")){
            numOfTest= 10;
        }
        if(comboBox.getValue().equals("test6")){
            numOfTest= 11;
        }
        if(comboBox.getValue().equals("test7")){
            numOfTest= 12;
        }
        if(comboBox.getValue().equals("test8")){
            numOfTest= 13;
        }
        if(comboBox.getValue().equals("test9")){
            numOfTest= 14;
        }
        if(comboBox.getValue().equals("test10")){
            numOfTest= 15;
        }
        if(comboBox.getValue().equals("ave")){
            numOfTest= 16;
        }


            String sql = "SELECT Registration1.id, Registration1.firstName, Registration1.lastName, Registration1.age, Registration1.hobby, " +
                    "Registration1.job, Registration1.salary, studentscore.test1, studentscore.test2, studentscore.test3, studentscore.test4," +
                    " studentscore.test5, studentscore.test6, studentscore.test7, studentscore.test8, studentscore.test9, " +
                    "studentscore.test10, studentscore.ave " +
                    "FROM Registration1 " +
                    "INNER JOIN studentscore ON Registration1.id=studentscore.id";

            ResultSet rs = conn.createStatement().executeQuery(sql);
            ArrayList<Object> arr;
            XYChart.Series set1;
            set1 = new XYChart.Series<>();
            arr = new ArrayList<>();

            while (rs.next()) {
                //get string from db,whichever way
                arr.add(new AllDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getInt(18)));

            }

            for (int i = 0; i < arr.size(); i++) {
                String ApersonInfo = arr.get(i).toString();//[1 dd dd 12 dd dd 22]
                String[] ApersonInfointoArr = ApersonInfo.split(" ");//[1,dd,dd,12,dd,dd,22]
                String xValueName = ApersonInfointoArr[1];
                int yValue = Integer.parseInt(ApersonInfointoArr[numOfTest]);
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


