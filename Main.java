import java.util.Scanner;

interface Document {
    void open();
}

class Report implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Отчёт. Содержит аналитические данные и графики.");
    }
}

class Resume implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Резюме. Содержит информацию о кандидате и опыте работы.");
    }
}

class Letter implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Письмо. Содержит текст сообщения.");
    }
}

abstract class DocumentCreator {
    public abstract Document createDocument();
}

class ReportCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Report();
    }
}

class ResumeCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Resume();
    }
}

class LetterCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Letter();
    }
}

class Invoice implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Счёт. Содержит информацию о сумме к оплате и реквизитах.");
    }
}

class InvoiceCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Invoice();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Система создания документов ===");
            System.out.println("Выберите тип документа:");
            System.out.println("1. Отчёт (Report)");
            System.out.println("2. Резюме (Resume)");
            System.out.println("3. Письмо (Letter)");
            System.out.println("4. Счёт (Invoice) — новый тип");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine();
            DocumentCreator creator = null;

            switch (choice) {
                case "1":
                    creator = new ReportCreator();
                    break;
                case "2":
                    creator = new ResumeCreator();
                    break;
                case "3":
                    creator = new LetterCreator();
                    break;
                case "4":
                    creator = new InvoiceCreator();
                    break;
                case "5":
                    exit = true;
                    System.out.println("Выход из программы.");
                    continue;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 5.");
                    continue;
            }

            Document document = creator.createDocument();
            document.open();
        }

        scanner.close();
    }
}