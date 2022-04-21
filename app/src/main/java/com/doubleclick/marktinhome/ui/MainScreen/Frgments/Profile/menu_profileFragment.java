package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Profile;

import static com.doubleclick.marktinhome.Model.Constantes.USER;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doubleclick.DashBoard.DashBoardActivity;
import com.doubleclick.RichEditor.sample.RichEditorActivity;
import com.doubleclick.ViewModel.UserViewModel;
import com.doubleclick.marktinhome.BaseFragment;
import com.doubleclick.marktinhome.MainActivity;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.ui.Add.AddActivity;
import com.doubleclick.marktinhome.ui.Advertisement.AdvertisementActivity;
import com.doubleclick.marktinhome.ui.MainScreen.Chat.ChatActivity;
import com.doubleclick.marktinhome.ui.Trademark.TrademarkActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class menu_profileFragment extends BaseFragment {


    private UserViewModel userViewModel;
    private CircleImageView person;
    private TextView username, address, email, phone;
    private ImageView editAddress, editPhone, editname;
    private AlertDialog.Builder builder;
    private FloatingActionButton fab;
    private ConstraintLayout AddProduct, AddAdv, AddTradmark, recentOrder, chat, joinUs, statistices,Groups;
    private ConstraintLayout logout;

    public menu_profileFragment() {
        // Required empty public constructor
    }


    public static menu_profileFragment newInstance(String param1, String param2) {
        menu_profileFragment fragment = new menu_profileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_profile, container, false);
        person = view.findViewById(R.id.person);
        username = view.findViewById(R.id.username);
        address = view.findViewById(R.id.address);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        fab = view.findViewById(R.id.fab);
        editAddress = view.findViewById(R.id.editAddress);
        editPhone = view.findViewById(R.id.editPhone);
        editname = view.findViewById(R.id.editname);
        joinUs = view.findViewById(R.id.joinUs);
        AddProduct = view.findViewById(R.id.AddProduct);
        logout = view.findViewById(R.id.logout);
        AddAdv = view.findViewById(R.id.AddAdv);
        AddTradmark = view.findViewById(R.id.AddTradmark);
        recentOrder = view.findViewById(R.id.recentOrder);
        statistices = view.findViewById(R.id.statistices);
        Groups = view.findViewById(R.id.Groups);
        chat = view.findViewById(R.id.chat);

        userViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                Glide.with(getContext()).load(user.getImage()).into(person);
                username.setText(user.getName());
                address.setText(user.getAddress());
                email.setText(user.getEmail());
                phone.setText(user.getPhone());
            }

        });
        fab.setOnClickListener(v -> {
            openImage("", USER, "");
        });
        editAddress.setOnClickListener(v -> {
            ShowEdite("address");
        });
        editPhone.setOnClickListener(v -> {
            ShowEdite("phone");
        });
        editname.setOnClickListener(v -> {
            ShowEdite("name");
        });
        AddProduct.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AddActivity.class));
        });
        AddAdv.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AdvertisementActivity.class));
        });
        AddTradmark.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), TrademarkActivity.class));
        });
        logout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(getContext(), MainActivity.class));
            requireActivity().finish();
        });
        chat.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ChatActivity.class);
            startActivity(intent);
//            Navigation.findNavController(v).navigate(menu_profileFragmentDirections.actionMenuProfileToAllUserFragment());
        });

        statistices.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), DashBoardActivity.class);
            startActivity(intent);
        });

        joinUs.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(menu_profileFragmentDirections.actionMenuProfileToJoinUsFragment());
        });

        recentOrder.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(menu_profileFragmentDirections.actionMenuProfileToRecentOrderFragment());
        });
        Groups.setOnClickListener(v -> {



        });
        return view;
    }

    private void ShowEdite(String type) {
        builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_edit, null, false);
        TextView ok = view.findViewById(R.id.ok);
        TextInputEditText edit = view.findViewById(R.id.edit);
        ok.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(edit.getText().toString())) {
                HashMap<String, Object> map = new HashMap<>();
                map.put(type, edit.getText().toString());
                reference.child(USER).child(myId).updateChildren(map);
                edit.setText("");
                ShowToast(getContext(), "Done");
            } else {
                ShowToast(getContext(), "you can't set empty text");

            }

        });
        builder.setView(view);
        builder.setCancelable(true);
        builder.show();
    }
}