package ormap;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orbean.StudentBean;

/**
 * Servlet implementation class Student
 */
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Student() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao dao = new StudentDao();

		StudentBean bean = new StudentBean("kumar", 5, 25);

		//		for (int i = 1; i <= 100; i++) {
		//			dao.addRecord(bean);
		//		}

		//dao.deleteRecord(106);

		//		bean.setId(105);

		//		dao.updateRecord(bean);

		List < StudentBean > collection = dao.getCollections();

		Iterator<?> iter = collection.iterator();

		while (iter.hasNext()) {
			System.out.println(((StudentBean) iter.next()).getId());
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
