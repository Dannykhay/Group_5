package Controllers;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModelOrder {
    private final SimpleStringProperty food;
    private final SimpleStringProperty location;
    private final SimpleIntegerProperty quantity;
    private final SimpleFloatProperty price;
    private final SimpleFloatProperty totalPrice;



//    public void setTotalPrice(float totalPrice) {
//        this.totalPrice.set(totalPrice);
//    }

    public ModelOrder(String food, String location, Integer quantity, Float price, SimpleFloatProperty totalPrice) {
        this.food = new SimpleStringProperty(food);
        this.location = new SimpleStringProperty(location);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleFloatProperty(price);
        this.totalPrice = totalPrice;
    }


    public String getFood() {

        return food.get();
    }

    public void setFood(String food) {
        this.food.set(food);
    }

    public String getLocation() {

        return location.get();
    }

    public void setLocation(String location) {

        this.location.set(location);
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public void setQuantity(Integer quantity) {
        this.quantity.set(quantity);
    }

    public float getPrice() {
        return price.get();
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public float getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleFloatProperty totalPriceProperty() {
        return totalPrice;
    }
}
