package JavaFinalFx.overview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import JavaFinalFx.DbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Formatter;


public class Overview implements Initializable  {
    @FXML
    private TableView<AllDetails> tableUser;

    @FXML
    private TableColumn<AllDetails, Integer> columnId;

    @FXML
    private TableColumn<AllDetails, String> columnFirst;

    @FXML
    private TableColumn<AllDetails, String> columnLast;

    @FXML
    private TableColumn<AllDetails, Integer> columnAge;

    @FXML
    private TableColumn<AllDetails, String> columnHobby;

    @FXML
    private TableColumn<AllDetails, String> columnJob;

    @FXML
    private TableColumn<AllDetails, Integer> columnSalary;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest1;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest2;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest3;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest4;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest5;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest6;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest7;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest8;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest9;

    @FXML
    private TableColumn<AllDetails, Integer> columnTest10;

    @FXML
    private TableColumn<AllDetails, Integer> columnTestAve;


    private ObservableList<AllDetails> data;
    private DbConnection dc;
    Connection conn = null;
    Statement stmt = null;
    ActionEvent event;
    public ComboBox combo;
    private static Formatter out;


    //todo JOIN!!


    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            conn = dc.Connect();
            data = FXCollections.observableArrayList();
            String sql = "SELECT Registration1.id, Registration1.firstName, Registration1.lastName, Registration1.age, Registration1.hobby, " +
                    "Registration1.job, Registration1.salary, studentscore.test1, studentscore.test2, studentscore.test3, studentscore.test4," +
                    " studentscore.test5, studentscore.test6, studentscore.test7, studentscore.test8, studentscore.test9, " +
                    "studentscore.test10, studentscore.ave " +
                    "FROM Registration1 " +
                    "INNER JOIN studentscore ON Registration1.id=studentscore.id";
            System.out.println(sql);

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                //get string from db,whichever way
                data.add(new AllDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getInt(18)));
            }

            System.out.println(Arrays.toString(new ObservableList[]{data}));

        } catch (SQLException ex) {
            System.err.println("Error" + ex);


        }

        //7+11 = 18
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFirst.setCellValueFactory(new PropertyValueFactory<>("first"));
        columnLast.setCellValueFactory(new PropertyValueFactory<>("last"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnHobby.setCellValueFactory((new PropertyValueFactory<>("hobby")));
        columnJob.setCellValueFactory(new PropertyValueFactory<>("job"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        columnTest1.setCellValueFactory(new PropertyValueFactory<>("test1"));
        columnTest2.setCellValueFactory(new PropertyValueFactory<>("test2"));
        columnTest3.setCellValueFactory(new PropertyValueFactory<>("test3"));
        columnTest4.setCellValueFactory(new PropertyValueFactory<>("test4"));
        columnTest5.setCellValueFactory(new PropertyValueFactory<>("test5"));
        columnTest6.setCellValueFactory(new PropertyValueFactory<>("test6"));
        columnTest7.setCellValueFactory(new PropertyValueFactory<>("test7"));
        columnTest8.setCellValueFactory(new PropertyValueFactory<>("test8"));
        columnTest9.setCellValueFactory(new PropertyValueFactory<>("test9"));
        columnTest10.setCellValueFactory(new PropertyValueFactory<>("test10"));
        columnTestAve.setCellValueFactory(new PropertyValueFactory<>("ave"));

        tableUser.setItems(null);
        tableUser.setItems(data);


    }


    public void gotoSalaryGragh(ActionEvent event) throws IOException {
        Stage stage;
        Pane myPane;
        Scene scene;

            System.out.println("value is age");
            stage = new Stage();
            myPane = FXMLLoader.load(getClass().getResource("../Model/Test1BarChart.fxml"));
            scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();


    }


    public void resultToTextFile(ActionEvent event) {

        try {
            out = new Formatter("/Users/jin-tak.han/IdeaProjects/JavaFxFinal/src/JavaFinalFx/overview/result.txt"); // open the file


            String resultArr = "id first last age hobby email birthday t1 t2 t3 t4 t5 t6 t7 t8 t9 t10 average\n";
            for(int i =0; i<data.size(); i++){
               resultArr +=  data.get(i) + "\n";
            }
            out.format(resultArr);

            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1); // terminate the program
        } catch (FormatterClosedException e) {
                System.err.println("Error writing to file. Terminating...");
            }


    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dc = new DbConnection();
        loadDataFromDatabase(event);
    }
}

