package test;

import java.sql.*;

public class AddproductDAO {
 public int k=0;
 public int add(ProductBean pb)
 {
	 try
	 {
	   Connection con =DBConnection.getCon();
	   PreparedStatement ps=con.prepareStatement("insert into Product52 values(?,?,?,?)");
		ps.setString(1,pb.getCode());
		ps.setString(2,pb.getName()); 
		ps.setFloat(3,pb.getPrice());
		ps.setInt(4,pb.getQty());
		k=ps.executeUpdate(); 
		 
		 
		 
		 
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
	
	
	
}
