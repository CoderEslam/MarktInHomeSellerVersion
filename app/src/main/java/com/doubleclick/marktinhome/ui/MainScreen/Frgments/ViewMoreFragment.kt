package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnProduct
import com.doubleclick.marktinhome.Adapters.ProductAdapterSmall
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R

class ViewMoreFragment : BaseFragment(), OnProduct {

    lateinit var viewMoreRecyclerView: RecyclerView
    val products by navArgs<ViewMoreFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_viewmore, container, false)
        viewMoreRecyclerView = view.findViewById(R.id.ViewMoreRecyclerView)
        Log.e("products", products.productArray.toString())
        var productAdapterSmall = ProductAdapterSmall(products.productArray,this,5)
        viewMoreRecyclerView.adapter = productAdapterSmall
        return view
    }

    override fun onItemProduct(product: Product?) {
        findNavController().navigate(
            ViewMoreFragmentDirections.actionViewMoreFragmentToProductFragment(
                product!!
            )
        )
    }

}