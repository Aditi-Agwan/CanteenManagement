import java.util.*; 
public class CreateAdmin {
	List<String> admin_username = new ArrayList<String>();
	List<String> admin_password = new ArrayList<String>() ;
	static Scanner scan = new Scanner(System.in);
	static List<List<String>> foodItem = new ArrayList<>();
	
	static Map<String,String> admin_account = new HashMap<>();
    public CreateAdmin(String username , String password) {
    	admin_username.add(username);
    	admin_password.add(password);
    	admin_account.put(username,password);
    	System.out.println("Admin account created");
    }
    public static void AdminValidation(String username,String password) {
    	if(admin_account.containsKey(username)) {
    		if(admin_account.get(username).equals(password) ) {
    			System.out.println("Admin Login Successful" );
    			adminTasks();
    		}
    		else {
    			System.out.println(admin_account.get(username) + " " + password);
    			System.out.println("Invalid password" );
    		}
    		}
    	else {
    		System.out.println("User does not exists");
    	}
    		
    }
	private static void adminTasks() {
		// TODO Auto-generated method stub
		
		System.out.println("1. Add  Food item ");
		System.out.println("2. Delete Food item");
		System.out.println("3. Add money to users account");
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
		default:
			break;
			
		}
	}
	private static void userManipulate() {
		// TODO Auto-generated method stub
		
	}
	private static void addFood() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<foodItem.size();i++)
			System.out.println(foodItem.get(i));
		System.out.println("Enter data to add food item ");
		System.out.println("Enter food name : ");
		String item = scan.nextLine();
		System.out.println("Enter available count : ");
		String item_count = scan.nextLine();
		System.out.println("Enter price per unit : ");
		String item_price = scan.nextLine();
		System.out.println("Enter max no of units per user : ");
		String max_units_per_user = scan.nextLine();
		
		List<String> data = new ArrayList<>();
		data.add(item);
		data.add(item_count);
		data.add(item_price);
		data.add(max_units_per_user);
		foodItem.add(data);
		System.out.println("Do you want to add more food items : [Y/N] ");
		if(scan.nextLine().equals("Y"))
			addFood();
		else {
			adminTasks();
		}
			
		
		
		
	}
	private static void deleteFood() {
		// TODO Auto-generated method stub
		for(int i=0;i<foodItem.size();i++)
			System.out.println(foodItem.get(i));
		System.out.println("Enter name of to deleted : ");
		String food_name = scan.nextLine();
		for(int i=0;i<foodItem.size();i++)
			if(foodItem.get(i).equals(food_name))
				foodItem.remove(i);
		System.out.println("Do you want to delete more food items : [Y/N] ");
		if(scan.nextLine().equals("Y"))
			deleteFood();
		else {
			adminTasks();
		}
	}
}
