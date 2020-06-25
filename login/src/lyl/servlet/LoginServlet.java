package lyl.servlet;

import lyl.dao.UserDao;
import lyl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //封装user对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用userDao的login()
        UserDao userDao = new UserDao();
        User userAfter = userDao.login(user);
        //判断user
        if (userAfter == null){
            //fail
            req.getRequestDispatcher("/FailServlet").forward(req, resp);
            System.out.println("登录失败");
        }else {
            //success,save
            req.setAttribute("user", user);
            req.getRequestDispatcher("/SuccessServlet").forward(req, resp);
            System.out.println("登录成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
