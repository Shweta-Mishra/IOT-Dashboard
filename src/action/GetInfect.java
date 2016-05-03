package action;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;

import model.*;
public class GetInfect implements ModelDriven<DataInput> ,RequestAware{
String s;
		   private Map<String,Object> request;

		 
	public Map<String, Object> getRequest() {
			return request;
		}

	DataInput input=new DataInput();
	public String execute()
	{
	
	System.out.println("infectname"+input.getInfectname());	
	
	s=input.getInfectname();
	request.put("infectname", s);	
		return "success";
	}

	@Override
	public DataInput getModel() {
		// TODO Auto-generated method stub
		return input;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
