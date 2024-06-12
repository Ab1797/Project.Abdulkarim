package Day4.session2;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "insert into jobs values (?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(url);) {

            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter job ID: ");
            int jobbId = sc.nextInt();
            st.setInt(1, jobbId);
            sc.nextLine();

            System.out.println("Enter job Name: ");
            String jobbdName = sc.nextLine();
            st.setString(2, jobbdName);

            System.out.println("Enter location ID: ");
            int locId = sc.nextInt();
            st.setInt(3, locId);

            int rows = st.executeUpdate();

            System.out.println(rows + " inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}