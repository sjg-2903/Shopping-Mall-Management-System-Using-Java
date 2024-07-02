import java.util.*;


class Shop {
    private String name;
    private List<ItemCategory> itemCategories;

    public Shop(String name) {
        this.name = name;
        this.itemCategories = new ArrayList<>();
    }

    public void addItemCategory(ItemCategory itemCategory) {
        itemCategories.add(itemCategory);
    }

    public List<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public String getName() {
        return name;
    }
}

// Item category class representing categories of items in a shop
class ItemCategory {
    private String name;
    private List<Item> items;

    public ItemCategory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}

// Item class representing individual items with their brands and prices
class Item {
    private String name;
    private List<Brand> brands;

    public Item(String name) {
        this.name = name;
        this.brands = new ArrayList<>();
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public String getName() {
        return name;
    }
}

// Brand class representing brands for each item
class Brand {
    private String name;
    private double price;

    public Brand(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Rs." + price;
    }
}

// Shopping mall management system
public class ShoppingMallSystem {
    private List<Shop> shops;
    private double totalBill;
    private Stack<String> navigationStack; // Stack to keep track of navigation

    public ShoppingMallSystem() {
        this.shops = new ArrayList<>();
        this.navigationStack = new Stack<>();
        setupShops();
    }

    private void setupShops() {
        // Create shops
        Shop clothesShop = new Shop("Reliance Trends");
        Shop perfumesShop = new Shop("Perfume Hub");
        Shop foodShop = new Shop("Food Plaza");
        Shop electronicsShop = new Shop("Croma Electronics");
        Shop coffeeShop = new Shop("Starbucks Coffee");

        // Add item categories to each shop
        ItemCategory clothesCategory = new ItemCategory("Clothes");
        Item shirt = new Item("Shirt");
        shirt.addBrand(new Brand("Polo", 500.0));
        shirt.addBrand(new Brand("Snitch", 300.0));
        shirt.addBrand(new Brand("AllenSolly", 800.0));
        clothesCategory.addItem(shirt);
        
        Item pant = new Item("Pants");
        pant.addBrand(new Brand("Calvin Klien", 500.0));
        pant.addBrand(new Brand("Pepe Jeans", 300.0));
        pant.addBrand(new Brand("Wrangler", 800.0));
        clothesCategory.addItem(pant);
        
        Item tshirt = new Item("TShirts");
        tshirt.addBrand(new Brand("Calvin Klien-RoundNeck", 1000.0));
        tshirt.addBrand(new Brand("Souledstore-Oversized", 700.0));
        tshirt.addBrand(new Brand("Polo-Net", 600.0));
        clothesCategory.addItem(tshirt);
        
        Item jeans = new Item("Jeans");
        jeans.addBrand(new Brand("Tommy-Hilfliger", 1000.0));
        jeans.addBrand(new Brand("Gini&Jonny", 700.0));
        jeans.addBrand(new Brand("Denim-Factory", 500.0));
        clothesCategory.addItem(jeans);
        clothesShop.addItemCategory(clothesCategory);

        ItemCategory perfumesCategory = new ItemCategory("Perfumes");
        
        Item perfume = new Item("Men-Perfumes");
        perfume.addBrand(new Brand("Fogg", 150.0));
        perfume.addBrand(new Brand("Park-Avenue", 250.0));
        perfume.addBrand(new Brand("WildStone", 200.0));
        perfumesCategory.addItem(perfume);
        
        Item ladyperfume = new Item("Ladies-Perfumes");
        ladyperfume.addBrand(new Brand("Wottagirl", 150.0));
        ladyperfume.addBrand(new Brand("Axe", 250.0));
        ladyperfume.addBrand(new Brand("Envy", 300.0));
        perfumesCategory.addItem(ladyperfume);
        perfumesShop.addItemCategory(perfumesCategory);

        ItemCategory foodCategory = new ItemCategory("Food");
        Item snacks = new Item("Snacks");
        snacks.addBrand(new Brand("Pizza", 300.0));
        snacks.addBrand(new Brand("Burger", 250.0));
        snacks.addBrand(new Brand("Sandwich", 150.0));
        foodCategory.addItem(snacks);
        
        Item fastfood = new Item("Fast-Food");
        fastfood.addBrand(new Brand("Dosa", 200.0));
        fastfood.addBrand(new Brand("Pav-Bhaji", 150.0));
        fastfood.addBrand(new Brand("Pasta", 170.0));
        foodCategory.addItem(fastfood);
        
        Item colddrink = new Item("Cold-Drinks");
        colddrink.addBrand(new Brand("Cola", 200.0));
        colddrink.addBrand(new Brand("Sprite", 150.0));
        colddrink.addBrand(new Brand("Fanta", 170.0));
        foodCategory.addItem(colddrink);
        foodShop.addItemCategory(foodCategory);

        ItemCategory electronicsCategory = new ItemCategory("Electronics");
        Item laptop = new Item("Laptop");
        laptop.addBrand(new Brand("Dell", 40000.0));
        laptop.addBrand(new Brand("HP", 50000.0));
        
        Item tv = new Item("TV");
        tv.addBrand(new Brand("Samsung", 40000.0));
        tv.addBrand(new Brand("Sony", 50000.0));
        
        Item ac = new Item("AC");
        ac.addBrand(new Brand("Mitsubishi", 60000.0));
        ac.addBrand(new Brand("Onida", 40000.0));
        electronicsCategory.addItem(ac);
        
        Item fridge = new Item("Fridge");
        fridge.addBrand(new Brand("WhirlPool", 70000.0));
        fridge.addBrand(new Brand("Samsung", 50000.0));
        electronicsCategory.addItem(fridge);
        
        Item mobile = new Item("Mobile");
        mobile.addBrand(new Brand("Redmi", 20000.0));
        mobile.addBrand(new Brand("Iphone", 70000.0));
        mobile.addBrand(new Brand("Samsung", 40000.0));
        electronicsCategory.addItem(mobile);
        electronicsShop.addItemCategory(electronicsCategory);

        ItemCategory coffeeCategory = new ItemCategory("Coffee");
        Item coffee = new Item("Coffee");
        coffee.addBrand(new Brand("Espresso", 200.0));
        coffee.addBrand(new Brand("Latte", 350.0));
        coffee.addBrand(new Brand("Mocha", 400.0));
        coffee.addBrand(new Brand("Frappe", 320.0));
        coffeeCategory.addItem(coffee);
        coffeeShop.addItemCategory(coffeeCategory);

        // Add shops to the list
        shops.add(clothesShop);
        shops.add(perfumesShop);
        shops.add(foodShop);
        shops.add(electronicsShop);
        shops.add(coffeeShop);
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Shopping Mall!");
            System.out.println("Select the shop where you want to do shopping:");
            System.out.println("1. Reliance Trends");
            System.out.println("2. Perfume Hub");
            System.out.println("3. Food Plaza");
            System.out.println("4. Croma Electronics");
            System.out.println("5. Starbucks Coffee");
            System.out.println("6. Display Total Bill");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    navigationStack.push("Reliance Trends");
                    buyItems("Reliance Trends");
                    break;
                case 2:
                    navigationStack.push("Perfume Hub");
                    buyItems("Perfume Hub");
                    break;
                case 3:
                    navigationStack.push("Food Plaza");
                    buyItems("Food Plaza");
                    break;
                case 4:
                    navigationStack.push("Croma Electronics");
                    buyItems("Croma Electronics");
                    break;
                case 5:
                    navigationStack.push("Starbucks Coffee");
                    buyItems("Starbucks Coffee");
                    break;
                case 6:
                    displayTotalBill();
                    break;
                case 7:
                    System.out.println("Thank you for using the Shopping Mall System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }
    }

    private void buyItems(String shopName) {
        Scanner scanner = new Scanner(System.in);

        for (Shop shop : shops) {
            if (shop.getName().equalsIgnoreCase(shopName)) {
                double shopBill = 0.0; // Track bill for the current shop

                // Display items directly
                for (ItemCategory category : shop.getItemCategories()) {
                    System.out.println("\nSelect an item from " + category.getName() + ":");
                    List<Item> items = category.getItems();
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i).getName());
                    }
                    System.out.println("0. Back to Shops");

                    int itemChoice = scanner.nextInt();
                    if (itemChoice == 0) {
                        navigationStack.pop(); // Back to shop menu
                        return;
                    } else if (itemChoice < 1 || itemChoice > items.size()) {
                        System.out.println("Invalid item choice.");
                        continue;
                    }

                    Item selectedItem = items.get(itemChoice - 1);
                    List<Brand> brands = selectedItem.getBrands();

                    while (true) {
                        System.out.println("\nSelect a brand for " + selectedItem.getName() + ":");
                        for (int j = 0; j < brands.size(); j++) {
                            System.out.println((j + 1) + ". " + brands.get(j));
                        }
                        System.out.println("0. Back to Items");
                        System.out.println("-1. Back to Shops");

                        int brandChoice = scanner.nextInt();
                        if (brandChoice == 0) {
                            // Back to item selection
                            break;
                        } else if (brandChoice == -1) {
                            // Move to main menu
                            navigationStack.pop();
                            return;
                        } else if (brandChoice < 1 || brandChoice > brands.size()) {
                            System.out.println("Invalid brand choice.");
                            continue;
                        }

                        Brand selectedBrand = brands.get(brandChoice - 1);
                        shopBill += selectedBrand.getPrice();
                        totalBill += selectedBrand.getPrice(); // Accumulate total bill
                        System.out.println("\nYou have selected: " + selectedItem.getName() + " - " + selectedBrand);
                        System.out.println("Total bill for " + shop.getName() + " so far: Rs." + shopBill);
                    }
                }
            }
        }

        System.out.println("Shop not found.");
    }

    private void displayTotalBill() {
        System.out.println("\nTotal bill across all shops: Rs." + totalBill);
    }

    public static void main(String[] args) {
        ShoppingMallSystem mallSystem = new ShoppingMallSystem();
        mallSystem.displayMenu();
    }
}