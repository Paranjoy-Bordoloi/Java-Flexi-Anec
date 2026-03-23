package XIV;
abstract class LibraryItem {
    private final String itemId;
    private final String title;
    protected boolean isReserved = false;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    public void showDetails() {
        System.out.println("The ID of the item is: " + this.itemId);
        System.out.println("The title of the item is: " + this.title);
        if (this.isReserved) {
            System.out.println("Status: Reserved.");
        } else {
            System.out.println("Status: Available.");
        }
    }

    public String getTitle() {
        return this.title;
    }

    public abstract void processLoan();
}

class TextBook extends LibraryItem {
    public TextBook(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        if (this.isReserved) {
            System.out.println("The book '" + getTitle() + "' is already reserved.");
        } else {
            this.isReserved = true;
            System.out.println("The book hardcopy has been issued for 14 days.");
        }
    }
}

class ResearchPaper extends LibraryItem {
    public ResearchPaper(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        System.out.println("Generating secure PDF download link for: " + this.getTitle());
    }
}

public class LibD {
    public static void main(String[] args) {
        System.out.println("--- Library Digital Management System ---");
        
        System.out.println("\nTesting Textbook:");
        TextBook t1 = new TextBook("B1", "Dominos");
        t1.showDetails();
        t1.processLoan(); 

        System.out.println("Trying to reserve book b1 again (Should show already reserved) :");
        t1.processLoan(); 

        System.out.println("\nTesting Research Paper:");
        ResearchPaper r1 = new ResearchPaper("R1", "Exploring The Universe");
        r1.processLoan();
        r1.showDetails();
    }
}