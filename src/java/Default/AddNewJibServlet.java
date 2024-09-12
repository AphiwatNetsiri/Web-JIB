package Default;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Jib;

@WebServlet("/addNewJibServlet")
public class AddNewJibServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jibName = request.getParameter("jibName");
        String jibType = request.getParameter("jibType");
        String priceStr = request.getParameter("jibPrice");
        int price = 0;

        // Validate and parse price
        if (priceStr != null && !priceStr.isEmpty()) {
            try {
                price = Integer.parseInt(priceStr);
            } catch (NumberFormatException e) {
                // Handle the error gracefully, e.g., set a default price or notify the user
                response.getWriter().println("Invalid price input.");
                return;
            }
        } else {
            response.getWriter().println("Price is required.");
            return;
        }

        Jib jib = new Jib();
        jib.setName(jibName);
        jib.setType(jibType);
        jib.setPrice(price);

        DBConnection dbConnection = new DBConnection();
        if (!dbConnection.insertNewJib(jib)) {
            System.out.println(">>> AddNewJibMySQL ERROR");
        }

        HttpSession session = request.getSession();
        session.setAttribute("jib", jib);

        response.sendRedirect("addNewJibSuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
