package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 AdminBean ab=new AdminLoginDAO().login(req);
	 
	 if(ab==null)
	 {
		 pw.println("Invalid Logging Process.<br>");
		 RequestDispatcher rd = req.getRequestDispatcher("home.html");
		 rd.include(req, res);
		 
	 }
	 else
	 {
	   HttpSession hs=req.getSession();//Session Created
	   hs.setAttribute("ab",ab);
	   pw.println("Welcome Admin:"+ab.getfName()+"<br>");
	   RequestDispatcher rd= req.getRequestDispatcher("link1.html");
	   rd.include(req, res);
		 
		 
		 
		 
	 }
 }
 
}
