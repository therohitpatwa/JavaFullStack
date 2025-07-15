import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");  //html to JSP --JSP Content goes to JSP Container --- From JSP Container goes to browser
        PrintWriter out=res.getWriter();
        out.println("<h1>Hello I am Servlet</h1>");
    }
}


//Catalina is Servlet Container inside tomcat manage Servlet Life Cycle