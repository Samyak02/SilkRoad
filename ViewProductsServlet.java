package test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")




public class ViewProductsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,

	HttpServletResponse res)throws ServletException,

	IOException
	{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  HttpSession hs=req.getSession(false);
	  if(hs==null)
	  {
		  pw.println("Session Expired..<br>");
		  RequestDispatcher rd =req.getRequestDispatcher("home.html");
          rd.include(req, res);
	  }
		
	  else
	  {
		  AdminBean ab =(AdminBean)hs.getAttribute("ab");
		  pw.println("Page Belongs to "+ab.getfName()+"<br>");
		  ArrayList<ProductBean> al=new ViewProductsDAO().retrieve();
		  hs.setAttribute("al", al);
		  if(al.size()==0)
		  {
			  pw.println("No Product Available..<br>");
		  }
		  else
		  {
			  al.forEach((k)->
			  {
				ProductBean pb=(ProductBean)k;  
				 pw.println(pb.getCode()+"&nbsp&nbsp&nbsp"
				+pb.getName()+"&nbsp&nbsp&nbsp" 
				+pb.getPrice()+"&nbsp&nbsp&nbsp"   
				+pb.getQty()+"&nbsp&nbsp&nbsp"  
				+"<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"
				+"&nbsp&nbsp&nbsp" 
				+"<a href='delete?pcode="+pb.getCode()+"'>Delete</a><br>");
			  }); 
				
			  pw.println("<a href ='link1.html'>Back</a>"
			  +"&nbsp&nbsp&nbsp" 
			  +"<a href ='logout'>Logout</a>");
				  
			  }
		  }
	  }
		
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

