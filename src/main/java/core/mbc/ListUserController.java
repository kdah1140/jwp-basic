package core.mbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;

public class ListUserController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(!UserSessionUtils.isLogined(req.getSession())) {
    		return "redirect:/user/loginForm";	
    	}
        req.setAttribute("users", DataBase.findAll());
        return "/user/list.jsp";
	}
}