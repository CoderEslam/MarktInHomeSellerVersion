package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.RecentOrderInterface
import com.doubleclick.ViewModel.RecentOrderViewModel
import com.doubleclick.marktinhome.Adapters.CartAdapter
import com.doubleclick.marktinhome.Adapters.RecentOrderAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.Model.RecentOrder
import com.doubleclick.marktinhome.R


class RecentOrderFragment : BaseFragment()  {

    private lateinit var recentOrderViewModel: RecentOrderViewModel
    private lateinit var myRecentOrder: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recent_order, container, false)
        recentOrderViewModel = ViewModelProvider(this)[RecentOrderViewModel::class.java]
        myRecentOrder = view.findViewById(R.id.myRecentOrder);
        recentOrderViewModel.myRecentOrderLiveData.observe(viewLifecycleOwner, Observer {
            var recentOrderAdapter = RecentOrderAdapter(it)
            myRecentOrder.adapter = recentOrderAdapter
        })
        return view;
    }




}