import java.util.*;
public class CreateUser {
	static List<String> user_username = new ArrayList<String>();
	static List<String> user_password = new ArrayList<String>();
    static Map<String,String> user_account = new HashMap<>();
    public static void UserValidation(String username,String password) {
    	
    }
public static String userCreation(String username, String password) {
	if(user_username.contains(username)) {
		return "Username already exists";
	}
	int contain_digit =0;
	int contain_uppercase =0;
	int contain_specialCharacter =0;
	int contain_repeatChar=0;
	String userOutput="";
	if(password.length()>=8) {
		for(int i=0;i<password.length();i++) {
			int Ascii = (int)password.charAt(i);
			if(Ascii>=)
		}
		for(int i=0;i<9;i++) {
			if(password.contains(Integer.toString(i))) {
				contain_digit=1;
				break;
			}
			    
		}
		if(contain_digit ==0)
			userOutput += "\n Password must contain atleast a digit";
		
			for(int i=65;i<91;i++) {
				char ch = (char)i;
				String uppercaseLetter = Character.toString(ch);
				
				if(password.contains(uppercaseLetter)) {
					contain_uppercase =1;
					break;
				}
					
			}
			
			if(contain_uppercase ==0)
			userOutput += "\n Password must contain atleast 1 uppercase letter ";
		
			for(int i=32;i<48;i++) {
				char ch = (char)i;
				String specialCharacter = Character.toString(ch);
				
				if(password.contains(specialCharacter)) {
					contain_specialCharacter =1;
					break;
			}
		}
			for(int i=58;i<65;i++) {
				char ch = (char)i;
				String specialCharacter = Character.toString(ch);
				
				if(password.contains(specialCharacter)) {
					contain_specialCharacter =1;
					break;
			}
		}
			for(int i=91;i<97;i++) {
				char ch = (char)i;
				String specialCharacter = Character.toString(ch);
				
				if(password.contains(specialCharacter)) {
					contain_specialCharacter =1;
					break;
			}
		}	
			for(int i=123;i<127;i++) {
				char ch = (char)i;
				String specialCharacter = Character.toString(ch);
				
				if(password.contains(specialCharacter)) {
					contain_specialCharacter =1;
					break;
			}
		}
			if(contain_specialCharacter ==0)
				userOutput += "\n Password must contain atleast 1 special case ";
			for(int i=0;i<password.length();i++) {
				int count =1;
				for(int j=i+1;j<password.length();j++) {
					if(password.charAt(j) == password.charAt(i))
						count++;
					if(count>3) {
						userOutput +=  "\n A letter should not repeat more than 3 times";
						contain_repeatChar =1;
						break;
					}
						
				}
			}	
		if(contain_digit ==1 && contain_uppercase  ==1 && contain_specialCharacter ==1 && contain_repeatChar==0) {
			
			
			password = passwordEncryptor(password);
			user_username.add(username);
			user_password.add(password);
			user_account.put(username,password);
			System.out.println(password);
			return null;
		}
	  }
	  else {
		  return "Password length must be atleast 8 characters";
	  }
	   
	return userOutput;
}
private static String passwordEncryptor(String password) {
	// TODO Auto-generated method stub
	int max_repition=0;
	int max_ASCII_value =0;
	for(int i=0;i<password.length();i++) {
		int no_of_repetition =1;
		for(int j=i+1;j<password.length();j++) {
			if(password.charAt(i)==password.charAt(j))
				no_of_repetition++;
			
		}
		if(no_of_repetition>max_repition) {
			max_repition = no_of_repetition;
			max_ASCII_value = (int)password.charAt(i); 
		}
			
		else if(no_of_repetition == max_repition) {
			max_ASCII_value = ((int)password.charAt(i)<max_ASCII_value)?(int)password.charAt(i):max_ASCII_value;
		}
		
			
	}
	int checksum = max_ASCII_value - 48;
	char password_array[] = password.toCharArray(); 
	for(int i=0;i<password.length();i++) {
		
		int update_char = password.charAt(i) + (char)checksum;
		password_array[i] = (char)update_char;
		System.out.print(password_array[i]);
	}
	
	return password_array.toString();
}

}
