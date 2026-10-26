public class Main {

    public static void main(String[] args) {
        BankAccount account = BankAccount.loadAccount();
        if (account == null) {
            System.out.println("Unable to load account.");
            return;
        }
        ATM atm = new ATM(account);
        atm.start();
    }
}