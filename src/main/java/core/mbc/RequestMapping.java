package core.mbc;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {
	private static final Logger logger =
			LoggerFactory.getLogger(RequestMapping.class);
	private Map<String, Controller> mappings =
			new HashMap<>();
	void initMappings() {
		mappings.put("/", new HomeController());
		mappings.put("/user/loginForm", 
				new ForwardController("/user/login.jsp"));
		mappings.put("/user/login",
			    new LoginController());
		mappings.put("/user/logout", new LogoutController());
		mappings.put("/user/list", new ListUserController());
		mappings.put("/user/updateForm", new UpdateUserFormController());
		mappings.put("/user/update", 
				new UpdateUserController());
		mappings.put("/user/profile", 
				new ProfileController());
		
		logger.debug("Initialized Request Mapping");
	}
	
	public Controller findController(String url) {
		return mappings.get(url);
	}
	
	public void put(String url, Controller controller) {
		mappings.put(url, controller);
	}

}
