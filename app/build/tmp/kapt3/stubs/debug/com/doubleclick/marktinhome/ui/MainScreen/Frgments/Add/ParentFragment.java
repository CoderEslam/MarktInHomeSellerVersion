package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/ParentFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "Lcom/doubleclick/OnItem;", "()V", "ParentRecyceler", "Landroidx/recyclerview/widget/RecyclerView;", "addParent", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "productViewModel", "Lcom/doubleclick/ViewModel/ProductViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItem", "parentCategory", "Lcom/doubleclick/marktinhome/Model/ParentCategory;", "onItemLong", "Companion", "app_debug"})
public final class ParentFragment extends com.doubleclick.marktinhome.BaseFragment implements com.doubleclick.OnItem {
    private com.doubleclick.ViewModel.ProductViewModel productViewModel;
    private androidx.recyclerview.widget.RecyclerView ParentRecyceler;
    private com.google.android.material.floatingactionbutton.FloatingActionButton addParent;
    @org.jetbrains.annotations.NotNull()
    public static final com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.ParentFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public ParentFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.ParentFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String param1, @org.jetbrains.annotations.NotNull()
    java.lang.String param2) {
        return null;
    }
    
    @java.lang.Override()
    public void onItem(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.ParentCategory parentCategory) {
    }
    
    @java.lang.Override()
    public void onItemLong(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.ParentCategory parentCategory) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/ParentFragment$Companion;", "", "()V", "newInstance", "Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/ParentFragment;", "param1", "", "param2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.ParentFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String param1, @org.jetbrains.annotations.NotNull()
        java.lang.String param2) {
            return null;
        }
    }
}