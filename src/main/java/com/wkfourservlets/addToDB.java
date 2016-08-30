package com.wkfourservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekfourproject.BasketballOfficial;
import com.weekfourproject.DAO;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasketballOfficial addOfficialToDB = new BasketballOfficial();
		
		addOfficialToDB.setLastName(request.getParameter("last_name"));
		addOfficialToDB.setFirstName(request.getParameter("first_name"));
		addOfficialToDB.setPhoneNumber(request.getParameter("phone_number"));
		addOfficialToDB.setDepartureLocation(request.getParameter("depart_loc"));
		
		DAO.writeToDB(addOfficialToDB);
		
		
		
		
	}//post

}//ends class
