package com.doubleclick.marktinhome.ui.MainScreen.Chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$\u00a8\u00065"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Chat/callUsFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "()V", "chatAdapter", "Lcom/doubleclick/marktinhome/Adapters/ChatAdapter;", "getChatAdapter", "()Lcom/doubleclick/marktinhome/Adapters/ChatAdapter;", "setChatAdapter", "(Lcom/doubleclick/marktinhome/Adapters/ChatAdapter;)V", "chatRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getChatRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setChatRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "chatViewModel", "Lcom/doubleclick/ViewModel/ChatViewModel;", "getChatViewModel", "()Lcom/doubleclick/ViewModel/ChatViewModel;", "setChatViewModel", "(Lcom/doubleclick/ViewModel/ChatViewModel;)V", "et_text_message", "Landroidx/appcompat/widget/AppCompatEditText;", "getEt_text_message", "()Landroidx/appcompat/widget/AppCompatEditText;", "setEt_text_message", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "sendText", "Landroidx/appcompat/widget/AppCompatImageView;", "getSendText", "()Landroidx/appcompat/widget/AppCompatImageView;", "setSendText", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "user", "Lcom/doubleclick/marktinhome/ui/MainScreen/Chat/callUsFragmentArgs;", "getUser", "()Lcom/doubleclick/marktinhome/ui/MainScreen/Chat/callUsFragmentArgs;", "user$delegate", "Landroidx/navigation/NavArgsLazy;", "defaultMessage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "sentMessage", "text", "", "app_debug"})
public final class callUsFragment extends com.doubleclick.marktinhome.BaseFragment {
    public androidx.appcompat.widget.AppCompatImageView sendText;
    public androidx.appcompat.widget.AppCompatEditText et_text_message;
    public androidx.recyclerview.widget.RecyclerView chatRecycler;
    public com.doubleclick.ViewModel.ChatViewModel chatViewModel;
    public com.doubleclick.marktinhome.Adapters.ChatAdapter chatAdapter;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy user$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public callUsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatImageView getSendText() {
        return null;
    }
    
    public final void setSendText(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.AppCompatEditText getEt_text_message() {
        return null;
    }
    
    public final void setEt_text_message(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getChatRecycler() {
        return null;
    }
    
    public final void setChatRecycler(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.ViewModel.ChatViewModel getChatViewModel() {
        return null;
    }
    
    public final void setChatViewModel(@org.jetbrains.annotations.NotNull()
    com.doubleclick.ViewModel.ChatViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.Adapters.ChatAdapter getChatAdapter() {
        return null;
    }
    
    public final void setChatAdapter(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Adapters.ChatAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.ui.MainScreen.Chat.callUsFragmentArgs getUser() {
        return null;
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
    
    private final void sentMessage(java.lang.String text) {
    }
    
    private final void defaultMessage() {
    }
}