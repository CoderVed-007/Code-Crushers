package com.smarttraffic.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

@WebServlet("/traffic")
public class TrafficManagementServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject trafficData = new JSONObject();
        trafficData.put("intersection", "Main St & 1st Ave");
        trafficData.put("status", "Heavy Traffic");
        trafficData.put("suggestedAction", "Adjust signal timing");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(trafficData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String intersection = request.getParameter("intersection");
        String action = request.getParameter("action");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        if (intersection != null && action != null) {
            response.getWriter().write("Traffic rules updated for " + intersection + " with action: " + action);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid input! Parameters are required.");
        }
    }
}
