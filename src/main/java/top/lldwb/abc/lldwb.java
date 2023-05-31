package top.lldwb.abc;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
@WebServlet("/lldwb")
public class lldwb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = req.getSession();
        //将数据存储到session中
        session.setAttribute("user", "12345");
    }
}
