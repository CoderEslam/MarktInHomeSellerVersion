package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/3/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0004H&J\u001a\u0010\t\u001a\u00020\u00032\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0004H&J\u001a\u0010\f\u001a\u00020\u00032\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u0010\u001a\u00020\u00032\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J\u001a\u0010\u0017\u001a\u00020\u00032\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004H&J*\u0010\u0018\u001a\u00020\u00032 \u0010\u0019\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004\u0018\u00010\u0004\u0018\u00010\u0004H&\u00a8\u0006\u001a"}, d2 = {"Lcom/doubleclick/Products;", "", "Childproduct", "", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/ChildCategory;", "Childrenproduct", "Parentproduct", "Lcom/doubleclick/marktinhome/Model/ParentCategory;", "getClassificationPC", "Product", "Lcom/doubleclick/marktinhome/Model/ClassificationPC;", "getProduct", "Lcom/doubleclick/marktinhome/Model/Product;", "getProductById", "productById", "getProductTopDeals", "topDeals", "getProductWithTrademark", "productWithTrademark", "getQueryByChild", "QueryProducts", "getQueryByParents", "getQueryProducts", "product", "products", "app_debug"})
public abstract interface Products {
    
    public abstract void product(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.util.ArrayList<java.util.ArrayList<com.doubleclick.marktinhome.Model.Product>>> products);
    
    public abstract void Parentproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ParentCategory> Parentproduct);
    
    public abstract void Childproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ChildCategory> Childproduct);
    
    public abstract void Childrenproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ChildCategory> Childproduct);
    
    public abstract void getProduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> Product);
    
    public abstract void getQueryProducts(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getQueryByParents(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getQueryByChild(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getProductWithTrademark(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> productWithTrademark);
    
    public abstract void getProductTopDeals(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> topDeals);
    
    public abstract void getProductById(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> productById);
    
    public abstract void getClassificationPC(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ClassificationPC> Product);
}