/*
11/10/2022
C3327794
Jake whamond
*/
import java.util.*;
import java.io.*;
public class Interface
{
    //defines arrays
    static Depot[] depots = new Depot[4];
    static boolean [] checkDepot = new boolean [4];
    static boolean [] checkProduct = new boolean [5];
    static Scanner console = new Scanner(System.in);
    static int depotCount = 0;

    private void run() throws IOException{

        //depot arrays are made
        for(int i = 0; i < 4; i++)
            depots[i] = new Depot();

        int choice;
        //loops until the user inputs 10
        do{
            System.out.print(("\nMenu\n1  Add Depot\n2  Remove Depot\n3  Add Product\n4  Remove Products\n5  Depot List\n6")+
                ("Product List\n7  Product Search\n8  Cumulative Value\n9 Export\n10. Exit\n11 "));
            choice = console.nextInt();
            switch(choice){

                case 1: setDepot();
                break;

                case 2: removeDepot();
                break;

                case 3: setProduct();
                break;

                case 4: removeProduct();
                break;

                case 5: queryDepot();
                break;  

                case 6: queryProduct();
                break;

                case 7: productSearch();
                break;

                case 8: cumulativeValue();
                break;

                case 9: export();
                break;

                case 10: System.out.print("Program ended\n");
                break;

            }
        }while(choice!=10);
    }

    // method creates a depot and checks for max depot
    public static void setDepot()
    {
        String input;       
        if (depotCount < 4) {
            System.out.print("Depot name = ");
            input = console.next();
            for (int i = 0; i < 4; i++){
                checkDepot[i] = input.equalsIgnoreCase(depots[i].getDepotName());
                if (checkDepot[i] == true){
                    System.out.print("Depot already exists");
                    return;
                }
            }
            depots[depotCount].setDepotName(input);
            System.out.print("Depot made");
            depotCount++;

        }
        else {
            System.out.print("Max depots made");
        }
    }

    //deletes depot
    public static void removeDepot()
    {
        String input;
        System.out.print(" Which depot should be deleted?");
        input = console.next();
        for (int i = 0;i < 4;i++){
            checkDepot[i] = depots[i].getDepotName().equalsIgnoreCase(input);
            if (checkDepot[i] == true){
                depots[i] = new Depot();
                --depotCount;
                System.out.print("Depot deleted");
                return;
            }
        }
        System.out.print(" named depot cannot be found ");
    }

    // add products and checks for max products
    public static void setProduct() 
    {
        String productName;
        String input;
        int productQuantity;
        double productPrice;
        double productWeight; 
        System.out.print("Put product in which depot ");
        input = console.next();
        for (int i = 0;i < 4;i++){
            checkDepot[i] = depots[i].getDepotName().equalsIgnoreCase(input);
            if (checkDepot[i] == true){
                System.out.print("Product name: ");
                productName = console.next();
                for (int count = 0;count < 5;count++){
                    checkProduct[count] = productName.equalsIgnoreCase(depots[i].products[count].getProductName());
                    if (checkProduct[count] == true){
                        System.out.print("Product"+depots[i].products[count].getProductName()+" exisits in "+depots[i].getDepotName()+
                            "Updating Quantity");
                        do{
                            System.out.print("Product quantity: ");
                            productQuantity = console.nextInt();
                        } while(productQuantity <= 0);
                        depots[i].addProductData(count, depots[i].products[count].getProductName(), depots[i].products[count].getProductPrice(), 
                        depots[i].products[count].getProductWeight(), productQuantity);
                        return;
                    }
                }
        
                for (int count = 0;count < 5;count++){
                    if (depots[i].products[count].getProductName() == ""){ 
                        do{
                            System.out.print("Product price: ");
                            productPrice = console.nextDouble();
                        }  while (productPrice <= 0);
                        do{
                            System.out.print("Product weight: ");
                            productWeight = console.nextDouble();
                        }   while (productWeight <= 0);
                        do{
                            System.out.print("Product quantity: ");
                            productQuantity = console.nextInt();
                        } while(productQuantity <= 0);
                        depots[i].addProductData(count, productName, productPrice, productWeight, productQuantity);
                        return;
                    }
                }
                System.out.print("Max products in Depot");
                return;
            }
        }
        System.out.print("No Depot With That Name");
        return;
    }
    // removes products from a depot 
    public static void removeProduct()
    {
        String input;
        int amount,total;
        System.out.print("Which depot to remove product from?");
        input = console.next();

        for (int i = 0;i < 4;i++){
            checkDepot[i] = depots[i].getDepotName().equalsIgnoreCase(input);
            if (checkDepot[i] == true){
                System.out.print("Product name ");
                input = console.next();
                for (int count = 0; count < 5; count++){
                    checkProduct[i] = input.equalsIgnoreCase(depots[i].products[count].getProductName());
                    if (checkProduct[i] == true){
                        do{
                            do{
                                System.out.print("Amount To remove: ");
                                amount = console.nextInt();
                                if (amount > depots[i].products[count].getProductQuantity()){
                                    System.out.print("Amount Entered Is Greater Than quantiy in depot");
                                    System.out.print("Try Again");
                                }
                                if (amount < 0){
                                    System.out.print("Enter Amount more than 0");
                                    System.out.print("Try Again");
                                }
                            }  while (amount > depots[i].products[count].getProductQuantity());
                        }while (amount < 0);
                        total = depots[i].products[count].getProductQuantity()-amount;
                        depots[i].addQuantity(i,total);
                        System.out.print(amount+" quantity of Product "+depots[i].products[count].getProductName()
                            +" removed from "+depots[i].getDepotName());
                        if (depots[i].products[count].getProductQuantity() == 0) {
                            System.out.print(depots[i].products[count].getProductName()+" quantity has been reduced to 0, and has"+
                                " been removed");
                            depots[i].newProduct(count);
                        }
                        return;
                    }
                }
                System.out.print("No products name in Depot");
                return;
            }
        }
        System.out.print("No Depots Name");
        return;
    }

    //prints depots and products 
    public static void queryDepot()
    {
        int productCount = 0;
        for(int i = 0; i < 4; i++)
        {
            if (depots[i].getDepotName() != ""){
                productCount = 0;
                for(int count = 0; count < 5; count++){
                    if (depots[i].products[count].getProductName() != ""){
                        productCount++;
                    }
                }
                System.out.print(depots[i].getDepotName()+" has "+productCount+" products");
            }
        }
        if (depotCount == 0){
            System.out.print("No Depots");
        }
    }

    //prints products information 
    public static void queryProduct()
    {
        int productCount;
        for(int i = 0; i < 4; i++)
        {
            productCount = 0;
            depotCount = 0;
            if (depots[i].getDepotName() != ""){
                if (i == 0)
                System.out.print("Depot "+i+" Name: "+depots[i].getDepotName());
                for(int count = 0; count < 5; count++){
                    if (depots[i].products[count].getProductName() != ""){
                        System.out.print("Product "+count+" Name: "+depots[i].products[count].getProductName());
                        System.out.print("Product "+count+" Price: "+depots[i].products[count].getProductPrice());
                        System.out.print("Product "+count+" Weight: "+depots[i].products[count].getProductWeight());
                        System.out.print("Product "+count+" Quantity: "+depots[i].products[count].getProductQuantity());
                    }
                    if (depots[i].products[count].getProductName() == ""){
                        productCount++;
                    }
                    if (productCount == 5){
                        System.out.print(depots[i].getDepotName()+" has no products\n");
                    }
                }
            }
            if (depots[i].getDepotName() != ""){
                depotCount++;
            }
            if (depotCount == 4){
                System.out.print("No Depots");
            }
        }
    }

    // Searchs for products
    public static void productSearch()
    {
        String input;
        System.out.print("Product name = ");
        input = console.next();
        for (int i = 0; i < 4; i++){
            for (int count = 0; count < 5; count++){
                checkProduct[i] = input.equalsIgnoreCase(depots[i].products[count].getProductName());
                if (checkProduct[i] == true){
                    System.out.print(depots[i].products[count].getProductName()+" exists in "+depots[i].getDepotName()+" with a quantity of "
                        +depots[i].products[count].getProductQuantity());
                    return;
                }
            }
        }
        System.out.print("No Products With That Name");
    }
    // exports data 
    public static void export()throws IOException
    {
        System.out.print("File name: ");
        String fileName = console.next();
        int productCount;
        PrintWriter writer = new PrintWriter(fileName+".txt");
        for(int i = 0; i < 4; i++)
        {
            for(int count = 0; count < 5; count++){
                if ((depots[i].getDepotName() != "")&&(depots[i].products[count].getProductName() != "")){
                    writer.println(depots[i].getDepotName()+"-depot "+depots[i].products[count].getProductName()+" "+depots[i].products[count].getProductPrice()
                        +" "+depots[i].products[count].getProductWeight()+" "+depots[i].products[count].getProductQuantity());
                }
                else if ((depots[i].getDepotName() != "")&&(depots[i].products[0].getProductName() == "")){
                    writer.println(depots[i].getDepotName()+"-depot");
                    break;
                }
            }
        }
        System.out.print("Data Written To File\n");
        writer.close();
    }
    // finds total value
    public static void cumulativeValue()
    {
        String input;
        double  amount = 0;
        System.out.print("Finds value Of which Depot? ");
        input = console.next();
        for (int i = 0;i < 4;i++){
            checkDepot[i] = depots[i].getDepotName().equalsIgnoreCase(input);
            if (checkDepot[i] == true){
                for (int count = 0; count < 5; count++){
                    amount = depots[i].products[count].getProductQuantity()*depots[i].products[count].getProductPrice()+amount;
                }
                System.out.print(depots[i].getDepotName()+" has a total value of "+amount);
            }
        }
    }
    
    //main method 
    public static void main(String[] args) throws IOException
    {
        Interface main = new Interface();
        main.run();
    }
}