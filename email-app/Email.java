package Emailapp;
import java.util.Scanner;
public class Email {
private String firstName;
private String lastName;
private String password;
private String department;
private int mailboxCapacity=500;
private int defaultPasswordLength=10;
private String email;
private String companySuffix="company.com";
private String alternateEmail;

	public Email(String firstName,String lastName) {
	this.firstName=firstName;
	this.lastName=lastName;
	//System.out.println("Email created:"+this.firstName+" "+this.lastName);
	
	this.department=setDepartment();
	//System.out.println("Department : "+this.department);
	
	this.password=randomPassword(defaultPasswordLength);
	System.out.println("your password is : "+ this.password);
	
	email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	//System.out.println("your email is : "+email);
	}
	
	private String setDepartment() {
		System.out.println("enter department\n 1 : sales\n 2 : development\n 3 : accounting\n 0 : none");
		Scanner scr=new Scanner(System.in);
		int choice=scr.nextInt();
		if(choice==1) {return "sales";}
		else if(choice==2) {return "dev";}
		else if(choice==3) {return "acct";}
		else {return"" ;}
	}
	
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789:@*$";		
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int) (Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
		
	}
	
	public void setMailboxCapacity(int capacity) {
	this.mailboxCapacity=capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	
	public void changePassword(String password) {
		this.password=password;
	}
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "NAME : "+firstName+" "+lastName+
				"\nCOMPANY MAIL : "+email+
		        "\nMAILBOX CAPACITY : " + mailboxCapacity + "mb";
	}
	
}
