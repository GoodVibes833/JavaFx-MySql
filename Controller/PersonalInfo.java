/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFinalFx.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import JavaFinalFx.Model.UserDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import JavaFinalFx.Util.DbConnection;

/**
 *
 * @author admin
 */
public class PersonalInfo implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textFirst;
    @FXML
    private TextField textLast;
    @FXML
    private TextField textAge;

    @FXML
    private TextField textHobby;

    @FXML
    private TextField textJob;

    @FXML
    private TextField textSalary;

    @FXML
    private Label label;
    @FXML
    private TableView<UserDetails> tableUser;
    @FXML
    private TableColumn<UserDetails, Integer> columnId;
    @FXML
    private TableColumn<UserDetails, String> columnFirst;
    @FXML
    private TableColumn<UserDetails, String> columnLast;
    @FXML
    private TableColumn<UserDetails, Integer> columnAge;
    @FXML
    private TableColumn<UserDetails, String> columnHobby;
    @FXML
    private TableColumn<UserDetails, String> columnJob;
    @FXML
    private TableColumn<UserDetails, Integer> columnSalary;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnSave;


    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnAge;

    @FXML
    private Button btnSalary;

    @FXML
    public ComboBox combo;

    @FXML
    private BarChart<String,Integer> barChart = null;

    private ObservableList<UserDetails> data;
    private DbConnection dc;
    Connection conn = null;
    Statement stmt = null;
    ActionEvent event;


    public String getCombo() {
        return (String)(combo.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DbConnection();
        loadDataFromDatabase(event);
        System.out.println(combo);



    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            conn = dc.Connect();
            data = FXCollections.observableArrayList();

            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Registration1");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new UserDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),rs.getInt(7)));
            }

            System.out.println(Arrays.toString(new ObservableList[]{data}));

        } catch (SQLException ex) {
            System.err.println("Error" + ex);


        }

        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFirst.setCellValueFactory(new PropertyValueFactory<>("first"));
        columnLast.setCellValueFactory(new PropertyValueFactory<>("last"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnHobby.setCellValueFactory((new PropertyValueFactory<>("hobby")));
        columnJob.setCellValueFactory(new PropertyValueFactory<>("job"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableUser.setItems(null);
        tableUser.setItems(data);


    }

    @FXML
    public void saveDataFromDatabase(ActionEvent event) {

        int id = Integer.parseInt(textId.getText());
        String first = textFirst.getText();
        String last = textLast.getText();
        int age = Integer.parseInt(textAge.getText());
        String hobby = textHobby.getText();
        String job = textJob.getText();
        int salary = Integer.valueOf(textSalary.getText());

        try {
            conn = dc.Connect();
            stmt = conn.createStatement();
            String sql = "INSERT INTO Registration1 VALUES (" + id + ",'" + first + "','" + last + "'," + age + ",'" + hobby + "','"+job+"',"+ salary +")";
            stmt.executeUpdate(sql);


        } catch (SQLException ex) {
            System.err.println("Error" + ex);

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        loadDataFromDatabase(event);

    }

    @FXML
    public void updateDataFromDatabase(ActionEvent event) {

        int id = Integer.parseInt(textId.getText());
        String first = textFirst.getText();
        String last = textLast.getText();
        int age = Integer.parseInt(textAge.getText());
        String hobby = textHobby.getText();
        String job = textJob.getText();
        int salary = Integer.parseInt(textSalary.getText());


        try {
//            String sql = "UPDATE Registration1 SET first='" + first + "',last='" + last + "',age=" + age + "                                                                  WHERE id in(" + id + ")";
            String sql = "UPDATE Registration1 SET firstName='"+ first +"',lastName='"+ last +"',age=" + age +",hobby='" + hobby + "',job='" + job + "' ,salary = " + salary + "  WHERE id in(" + id + ")";

            conn = dc.Connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadDataFromDatabase(event);


    }


    @FXML
    public void deleteDataFromDatabase(ActionEvent event) {

        int id = Integer.parseInt(textId.getText());

        try {
            String sql = "DELETE FROM Registration1 WHERE id = " + id;
            conn = dc.Connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadDataFromDatabase(event);

    }


    public void gotoSalaryGragh(ActionEvent event) throws IOException {

        Stage stage;
        Pane myPane;
        Scene scene;
             stage = new Stage();
             myPane = FXMLLoader.load(getClass().getResource("../../charts/barChart.fxml"));
             scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
}



}









