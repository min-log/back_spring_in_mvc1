package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="helloServlet",urlPatterns = "/hello") //  서블릿으로 설정 - 2) @WebServlet 어노테이션
public class HelloServlet extends HttpServlet { // 서블릿으로 설정 - 1) HttpServlet 을 상속

    // 3) 서블릿으로 http 요청 및 응답
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String userName = request.getParameter("username");
        System.out.println("userName = " + userName);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("hello " + userName);


    }
}
