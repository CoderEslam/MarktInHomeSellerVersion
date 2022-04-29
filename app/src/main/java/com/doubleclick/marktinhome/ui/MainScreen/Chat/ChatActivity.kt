package com.doubleclick.marktinhome.ui.MainScreen.Chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.findNavController
import com.doubleclick.marktinhome.Model.User
import com.doubleclick.marktinhome.R

class ChatActivity : AppCompatActivity() {


    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        try {
            user = intent.getSerializableExtra("user") as User
            if (user.id != "") {
                val chatFragment = ChatFragment()
                val bundle = Bundle();
                bundle.putSerializable("user", user)
                chatFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_Chat, chatFragment).commit()
            }
        } catch (e: Exception) {
            Log.e("userException", e.message.toString())
        }

    }
}