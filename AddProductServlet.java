package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/add")

public class AddProductServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	HttpSession hs=req.getSession(false);
	
	if (hs==null)
	{
		pw.println("Session Expired..");
		RequestDispatcher rd =req.getRequestDispatcher("home.html");
		rd.include(req, res);
	}
	else
	{
		AdminBean ab=(AdminBean)hs.getAttribute("ab");
		ProductBean pb =new ProductBean();
		pb.setCode(req.getParameter("code"));
		pb.setName(req.getParameter("code"));
		pb.setPrice(Float.parseFloat(req.getParameter("price")));
		pb.setQty(Integer.parseInt(req.getParameter("qty")));
		
		int k=new AddproductDAO().add(pb);
		pw.println("Page Belongs to"+ab.getfName()+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req,res);
		if(k>0) {
			pw.println("Product added Successfully..");
			}
		
		
		
		
	}
}
}
