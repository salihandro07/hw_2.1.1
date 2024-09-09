public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(15000);

        System.out.println("Текущий остаток: " + account.getAmount());

        while (true) {
            try {
                System.out.println("Попытка снять 6000 сом...");
                account.withDraw(6000);
                System.out.println("Снято успешно. Остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Недостаточно средств для снятия 6000 сом. Остаток: " + e.getRemainingAmount());
                System.out.println("Снятие оставшейся суммы: " + e.getRemainingAmount());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println("Ошибка: " + ex.getMessage());
                }
                System.out.println("Остаток после снятия: " + account.getAmount());
                break;
            }
        }
    }
}
