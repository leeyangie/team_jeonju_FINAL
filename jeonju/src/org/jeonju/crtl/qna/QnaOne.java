package org.jeonju.crtl.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeonju.dao.QnaDAO;
import org.jeonju.dto.Qna;

/**
 * Servlet implementation class QOne
 */
@WebServlet("/qna_one")
public class QnaOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		QnaDAO qd = new QnaDAO();
		Qna qna = qd.getQnaOne(no,true);
		request.setAttribute("qna", qna);
		
		RequestDispatcher view = request.getRequestDispatcher("/qna/qnaOne.jsp");
		view.forward(request, response);
	}

}
