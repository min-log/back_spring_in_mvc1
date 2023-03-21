package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet",urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 전송 받은 request 값 가져오기
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        //2. 비즈니스 로직
        Member member = new Member(username,age);
        Member saveMember = memberRepository.save(member);

        //3. 응답 전달 시 세팅
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //4. 응답 - HTML로 내려주기
        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+saveMember.getId()+"</li>\n" +
                " <li>username="+saveMember.getUsername()+"</li>\n" +
                " <li>age="+saveMember.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>"
        );

    }
}
