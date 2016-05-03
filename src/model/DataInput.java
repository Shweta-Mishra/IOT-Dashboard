package model;

public class DataInput {
String month;
String infectname ;

public String getInfectname() {

	return infectname;
}

public void setInfectname(String infectname) {
	System.out.println("info in set"+infectname);
	this.infectname = infectname;
	
	System.out.println("info in set 2"+this.infectname);	}

public String getMonth() {
	System.out.println("here in month");
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

}
