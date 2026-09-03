package org.quickbite.users;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class OrderResponse {
    private int id;
    private String UserEmail;
    private int ItemId;
    private int RestaurantId;
    private BigDecimal ItemPrice;
    private int Quantity;
    private BigDecimal TotalPrice;
    private String Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public BigDecimal getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
