package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.UserInter
import com.doubleclick.ViewModel.UserViewModel
import com.doubleclick.marktinhome.Adapters.AllUserChatListAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Constantes.CHAT_LIST
import com.doubleclick.marktinhome.Model.User
import com.doubleclick.marktinhome.R


class AllUserFragment : BaseFragment(), UserInter {

    lateinit var allUser: RecyclerView;
    lateinit var userViewModel: UserViewModel;

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
        var view = inflater.inflate(R.layout.fragment_all_user, container, false)
        allUser = view.findViewById(R.id.allUser);
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java];
        userViewModel.getChatList()
        userViewModel.chatUser.observe(viewLifecycleOwner, Observer {
            var AllUserChatListAdapter = AllUserChatListAdapter(it, this);
            allUser.adapter = AllUserChatListAdapter
        })
        makeChatList();
        return view;
    }

    override fun ItemUser(user: User?) {}

    override fun AllUser(user: ArrayList<User>?) {}

    override fun OnUserLisitner(user: User) {
        findNavController().navigate(AllUserFragmentDirections.actionAllUserFragmentToCallUsFragment(user))
    }

    private fun makeChatList() {
        var map: HashMap<String, Any> = HashMap();
        if (!myId.equals("WoWDlmZx7lUwRr9ZD2LAkHRwkoi1")) {
            map["id"] = myId
            reference.child(CHAT_LIST).child("WoWDlmZx7lUwRr9ZD2LAkHRwkoi1").updateChildren(map)
            val m: HashMap<String, Any> = HashMap();
            m["id"] = "WoWDlmZx7lUwRr9ZD2LAkHRwkoi1"
            reference.child(CHAT_LIST).child(myId).updateChildren(m)
        }

    }

}