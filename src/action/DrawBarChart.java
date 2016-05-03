package action;

//import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.*;

//import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;

import model.*;
public class DrawBarChart implements ModelDriven<Data>{
	int i=0;
	String []year=new String[12];	
	String []month=new String[12];
	String []result=new String[12];
	String []expo=new String[12];
	String []inpatient=new String[12];
	Data injury=new Data();

	//near miss year
	public void nearmissyear()
	{


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/nearmissesyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("number of blood body fluid exposure");
				inpatient[i]=input.get("number of in-patient days");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}





	}

	//near miss month
	public void nearmissmonth()
	{			
		//	s=input.getMonth();


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/nearmissesmonth.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				month[i]=input.get("Month");
				expo[i]=input.get("number of blood body fluid exposure");
				inpatient[i]=input.get("number of in-patient days");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//csv write
		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	//needle injury year
	public void needleinjuryyear()
	{


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/needleinjuryyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("number of parenteral exposure");
				inpatient[i]=input.get("number of in-patient days");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}





	}
	//needle injury month

	public void needleinjurymonth()
	{			
		//	s=input.getMonth();


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/needleinjurymonth.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				month[i]=input.get("Month");
				expo[i]=input.get("number of parenteral exposure");
				inpatient[i]=input.get("number of in-patient days");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//csv write
		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//patient in satisfaction year
	public void patientinyear()
	{


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/patient-in-year.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("score_achieved");
				inpatient[i]=input.get("maximum_possible_score");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}





	}

	public void patientinmonth()
	{			
		//	s=input.getMonth();


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/patient-in-month.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				month[i]=input.get("Month");
				expo[i]=input.get("score_achieved");
				inpatient[i]=input.get("maximum_possible_score");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//csv write
		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//patient out satisfaction

	public void patientoutyear()
	{


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/patient-out-year.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("score_achieved");
				inpatient[i]=input.get("maximum_possible_score");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void patientoutmonth()
	{


		try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/patient-out-year.csv");

			input.readHeaders();

			while (input.readRecord())
			{
				//String month = input.get("Month");
				//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("score_achieved");
				inpatient[i]=input.get("maximum_possible_score");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

				//	System.out.println("infect"+parenteral_expo[i]);
				//System.out.println("infection "+input.get("Infection"));
				i++;
			}

			// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		// sankar code
		
		

		public void unplanned()
		{


			try {


				CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/17kpi-yearly.csv");

				input.readHeaders();

				while (input.readRecord())
				{
					//String month = input.get("Month");
					//System.out.println("month"+month);

					year[i]=input.get("year");
					expo[i]=input.get("number unplanned return to OT");
					inpatient[i]=input.get("Number of patients operated");
					result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

					//	System.out.println("infect"+parenteral_expo[i]);
					//System.out.println("infection "+input.get("Infection"));
					i++;
				}

				// perform program logic here



				input.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}



			String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
			public void reschedulemonth()
			{


				try {


					CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/18kpi-monthly.csv");

					input.readHeaders();

					while (input.readRecord())
					{
						//String month = input.get("Month");
						//System.out.println("month"+month);

						month[i]=input.get("month");
						expo[i]=input.get("number of cases resheduled");
						inpatient[i]=input.get("Number of Surgeries performed");
						result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

						//	System.out.println("infect"+parenteral_expo[i]);
						//System.out.println("infection "+input.get("Infection"));
						i++;
					}

					// perform program logic here



					input.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}



				String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

				public void rescheduleyear()
				{


					try {


						CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/18kpi-yearly.csv");

						input.readHeaders();

						while (input.readRecord())
						{
							//String month = input.get("Month");
							//System.out.println("month"+month);

							year[i]=input.get("year");
							expo[i]=input.get("number of cases resheduled");
							inpatient[i]=input.get("Number of Surgeries performed");
							result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

							//	System.out.println("infect"+parenteral_expo[i]);
							//System.out.println("infection "+input.get("Infection"));
							i++;
						}

						// perform program logic here



						input.close();

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}



					String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				public void preventyear()
					{


						try {


							CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/19kpi-yearly.csv");

							input.readHeaders();

							while (input.readRecord())
							{
								//String month = input.get("Month");
								//System.out.println("month"+month);

								year[i]=input.get("year");
								expo[i]=input.get("no. of cases org. procedure followed");
								inpatient[i]=input.get("Number of surgeries performed");
								result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

								//	System.out.println("infect"+parenteral_expo[i]);
								//System.out.println("infection "+input.get("Infection"));
								i++;
							}

							// perform program logic here



							input.close();

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}



						String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

						public void preventmonth()
						{


							try {


								CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/19kpi-monthly.csv");

								input.readHeaders();

								while (input.readRecord())
								{
									//String month = input.get("Month");
									//System.out.println("month"+month);

									month[i]=input.get("month");
									expo[i]=input.get("no. of cases org. procedure followed");
									inpatient[i]=input.get("Number of surgeries performed");
									result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

									//	System.out.println("infect"+parenteral_expo[i]);
									//System.out.println("infection "+input.get("Infection"));
									i++;
								}

								// perform program logic here



								input.close();

							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}



							String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
							} catch (IOException e) {
								e.printStackTrace();
							}

						}

							public void receivedmonth()
							{


								try {


									CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/20kpi-monthly.csv");

									input.readHeaders();

									while (input.readRecord())
									{
										//String month = input.get("Month");
										//System.out.println("month"+month);

										month[i]=input.get("month");
										expo[i]=input.get("No. of patients received prophylactic antibiotics");
										inpatient[i]=input.get("Number of surgeries performed");
										result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

										//	System.out.println("infect"+parenteral_expo[i]);
										//System.out.println("infection "+input.get("Infection"));
										i++;
									}

									// perform program logic here



									input.close();

								} catch (FileNotFoundException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}



								String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
								} catch (IOException e) {
									e.printStackTrace();
								}
							}


								public void receivedyear()
								{


									try {


										CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/20kpi-yearly.csv");

										input.readHeaders();

										while (input.readRecord())
										{
											//String month = input.get("Month");
											//System.out.println("month"+month);

											year[i]=input.get("year");
											expo[i]=input.get("No. of patients received prophylactic antibiotics");
											inpatient[i]=input.get("Number of surgeries performed");
											result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

											//	System.out.println("infect"+parenteral_expo[i]);
											//System.out.println("infection "+input.get("Infection"));
											i++;
										}

										// perform program logic here



										input.close();

									} catch (FileNotFoundException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}



									String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
									} catch (IOException e) {
										e.printStackTrace();
									}

								}



									public void returnmonth()
									{


										try {


											CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/17kpi-monthly.csv");

											input.readHeaders();

											while (input.readRecord())
											{
												//String month = input.get("Month");
												//System.out.println("month"+month);

												month[i]=input.get("month");
												expo[i]=input.get("number of cases resheduled");
												inpatient[i]=input.get("Number of Surgeries performed");
												result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
												i++;
											}

											// perform program logic here



											input.close();

										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										}



										String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
										} catch (IOException e) {
											e.printStackTrace();
										}

				


	}

						//shweta
									public void OTUtilizationmonth()
									{


										try {


											CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/otmonth.csv");

											input.readHeaders();

											while (input.readRecord())
											{
												//String month = input.get("Month");
												//System.out.println("month"+month);

												month[i]=input.get("month");
												expo[i]=input.get("ot utilization");
												inpatient[i]=input.get("resource hours");
												result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
												i++;
											}

											// perform program logic here



											input.close();

										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										}



										String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
										} catch (IOException e) {
											e.printStackTrace();
										}





									}



public void OTUtilizationyear()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/otyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("ot utilization");
				inpatient[i]=input.get("resource hours");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}





}
									
									
public void icuUtilizationyear()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/icuyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("number of euipment utilized days");
				inpatient[i]=input.get("equipment days available");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}





}

public void icuUtilizationmonth()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/icumonth.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				month[i]=input.get("month");
				expo[i]=input.get("number of euipment utilized days");
				inpatient[i]=input.get("equipment days available");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}

}


public void bedUtilizationyear()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/bedyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("number of bed utilized days");
				inpatient[i]=input.get("bed days available");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}





}


public void bedUtilizationmonth()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/bedmonth.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				month[i]=input.get("month");
				expo[i]=input.get("number of bed utilized days");
				inpatient[i]=input.get("bed days available");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}

}

public void drugsyear()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/drugsyear.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				year[i]=input.get("year");
				expo[i]=input.get("Total quantity rejected");
				inpatient[i]=input.get("Total quantity received before GRN");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}





}


public void drugsmonth()
{


	try {


			CsvReader input = new CsvReader("/home/disha/Documents/SEfinal/src/action/drugsmonth.csv");

			input.readHeaders();

			while (input.readRecord())
			{
												//String month = input.get("Month");
												//System.out.println("month"+month);

				month[i]=input.get("month");
				expo[i]=input.get("Total quantity rejected");
				inpatient[i]=input.get("Total quantity received before GRN");
				result[i]=	String.valueOf(Float.parseFloat(expo[i])/Float.parseFloat(inpatient[i])*100);

												//	System.out.println("infect"+parenteral_expo[i]);
												//System.out.println("infection "+input.get("Infection"));
				i++;
			}

											// perform program logic here



			input.close();

		} catch (FileNotFoundException e) {
									e.printStackTrace();
					} catch (IOException e) {
											e.printStackTrace();
										}



		String outputFile = "/home/disha/Documents/SEfinal/WebContent/users.csv";

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
				} catch (IOException e) {
											e.printStackTrace();
										}

}


	@Override
	public Data getModel() {
		// TODO Auto-generated methSod stub
		return injury;
	}
}

