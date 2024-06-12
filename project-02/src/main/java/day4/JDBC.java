package day4;

import java.sql.*;
import java.util.Scanner;

public class JDBC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\project-02\\src\\main\\java\\day4\\hr.db";
        String query = "insert into  jobs values (? ? ?)";


        try (Connection conn = DriverManager.getConnection(url);) {
            conn.setAutoCommit(false);
            PreparedStatement st = conn.prepareStatement(query);

            while (true) {


                System.out.println("Enter department ID: ");
                int deptId = sc.nextInt();
                st.setInt(1, deptId);
                sc.nextLine();

                System.out.println("Enter department Name: ");
                String deptName = sc.nextLine();
                st.setString(2, deptName);

                System.out.println("Enter location ID: ");
                int locId = sc.nextInt();
                st.setInt(3, locId);

                st.addBatch();


                sc.nextLine();
                System.out.println("Do you want to save: ");
                String toSave = sc.nextLine();
                if (toSave.equals("yes")) {
                    int[] rows = st.executeBatch();
                    for (int r : rows) {
                        System.out.println(r + " inserted");
                    }
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