package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandeInitUpdateTheme implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");
		String themeName = request.getParameter("themeName");
		String themeDesc = request.getParameter("themeDesc");
		String themeDetail = request.getParameter("themeDetail");
		String themeColor = request.getParameter("themeColor");
		
		if (themeName == null)
			themeName = "";
		if (themeDesc == null)
			themeDesc = "";
		if (themeDetail == null)
			themeDetail = "";
		if (themeColor == null)
			themeColor = "#FFFFFF";
		
		HttpSession session = request.getSession(true);
		session.setAttribute("themeId", themeId);
		session.setAttribute("themeName", themeName);
		session.setAttribute("themeDesc", themeDesc);
		session.setAttribute("themeDetail", themeDetail);
		session.setAttribute("themeColor", themeColor);
		
		return "updateTheme";
	}

}
