package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

import java.util.List;

/**
 * Created by Administrator on 2016/12/4.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @RequestMapping("create")
    private String create(User user) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("user.create", user);
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("login")
    private String login(User user) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            user = sqlSession.selectOne("user.login", user);
            if (user != null) {
                user.setPassword(null);
                session.setAttribute("user", user);
                return "redirect:/home.jsp";
            } else {
                request.setAttribute("message", "invalid username or password.");
                return "/index.jsp";
            }
        }
    }

    @RequestMapping("logout")
    private String logout() {
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
