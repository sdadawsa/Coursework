/*
11/10/2022
C3327794
Jake whamond
*/
public class Depot
{
    //defines array of products and depot variable
    private String depotname; 
    Product[] products = new Product[5];

    //constructor creates 5 products in each depot
    public Depot()
    {
        depotname = "";
        for(int i = 0; i < 5; i++)  
            products[i] = new Product();
    }

    //setters and getters 
    public void setDepotName(String depotName)
    {
        depotname = depotName;
    }

    public String getDepotName()
    {
        return depotname;
    }

    public void setProductData(Product p, String name, double price, double weight, int quantity)
    {
        p.setName(name);
        p.setPrice(price);
        p.setWeight(weight);
        p.setQuantity(quantity);
    }

    public void addProductData(int i, String newName, double newPrice, double newWeight, int newQuantity)
    {
        setProductData(products[i],newName,newPrice,newWeight,newQuantity);
    }

    private void setQuantity(Product p, int quantity)
    {
        p.setQuantity(quantity);
    }    

    public void addQuantity(int i, int newQuantity)
    {
        setQuantity(products[i],newQuantity);

    }

    public void getProductName()
    {
        int i = 0;
        products[i].getProductName();
    }

    public void getProductPrice()
    {
        int i = 0;
        products[i].getProductPrice();
    }

    public void getProductWeight()
    {
        int i = 0;
        products[i].getProductWeight();
    }

    public void getProductQuantity()
    {
        int i = 0;
        products[i].getProductQuantity();
    }

    public void newProduct(int i)
    {
        products[i] = new Product();
    }
}
