package Day4.session2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemoV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
        String query = "insert into jobs values (?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(url);) {
            conn.setAutoCommit(false);

            while (true) {

                PreparedStatement st = conn.prepareStatement(query);
                System.out.println("Enter job ID: ");
                int jobbId = sc.nextInt();
                st.setInt(1, jobbId);
                sc.nextLine();

                System.out.println("Enter job Name: ");
                String jobbName = sc.nextLine();
                st.setString(2, jobbName);

                System.out.println("Enter location ID: ");
                int locId = sc.nextInt();
                st.setInt(3, locId);

                int rows = st.executeUpdate();

                System.out.println(rows + " inserted");

                sc.nextLine();
                System.out.println("Do you want to save: ");
                String toSave = sc.nextLine();
                if(toSave.equals("yes")) {
                    conn.commit();
                    System.out.println("Data saved");
                    break;
                } else if (toSave.equals("no")) {
                    conn.rollback();
                    System.out.println("Save cancelled");
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}