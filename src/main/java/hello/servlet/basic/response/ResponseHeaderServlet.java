package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Status line -------응답코드
        //response.setStatus(200); //성공
        //response.setStatus(HttpServletResponse.SC_OK); //성공
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); //실패 400

        //response-header
        response.setHeader("content-Type","text/plan;charset=utf-8"); //컨텐츠 타입
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //캐쉬 무효화
        response.setHeader("Pragma","no-cache"); //과거 캐쉬 무효화
        response.setHeader("my-header","hello"); //원하는 임의의 값을 넣을 수 있음.

        //메시지 body
        PrintWriter writer = response.getWriter();
        writer.println("ok- 안녕");

        //header 편의 메서드
        content(response);
        //쿠키 메서드
        cookie(response);
        redirect(response);

    }

    //header 편의 메서드
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)

    }

    //쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600; //쿠키 유효 시간 600초
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    //redirect
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

}
