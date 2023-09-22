package pandey.ujjwal.springsecurityclient.utlity;

import jakarta.servlet.http.HttpServletRequest;

public class ReqResRelated {
	public static String getApplicationURl(HttpServletRequest req) {
		return "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + req.getRequestURI();
	}
}
