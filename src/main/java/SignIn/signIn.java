//package SignIn;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
///**
// * Servlet implementation class signIn
// */
//@WebServlet("/signIn")
//public class signIn extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public signIn() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: Pranita").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		String user = request.getParameter("user");
//		String password = request.getParameter("password");
//		
//		try {
//			String url ="jdbc:mysql://localhost:3306";
//			String user1 = "root";
//			String password1 ="#31112921@Pra";
//			
//			Connection conn = DriverManager.getConnection(url, user1, password1);
//			String msg = "Connected Successfully";
//			request.setAttribute("message", msg);
//			// Forward the request to the weather.jsp page for rendering
//	        request.getRequestDispatcher("login1.jsp").forward(request, response);
//			
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			System.out.println(e);
//			
//		}
//	}
//
//}
