import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create and populate a sample user object
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john.doe@example.com");
        user.setAge(25);

        // Set user object in the request scope
        request.setAttribute("user", user);

        // Forward to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("userProfile.jsp");
        dispatcher.forward(request, response);
    }
}
