package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.UserInter
import com.doubleclick.ViewModel.ChatListViewModel
import com.doubleclick.ViewModel.UserViewModel
import com.doubleclick.marktinhome.Adapters.AllUserChatListAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.CHAT_LIST
import com.doubleclick.marktinhome.Model.User
import com.doubleclick.marktinhome.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.todkars.shimmer.ShimmerRecyclerView


class ChatListFragment : BaseFragment(), UserInter {

    lateinit var allUser: ShimmerRecyclerView;
    lateinit var chatListViewModel: ChatListViewModel
    lateinit var chatUser: FloatingActionButton


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
        var view = inflater.inflate(R.layout.fragment_chat_list, container, false)
        allUser = view.findViewById(R.id.allUser);
        allUser.showShimmer();
        chatUser = view.findViewById(R.id.chatUser);
        chatListViewModel = ViewModelProvider(this)[ChatListViewModel::class.java];
        chatListViewModel.myChatList().observe(viewLifecycleOwner, Observer {
            var allUserChatListAdapter = AllUserChatListAdapter(it, this);
            allUser.adapter = allUserChatListAdapter;
            allUser.hideShimmer()
        })


        chatUser.setOnClickListener {
            findNavController().navigate(ChatListFragmentDirections.actionChatListFragmentToAllUsersFragment())
        }
        return view;
    }

    override fun ItemUser(user: User?) {}

    override fun AllUser(user: ArrayList<User>?) {}

    override fun OnUserLisitner(user: User) {
        findNavController().navigate(
            ChatListFragmentDirections.actionChatListFragmentToChatFragment(
                user
            )
        )
    }

}