package HrApiDay08.dao;


import HrApiDay08.dto.JobFilterDto;
import HrApiDay08.models.Job;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_JOBBS = "select * from jobs";
    private static final String SELECT_ONE_JOBB = "select * from jobs where job_id = ?";
    private static final String SELECT_JOBB_WITH_LOC = "select * from jobs where location_id = ?";
    private static final String SELECT_JOBB_WITH_LOC_PAGINATION = "select * from jobs where location_id = ? order by department_id limit ? offset ?";
    private static final String SELECT_JOBB_WITH_PAGINATION = "select * from jobs order by department_id limit ? offset ?";
    private static final String INSERT_JOBB= "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_JOBB = "update jobs set job_name = ?, location_id = ? where job_id = ?";
    private static final String DELETE_JOBB = "delete from departments where department_id = ?";

    public void insertJobb(Job d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOBB);
        st.setInt(1, d.getJobId());
        st.setString(2, d.getJobName());
        st.setInt(3, d.getLocationId());
        st.executeUpdate();
    }

    public void updateJobb(Job d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOBB);
        st.setInt(3, d.getJobId());
        st.setString(1, d.getJobName());
        st.setInt(2, d.getLocationId());
        st.executeUpdate();
    }

    public void deleteJobb(int jobbId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOBB);
        st.setInt(1, jobbId);
        st.executeUpdate();
    }

    public Job selectJobb(int jobbId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOBB);
        st.setInt(1, jobbId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return newJobb(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Job> selectAllDepts(Integer locId, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(locId != null && limit != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_LOC_PAGINATION);
            st.setInt(1, locId);
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(locId != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_LOC);
            st.setInt(1, locId);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Job> jobbs = new ArrayList<>();
        while (rs.next()) {
            jobbs.add(new Job(rs));
        }

        return jobbs;
    }

    public ArrayList<Job> selectAllJobbs(JobFilterDto) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getLocId() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_LOC_PAGINATION);
            st.setInt(1, filter.getLocId());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getLocId() != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_LOC);
            st.setInt(1, filter.getLocId());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOBB_WITH_LOC_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Job> jobbs = new ArrayList<>();
        while (rs.next()) {
            jobbs.add(new Job(rs));
        }

        return jobbs;
    }
}