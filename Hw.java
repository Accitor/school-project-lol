import java.util.*;

class User{
	private String username;
	private String password;
	
	public User(String a, String b) {
		this.username = a;
		this.password = b;	
	}
	
	public String getName() {
		return this.username;
	}
	
	public String getPass() {
		return this.password;
	}
	
	public void changePass(String str){
		this.password = str;
	}
	
	public void changeUser(String str){
		this.username = str;
	}
}

public class Hw {
	static Scanner input = new Scanner(System.in);
	static String[] usernames = new String[100];
    static User[] userArray = new User[100];
	public static void main(String[] args) {
		User user1 = new User("Sahar", "Lando");
	    User user2 = new User("Shon", "Lapkes");
	    userArray[0] = user1;
	    userArray[1] = user2;
	    getNameArray();
		chooseUser(userArray);
	}
	
	public static void chooseUser(User[] ar) {
		int choose = menuPrint(usernames);
		enterPassword(userArray[choose - 1]);
	}
	
	public static void enterPassword(User passwo) {
		System.out.println("Enter password: ");
        String passw = input.next().trim();
        while(!passw.equals(passwo.getPass())) {
            System.out.println("Wrong password. Try again.");
            passw = input.next();
        }
        if(passw.equals(passwo.getPass())) {
            System.out.println("Entered user successfully!\n");
            mainMenu(passwo);
        }
	}
	
	public static void mainMenu(User userio) {
		int choose;
		choose = menuPrint(new String[] {"Show Username", "Show Password", "Change Username", "Change Password"});
		
	}
	
	public static void getNameArray() {
		for(int i = 0; i < usernames.length; i++) {
			if(userArray[i] == null) {
				break;
			}
			usernames[i] = userArray[i].getName();
		}
	}
	
    public static int menuPrint(String[] arr){
        int choose;
        int quitIndex=arr.length;
        for(int i = 0; i < arr.length; i++){
        	if(arr[i] == null) {
        		quitIndex = i;
        		break;
        	}
            System.out.println((i + 1) + ")" + arr[i]);
        }
        while(true){
            try {
            	choose = input.nextInt();
                if(choose <= quitIndex && choose > 0)
                    break;
                else
                    System.out.println("No such choice. Try again.");
            }
            catch(Exception e) {
            	System.out.println("Invalid choice.");
            	input.next();

            }
        }
        return choose;
    }
}




