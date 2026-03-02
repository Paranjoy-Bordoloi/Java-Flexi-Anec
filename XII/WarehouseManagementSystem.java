import java.util.*;

interface Taxable {
    double CalculateTax();
}

abstract class Item {
    protected String itemId;
    protected String name;
    protected double basePrice;

    public Item(String itemId , String name , double basePrice ){
        this.itemId = itemId;
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getItemId (){return itemId;}
    public String getname(){return name;}
    public double getbasePrice(){return basePrice;}

    public abstract void displayDetails();
}


class PerishableItem extends Item {
    private final String expiryDate;

    public PerishableItem (String itemId , String name , double basePrice , String expiryDate){
        super (itemId, name , basePrice);
        this.expiryDate=expiryDate;
    }
    public double CalculateTax(){
        return basePrice * 0.05;
    }
    @Override
    public void displayDetails() {
        System.out.printf("[Perishable] ID: %-6s | Name: %-12s | Price: $%-8.2f | Expiry: %s%n", 
                          itemId, name, basePrice, expiryDate);
    }
}

class ElectronicItem extends Item{
    private final int Warranty;

    public ElectronicItem(String itemId , String name , double basePrice , int Warranty){
        super (itemId,name,basePrice);
        this.Warranty = Warranty;
    }
    public double CalculateTax(){
        return basePrice*0.15;
    }
    @Override
    public void displayDetails(){
        System.out.printf("[Electronic] ID %-6s | Nae : %-12s | Price : $%-8.2f | Warranty : %s%n",itemId,name,basePrice,Warranty);
    }
}

public class WarehouseManagementSystem {
    private final Map <String , Item>Inventory = new HashMap<>();

    public void addItem (Item item){
        Inventory.put(item.getItemId() , item);
    }

    public void displayInventory (){
        if(Inventory.isEmpty()){
            System.out.println("There are not items in the warehouse.");
        }
        else{
            for (Item item: Inventory.values()){
                item.displayDetails();
            }
        }
    }

    public void searchById(String id){
        Item item = Inventory.get(id);
        if (item!=null){
            System.out.println("Item found.");
            item.displayDetails();
        }
        else{
            System.out.println("Error: Item ID " + id + " not found.");
        }
    }

    public void displaySortedByPrice() {
        List<Item> sortedList = new ArrayList<>(Inventory.values());
        sortedList.sort(Comparator.comparingDouble(Item::getbasePrice));
        
        System.out.println("\n--- Items Sorted by Price (Low to High) ---");
        for (Item item : sortedList) {
            item.displayDetails();
        }
    }
    public double calculateTotalValue() {
        double total = 0;
        for (Item item : Inventory.values()) {
            double tax = 0;
            if (item instanceof Taxable taxable) {
                tax = taxable.CalculateTax();
            }
            total += item.getbasePrice() + tax;
        }
        return total;
    }
    public static void main (String [] args){
        WarehouseManagementSystem warehouse = new WarehouseManagementSystem();
        warehouse.addItem(new PerishableItem("P001" , "Milk" , 2.50 , "2026-3-10"));
        warehouse.addItem(new PerishableItem("P002","Cheese", 7.00 , "2026-4-29"));
        warehouse.addItem(new ElectronicItem("E501", "Headphones", 120.00, 24));
        warehouse.addItem(new PerishableItem("P003", "Yogurt", 1.75, "2026-04-15"));
        warehouse.addItem(new ElectronicItem("E502", "Smartwatch", 250.00, 12));

        System.out.println("------------------------Logistics Tech App------------------------");
        warehouse.displayInventory();

        System.out.println("Searching for item with Id : P001");
        warehouse.searchById("P001");

        warehouse.displaySortedByPrice();
        System.out.println("Total value of the inventory :");
        double totalValue = warehouse.calculateTotalValue();
        System.out.printf("Total Inventory Value (Incl. Tax): $%.2f%n", totalValue);
    }
}