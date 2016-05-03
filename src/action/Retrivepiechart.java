package action;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.*;



import com.opensymphony.xwork2.ModelDriven;

import model.*;
public class Retrivepiechart implements ModelDriven<DataInput>{
	int i=0;
	String s;
	String []infectname=new String[12];
	String []patient_infected=new String[12];


		DataInput input=new DataInput();
		public String execute()
		{
		
	
		
		s=input.getMonth();
	
		
		
try {
			

	CsvReader input = new CsvReader("/home/disha/workspace/SE/SE/src/action/month.csv");
		
			input.readHeaders();

while (input.readRecord())
			{
				String month = input.get("month");
				System.out.println("month"+month);
				if(month.equals(s))
				{
					infectname[i]=input.get("Infection");
					patient_infected[i]=input.get("Patient_infected");
					
					System.out.println("infect"+infectname[i]);
					System.out.println("infection "+input.get("Infection"));
					i++;
				}
			
				// perform program logic here
			}
	

			input.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
String outputFile = "/home/disha/workspace/SE/SE/WebContent/users.csv";

// before we open the file check to see if it already exists
boolean alreadyExists = new File(outputFile).exists();
	

if(alreadyExists)
{
	new File(outputFile).delete();

}
try {
	// use FileWriter constructor that specifies open for appending
	CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
	
	// if the file didn't already exist then we need to write out the header line

		csvOutput.write("Infection");
		csvOutput.write("Patient_infected");
		csvOutput.endRecord();
	
	// else assume that the file already has the correct header line
	i--;
	System.out.println("i="+i);
	// write out a few records
	while(!(i<0))
	{
		System.out.println("here in write");
	csvOutput.write(infectname[i]);
	csvOutput.write(patient_infected[i]);
	csvOutput.endRecord();
i--;
	}
	csvOutput.close();
} catch (IOException e) {
	e.printStackTrace();
}


		
			return "success";
		}


		@Override
		public DataInput getModel() {
			// TODO Auto-generated methSod stub
			return input;
		}
	}
