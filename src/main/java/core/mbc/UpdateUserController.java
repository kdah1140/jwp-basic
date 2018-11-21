package core.mbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import next.model.User;

public class UpdateUserController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userId = req.getParameter("userId");
		User user = DataBase.findUserById(userId);
		if(UserSessionUtils.isSameUser(req.getSession(), user)) {
			throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
		}
		
		User updateUser = new User(req.getParameter("userId"),
				req.getParameter("password"),
				req.getParameter("name"),
				req.getParameter("email"));
		
		DataBase.addUser(updateUser);
		return "Redirect:/";
	}
}
