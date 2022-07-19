import java.util.*;
public class LoginAuth {
	public static void mainMenu() {
		Scanner scan = new Scanner(System.in); 
		String username,password;
		
			System.out.println("1. Admin account creation");
	        System.out.println("2. User account creation ");
	        System.out.println("3. Admin login ");
	        System.out.println("4. User login ");
	        System.out.println("5. Exit");
	        System.out.println("Select an option : ");
	        int option = Integer.parseInt(scan.nextLine());
	        switch(option) {
	        case 1 :
	        	//Admin account creation 
	            System.out.println("Admin Username : ");
	            username = scan.nextLine();
	            System.out.println("Admin Password : ");
	            password = scan.nextLine();
	            new CreateAdmin(username,password);
	        	break;
	        case 2:
	            //User account creation
	        	if(CreateAdmin.admin_account.isEmpty()) {
	        		System.out.println("Create an admin account first");
	        		mainMenu();
	        		
	        	}
	        	else {
	        		System.out.println("Username : ");
		            username = scan.nextLine();
		            System.out.println("Password : ");
		            password = scan.nextLine();
		            String output = CreateUser.userCreation(username , password);
		            if(output != "") {
		            	System.out.println(output);
		            	mainMenu();
		            }
		            else {
		            	System.out.println("User account created ");
		            	mainMenu();
		            }		           	
	        	}
	            
	            break;
	        case 3 : 
	        	//Admin Login
	        	System.out.println("Admin Username : ");
	            username = scan.nextLine();
	            System.out.println("Admin Password : ");
	            password = scan.nextLine();
	        	CreateAdmin.AdminValidation(username,password);
	            break;
	        case 4 :
	        	//User Login
	        	 System.out.println("Username : ");
		         username = scan.nextLine();
		         System.out.println("Password : ");
		         password = scan.nextLine();
		         CreateUser.UserValidation(username,password);
		         break;
	        case 5:
	        	System.exit(0);
	            default : 
	            	System.out.println("Enter a valid option");
	            	mainMenu();
	            	break;
	            
	        }
		scan.close();
	}

	public static void main(String[] args) {
		LoginAuth.mainMenu();
	}
}
