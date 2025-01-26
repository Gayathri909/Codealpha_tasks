import java.util.Scanner;
public class BankingApplication {
    private double balance=0.0;
    private String accHolder;
    public BankingApplication(String accHolder){
        this.accHolder=accHolder;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance+=amount;
            System.out.println("Successfully deposited Rupees:"+amount);
        }
        else
        System.out.println("Inavalid deposit amount");
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance-=amount;
            System.out.println("Successfully withdraw of Rupees:"+amount);
        }
            else if(amount > balance)
            System.out.println("Insufficient Balance.\nyour balance is "+balance);
            else
            System.out.println("Invalid withdraw amount");
    }
    public void checkBalance(){
        System.out.println("Current Balance:"+balance);
    } 
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Account Holder's Name:");
        String accHolder=s.nextLine();
        BankingApplication account = new BankingApplication(accHolder);
        boolean exit =false;
        while( !exit){
            System.out.println("\n----Banking Menu----");
            System.out.println("1.Deposit");
            System.out.println("2.withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.println("Choose an option:");
            int choice=s.nextInt();
            switch(choice){
                case 1:System.out.println("Enter amount to deposit:");
                        double depositAmount=s.nextDouble();
                        account.deposit(depositAmount);
                        break;
                case 2:System.out.println("Enter amount to withdraw:");
                        double withdrawAmount=s.nextDouble();
                        account.withdraw(withdrawAmount);
                         break;
                case 3: account.checkBalance();
                         break;
                case 4: System.out.println("Thankyou for using the Banking Application!");
                        exit=true;
                        break;
                default:
                System.out.println("Invalid choice. Please try again.");        
            }
        }
        s.close();
    }
}
