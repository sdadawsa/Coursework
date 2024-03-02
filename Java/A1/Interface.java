/*
Jake Whamond
C3339952
*/
import java.util.Scanner;
public class Interface
{
    private Depot depot1=null; 
    private Depot depot2=null;
    private String name;
    private void addDepot(Scanner scanner) 
    { 
      if 
        (depot1 == null) {
            System.out.println("There are already 2 Depot");
            return; // tell the user 2 depots exist 
            } 
      else 
      {
      System.out.print("Enter Depot Name: ");
      String dname = scanner.next(); 
      }
      if (depot1 == null ) 
            {
                System.out.println("Depot already exists");
                return;
            }  
      if (depot2 == null ) 
            {
                System.out.println("Depot already exists");
                return;
            }    
      if (depot1 == null) 
      {
                depot1 = new Depot();
      }
          else 
      {
        depot2 = new Depot();
      }
    }
    private void addProduct(Scanner scanner) {
      System.out.print("Enter Product Name: ");
      String name = scanner.next();
      System.out.print("Enter the Depot its in");
      String Depotname = scanner.next();
      System.out.print("Enter the price");
      String price = scanner.next();
      Double Price = Double.parseDouble(price);
      System.out.print("Enter the weight");
      String weight = scanner.next();
      Double Weight = Double.parseDouble(weight);
      Product p1 = new Product();
       if (depot1 == null){
          if (depot1.getName().equals(Depotname)) {
              if (depot1.getP1() == null) 
                {
                    depot1.setP1(p1);
                } 
                if (depot1.getP2() == null)
                {
                    depot1.setP2(p1);
                }
                    else if (depot1.getP3()==null)
                    {
                      depot1.setP3(p1);   
                    }
                    else if (depot1 == null && (depot1.getP1().getName().equals(name)
                       || depot1.getP2().getName().equals(name))) 
                    {
                    System.out.println(" the product already exists");
                    return;
                }
                else if (depot1 == null && (depot1.getP2().getName().equals(name)
                    || depot1.getP3().getName().equals(name))) 
                {
                    System.out.println(" the product already exists");
                    return;
                }
                 else 
                {
                    System.out.println(" the depot already has 3 product.");
                }
                 if (depot2 == null) 
                 {
                    if (depot2.getName().equals(Depotname))       
                {
                 if (depot2.getP1() == null)    
                {
                    depot2.setP1(p1);
                    } 
                    else if (depot2.getP2()==null)
                    {
                        depot2.setP2(p1);
                    }
                    else if (depot2.getP3()==null)
                    {
                        depot2.setP3(p1);
                    }
                    else if (depot2 ==null && (depot2.getP1().getName().equals(name)
                     || depot2.getP2().getName().equals(name))) 
                     {
                         System.out.println("product already exist");  
                         return;
                    }
                    else 
                    {
                         System.out.println(" the depot already has 2 product.");
                    }
                }  
            }
            }
        } 
    }
    private void deleteDepot(Scanner scanner)   {
        System.out.print("Enter Depot Name: ");
        String name = scanner.next();
         if (depot1 == null && depot1.getName().equals(name)) 
        {
            depot1 = null;
            System.out.println("Depot1 is deleted");
        }
        else if (depot2 ==null && depot2.getName().equals(name))
        {
            depot2 = null;
            System.out.println("Depot2 is deleted");   
        }
        else
        {
            
         System.out.println("Depot doesn't exist");
            return;    
        }
    }
    private void deleteProduct(Scanner scanner)   {
        System.out.print("Product name");
        String name = scanner.next();
          if (depot1 != null && depot1.getP1() == null && depot1.getP1().getName().equals(name))
          {
            depot1.setP1(null);
            System.out.println("Product one is deleted from depot one");   
          }
           else if (depot1 != null && depot1.getP2() == null && depot1.getP2().getName().equals(name)) {
            depot1.setP2(null);
            System.out.println("Product two is deleted from depot one");
            }
          if (depot2 != null && depot2.getP1() == null && depot2.getP1().getName().equals(name)) 
            {
            depot2.setP1(null);
            System.out.println("Product one is deleted from depot two");
            } 
          else if (depot2 != null && depot2.getP2() == null && depot2.getP2().getName().equals(name)) 
            {
            depot2.setP2(null);
            System.out.println("product two is deleted from depot two");
            } 
          else
            {
            System.out.println("the product does not exist");
            return;
            }
    }
    private void printListDepot(Scanner scanner)   {
        boolean isFound = false;
        if (depot1 == null) 
        {
            System.out.println(depot1);
            if (depot1.getP1() == null)
             {
                System.out.println(depot1.getP1());
            }
            if (depot1.getP2() == null) 
            {
                System.out.println(depot1.getP2());
            }
            if (depot1.getP3() == null) 
            {
                System.out.println(depot1.getP2());
            }
            isFound = true;
        } 
        if (depot2 == null) 
        {
            System.out.println(depot2);
            if (depot2.getP1() == null) 
            {
                System.out.println(depot2.getP1());
            }
            if (depot2.getP2() == null) {
                System.out.println(depot2.getP2());
            }
            if (depot2.getP3() == null) {
                System.out.println(depot2.getP3());
            }
            isFound = true;
        }
        if (!isFound) 
        {
            System.out.println("No Depot or Product exist");
        }
    }
    private void printsListProduct(Scanner scanner)   
    {
     System.out.print("Enter Depot Name: ");
     String name = scanner.next();
      if (depot1 == null && depot1.getName().equals(name)) 
      {
         if (depot1.getP1() == null) 
    
          {
                System.out.println("Product" + depot1.getP1().getName() + "is in this depot");
                return;
            }
         if (depot1.getP2() == null) 
            {
                System.out.println("Product" + depot1.getP2().getName() + "is in this depot");
                return;
            } 
         if (depot1.getP3() == null) 
            {
                System.out.println("Product" + depot1.getP3().getName() + "is in this depot");
                return;
            } 
            else
            {
              System.out.println("products in depot");  
                
            }
            } 
            else if (depot2 == null && depot2.getName().equals(name)) 
            {
                if (depot2.getP1() == null) 
            {
                System.out.println("Product " + depot2.getP1().getName() + "is in this depot");
                return;
            }
              if (depot2.getP2() == null) 
            {
                System.out.println("Product " + depot2.getP1().getName() + "is in this depot");
                return;
            }
              if (depot2.getP3() == null) 
            {
                System.out.println("Product " + depot2.getP1().getName() + "is in this depot");
                return;
            }
            else 
            {
                System.out.println("no products in depot");
            }
            }
    }
    private void Cumulativevalue(Scanner scanner)   {}
    private void productindepots(Scanner scanner)   {}
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Menu(scanner);
        scanner.close();
    }
    private void Menu(Scanner scanner) 
    {
        do 
        {
            System.out.println("1. Add a Depot");
            System.out.println("2. Add a Product");
            System.out.println("3. Delete a Depot");
            System.out.println("4. Delete a Product");
            System.out.println("5. List of products in a depot.");
            System.out.println("6. List of Depot");
            System.out.println("7. Cumulative value of all products in a depot.");
            System.out.println("8. look up product's presence in the depots.  .");
            System.out.println("9. Exit.");

            System.out.print("Enter an option: ");
            int option = scanner.nextInt();
            switch (option) 
            {
            case 1:
                addDepot(scanner);
                break;
            case 2:
                addProduct(scanner);
                break;
            case 3:
                deleteDepot(scanner);
                break;
            case 4:
                deleteProduct(scanner);
                break;
            case 5:
                printsListProduct(scanner);
                break;
            case 6:
                printListDepot(scanner);
                break;
            case 7:
                Cumulativevalue(scanner);
                break;
            case 8:
                productindepots(scanner);
                break;

            case 9:
                System.out.println("Bye");
                System.exit(0);
                break;
            }
        }
        while (true);  
            }
    public static void main(String[] args) {
        Interface intFace = new Interface();
        intFace.run();   
    }  
            
            
            
            
            
            
            
            
            
        
        
        
        
    }

    
    


