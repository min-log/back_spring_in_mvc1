package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.request.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 컨텐츠 타입
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //2. 전달할 객체 생성
        HelloData helloData = new HelloData();
        helloData.setUsername("lee");
        helloData.setAge(10);
        //3. json 형태로 변환 {"username":"lee","age":10}
        //json 형태로 변환하려면 ObjectMapper가  필요하다.
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);

    }
}
