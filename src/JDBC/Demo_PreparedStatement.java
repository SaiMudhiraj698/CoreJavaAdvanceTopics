package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Demo_PreparedStatement {
    public static final String url="jdbc:mysql://localhost:3306/useless";
    public static final String user="root";
    public static final String password="01JDBCLe@rn";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,password);
            Scanner sc=new Scanner(System.in);
            // Retriving the data from database
//            String query="select * from student";
//            PreparedStatement pst=con.prepareStatement(query);
//            ResultSet rs=pst.executeQuery();
//
//            while(rs.next()){
//                System.out.print(rs.getString(1)+"  ");
//                System.out.print(rs.getString(2)+"  ");
//                System.out.print(rs.getString(3)+"  ");
//                System.out.print(rs.getInt(4)+"  ");
//                System.out.println();
//            }

//            inserting the values
//            String query1="insert into student(roll_no,name,branch,age) values(?,?,?,?)";
//            PreparedStatement pst1=con.prepareStatement(query1);
//            pst1.setString(1,"24rz6");
//            pst1.setString(2,"nig");
//            pst1.setString(3,"cor");
//            pst1.setInt(4,45);
//            pst1.executeUpdate();

//          Update the values
//            String query2="update student set age=? where roll_no=? ";
//            PreparedStatement ps=con.prepareStatement(query2);
//            ps.setInt(1,30);
//            ps.setString(2,"24rz6");


////    batch process
            String query=String.format("INSERT into student(roll_no,name,branch,age) values(?,?,?,?)");
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            while (true) {
                System.out.print("Enter roll no:");
                String rollno = sc.next();
                System.out.print("Enter name:");
                String name = sc.next();
                System.out.print("Enter branch:");
                String branch = sc.next();
                System.out.print("Enter age:");
                int age = sc.nextInt();
                preparedStatement.setString(1,rollno);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,branch);
                preparedStatement.setInt(4,age);
                preparedStatement.addBatch();
                String choice = sc.next();
                if (choice.toUpperCase().charAt(0)== 'N') {
                    break;
                }
            }
            int[] result=preparedStatement.executeBatch();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
