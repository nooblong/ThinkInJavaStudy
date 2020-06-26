package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //先判断验证码
        HttpSession session = request.getSession();
        String checkCodeSession = (String)session.getAttribute("checkCodeSession");
        //一拿到就删除
        session.removeAttribute("checkCodeSession");
        if (checkCodeSession != null && checkCodeSession.equalsIgnoreCase(checkCode)){
            //一致
            if ("zhangsan".equals(username) && "123".equals(password)){
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            //不一致
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
