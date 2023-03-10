package converter;
import java.sql.*;
import java.util.*;
class A{
	public static void main(String[] args)throws Exception {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahesh","root","root");
		PreparedStatement pt=c.prepareStatement("null");
		Statement st=c.createStatement();
		String q="select*from sur3";
		ResultSet s= st.executeQuery(q);
		ResultSetMetaData rs=s.getMetaData();
		System.out.println("table is cre");
		while(s.next()) {
			String a,b;
			a=s.getString("id");
			b=s.getString("name");
			System.out.println(a+" "+b);
		}
		
	}
}