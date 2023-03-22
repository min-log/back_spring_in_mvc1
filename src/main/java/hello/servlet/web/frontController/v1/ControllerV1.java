package hello.servlet.web.frontController.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 서블릿과 비슷한 모양의 인터페이스
* 컨트롤러들이 인터페이스를 구현
* */

public interface ControllerV1 {
    void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
