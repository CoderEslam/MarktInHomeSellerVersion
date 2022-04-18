package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0016Jb\u0010T\u001a\u00020R2\b\u0010U\u001a\u0004\u0018\u00010\u00162\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\b\u0010J\u001a\u0004\u0018\u00010\u00162\b\u0010Z\u001a\u0004\u0018\u00010\u00162\b\u0010[\u001a\u0004\u0018\u00010\u00162\b\u0010\\\u001a\u0004\u0018\u00010\u00162\b\u0010]\u001a\u0004\u0018\u00010\u0016Jb\u0010^\u001a\u00020R2\b\u0010U\u001a\u0004\u0018\u00010\u00162\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\b\u0010J\u001a\u0004\u0018\u00010\u00162\b\u0010Z\u001a\u0004\u0018\u00010\u00162\b\u0010[\u001a\u0004\u0018\u00010\u00162\b\u0010\\\u001a\u0004\u0018\u00010\u00162\b\u0010]\u001a\u0004\u0018\u00010\u0016J\u0014\u0010_\u001a\u0004\u0018\u00010\u00162\b\u0010`\u001a\u0004\u0018\u00010PH\u0016J\"\u0010a\u001a\u00020R2\u0006\u0010b\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u00020R2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J&\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010n2\b\u0010g\u001a\u0004\u0018\u00010hH\u0017J\b\u0010o\u001a\u00020RH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020!0 X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u000e\u0010%\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R&\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020!0 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020P0OX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006p"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "()V", "IMAGES_REQUEST", "", "RichTable", "Landroid/widget/FrameLayout;", "Upload", "Landroid/widget/Button;", "addToggleButton", "Landroid/widget/LinearLayout;", "getAddToggleButton", "()Landroid/widget/LinearLayout;", "setAddToggleButton", "(Landroid/widget/LinearLayout;)V", "addView", "Landroid/widget/ImageView;", "getAddView", "()Landroid/widget/ImageView;", "setAddView", "(Landroid/widget/ImageView;)V", "begin", "", "getBegin", "()Ljava/lang/String;", "setBegin", "(Ljava/lang/String;)V", "builder", "Landroidx/appcompat/app/AlertDialog$Builder;", "description", "Landroid/widget/EditText;", "downloadUri", "Ljava/util/HashMap;", "", "end", "getEnd", "setEnd", "keywords", "mapToggleButton", "getMapToggleButton", "()Ljava/util/HashMap;", "setMapToggleButton", "(Ljava/util/HashMap;)V", "marke", "getMarke", "setMarke", "parent_child", "Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragmentArgs;", "getParent_child", "()Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragmentArgs;", "parent_child$delegate", "Landroidx/navigation/NavArgsLazy;", "productImages", "Landroidx/recyclerview/widget/RecyclerView;", "productLastPrice", "productName", "productPrice", "rate", "", "getRate", "()F", "setRate", "(F)V", "ratingSeller", "Landroid/widget/RatingBar;", "getRatingSeller", "()Landroid/widget/RatingBar;", "setRatingSeller", "(Landroid/widget/RatingBar;)V", "selectImages", "getSelectImages", "()Landroid/widget/Button;", "setSelectImages", "(Landroid/widget/Button;)V", "trademark", "Landroidx/appcompat/widget/AppCompatSpinner;", "tradmarkViewModel", "Lcom/doubleclick/ViewModel/TradmarkViewModel;", "uris", "", "Landroid/net/Uri;", "ShowHTML", "", "html", "UplaodAllData", "name", "price", "", "LastPrice", "descroiprion", "ParentId", "ChildId", "ParentName", "ChildName", "UploadImages", "getFileExtension", "uri", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "openImage", "app_debug"})
public final class UploadFragment extends com.doubleclick.marktinhome.BaseFragment {
    public java.lang.String marke;
    private int IMAGES_REQUEST = 100;
    private android.widget.EditText productName;
    private android.widget.EditText productPrice;
    private android.widget.EditText productLastPrice;
    private android.widget.FrameLayout RichTable;
    private android.widget.EditText description;
    private android.widget.EditText keywords;
    private androidx.appcompat.widget.AppCompatSpinner trademark;
    private android.widget.Button Upload;
    private com.doubleclick.ViewModel.TradmarkViewModel tradmarkViewModel;
    private java.util.List<android.net.Uri> uris;
    private androidx.recyclerview.widget.RecyclerView productImages;
    private java.util.HashMap<java.lang.String, java.lang.Object> downloadUri;
    public android.widget.Button selectImages;
    public android.widget.RatingBar ratingSeller;
    public java.util.HashMap<java.lang.String, java.lang.Object> mapToggleButton;
    private float rate = 0.0F;
    public android.widget.LinearLayout addToggleButton;
    public android.widget.ImageView addView;
    private androidx.appcompat.app.AlertDialog.Builder builder;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy parent_child$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String begin = "<!DOCTYPE html>\n<html>\n\n<head>\n    <style>\n        table,\n        th,\n        td {\n            border: 2px solid black;\n            border-collapse: collapse;\n        }\n      table{\n        width: 100%\n      }\n    </style>\n</head>\n\n<body>";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String end = "</body>\n\n</html>";
    private java.util.HashMap _$_findViewCache;
    
    public UploadFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMarke() {
        return null;
    }
    
    public final void setMarke(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getSelectImages() {
        return null;
    }
    
    public final void setSelectImages(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RatingBar getRatingSeller() {
        return null;
    }
    
    public final void setRatingSeller(@org.jetbrains.annotations.NotNull()
    android.widget.RatingBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, java.lang.Object> getMapToggleButton() {
        return null;
    }
    
    public final void setMapToggleButton(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> p0) {
    }
    
    public final float getRate() {
        return 0.0F;
    }
    
    public final void setRate(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.LinearLayout getAddToggleButton() {
        return null;
    }
    
    public final void setAddToggleButton(@org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getAddView() {
        return null;
    }
    
    public final void setAddView(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.UploadFragmentArgs getParent_child() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBegin() {
        return null;
    }
    
    public final void setBegin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnd() {
        return null;
    }
    
    public final void setEnd(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void openImage() {
    }
    
    public final void ShowHTML(@org.jetbrains.annotations.NotNull()
    java.lang.String html) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getFileExtension(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    public final void UploadImages(@org.jetbrains.annotations.Nullable()
    java.lang.String name, double price, double LastPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String descroiprion, @org.jetbrains.annotations.NotNull()
    java.lang.String keywords, @org.jetbrains.annotations.Nullable()
    java.lang.String trademark, @org.jetbrains.annotations.Nullable()
    java.lang.String ParentId, @org.jetbrains.annotations.Nullable()
    java.lang.String ChildId, @org.jetbrains.annotations.Nullable()
    java.lang.String ParentName, @org.jetbrains.annotations.Nullable()
    java.lang.String ChildName) {
    }
    
    public final void UplaodAllData(@org.jetbrains.annotations.Nullable()
    java.lang.String name, double price, double LastPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String descroiprion, @org.jetbrains.annotations.NotNull()
    java.lang.String keywords, @org.jetbrains.annotations.Nullable()
    java.lang.String trademark, @org.jetbrains.annotations.Nullable()
    java.lang.String ParentId, @org.jetbrains.annotations.Nullable()
    java.lang.String ChildId, @org.jetbrains.annotations.Nullable()
    java.lang.String ParentName, @org.jetbrains.annotations.Nullable()
    java.lang.String ChildName) {
    }
}