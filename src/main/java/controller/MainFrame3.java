package controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFrame3 extends JFrame {	
	

private static final Logger logger = LogManager.getLogger(MainFrame3.class);	
	//private JFrame frame;
private JPanel jpanel;
private JTextField textfield1;
private JTextField textfield2;
private JTextField textfield3;
private JTextField textfield4;	
private JTextField textfield5;
private JTextField textfield6;
	
	
	
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JLabel label4;
private JLabel label5;
private JLabel label6;
	
private JButton button;
static String[] data=new String[6];

static DataStorage ds=new DataStorage();
	
public MainFrame3()
{	
	//super("Excrcie1");
	logger.info("Application GUI starts");	
	GridBagLayout grid= new GridBagLayout();
	GridBagConstraints gbc= new GridBagConstraints();
	setLayout(grid);
	
	final JTextField textfield1= new JTextField(20);
	final JTextField textfield2= new JTextField(20);
	final JTextField textfield3= new JTextField(20);
	final JTextField textfield4= new JTextField(20);
	final JTextField textfield5= new JTextField(20);
	final JTextField textfield6= new JTextField(20);
	final JTextField textfield7= new JTextField(20);
	
	JLabel label1= new JLabel("TAN");
	JLabel label2= new JLabel("City");
	JLabel label3= new JLabel("PI");
	JLabel label4= new JLabel("RI");
	JLabel label5= new JLabel("NOT");
	JLabel label6= new JLabel("Province");
	JLabel label7= new JLabel("Path");
	
	
	JButton button= new JButton("Submit");
	ButtonGroup group = new ButtonGroup();
	final JRadioButton rb1 = new JRadioButton("manual");
    final JRadioButton rb2 = new JRadioButton("csv file");
    group.add(rb1);
    group.add(rb2);

	
	this.setLayout(grid);
	gbc.fill=GridBagConstraints.HORIZONTAL;
	
	gbc.gridx=0;
	gbc.gridy=0;
	this.add(label1,gbc);

	
	gbc.gridx=1;
	gbc.gridy=0;
	gbc.fill= GridBagConstraints.BOTH;
	this.add(textfield1,gbc);
	
	gbc.gridx=0;
	gbc.gridy=1;
	this.add(label2,gbc);

	
	gbc.gridx=1;
	gbc.gridy=1;
	this.add(textfield2,gbc);
	
	gbc.gridx=0;
	gbc.gridy=2;	
	this.add(label3,gbc);
 
	gbc.gridx=1;
	gbc.gridy=2;
	this.add(textfield3,gbc);
	
	
	gbc.gridx=0;
	gbc.gridy=3;	
	this.add(label4,gbc);

	gbc.gridx=1;
	gbc.gridy=3;
	this.add(textfield4,gbc);
	
	
	
	gbc.gridx=2;
	gbc.gridy=0;
	this.add(label5,gbc);

	gbc.gridx=3;
	gbc.gridy=0;
	this.add(textfield5,gbc);

	gbc.gridx=2;
	gbc.gridy=1;
	this.add(label6,gbc);

	gbc.gridx=3;
	gbc.gridy=1;
	this.add(textfield6,gbc);
	
	gbc.gridx=0;
	gbc.gridy=6;
	this.add(label7,gbc);

	gbc.gridx=1;
	gbc.gridy=6;
	gbc.gridwidth=3;
	this.add(textfield7,gbc);
	
	gbc.anchor=GridBagConstraints.PAGE_END;
	
	gbc.gridx=1;
	gbc.gridy=4;
	this.add(rb1,gbc);
	    
	gbc.gridx=1;
	gbc.gridy=5;
	this.add(rb2,gbc);
	
	gbc.gridx=3;
	gbc.gridy=8;
	this.add(button,gbc);
	
	button.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(rb1.isSelected()){    
				System.out.println("Manual is selected");
				logger.info("manual button is selected");
				String tf1=textfield1.getText();
				String tf2=textfield2.getText();
				String tf3=textfield3.getText();
				String tf4=textfield4.getText();
				String tf5=textfield5.getText();
				String tf6=textfield6.getText();
				
				data= new String[]{tf1,tf5,tf2,tf6.toUpperCase(),tf3,tf4,};//tan, not, city, province, pi, ri
				validatedata(data);		
			}    
			
			if(rb2.isSelected()){   
				logger.info("csv button is selected.");
				System.out.println("CSV is selected");    
				String path=textfield7.getText();
				if(!(path.substring(path.length()-3).toLowerCase().equals("csv")))
				{
					System.out.println("the path of csv file is incorrect. Please eneter the correct path name "+path.substring(path.length()-3));
				}
				
				else if (path==null||path.trim().isEmpty()) 
				{
					System.out.println("the path field is empty!");	
					logger.info("the path field is empty");
				}
				
				else {
					
					System.out.println("the csv file is valid"+path);
					String line = "";  
					String splitBy = ",";  
					int count=0;
					try   
					{  
					//parsing a CSV file into BufferedReader class constructor  
					BufferedReader br = new BufferedReader(new FileReader(path));  
					while ((line = br.readLine()) != null)   //returns a Boolean value  
					{ 
						if(count==0) 
						{
							count++;
							continue;
						}
						
						String[] csvdata = line.split(splitBy);    // use comma as separator 
						count++;
						validatecsvdata(csvdata, count);
					}
					System.out.println("All the rows in csv are read.");
					logger.info("All the csv reows are read");
					}   
					catch (IOException e1)   
					{  
					e1.printStackTrace();  
					System.out.println("could not read the file");
					logger.info("could not read the file");
					}  					
				}
				}    	
		}
	});
	
	
	this.setLocationRelativeTo(null);
	this.setSize(600,400);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setVisible(true);	
	}
//manual data validation method	
public void validatedata(String[] data) {
	
	ErrorValidator errval= new ErrorValidator(data);
	System.out.println("Validating the data entered");
	
	if (errval.validatetan()&& errval.validatecity() && errval.validatepi() && errval.validateri() &&errval.validatenot() && errval.validateprovince()) {
		System.out.println("Data entered is correct and is being added to records.");
		ds.storedata(data);//adds data to hashtable
		System.out.println("The data manualy entered is:");
		System.out.println(Arrays.toString(data));
		logger.info("data entered in manual mode is correct and is added to the records.");
	}
	else {
		
		System.out.println("Data entered is incorrect. Please read the instructions and try again");
		logger.info("data entered in manual mode is incorrect");
		//instructions
	}
}	

//csv data validation method	
public void validatecsvdata(String[] data, int count) {
	
	ErrorValidator errval= new ErrorValidator(data);
		if (errval.validatetan()&& errval.validatecity() && errval.validatepi() && errval.validateri() &&errval.validatenot() && errval.validateprovince()) {
		System.out.println("Data at row="+count+" is being added to records.");
		ds.storedata(data);	
		logger.info("data eneterd through csv file is valid and has been added to the records");
	}
	else {
		
		System.out.println("Data at row="+count+" is invalid and is discarded");
		logger.info("data of row "+count+" is invalid and discarded");
		//instructions
	}	
}


}


