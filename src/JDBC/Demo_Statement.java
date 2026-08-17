package JDBC;
import java.sql.*;
import java.util.Scanner;

public class Demo_Statement {
    public static final String url="jdbc:mysql://localhost:3306/useless";
    public static final String username="root";;
    public static final String password="01JDBCLe@rn";

    public static void main(String[] args) {
        // drivers loading
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }



        try{

            //connection established
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();

            Scanner sc=new Scanner(System.in);


            //// Retriving the data from database
//            String query1="select * from student";
//
//            ResultSet resultSet=statement.executeQuery(query1);
//            while(resultSet.next()){
//                String roll=resultSet.getString("roll_no");
//                String name=resultSet.getString("name");
//                String branch=resultSet.getString("branch");
//                int age=resultSet.getInt("age");
//                System.out.println("rollno:"+roll);
//                System.out.println("name:"+name);
//                System.out.println("branch:"+branch);
//                System.out.println("age:"+age);
//            }
           ///// // inserting the values into the table

//            String query2=String.format("insert into student(roll_no,name,branch,age) values('%s','%s','%s',%d)","24R1Z1","ganesh","CSM",21);
//            int rowsAffected=statement.executeUpdate(query2);
//             if(rowsAffected>0){
//                 System.out.println("successfully updated");
//             }
//             else{
//                 System.out.println("failed to update");
//             }

  //////////    updating table
//              String query3=String.format("update student set age = %d where roll_no = '%s'",19,"24R1Z6");
//               statement.executeUpdate(query3);


    ////    deleting
//    String query4=String.format("delete from student where roll_no ='%s'","24R1Z6");
//    statement.executeUpdate(query4);


////////  Batch processing

      while (true) {
            System.out.print("Enter roll no:");
            String rollno = sc.next();
            System.out.print("Enter name:");
            String name = sc.next();
            System.out.print("Enter branch:");
            String branch = sc.next();
            System.out.print("Enter age:");
            int age = sc.nextInt();
            String query=String.format("INSERT into student(roll_no,name,branch,age) values('%s','%s','%s',%d)", rollno, name, branch, age);
            statement.addBatch(query);
            String choice = sc.next();
            if (choice.toUpperCase().charAt(0)== 'N') {
                break;
            }
            }
            int[] result=statement.executeBatch();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
