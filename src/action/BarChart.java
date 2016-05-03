package action;

import java.util.ArrayList;

import model.Data;

import com.opensymphony.xwork2.ModelDriven;

import dbhandler.DBhandler;

public class BarChart implements ModelDriven<Data> {

	Data data=new Data();
	DrawBarChart dp=new DrawBarChart();
	public ArrayList<String> cname=new ArrayList<String>();

	public String showDropDown()
	{

		DBhandler retrieve = new DBhandler();
		System.out.println("inside BarChartAction class show DropDown");
		cname=retrieve.getCat(data.getKpi());
		return "drop";

	}

	public String execute()
	{
		DBhandler db =new DBhandler();

		System.out.println("in exec method");
		System.out.println("inside the execute method of barchart");
		if(data.getChart().equals("bar"))
		{
			if(data.getTime().equals("month"))
			{

				System.out.println("here");
				db.calculateResult(data.getName());
				System.out.println("from action class Bar Chart"+data.getName());
				return "success";
			}


			else 
			{
				db.calculateResultYear(data.getName());

				return "success1";
			}
		}
		else if (data.getChart().equals("pie"))
		{


			if(data.getTime().equals("month"))
			{

				db.calculateResultmonthpie(data.getName());
				System.out.println("from action class"+data.getName());
				return "success2";
			}


			else 
			{
				db.calculateResultYearPie(data.getName());

				return "success3";
			}

		}
		
		
		else if (data.getChart().equals("bubble"))
		{


			if(data.getTime().equals("month"))
			{

				db.calculateResultmonthbubble(data.getName());
				System.out.println("from action class"+data.getName());
				return "success4";
			}


			else 
			{
				db.calculateResultYearbubble(data.getName());

				return "success5";
			}

		}

		
		
		return "fail";



		}




		@Override
		public Data getModel() {
			// TODO Auto-generated method stub
			return data;
		}
	}
