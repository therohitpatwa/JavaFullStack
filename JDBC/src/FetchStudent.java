import java.sql.*;

public class FetchStudent {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/JavaFullStack";
        String username="root";
        String password="R0hit@#$18";

        String query="select * from students";
        try {

            //1. Driver load kro -- nowdays it loads automatically//
             Class.forName("com.mysql.cj.jdbc.Driver");

            //2 connection bana rahe hain
            Connection con=DriverManager.getConnection(url,username,password);

            //3 Create Statement
            Statement stmt=con.createStatement();     //resolve static query

            //4 Execute Statement
            ResultSet rs = stmt.executeQuery(query);

            //get result
            System.out.println("Id | Name | Age | Course");
            System.out.println("----------------------------------");
            while (rs.next())
            {
                System.out.println(rs.getInt("id")+ " | "+
                        rs.getString("name")+ " | "+
                        rs.getInt("age")+" | "+
                        rs.getString("course")+ " | " );
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}