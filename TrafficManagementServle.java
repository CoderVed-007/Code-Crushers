

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/traffic")
public class TrafficManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Simulated traffic data
        String trafficStatus = "Moderate Traffic";
        int averageSpeed = 40; // in km/h

        // Simulated user data
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice Johnson", "alice.j@example.com"));
        users.add(new User(2, "Bob Smith", "bob.smith@example.com"));
        users.add(new User(3, "Charlie Brown", "charlie.brown@example.com"));

        // Add data to request scope
        request.setAttribute("trafficStatus", trafficStatus);
        request.setAttribute("averageSpeed", averageSpeed);
        request.setAttribute("users", users);

        // Forward the request to JSP
        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
