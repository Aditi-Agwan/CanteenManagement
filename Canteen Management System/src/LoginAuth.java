import java.util.*;
public class LoginAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		String username,password;
		
			System.out.println("1. Admin Login");
	        System.out.println("2. User Login");
	        System.out.println("3. Admin Creation");
	        System.out.println("4. User Creation");
	        System.out.println("Select an option : ");
	        int option = Integer.parseInt(scan.nextLine());
	        switch(option) {
	        case 1 :
	        	System.out.println("Admin Username : ");
	            username = scan.nextLine();
	            System.out.println("Admin Password : ");
	            password = scan.nextLine();
	        	CreateAdmin.AdminValidation(username,password);
	        	break;
	        case 2:
	        	System.out.println("Username : ");
	            username = scan.nextLine();
	            System.out.println("Password : ");
	            password = scan.nextLine();
	            CreateUser.UserValidation(username,password);
	            break;
	        case 3 : 
	        	//Admin account creation 
	            System.out.println("Admin Username : ");
	            username = scan.nextLine();
	            System.out.println("Admin Password : ");
	            password = scan.nextLine();
	            new CreateAdmin(username,password);
	            break;
	        case 4 :
	        	//User account creation
	            System.out.println("Username : ");
	            username = scan.nextLine();
	            System.out.println("Password : ");
	            password = scan.nextLine();
	            String output = CreateUser.userCreation(username , password);
	            if(output!=null) {
	            	System.out.println("The password did not match the requirements : ");
	            	System.out.println(output);
	            }
	            else
	            	System.out.println("User Account created");
	            break;
	            default : 
	            	break;
	            
	        }
			
		
		
        scan.close();
        
        
	}

}
