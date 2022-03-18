package com.doubleclick.marktinhome.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import kotlinx.android.parcel.Parcelize;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
@Parcelize
public class Product implements  Comparable, Parcelable {

    private String productId;
    private double price;
    private String description;
    private long date;
    private String adminId;
    private String productName;
    private double lastPrice;
    private String tradeMark;
    private String parentCategoryName;
    private String childCategoryName;
    private String parentCategoryId;
    private String childCategoryId;
    private int TotalRating;
    private int discount;
    private String keywords;
    private String Images;
    private String Toggals;

    public Product(double price, String productName, String images, String toggals) {
        this.price = price;
        this.description = description;
        this.productName = productName;
        this.lastPrice = lastPrice;
        this.tradeMark = tradeMark;
        Images = images;
        Toggals = toggals;
    }


    protected Product(Parcel in) {
        productId = in.readString();
        price = in.readDouble();
        description = in.readString();
        date = in.readLong();
        adminId = in.readString();
        productName = in.readString();
        lastPrice = in.readDouble();
        tradeMark = in.readString();
        parentCategoryName = in.readString();
        childCategoryName = in.readString();
        parentCategoryId = in.readString();
        childCategoryId = in.readString();
        TotalRating = in.readInt();
        discount = in.readInt();
        keywords = in.readString();
        Images = in.readString();
        Toggals = in.readString();
        ratingSeller = in.readFloat();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product(String productId, double price, String description, long date, String adminId, String productName, double lastPrice, String tradeMark, String parentCategoryName, String childCategoryName, String parentCategoryId, String childCategoryId, int totalRating, int discount, String keywords, String images, String toggals, float ratingSeller) {
        this.productId = productId;
        this.price = price;
        this.description = description;
        this.date = date;
        this.adminId = adminId;
        this.productName = productName;
        this.lastPrice = lastPrice;
        this.tradeMark = tradeMark;
        this.parentCategoryName = parentCategoryName;
        this.childCategoryName = childCategoryName;
        this.parentCategoryId = parentCategoryId;
        this.childCategoryId = childCategoryId;
        TotalRating = totalRating;
        this.discount = discount;
        this.keywords = keywords;
        Images = images;
        Toggals = toggals;
        this.ratingSeller = ratingSeller;
    }

    public String getToggals() {
        return Toggals;
    }

    public void setToggals(String toggals) {
        Toggals = toggals;
    }


    public float getRatingSeller() {
        return ratingSeller;
    }

    public void setRatingSeller(float ratingSeller) {
        this.ratingSeller = ratingSeller;
    }

    private float ratingSeller;

    public String getImages() {
        return Images;
    }

    public String getOnlyImage() {
        List<String> image = Arrays.asList(getImages().replace("[", "").replace("]", "").replace(" ", "").trim().split(","));
        return image.get(0);
    }

    public void setImages(String images) {
        Images = images;
    }


    public Product() {
    }


    @Override
    public int compareTo(Object o) {
        int rate = ((Product) o).getTotalRating();
        return (this.TotalRating - rate);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public String getChildCategoryName() {
        return childCategoryName;
    }

    public void setChildCategoryName(String childCategoryName) {
        this.childCategoryName = childCategoryName;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getChildCategoryId() {
        return childCategoryId;
    }

    public void setChildCategoryId(String childCategoryId) {
        this.childCategoryId = childCategoryId;
    }


    public int getTotalRating() {
        return TotalRating;
    }

    public void setTotalRating(int totalRating) {
        TotalRating = totalRating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", adminId='" + adminId + '\'' +
                ", productName='" + productName + '\'' +
                ", lastPrice=" + lastPrice +
                ", tradeMark='" + tradeMark + '\'' +
                ", parentCategoryName='" + parentCategoryName + '\'' +
                ", childCategoryName='" + childCategoryName + '\'' +
                ", parentCategoryId='" + parentCategoryId + '\'' +
                ", childCategoryId='" + childCategoryId + '\'' +
                ", Images='" + Images + '\'' +
                ", TotalRating=" + TotalRating +
                ", discount=" + discount +
                ", keywords='" + keywords + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeLong(date);
        dest.writeString(adminId);
        dest.writeString(productName);
        dest.writeDouble(lastPrice);
        dest.writeString(tradeMark);
        dest.writeString(parentCategoryName);
        dest.writeString(childCategoryName);
        dest.writeString(parentCategoryId);
        dest.writeString(childCategoryId);
        dest.writeInt(TotalRating);
        dest.writeInt(discount);
        dest.writeString(keywords);
        dest.writeString(Images);
        dest.writeString(Toggals);
        dest.writeFloat(ratingSeller);
    }
}
