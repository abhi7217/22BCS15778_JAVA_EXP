package Unit3.Experiment3.1;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple login logic (for demo purpose)
        if ("admin".equals(username) && "password".equals(password)) {
            response.getWriter().write("Welcome, " + username);
        } else {
            response.getWriter().write("Invalid credentials.");
        }
    }
}
