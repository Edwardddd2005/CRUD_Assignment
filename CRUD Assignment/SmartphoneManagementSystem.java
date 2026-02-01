import java.util.Scanner;

class Smartphone {
    protected String brand;
    protected String model;
    protected int storage;

    public Smartphone(String brand, String model, int storage) {
        this.brand = brand;
        this.model = model;
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Brand   : " + brand);
        System.out.println("Model   : " + model);
        System.out.println("Storage : " + storage + " GB");
    }
}

class AndroidPhone extends Smartphone {
    public AndroidPhone(String brand, String model, int storage) {
        super(brand, model, storage);
    }

    @Override
    public void displayInfo() {
        System.out.println("\nType    : Android");
        super.displayInfo();
    }
}

class IPhone extends Smartphone {
    public IPhone(String brand, String model, int storage) {
        super(brand, model, storage);
    }

    @Override
    public void displayInfo() {
        System.out.println("\nType    : iPhone");
        super.displayInfo();
    }
}

public class SmartphoneManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Smartphone[] phones = new Smartphone[10];
        int count = 0;
        int choice;

        do {
            System.out.println("\nSMARTPHONE MANAGEMENT SYSTEM");
            System.out.println("1. Add Smartphone");
            System.out.println("2. View Smartphones");
            System.out.println("3. Update Smartphone");
            System.out.println("4. Delete Smartphone");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    if (count == phones.length) {
                        System.out.println("Storage is full.");
                        break;
                    }

                    System.out.print("Enter type (1-Android, 2-iPhone): ");
                    int type = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter brand: ");
                    String brand = input.nextLine();

                    System.out.print("Enter model: ");
                    String model = input.nextLine();

                    System.out.print("Enter storage (GB): ");
                    int storage = input.nextInt();
                    input.nextLine();

                    if (type == 1) {
                        phones[count] = new AndroidPhone(brand, model, storage);
                    } else if (type == 2) {
                        phones[count] = new IPhone(brand, model, storage);
                    } else {
                        System.out.println("Invalid type.");
                        break;
                    }

                    count++;
                    System.out.println("Smartphone added successfully.");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No smartphones available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("\nIndex: " + i);
                            phones[i].displayInfo();
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No smartphones to update.");
                        break;
                    }

                    System.out.print("Enter index to update: ");
                    int updateIndex = input.nextInt();
                    input.nextLine();

                    if (updateIndex < 0 || updateIndex >= count) {
                        System.out.println("Invalid index.");
                        break;
                    }

                    System.out.print("New brand: ");
                    phones[updateIndex].brand = input.nextLine();

                    System.out.print("New model: ");
                    phones[updateIndex].model = input.nextLine();

                    System.out.print("New storage (GB): ");
                    phones[updateIndex].storage = input.nextInt();
                    input.nextLine();

                    System.out.println("Smartphone updated successfully.");
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No smartphones to delete.");
                        break;
                    }

                    System.out.print("Enter index to delete: ");
                    int deleteIndex = input.nextInt();
                    input.nextLine();

                    if (deleteIndex < 0 || deleteIndex >= count) {
                        System.out.println("Invalid index.");
                        break;
                    }

                    for (int i = deleteIndex; i < count - 1; i++) {
                        phones[i] = phones[i + 1];
                    }

                    phones[count - 1] = null;
                    count--;

                    System.out.println("Smartphone deleted successfully.");
                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}
