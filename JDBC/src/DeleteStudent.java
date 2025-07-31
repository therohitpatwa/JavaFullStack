import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/Jdbc";
        String username="root";
        String password="R0hit@#$18";


        String deleteQuery="Delete from student where id=?";
        Connection con=null;
        //jdbc-->hibernate--->jpa
        try {
            con= DriverManager.getConnection(url,username,password);
            //create statement
            PreparedStatement pr = con.prepareStatement(deleteQuery);
            pr.setInt(1,16);
            int update = pr.executeUpdate();
            if(update>0)
            {
                System.out.println("data deleted....");
            }
            else {
                System.out.println("data not found....");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            con.close();;  //Connection Close
        }
    }
}