import java.util.Scanner;

class ATM {
    private BankAccount Account;
    private int Pin;

    public ATM(BankAccount Account, int Pin) {
        this.Account = Account;
        this.Pin = Pin;
    }

    public void menu() {
        System.out.println("ATM MACHINE SCREEN");
        System.out.println(" 1. CHECK BALANCE\n 2. DEPOSIT CASH\n 3. WITHDRAWL CASH\n 4. EXIT");
    }

    public boolean verifyPin(int Entered_Pin) {
        return this.Pin == Entered_Pin;
    }

    public void Bank_Process() {
        Scanner sc = new Scanner(System.in);
        int Entered_Pin;

        System.out.print("ENTER YOUR PIN : ");
        Entered_Pin = sc.nextInt();
        if (verifyPin(Entered_Pin)) {
            int Option = 0;
            while (Option != 4) {
                menu();
                System.out.print("ENTER YOUR CHOICE : ");
                Option = sc.nextInt();

                switch (Option) {
                    case 1:
                        System.out.println("THE REMAINING BALANCE IS " + Account.getBalance()+ " RUPEES");
                        break;
                    case 2:
                        System.out.print("ENTER THE AMOUNT YOU WANT TO DEPOSIT : ");
                        double Amt_Deposit = sc.nextDouble();
                        Account.deposit_balance(Amt_Deposit);
                        break;
                    case 3:
                        System.out.print("ENTER THE AMOUNT YOU WANT TO WITHDRAWL : ");
                        double amount_withdraw = sc.nextDouble();
                        Account.withdraw_bal(amount_withdraw);
                        break;
                    case 4:
                        System.out.println("THANK YOU FOR USING THE ATM !");
                        break;
                    default:
                        System.out.println("YOUR CHOICE IS INVALID , PLEASE SELECT VALID OPTION ");
                }
            }
        } else {
            System.out.println("INCORRECT PIN");
        }

        sc.close();
    }
}

class BankAccount {
    private double Balance;

    public BankAccount(double initial_Balance) {
        this.Balance = initial_Balance;
    }

    public double getBalance() {
        return Balance;
    }

    public void deposit_balance(double Amount) {
        if (Amount > 0) {
            Balance += Amount;
            System.out.println("THE AMOUNT " + Amount + " IS DEPOSITED SUCCESSFULLY");
        } else {
            System.out.println("YOU CANNOT DEPOSIT AMOUNT LESS THAN 0.");
        }
    }

    public void withdraw_bal(double Amount) {
        if (Amount > 0 && Amount <= Balance) {
            Balance -= Amount;
            System.out.println(" THE AMOUNT " + Amount + " RUPEES IS WITHDRAWL SUCCESSFULLY");
        } else {
            System.out.println("INSUFFICIENT BALANCE TO WITHDRAWL.");
        }
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        BankAccount User_Account = new BankAccount(2000);
        int Correct_Pin = 2023;
        ATM atm = new ATM(User_Account, Correct_Pin);
        atm.Bank_Process();
    }
}
