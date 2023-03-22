package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String,String> paramMap = createParamMap(request); // 뷰


        ModelView modelView = controller.process(paramMap);


        return modelView;
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
