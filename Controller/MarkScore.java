package JavaFinalFx.Controller;

import JavaFinalFx.Model.ScoreDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import JavaFinalFx.Util.DbConnection;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * mark scores, add, and update
 */
public class MarkScore implements Initializable{
    @FXML
    private Label label;

    @FXML
    private TableView<ScoreDetails> tableUser;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnId;

    @FXML
    private TableColumn<ScoreDetails, String> columnFirst;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest1;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest2;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest3;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest4;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest5;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest6;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest7;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest8;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest9;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnTest10;

    @FXML
    private TableColumn<ScoreDetails, Integer> columnAve;

    @FXML
    private TextField textFieldId;

    @FXML
    private Button btnMartAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;



    static ArrayList<String> arrStudentAnswer = new ArrayList<>();
    static ArrayList<String> arrRightAnswer = new ArrayList<>();
    private Scanner studentAnswer;
    private Scanner rightAnswer;
    private ObservableList<ScoreDetails> scoredata;
    private DbConnection dc;
    Connection conn = null;
    Statement stmt = null;
    ActionEvent event;
    int score ;
    int studentId;
    String studentName;
    String testName;


    /**
     * read text file
     * @return student answer with array
     */
    public ArrayList<String> readfile(){
        arrRightAnswer.clear();
        arrStudentAnswer.clear();

        try{
            studentAnswer = new Scanner(new File("./src/JavaFinalFx/Util/studentAnswer.txt"));
            rightAnswer = new Scanner(new File("./src/JavaFinalFx/Util/rightAnswer.txt"));
        }
        catch (Exception e){
            System.out.println("no file");
        }

        while (studentAnswer.hasNext()){
            arrStudentAnswer.add(studentAnswer.next());

        }
        while (rightAnswer.hasNext()){
            arrRightAnswer.add(rightAnswer.next());

        }

    return arrStudentAnswer;
    }

    /**
     * mark student's score
     * @return score
     */
    public int mark(){
        int numOfRightAnswer=0;

        for(int i = 3; i <= (arrRightAnswer.size()-2)/2; i++){
            if(arrRightAnswer.get(2*i+1).equals(arrStudentAnswer.get(2*i+1))){
                numOfRightAnswer ++;
            }
        }
        score = numOfRightAnswer* (100/((arrRightAnswer.size()/2)-3));

        System.out.println(arrRightAnswer +" "+ arrRightAnswer.size()+ "개");
        System.out.println(arrStudentAnswer+" "+ arrStudentAnswer.size()+ "개");
        System.out.println("numOfRightAnswer : " +numOfRightAnswer);
        System.out.println("score : " + score);



        return score;

    }


    public int getStudentId(){
        readfile();
        studentId = Integer.parseInt(arrStudentAnswer.get(1));
        return studentId;

    }

    public String getStudentName(){
        readfile();
        studentName = arrStudentAnswer.get(3);
        return studentName;
    }

    public String getTestName(){
        readfile();
        testName = arrStudentAnswer.get(5);
        return testName;
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            conn = dc.Connect();
            scoredata = FXCollections.observableArrayList();

            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM studentscore");
            while (rs.next()) {
                //get string from db,whichever way
                scoredata.add(new ScoreDetails(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13)));
            }

            System.out.println(Arrays.toString(new ObservableList[]{scoredata}));

        } catch (SQLException ex) {
            System.err.println("Error" + ex);


        }

        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFirst.setCellValueFactory(new PropertyValueFactory<>("first"));
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
        columnAve.setCellValueFactory(new PropertyValueFactory<>("ave"));

        tableUser.setItems(null);
        tableUser.setItems(scoredata);



    }

    @FXML
    public void saveDataFromDatabase(ActionEvent event) {
        int test1 = 0;
        int test2 = 0;
        int test3 = 0;
        int test4 = 0;
        int test5 = 0;
        int test6 = 0;
        int test7 = 0;
        int test8 = 0;
        int test9 = 0;
        int test10 = 0;
        int ave = 0;

        try {
            conn = dc.Connect();
            stmt = conn.createStatement();
            String sql = "INSERT INTO studentscore VALUES (" +getStudentId()+ ",'" + getStudentName() + "'," + test1 + "," + test2 + "," + test3 + "," + test4 + "," + test5 + "," + test6 + "," + test7 + "," + test8 + "," + test9 + "," + test10 + "," + ave + ")";
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

        try {

            conn = dc.Connect();
            stmt = conn.createStatement();
            String sql = "UPDATE studentscore SET "+getTestName()+"="+ mark() + "  WHERE id in(" + getStudentId() + ")";
            stmt.executeUpdate(sql);

            System.out.println(sql);
            System.out.println("test name : "+ getTestName());


        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadDataFromDatabase(event);

    }

    @FXML
    public void deleteDataFromDatabase(ActionEvent event) {

        int id = Integer.parseInt(textFieldId.getText());
        System.out.println(id);

        try {
            String sql = "DELETE FROM studentscore WHERE id = " + id;
            conn = dc.Connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadDataFromDatabase(event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dc = new DbConnection();
        loadDataFromDatabase(event);


    }
}
