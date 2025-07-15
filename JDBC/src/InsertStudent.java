import java.sql.*;

public class InsertStudent {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/JavaFullStack";
        String username="root";
        String password="R0hit@#$18";

        String insertQuery="insert into students(name,age,course) values (?,?,?)";
        try {

            //1. load kro -- nowdays it loads automatically.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            //2 connection bana rahe hain
            Connection con= DriverManager.getConnection(url,username,password);

            //create statement
            PreparedStatement pr=con.prepareStatement(insertQuery);
            pr.setString(1,"Styam3");
            pr.setInt(2,21);
            pr.setString(3,"DSA");


            //execute
            pr.executeUpdate();

            pr.setString(1,"Riya3");
            pr.setInt(2,21);
            pr.setString(3,"C");


            //execute
            pr.executeUpdate();



            pr.setString(1,"Feraz3");
            pr.setInt(2,21);
            pr.setString(3,"DSA");


            //execute
            pr.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
