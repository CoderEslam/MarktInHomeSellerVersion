package com.doubleclick.marktinhome.Model;

import java.util.Arrays;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/12/2022
 */
public class RecentOrder {

    private String ProductId;
    private double price;
    private int Quantity;
    private String productName;
    private String images;
    private String id;
    private String BuyerId;
    private String SellerId;
    private double TotalPrice;
    private long date;
    private String address;
    private String phone;
    private String anotherPhone;
    private String locationUri;
    private String ToggleItem;

    public RecentOrder() {
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(String buyerId) {
        BuyerId = buyerId;
    }

    public String getSellerId() {
        return SellerId;
    }

    public void setSellerId(String sellerId) {
        SellerId = sellerId;
    }

    public long getQuantity() {
        return Quantity;
    }


    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getImages() {
        return images;
    }

    public String getOnlyImage() {
        List<String> image = Arrays.asList(images.replace("[", "").replace("]", "").replace(" ", "").trim().split(","));
        return image.get(0);
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAnotherPhone() {
        return anotherPhone;
    }

    public void setAnotherPhone(String anotherPhone) {
        this.anotherPhone = anotherPhone;
    }

    public String getLocationUri() {
        return locationUri;
    }

    public void setLocationUri(String locationUri) {
        this.locationUri = locationUri;
    }

    public String getToggleItem() {
        return ToggleItem;
    }

    public void setToggleItem(String toggleItem) {
        ToggleItem = toggleItem;
    }


    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecentOrder{" +
                "ProductId='" + ProductId + '\'' +
                ", price=" + price +
                ", Quantity=" + Quantity +
                ", productName='" + productName + '\'' +
                ", images='" + images + '\'' +
                ", id='" + id + '\'' +
                ", BuyerId='" + BuyerId + '\'' +
                ", SellerId='" + SellerId + '\'' +
                ", TotalPrice=" + TotalPrice +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", anotherPhone='" + anotherPhone + '\'' +
                ", locationUri='" + locationUri + '\'' +
                ", ToggleItem='" + ToggleItem + '\'' +
                '}';
    }
}
