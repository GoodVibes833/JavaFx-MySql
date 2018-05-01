package JavaFinalFx.overview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AllDetails {
    private final IntegerProperty id;
    private final StringProperty first;
    private final StringProperty last;
    private final IntegerProperty age;
    private final StringProperty hobby;
    private final StringProperty job;
    private final IntegerProperty salary;
    private final IntegerProperty test1;
    private final IntegerProperty test2;
    private final IntegerProperty test3;
    private final IntegerProperty test4;
    private final IntegerProperty test5;
    private final IntegerProperty test6;
    private final IntegerProperty test7;
    private final IntegerProperty test8;
    private final IntegerProperty test9;
    private final IntegerProperty test10;
    private final IntegerProperty ave;



    public AllDetails(int id, String first, String last, int age, String hobby, String job, int salary, int test1, int test2, int test3, int test4, int test5, int test6, int test7, int test8, int test9, int test10, int ave) {
        this.id = new SimpleIntegerProperty(id);
        this.first = new SimpleStringProperty(first);
        this.last = new SimpleStringProperty(last);
        this.age = new SimpleIntegerProperty(age);
        this.hobby = new SimpleStringProperty(hobby);
        this.job = new SimpleStringProperty(job);
        this.salary = new SimpleIntegerProperty(salary);
        this.test1 = new SimpleIntegerProperty(test1);
        this.test2 = new SimpleIntegerProperty(test2);
        this.test3 = new SimpleIntegerProperty(test3);
        this.test4 = new SimpleIntegerProperty(test4);
        this.test5 = new SimpleIntegerProperty(test5);
        this.test6 = new SimpleIntegerProperty(test6);
        this.test7 = new SimpleIntegerProperty(test7);
        this.test8 = new SimpleIntegerProperty(test8);
        this.test9 = new SimpleIntegerProperty(test9);
        this.test10 = new SimpleIntegerProperty(test10);
        this.ave = new SimpleIntegerProperty(ave);
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFirst() {
        return first.get();
    }

    public StringProperty firstProperty() {
        return first;
    }

    public String getLast() {
        return last.get();
    }

    public StringProperty lastProperty() {
        return last;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public String getHobby() {
        return hobby.get();
    }

    public StringProperty hobbyProperty() {
        return hobby;
    }

    public String getJob() {
        return job.get();
    }

    public StringProperty jobProperty() {
        return job;
    }

    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public int getTest1() {
        return test1.get();
    }

    public IntegerProperty test1Property() {
        return test1;
    }

    public int getTest2() {
        return test2.get();
    }

    public IntegerProperty test2Property() {
        return test2;
    }

    public int getTest3() {
        return test3.get();
    }

    public IntegerProperty test3Property() {
        return test3;
    }

    public int getTest4() {
        return test4.get();
    }

    public IntegerProperty test4Property() {
        return test4;
    }

    public int getTest5() {
        return test5.get();
    }

    public IntegerProperty test5Property() {
        return test5;
    }

    public int getTest6() {
        return test6.get();
    }

    public IntegerProperty test6Property() {
        return test6;
    }

    public int getTest7() {
        return test7.get();
    }

    public IntegerProperty test7Property() {
        return test7;
    }

    public int getTest8() {
        return test8.get();
    }

    public IntegerProperty test8Property() {
        return test8;
    }

    public int getTest9() {
        return test9.get();
    }

    public IntegerProperty test9Property() {
        return test9;
    }

    public int getTest10() {
        return test10.get();
    }

    public IntegerProperty test10Property() {
        return test10;
    }

    public int getAve() {
        return ave.get();
    }

    public IntegerProperty aveProperty() {
        return ave;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setFirst(String first) {
        this.first.set(first);
    }

    public void setLast(String last) {
        this.last.set(last);
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public void setHobby(String hobby) {
        this.hobby.set(hobby);
    }

    public void setJob(String job) {
        this.job.set(job);
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public void setTest1(int test1) {
        this.test1.set(test1);
    }

    public void setTest2(int test2) {
        this.test2.set(test2);
    }

    public void setTest3(int test3) {
        this.test3.set(test3);
    }

    public void setTest4(int test4) {
        this.test4.set(test4);
    }

    public void setTest5(int test5) {
        this.test5.set(test5);
    }

    public void setTest6(int test6) {
        this.test6.set(test6);
    }

    public void setTest7(int test7) {
        this.test7.set(test7);
    }

    public void setTest8(int test8) {
        this.test8.set(test8);
    }

    public void setTest9(int test9) {
        this.test9.set(test9);
    }

    public void setTest10(int test10) {
        this.test10.set(test10);
    }

    public void setAve(int ave) {
        this.ave.set(ave);
    }


    @Override
    public String toString() {
    return getId()+ " " +getFirst()+ " " +getLast()+ " " +getAge()+ " " +getHobby()+ " " +getJob()+ " " +getSalary()+ " " +getTest1()+ " " +getTest2()+ " " +getTest3()+ " " +getTest4()+ " " +getTest5()+ " " +getTest6()+ " " +getTest7()+ " " +getTest8()+ " " +getTest9()+ " " +getTest10()+ " " +getAve();
    }
}
