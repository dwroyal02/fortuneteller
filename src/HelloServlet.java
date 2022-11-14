import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("TEXT/HTML");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("그냥 스트링");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("</html>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>");
        out.print("Hello!!");
        out.print("</h1");
        out.print("</body>");
        out.print("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
