package dbhandler;
import java.sql.*;



public class DBconnection 
{
	public Connection createConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver")	;
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/DASHBOARD", "root","mishra");
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception");
			ex.printStackTrace();
		}
		
		return connection;
	}


}