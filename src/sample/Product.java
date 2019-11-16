package sample;

public abstract class Product implements Item {
  private int productID;
  private ItemType Type;
  public String manufacturer;
  private String name;

  public Product(String name, String manufacturer, ItemType type){
    this.name = name;
    this.manufacturer = manufacturer;
    this.Type = type;
  }
  public ItemType getType(){
    return Type;
  }
  public int getProductID(){
    return productID;
  }
  public String getManufacturer(){
    return manufacturer;
  }

  public void setManufacturer(String manufacturer){
    this.manufacturer = manufacturer;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String toString(){
    return "Name: " + name + '\n' +
        "Manufacturer: " + manufacturer + '\n' +
        "Type: " + Type + '\n';
  }
}