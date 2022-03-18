package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/11/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/doubleclick/RecentSearchInterface;", "", "getLastListSearchAboutProductOneTime", "", "recentSearchaboutProduct", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Product;", "Lkotlin/collections/ArrayList;", "getRecentSearch", "recentSearch", "Lcom/doubleclick/marktinhome/Model/RecentSearch;", "app_debug"})
public abstract interface RecentSearchInterface {
    
    public abstract void getLastListSearchAboutProductOneTime(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> recentSearchaboutProduct);
    
    public abstract void getRecentSearch(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.RecentSearch recentSearch);
}