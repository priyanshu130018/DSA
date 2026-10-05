import java.util.Scanner;

public class Login {
    public static void login(){
        int Lcount=1;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Enter user name: ");
            String name=sc.next();
            System.out.println("Enter password: ");
            String password=sc.next();

            if("admin".equalsIgnoreCase(name) && "Admin@123".equals(password)){
                System.out.println("Welcome, Login successful");
                return;
            }
            else {
                if(Lcount==3) {
                    System.err.println("Invalid login attempt");
                    System.exit(0);
                }
                else {
                    System.err.println("Invalid "+Lcount);
                    Lcount++;
                }
            }
        }
    }

    public static void main(String[] args) {
        login();
    }
}
