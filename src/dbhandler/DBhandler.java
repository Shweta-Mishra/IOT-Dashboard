package dbhandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.csvreader.CsvWriter;



public class DBhandler {
String month[]=new String[12];
String year[]=new String[12];
	String[] num=new String[12];
	String deno[]=new String [12];
	String [] result=new String[12];
	String [] result1=new String[12];
	DBconnection db=new DBconnection();
	Connection con= (Connection) db.createConnection();
	public void calculateResult(String kpi)
	{
		int i=0;
		String query="select year,month,numerator,denominator from DASHBOARD.KPI where kPIname=? ";
		
		    
		try
		{
			
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1,kpi);
			ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		System.out.println("in result set");
		System.out.println("rs"+rs.getString(3));
		if(rs.getString(1).equals("2015"))
		{
			month[i]=rs.getString(2);
			num[i]=rs.getString(3);
			deno[i]=rs.getString(4);
			result[i]=	String.valueOf(Float.parseFloat(num[i])/Float.parseFloat(deno[i])*100);
		System.out.println("res"+result[i]);
i++;
	}
	}
		
	
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("month");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
		i--;
		System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(month[i]);
			System.out.println("res"+result[i]);
			csvOutput.write(result[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	public ArrayList<String> getCat(String kpi) {
		// TODO Auto-generated method stub
		ArrayList<String> cname = new ArrayList<String>();
		try
		{
			System.out.println("inside handler");
			int i=0; 
			DBconnection db=new DBconnection();
			System.out.println("connection");
			Connection con= db.createConnection();
			PreparedStatement ps = con.prepareStatement("select Subcategory from DASHBOARD.Category where Category=?");
			ps.setString(1,kpi);
			ResultSet rs = ps.executeQuery();
			
			//System.out.println("rs is\n"+rs);
			while(rs.next())
			{
				cname.add(rs.getString("Subcategory"));
			    i++;
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return cname;
	
		
	}
	
	public void calculateResultYear(String kpiname)
	{
		int i=0;
		String query="select year,avg(numerator),avg(denominator) from DASHBOARD.KPI where kPIname=? group by year";
		try
		{
			//System.out.println("");
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1, kpiname);
			ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		//System.out.println("rs"+rs.getString(3));
	
		year[i]=rs.getString(1);
			num[i]=rs.getString(2);
			deno[i]=rs.getString(3);
			result[i]=	String.valueOf(Float.parseFloat(num[i])/Float.parseFloat(deno[i])*100);
		System.out.println("res"+result[i]);
i++;
	
	}
		
	
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("year");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
		i--;
		System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(year[i]);
			System.out.println("res"+result[i]);
			csvOutput.write(result[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	
	public void calculateResultmonthpie(String kpiname)
	{
		
		int i=0;
		String query="select year,month,numerator,denominator from KPI where kPIname=? ";
		float sum=0;
		    
		try
		{
			System.out.println("kpi from pie"+kpiname);
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1, kpiname);
			ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		System.out.println("rs"+rs.getString(3));
		if(rs.getString(1).equals("2015"))
		{
			year[i]=rs.getString(2);
			num[i]=rs.getString(3);
			deno[i]=rs.getString(4);
			result[i]=	String.valueOf(Float.valueOf(num[i])/Float.valueOf(deno[i]));
	sum=sum+Float.valueOf(result[i]);		
	System.out.println("res"+result[i]);
i++;
	}
	}
		System.out.println("i afterr result set"+i);
	i--;
	int j=0;
		while(j<=i)
		{
		
			result1[j]=String.valueOf(Float.valueOf(result[j])/sum*100);
			j++;
		}
		
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users2.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("year");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
		//i--;
		System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(year[i]);
			System.out.println("res"+result1[i]);
			csvOutput.write(result1[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	
	
	public void calculateResultYearPie(String kpiname)
	{
		int i=0;
		float sum=0;
		String query="select year,avg(numerator),avg(denominator) from DASHBOARD.KPI where kPIname=? group by year";
		try
		{
			//System.out.println("");
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1, kpiname);
			ResultSet rs= ps.executeQuery();

			while(rs.next())
	{
				System.out.println("row"+rs.getString(1));		//System.out.println("rs"+rs.getString(3));
	
		year[i]=rs.getString(1);
			num[i]=rs.getString(2);
			deno[i]=rs.getString(3);
			result[i]=	String.valueOf(Float.parseFloat(num[i])/Float.parseFloat(deno[i]));
			sum=sum+Float.valueOf(result[i]);
		
i++;
	
	}
		
	
	i--;
	int j=0;
		while(j<=i)
		{
		
			result1[j]=String.valueOf(Float.valueOf(result[j])/sum*100);
			j++;
		}
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("year");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
	//	i--;
		//System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(year[i]);
			System.out.println("res"+result[i]);
			csvOutput.write(result1[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	

	
	public void calculateResultmonthbubble(String kpi)
	{
		int i=0;
		String query="select year,month,numerator,denominator from DASHBOARD.KPI where kPIname=? ";
		
		    
		try
		{
			
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1,kpi);
			ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		System.out.println("in result set");
		System.out.println("rs"+rs.getString(3));
		if(rs.getString(1).equals("2015"))
		{
			month[i]=rs.getString(2);
			num[i]=rs.getString(3);
			deno[i]=rs.getString(4);
			result[i]=	String.valueOf(Float.parseFloat(num[i])/Float.parseFloat(deno[i])*100);
		System.out.println("res"+result[i]);
i++;
	}
	}
		
	
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("month");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
		i--;
		System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(month[i]);
			System.out.println("res"+result[i]);
			csvOutput.write(result[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}

	
	public void calculateResultYearbubble(String kpiname)
	{
		int i=0;
		String query="select year,avg(numerator),avg(denominator) from DASHBOARD.KPI where kPIname=? group by year";
		try
		{
			//System.out.println("");
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(query);
	ps.setString(1, kpiname);
			ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		//System.out.println("rs"+rs.getString(3));
	
		year[i]=rs.getString(1);
			num[i]=rs.getString(2);
			deno[i]=rs.getString(3);
			result[i]=	String.valueOf(Float.parseFloat(num[i])/Float.parseFloat(deno[i])*100);
		System.out.println("res"+result[i]);
i++;
	
	}
		
	
	String outputFile = "/home/shweta/OOAD/SEfinal/WebContent/users.csv";

	// before we open the file check to see if it already exists
	boolean alreadyExists = new File(outputFile).exists();


	if(alreadyExists)
	{
		new File(outputFile).delete();

	}
		// use FileWriter constructor that specifies open for appending
		CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

		// if the file didn't already exist then we need to write out the header line

		csvOutput.write("year");
		csvOutput.write("result");
		csvOutput.endRecord();

		// else assume that the file already has the correct header line
		i--;
		System.out.println("i="+i);
		// write out a few records
		while(!(i<0))
		{
			System.out.println("here in write");
			csvOutput.write(year[i]);
			System.out.println("res"+result[i]);
			csvOutput.write(result[i]);
			csvOutput.endRecord();
			i--;
		}
		csvOutput.close();
	 

		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}
	

	
}
