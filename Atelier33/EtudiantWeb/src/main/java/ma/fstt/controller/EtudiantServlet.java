package ma.fstt.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.beans.EtudiantTraitementBean;
import ma.fstt.entities.Etudiant;
import ma.fstt.persistence.EtudiantTraitementRemote;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EtudiantServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @EJB(mappedName="java:global/CliEJB/HelloTest!ma.fstt.ejb.HelloTest")
	 */
    
    @EJB(mappedName="java:global/EjbContainerEtd/EtudiantTraitementRemote!ma.fstt.beans.EtudiantTraitementRemote")
    EtudiantTraitementRemote ejb ;
    @EJB(mappedName="java:global/EjbContainerEtd/Etudiant!ma.fstt.entities.Etudiant")
    Etudiant etd ;
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "list":
				list(request, response);
				break;
			
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Etudiant> list = ejb.list();
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Etudiant existingClient = ejb.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
		request.setAttribute("etd", existingClient);
		dispatcher.forward(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String pre = request.getParameter("pre");
		String adr = request.getParameter("adr");
		String cne = request.getParameter("cne");
		String niv = request.getParameter("niv");

		Etudiant newEtd = new Etudiant(nom, pre,cne, adr, niv);
		ejb.save(newEtd);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String pre = request.getParameter("pre");
		String adr = request.getParameter("adr");
		String cne = request.getParameter("cne");
		String niv = request.getParameter("niv");


		Etudiant etd = new Etudiant(id, nom, pre, cne, adr, niv);
		ejb.update(etd);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Etudiant etd = new Etudiant(id);
		ejb.delete(etd);
		response.sendRedirect("list");

	}

}
