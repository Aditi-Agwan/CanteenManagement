import java.util.*;
import java.util.stream.Collectors; 
public class CreateAdmin {
	List<String> admin_username = new ArrayList<String>();
	List<String> admin_password = new ArrayList<String>() ;
	static Scanner scan = new Scanner(System.in);
	static Map<String,String> admin_account = new HashMap<>();
	static List<List<String>> foodItem = new ArrayList<>();
		
	
	//Admin account creation 
    public CreateAdmin(String username , String password) {
    	admin_username.add(username);
    	admin_password.add(password);
    	admin_account.put(username,password);
    	System.out.println("Admin account created");
    	LoginAuth.mainMenu();
    }
    
    
    //Admin Login
    public static void AdminValidation(String username,String password) {
    	if(admin_account.containsKey(username)) {
    		if(admin_account.get(username).equals(password) ) {
    			System.out.println("Admin Login Successful" );
    			adminTasks();
    		}
    		else {
    			
    			System.out.println("Invalid password . Please re-enter" );
    			LoginAuth.mainMenu();
    		}
    		}
    	else {
    		System.out.println("User does not exists.");
    		LoginAuth.mainMenu();
    	}
    		
    }
    
    
    //Admin Panel Menu
	public static void adminTasks() {
		System.out.println("----Welcome to Admin Panel----");		
		System.out.println("1. Add  Food item ");
		System.out.println("2. Delete Food item");
		System.out.println("3. Add money to users account");
		System.out.println("4. View users account");
		System.out.println("5. Logout");
		System.out.println("Select an otpion");
		int option = scan.nextInt();
		switch(option) {
		case 1:
			addFood();
			break;
		case 2:
			deleteFood();
			break;
		case 3:
			userManipulate();
			break;
		case 4:
			CreateUser.showUsers();
			break;
		case 5:
			System.out.println("Admin Logged out");
			LoginAuth.mainMenu();
			break;
		default:
			System.out.println("Please enter a valid option : ");
			adminTasks();
			break;
			
		}
	}
	
	
	//Add food item in the menu
	private static void addFood() {
		for(int i=0;i<foodItem.size();i++)
			System.out.println(foodItem.get(i));
		
		List<String> data = new ArrayList<>();
		
		System.out.println("Enter data to add food item ");
		System.out.println("Enter food name : ");
		data.add(scan.nextLine());
		System.out.println("Enter available count : ");
		data.add(scan.nextLine());
		System.out.println("Enter price per unit : ");
		data.add(scan.nextLine());
		System.out.println("Enter max no of units per user : ");
		data.add(scan.nextLine());
		
		foodItem.add(data);
		
		System.out.println("Do you want to add more food items : [Y/N] ");
		if(scan.nextLine().equals("Y"))
			addFood();
		else {
			adminTasks();
		}
    }
	
	
	//Delete food item from the menu
	private static void deleteFood() {
		
		for(int i=0;i<foodItem.size();i++)
			System.out.println(foodItem.get(i).toString());
		
		System.out.println("Enter name of food item to be deleted : ");
		String food_name = scan.nextLine();
		
		for(int i=0;i<foodItem.size();i++)
			if(foodItem.get(i).get(0).equals(food_name))
				foodItem.remove(i);
		
		System.out.println("Do you want to delete more food items : [Y/N] ");
		if(scan.nextLine().equals("Y"))
			deleteFood();
		else {
			adminTasks();
		}
	}
	
	
	//Add money to users account
	private static void userManipulate() {
		for(String key : CreateUser.user_account.keySet())
			System.out.println(key + " : " + CreateUser.user_account.get(key).toString() );
		
			
		System.out.println("Enter the username for which money is to be added : ");
		String username=scan.nextLine();
		if(CreateUser.user_account.containsKey(username)) {
			System.out.println("Enter the amount to be added : ");
			CreateUser.user_account.get(username).add(scan.nextLine());
			System.out.println("Money added to username \n Do you want to add money to more users : [Y/N] ");
			if(scan.nextLine().equals("Y"))
				userManipulate();
			else {
				adminTasks();
			}
		}
		else {
			System.out.println("Username does not exist \n Do you want to add money to another user : [Y/N] ");
			if(scan.nextLine().equals("Y"))
				userManipulate();
			else {
				adminTasks();
			}
		}
		
	}
}
