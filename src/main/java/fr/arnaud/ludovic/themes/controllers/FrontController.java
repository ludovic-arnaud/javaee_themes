package fr.arnaud.ludovic.themes.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.arnaud.ludovic.themes.constantes.Constantes;
import fr.arnaud.ludovic.themes.controllers.commande.Commande;
import fr.arnaud.ludovic.themes.controllers.commande.CommandeInconnue;
import fr.arnaud.ludovic.themes.controllers.exceptions.CommandeCreationException;

// TODO: Auto-generated Javadoc
/**
 * La classe FrontController hérite de HttpServlet
 * C'est un contrôleur qui gère toutes les demandes pour un site Web
 * Il distribue les requêtes de façon générique à une hiérarchier de commandes
 * On a alors un seul servlet mais via les Commande plusieurs doGet et doPost (via leur execute)
 */

@WebServlet(name = "/indexServlet", urlPatterns = "/")
public class FrontController extends HttpServlet {
	
	/** Constante de sérialization */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		// this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request,
		// response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Do process.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("NomServlet '" + getServletName() + "'" + " methode " + request.getMethod() + " uri ["
				+ request.getRequestURI() + "]");
		String cmdClass = Constantes.CMDPACKAGE + Constantes.CMD + request.getParameter(Constantes.CMDPARAM);
		System.out.println(cmdClass);

		
		// response.setContentType(HotelConstants.CONTENT_TYPE);
		Commande command = getCommand(request);
		String view = command.execute(request, response);
		System.out.println("view  [" + view + "]");
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.split("redirect:")[1]);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.JSPROOT + view + ".jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Génère dynamiquement les classes de Commande
	 *
	 * @param request the request
	 * @return the command
	 */
	private Commande getCommand(HttpServletRequest request) {
		String action = request.getParameter(Constantes.CMDPARAM);
		Class<?> commandClass = getCommandClass(action);
		try {
			return (Commande) commandClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			throw new CommandeCreationException("Command class '" + commandClass
					+ "' inconnu . Verifiez le parametre de votre request the request parameter", e);
		}
	}

	/**
	 * Génère la loadedClass obtenue après concaténation des paramètres situés dans l'interface Constantes
	 *
	 * @param commandAction the command action
	 * @return the command class
	 */
	private static Class<?> getCommandClass(String commandAction) {
		System.out.println("getcommandclass:" + Constantes.CMDPACKAGE + Constantes.CMD + commandAction);
		Class<?> loadedClass;
		try {
			loadedClass = Class.forName(Constantes.CMDPACKAGE + Constantes.CMD + commandAction);
			System.out.println("loadedClass.getCanonicalName: " + loadedClass.getCanonicalName());
		} catch (ClassNotFoundException e) {
			loadedClass = CommandeInconnue.class;
		}
		return loadedClass;
	}

}
