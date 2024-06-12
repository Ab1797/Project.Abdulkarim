package day4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jops {
    private int job_id;
    private  String job_title;
    private double main_salary;
    private  double max_salary;


    public jops (ResultSet as )throws SQLException{
        job_id =as.getInt("job_id");
        job_title = as.getString("job_title");
        main_salary= as.getDouble("main_salary");
        max_salary= as.getDouble("maix_salary");


    }

    public jops(int jop_id, String jop_title) {
        this.job_id = jop_id;
        this.job_title = jop_title;
    }

    @Override
    public String toString() {
        return "jops{" +
                "job_id=" + job_id +
                ", job_title='" + job_title + '\'' +
                ", main_salary=" + main_salary +
                ", max_salary=" + max_salary +
                '}';
    }

    public int getJop_id() {
        return job_id;
    }

    public String getJop_title() {
        return job_title;
    }

    public void setJop_id(int jop_id) {
        this.job_id = jop_id;
    }

    public void setJop_title(String jop_title) {
        this.job_title = jop_title;
    }

    public double getMain_salary() {
        return main_salary;
    }

    public double getMax_salary() {
        return max_salary;
    }

    public void setMain_salary(double main_salary) {
        this.main_salary = main_salary;
    }

    public void setMax_salary(double max_salary) {
        this.max_salary = max_salary;
    }

    public jops(double main_salary, double max_salary) {
        this.main_salary = main_salary;
        this.max_salary = max_salary;
    }


}
