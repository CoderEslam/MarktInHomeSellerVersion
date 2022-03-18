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
import com.airbnb.lottie.LottieAnimationView
import com.doubleclick.OnProduct
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.marktinhome.Adapters.ProductAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.ProductActivity.productFragmentArgs


class TrademarkFragment : BaseFragment(), OnProduct {


    lateinit var trademarkRecycler: RecyclerView
    lateinit var productViewModel: ProductViewModel
    private val trademark by navArgs<TrademarkFragmentArgs>()
    lateinit var animationView: LottieAnimationView
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
        var view = inflater.inflate(R.layout.fragment_trademark, container, false)
        trademarkRecycler = view.findViewById(R.id.trademarkRecycler);
        animationView = view.findViewById(R.id.animationView);
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.ProductWithTrademark(trademark.trademark!!.name)
        productViewModel.ProductWithTrademarkLiveDate().observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                animationView.visibility = View.GONE
                var productAdapter = ProductAdapter(it, this);
                trademarkRecycler.adapter = productAdapter
            } else {
                animationView.visibility = View.VISIBLE
            }

        })

        return view;
    }

    override fun onItemProduct(product: Product?) {
        findNavController().navigate(
            TrademarkFragmentDirections.actionTrademarkFragmentToProductFragment(
                product
            )
        )
    }

}