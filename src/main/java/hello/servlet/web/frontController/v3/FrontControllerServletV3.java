package hello.servlet.web.frontController.v3;


import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;

import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    /*
    * 매핑 정보
    * */
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }
    /*
    *프론트 컨트롤러 역할
    * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3 start ");
        //url : front-controller/v2/members/new-form
        String requestURI = request.getRequestURI();
        // 부모객체로 객체 반환
        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controller.process(paramMap); //파라미터 전달

        String viewName = modelView.getViewName();// 논리 이름만 얻어온다.
        MyView view = viewResolver(viewName); // 실제 물리 이름으로 변경

        view.render(modelView.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        //파라미터 modelView에 전달
        // paramMap
        Map<String, String> paramMap = new HashMap<>();

        // request로 전달 받은 파라미터 이름을 전부가져온다.
        // 만들어둔 paramMap에 key,value를 바로 넣어준다.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
