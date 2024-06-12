package Day4.session3;

import Day4.session1.Job;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String query = "select * from jobs where location_id = 1700";

        try (Connection conn = ConnPoolConfig.getConnection();) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Job d = new Job(rs);
                System.out.println(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}