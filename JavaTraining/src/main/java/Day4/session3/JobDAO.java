package Day4.session3;

import Day4.session1.Job;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaTraining\\src\\main\\java\\Day4\\hr.db";
    private static final String SELECT_ALL_JOBBS = "select * from departments";
    private static final String SELECT_ONE_DEPT = "select * from jobs where job_id = ?";
    private static final String INSERT_JOBB = "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_JOBB = "update jobs set job_name = ?, location_id = ? where department_id = ?";
    private static final String DELETE_JOBB = "delete from departments where job_id = ?";

    public void insertJob(Job d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOBB);
        st.setInt(1, d.getJobId());
        st.setString(2, d.getJobName());
        st.setInt(3, d.getLocationId());
        st.executeUpdate();
    }

    public void updateJobb(Job d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOBB);
        st.setInt(3, d.getJobId());
        st.setString(1, d.getJobName());
        st.setInt(2, d.getLocationId());
        st.executeUpdate();
    }

    public void deleteDept(int deptId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOBB);
        st.setInt(1, deptId);
        st.executeUpdate();
    }

    public Job selectJobb(int deptId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_DEPT);
        st.setInt(1, deptId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Job(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Job> selectAllDepts() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_JOBBS);
        ResultSet rs = st.executeQuery();
        ArrayList<Job> depts = new ArrayList<>();
        while (rs.next()) {
            depts.add(new Job(rs));
        }

        return depts;
    }

}