// This class acts as a model class,holding getters,setters and properties
package JavaFinalFx.userInfo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableIntegerProperty;
import javafx.css.SimpleStyleableStringProperty;

/**
 *
 * @author admin
 */
public class UserDetails {

    private final IntegerProperty id;
    private final StringProperty first;
    private final StringProperty last;
    private final IntegerProperty age;
    private final StringProperty hobby;
    private final StringProperty job;
    private final IntegerProperty salary;


    //Default constructor


    public UserDetails(int id, String first, String last, int age, String hobby, String job, int salary) {
        this.id = new SimpleIntegerProperty(id);
        this.first = new SimpleStringProperty(first);
        this.last = new SimpleStringProperty(last);
        this.age = new SimpleIntegerProperty(age);
        this.hobby = new SimpleStringProperty(hobby);
        this.job = new SimpleStringProperty(job);
        this.salary = new SimpleIntegerProperty(salary);
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


    @Override
    public String toString() {
        return getId() + " " + getFirst() + " " + getLast() + " " + getAge() + " " + getHobby() + " " + getJob() + " " + getSalary();

    }
};
