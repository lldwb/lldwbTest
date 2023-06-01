package top.lldwb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @Date(时间)2023-06-01
 * @Author 家辉
 */
@WebServlet("/user")
public class DemoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtils.toBean(req, User.class);
        System.out.println(user);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(user));
    }
}
