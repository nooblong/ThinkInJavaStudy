package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("not first");
        boolean flag = false;

        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>welcome back last time is " + value + "</h1>");


                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    cookie.setMaxAge(60*60*24*30);
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies == null){
            System.out.println("first");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = simpleDateFormat.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);
            cookie.setValue(str_date);
            response.addCookie(cookie);
            response.getWriter().write("<h1>首次访问,现在是 </h1>" + URLDecoder.decode(str_date, "utf-8"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
