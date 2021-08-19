package phonebook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phonebook.dao.PhoneBookDao;
import phonebook.dao.PhoneBookDaoImpl;
import phonebook.vo.PhoneBookVo;

@WebServlet("/pb")
public class PhoneBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String actionName = req.getParameter("a");

		if ("index".equals(actionName)) {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/phonebook/index.jsp");
			
			rd.forward(req, resp);
		} else {
		
			PhoneBookDao dao = new PhoneBookDaoImpl();
			List<PhoneBookVo> list = dao.getList();

			
			req.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/phonebook/form.jsp");
			
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		
		if ("add".equals(actionName)) {	
			String Name = req.getParameter("name");
			String PhoneNum = req.getParameter("phonenum");
			String Tel = req.getParameter("tel");
			
			
			PhoneBookVo vo = new PhoneBookVo();
			vo.setName(Name);
			vo.setPhoneNum(PhoneNum);
			vo.setTel(Tel);
			
			
			PhoneBookDao dao = new PhoneBookDaoImpl();
			int insertedCount = dao.insert(vo);
			
			
			resp.sendRedirect(req.getContextPath() + "/pb");
		} else if ("delete".equals(actionName)) {
			
			Long no = Long.valueOf(req.getParameter("no"));
			
			PhoneBookDao dao = new PhoneBookDaoImpl();
			int deletedCount = dao.delete(no);
			
			
			resp.sendRedirect(req.getContextPath() + "/pb");
		} else {
			doGet(req, resp);
		}
	}

}
