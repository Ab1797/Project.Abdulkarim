package Day4.session2;

import Day4.session1.Job;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemoV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "select * from jobs where location_id = ?";


        try (Connection conn = DriverManager.getConnection(url);) {

            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter location ID: ");
            int locId = sc.nextInt();
            st.setInt(1, locId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Job d = new Job(rs);
                System.out.println(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}