package test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductsServlet extends HttpServlet {
	@SuppressWarnings("Unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
			
	{PrintWriter pw = res.getWriter();
			res.setContentType("text/html");

			HttpSession hs = req.getSession(false);
			if(hs==null) 
			{
				pw.println("Session Expired...<br>");
				RequestDispatcher rd =req.getRequestDispatcher("home.html"); 
				rd.include(req, res);
			
			}else 
			{
				String code = req.getParameter("pcode");
				ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("al");
				al.forEach((k)->
				{
					if(code.equals(k.getCode()))
					{
						pw.println("<form action ='update'method ='post'>");
						pw.println("<input type='hidden'name='pcode' value="+code+">");
						pw.println("ProdPrice:<input type='text'name='pprice' value="+k.getPrice()+"><br>");
						pw.println("ProdQty:<input type='text'name='pqty' value="+k.getQty()+"><br>");
						pw.println("<input type='submit'value='UpdateProduct'>");
						pw.println("</form>");					
				    }
			
				});
			}	
	}
}
