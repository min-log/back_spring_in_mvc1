package hello.servlet.web.frontController;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Setter
@Getter
public class ModelView {
    public String viewName;

    //JSP에 전달할
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }


}
