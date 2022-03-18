package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnItem
import com.doubleclick.OnProduct
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.marktinhome.Adapters.HomeAdapter
import com.doubleclick.marktinhome.Adapters.ProductAdapter
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.ProductActivity.productFragmentArgs


class FilterParentFragment : Fragment() , OnProduct {

    lateinit var FilterParent: RecyclerView
    private val filterParentFragmentArgs by navArgs<FilterParentFragmentArgs>()
    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_filter_parent, container, false)
        FilterParent = view.findViewById(R.id.FilterRecyclerView);
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.FilterByParent(filterParentFragmentArgs.parentCategory!!.pushId)
        productViewModel.FilterByParentLiveDate().observe(viewLifecycleOwner, Observer {
            var productAdapter = ProductAdapter(it,this)
            FilterParent.adapter = productAdapter
        })
        return view;

    }

    override fun onItemProduct(product: Product?) {
        findNavController().navigate(FilterParentFragmentDirections.actionFilterParentFragmentToProductFragment(product))
    }

}