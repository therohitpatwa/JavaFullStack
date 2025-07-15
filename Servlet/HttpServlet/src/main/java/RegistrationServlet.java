import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    List<User> users= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h2> Registration Users<h2>");
        if(users.isEmpty())
        {
            out.println("<p>No User Registered<p>");
        }
        else {
            out.println("<ul>");
            for (User user:users)
            {
                out.println("<li>"+user.getName()+"-"+user.getEmail()+"</li>");
            }
            out.println("<a href='index.html'>Back to Registration</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        users.add(new User(name,email));
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h2>Registration Successful<h2>");
        out.println("<p>Name: "+name+"</p>");
        out.println("<p>Email: "+email+"</p>");
        out.println("<a href='register'>view All Users</a>");
        out.println("<a href='index.html'>Back to Registration</a>");




    }
}


class  User
{
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

}

