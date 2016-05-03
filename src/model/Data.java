package model;

public class Data {

	String  name;
	String Time;
	String chart;
	private String kpi;
	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getTime() {
System.out.println("time"+ Time);
		return Time;
	}

	public void setTime(String time) {
	Time = time;
	System.out.println("set time"+ Time);
	}

	public String getInjuryname() {
		System.out.println("inj"+ name);
		return name;
	}

	public void setInjuryname(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	
}
