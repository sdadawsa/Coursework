/*
Jake Whamond
C3339952
*/
public class Product
{
    private String name;
    private double price;
    private double weight;
    private int quantity;

    public Product()
    {
        name = "";
        price = 0.0;
        weight = 0.0;
        quantity=0;
    }
    /*
     getters and setters
     */
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName) {
	name = newName;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public void setWeight(Double newWeight) {
	weight = newWeight;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setPrice(Double newPrice) {
	price = newPrice;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int newQuantity) {
	quantity = newQuantity;
    }
    
    public String toString() {
	return "Product" + name + "Product" + weight + "price" + price;
    }
}
