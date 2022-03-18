package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.doubleclick.OnItem
import com.doubleclick.OnProduct
import com.doubleclick.Tradmarkinterface
import com.doubleclick.ViewModel.AdvertisementViewModel
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.ViewModel.RecentSearchViewModel
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.ViewMore
import com.doubleclick.marktinhome.Adapters.HomeAdapter
import com.doubleclick.marktinhome.BaseApplication.isNetworkConnected
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.PRODUCT
import com.doubleclick.marktinhome.Model.HomeModel
import com.doubleclick.marktinhome.Model.ParentCategory
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.Model.Trademark
import com.doubleclick.marktinhome.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class HomeFragment : BaseFragment(), OnItem, OnProduct, Tradmarkinterface, ViewMore {


    lateinit var MainRecyceler: RecyclerView
    private lateinit var productViewModel: ProductViewModel
    private lateinit var homeModels: ArrayList<HomeModel>
    lateinit var homeAdapter: HomeAdapter
    lateinit var advertisementViewModel: AdvertisementViewModel
    lateinit var trademarkViewModel: TradmarkViewModel
    lateinit var animationView: LottieAnimationView
    lateinit var recentSearchViewModel: RecentSearchViewModel
    private var idProduct: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idProduct = it.getString("idProduct", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        MainRecyceler = view.findViewById(R.id.MainRecyceler)
        animationView = view.findViewById(R.id.animationView);
        homeModels = ArrayList()
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        advertisementViewModel = ViewModelProvider(this)[AdvertisementViewModel::class.java];
        trademarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
        recentSearchViewModel = ViewModelProvider(this)[RecentSearchViewModel::class.java]
        productViewModel.parent.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(0, HomeModel(it, HomeModel.TopCategory, this))
            }
        });
        advertisementViewModel.allAdv.observe(viewLifecycleOwner, Observer {
            homeModels.add(1, HomeModel(it, HomeModel.Advertisement))
        });
        productViewModel.getProduct().observe(
            viewLifecycleOwner,
            Observer { products: ArrayList<Product?>? ->
                if (products!!.size != 0) {
                    homeModels.add(HomeModel(products, HomeModel.Products, this))
                    homeAdapter = HomeAdapter(homeModels);
                    MainRecyceler.adapter = homeAdapter
                    animationView.visibility = View.GONE
                } else {
                    animationView.visibility = View.VISIBLE
                }

            });
        productViewModel.getTopDealsLiveData().observe(viewLifecycleOwner, Observer {
            homeModels.add(HomeModel(it, HomeModel.TopDeal, this, this));
        })



        trademarkViewModel.allMark.observe(viewLifecycleOwner, Observer {
            homeModels.add(HomeModel(it, HomeModel.Trademarks, this))
        });


        recentSearchViewModel.lastSearchListLiveDataOneTime.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(HomeModel.RecentSearch, it, this, this, 0))
            }
        })

        if (idProduct != "") {
            reference.child(PRODUCT).child(idProduct).addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    try {
                        if (isNetworkConnected()) {
                            if (snapshot.exists()) {
                                var product: Product? =  snapshot.getValue(Product::class.java)
                                Log.e("ggggggggggggg", product.toString())
                                findNavController().navigate(
                                    HomeFragmentDirections.actionHomeFragmentToProductFragment(
                                        product
                                    )
                                )
                            }
                        } else {
                            ShowToast(context, "No Internet Connection")
                        }
                    } catch (e: Exception) {

                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }

            })

        }


        return view;
    }

    override fun onItem(parentCategory: ParentCategory?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToFilterParentFragment(
                parentCategory
            )
        )
    }

    override fun onItemLong(parentCategory: ParentCategory?) {}

    override fun onItemProduct(product: Product?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToProductFragment(
                product
            )
        )
    }

    override fun AllTradmark(tradmark: ArrayList<Trademark?>?) {}

    override fun AllNameTradmark(names: List<String?>?) {}

    override fun OnItemTradmark(tradmark: Trademark?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToTrademarkFragment(
                tradmark
            )
        )
    }

    override fun getViewMore(products: ArrayList<Product>) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToViewMoreFragment(
                products.toTypedArray()
            )
        )
    }
}

