package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.ViewModel.ChatViewModel
import com.doubleclick.marktinhome.Adapters.ChatAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.CHATS
import com.doubleclick.marktinhome.Model.Constantes.CHAT_LIST
import com.doubleclick.marktinhome.R
import java.util.*
import kotlin.collections.HashMap


class callUsFragment : BaseFragment() {


    lateinit var sendText: AppCompatImageView
    lateinit var et_text_message: AppCompatEditText
    lateinit var chatRecycler: RecyclerView;
    lateinit var chatViewModel: ChatViewModel
    lateinit var chatAdapter: ChatAdapter
    val user by navArgs<callUsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_call_us, container, false)
        sendText = view.findViewById(R.id.sendText);
        et_text_message = view.findViewById(R.id.et_text_message);
        chatRecycler = view.findViewById(R.id.chatRecycler);
        chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        chatViewModel.ChatById(user.user.id)
        chatViewModel.myChat.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            chatAdapter = ChatAdapter(it);
            chatRecycler.adapter = chatAdapter
        })
        sendText.setOnClickListener {
            sentMessage(et_text_message.text.toString())
        }
        defaultMessage();
        return view;
    }

    private fun sentMessage(text: String) {
        var map: HashMap<String, Any> = HashMap()
        var id = reference.push().key.toString()
        map["sender"] = myId
        map["message"] = text.trim()
        map["type"] = "text"
        map["receiver"] = user.user.id // Id of Admin
        map["date"] = Date().time
        map["id"] = id
        reference.child(CHATS).child(id).updateChildren(map)
        et_text_message.setText("")
    }

    private fun defaultMessage() {
        if (!myId.equals("WoWDlmZx7lUwRr9ZD2LAkHRwkoi1")) {
            var map: HashMap<String, Any> = HashMap()
            // id of admin + id of user
            var id = "WoWDlmZx7lUwRr9ZD2LAkHRwkoi1" + ":" + myId
            map["sender"] = "WoWDlmZx7lUwRr9ZD2LAkHRwkoi1" //  id of Admin
            map["message"] = "How I can help you ? "
            map["type"] = "text"
            map["receiver"] = myId // Id of user
            map["date"] = 0
            map["id"] = id
            reference.child(CHATS).child(id).updateChildren(map)
        }
    }


}