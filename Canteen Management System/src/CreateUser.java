import java.util.*;
public class CreateUser {
	static List<String> user_username = new ArrayList<String>();
	static List<String> user_password = new ArrayList<String>();
	static Map<String, ArrayList<String>> user_account = new HashMap<String, ArrayList<String>>();
    public static void UserValidation(String username,String password) {
    	
    }
public static String userCreation(String username, String password) {
	if(user_username.contains(username)) {
		return "Username already exists";
	}
	//Password Checker according to condition
	int contain_digit =0;
	int contain_uppercase =0;
	int contain_specialCharacter =0;
	int contain_repeatChar=0;
	String userOutput="";
	if(password.length()>=8) {
		for(int i=0;i<password.length();i++) {
			int Ascii = (int)password.charAt(i);
			if(Ascii>=65 && Ascii<=90)
				contain_uppercase =1;
			if(Ascii>=48 && Ascii<=57)
				contain_digit =1;
			if((Ascii>=32 && Ascii<=47) || (Ascii>=58 && Ascii<=64) || (Ascii>=91 && Ascii<=96) || (Ascii>=123 &&Ascii<=126))
				contain_specialCharacter =1;
			
			int count =1;
			for(int j=i+1;j<password.length();j++) {
				if(password.charAt(j) == password.charAt(i))
					count++;
				if(count>3) {
					userOutput +=  "\n A letter "+ password.charAt(i) + " should not repeat more than 3 times";
					contain_repeatChar =1;
					break;
				}
					
			}

		}
		
			
		if(contain_digit ==1 && contain_uppercase  ==1 && contain_specialCharacter ==1 && contain_repeatChar==0) {
			
			password = passwordEncryptor(password);
			user_username.add(username);
			user_password.add(password);
			user_account.put(username, new ArrayList<String>());
			user_account.get(username).add(password);
			
		}
		else {
			if(contain_digit ==0)
				userOutput+= "Password must contain atleast 1 digit";
			if(contain_uppercase  ==0)
				userOutput+= "Password must contain atleast 1 uppercase letter";
			if(contain_specialCharacter ==0)
				userOutput+= "Password must contain atleast 1 special case character";
		}
	  }
	  else {
		  userOutput+= "Password length must be atleast 8 characters";
	  }
	   
	return userOutput;
}
private static String passwordEncryptor(String password) {
	
	int max_repition=0;
	int max_ASCII_value =0;
	//Calculate max ascii value
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
	//update checksum 
	int checksum = max_ASCII_value - 48;
	
	//store new encrypted password
	String new_password = "";
	for(int i=0;i<password.length();i++) {
		int Ascii =(int)password.charAt(i);
		int update_value=0;
		if((Ascii>=32 && Ascii<=47) || (Ascii>=58 && Ascii<=64) || (Ascii>=91 && Ascii<=96) || (Ascii>=123 &&Ascii<=126))
			new_password+=password.charAt(i);
		else if(Ascii>=65 && Ascii<=90) {
			int dup = checksum;
			 
            if (Ascii+dup > 90) {
               dup -= (90 - Ascii);
               dup = dup % 26;
                 
               new_password += (char)(64 + dup);
            } else {
                new_password += (char)(Ascii + dup);
            }
         
		}
		else if(Ascii>=97 && Ascii<=122) {
			int dup = checksum;
			 
            if (Ascii+dup > 122) {
               dup -= (122 - Ascii);
               dup = dup % 26;
                 
               new_password += (char)(96 + dup);
            } else {
                new_password += (char)(Ascii + dup);
            }
         
		}
		else if(Ascii>=48 && Ascii<=57) {
			int dup = checksum;
			 
            if (Ascii+dup > 57) {
               dup -= (57 - Ascii);
               dup = dup % 10;
                 
               new_password += (char)(47 + dup);
            } else {
                new_password += (char)(Ascii + dup);
            }
         
		}
		
	}
	
	return new_password;
}
public static void showUsers() {
	for(String key : user_account.keySet())
		System.out.println(key + " : " + user_account.get(key) );
	CreateAdmin.adminTasks();
}


}
