package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 防盗链接案例
 * 对应项目依赖模块：
 * 1.day03_referer
 * 2.day03/web/login
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String referer = req.getHeader("referer");
        System.out.println(referer);
        if(referer.contains(("/day03"))){
            //System.out.println("可以看电影..!!");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("可以看电影..!!");
        }else{
            //System.out.println("不能看电影....");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("不能看电影....");
        }
        /**
         * 注意：直接从浏览器地址栏访问referer = null
         */
    }
}
