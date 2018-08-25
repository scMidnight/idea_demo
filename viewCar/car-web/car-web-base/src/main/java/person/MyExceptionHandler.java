package person;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    private String errorUrl;

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase(
                "XMLHttpRequest")) { // ajax 超时处理
            try {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print(JsonUtil.getJSONString(JsonUtil.toString("n",ex.getMessage())));
                out.flush();
                out.close();
            } catch (Exception e) {
                System.err.println(ex.getMessage());
            }

        } else {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("ex", ex);
            try {
				/*request.getRequestDispatcher(errorUrl).forward(request,
						response);*/
                response.sendRedirect(request.getContextPath()+errorUrl);
            }  catch (IOException e) {
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }
}
