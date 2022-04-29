package com.doubleclick.marktinhome.ui.ProductActivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.doubleclick.ViewModel.RateViewModel
import com.doubleclick.marktinhome.Adapters.ProductSliderAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.*
import com.doubleclick.marktinhome.R
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import java.util.*


class productFragment : BaseFragment() {


    private lateinit var fab: FloatingActionButton
    private lateinit var banner_slier_view_pager: ViewPager
    private lateinit var productName: TextView
    private lateinit var trarmark: TextView
    private lateinit var price: TextView
    private lateinit var lastPrice: TextView
    private lateinit var description: TextView
    private lateinit var TotalRating: TextView;
    private lateinit var yourRate: RatingBar;
    private lateinit var rateViewModel: RateViewModel;
    private lateinit var addToggalsLinearLayout: LinearLayout
    lateinit var plus: ImageView
    lateinit var mins: ImageView
    lateinit var quantity: TextView
    var qNumber: Int = 0
    lateinit var share: ImageView
    lateinit var pieChartView: PieChartView
    lateinit var ratingSeller: TextView
    private var ToggleItem: String? = ""
    lateinit var comments: TextView;
    lateinit var radioGroup: RadioGroup
    lateinit var webView: WebView


    private val product by navArgs<productFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_product, container, false)
        rateViewModel = ViewModelProvider(this)[RateViewModel::class.java]
        fab = view.findViewById(R.id.fab)
        banner_slier_view_pager = view.findViewById(R.id.banner_slier_view_pager)
        productName = view.findViewById(R.id.productName)
        trarmark = view.findViewById(R.id.trarmark)
        price = view.findViewById(R.id.price)
        webView = view.findViewById(R.id.webView)
        lastPrice = view.findViewById(R.id.lastPrice)
        description = view.findViewById(R.id.description)
        TotalRating = view.findViewById(R.id.TotalRating)
        yourRate = view.findViewById(R.id.yourRate);
        comments = view.findViewById(R.id.comments);
        addToggalsLinearLayout = view.findViewById(R.id.addToggalsLinearLayout);
        plus = view.findViewById(R.id.plus)
        quantity = view.findViewById(R.id.quantity)
        mins = view.findViewById(R.id.mins)
        share = view.findViewById(R.id.share);
        ratingSeller = view.findViewById(R.id.ratingSeller)
        pieChartView = view.findViewById(R.id.pieChartView);
        radioGroup = view.findViewById(R.id.radioGroup)
        productName.text = product.product!!.productName
        trarmark.text = product.product!!.tradeMark
        price.text = product.product!!.price.toString()
        lastPrice.text = product.product!!.lastPrice.toString()
        if (product.product!!.description.contains("</")) {
            description.visibility = View.GONE
            webView.loadDataWithBaseURL(
                null,
                product.product!!.description,
                "text/html",
                "utf-8",
                null
            );
        } else {
            description.text = product.product!!.description
        }
        var spliter = product!!.product!!.toggals.toString().replace("[", "").replace("]", "")
            .replace(" ", "").split(",")
        for (i in 0 until spliter.size) {
            var togal = RadioButton(requireContext())
            togal.text = spliter[i]
            togal.setOnClickListener {
                ToggleItem = spliter[i]
            }
            radioGroup.addView(togal)
        }
        ratingSeller.text = product.product!!.ratingSeller.toInt().toString()
        setBannerSliderViewPager(product.product!!.images)
        rateViewModel.getMyRate(myId, product.product!!.productId)
        rateViewModel.myRateing.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                yourRate.rating = it.rate.toFloat();
            }
        })
        rateViewModel.getAllRate(product.product!!.productId)
        rateViewModel.allRateing.observe(viewLifecycleOwner, Observer {
            TotalRating.text = it.size.toString() + " ratings"
            val map: HashMap<String, Any> = HashMap();
            map["TotalRating"] = (it.size);
            reference.child(PRODUCT).child(product.product!!.productId).updateChildren(map);
            var r1 = 0f;
            var r2 = 0f;
            var r3 = 0f;
            var r4 = 0f;
            var r5 = 0f
            val list: MutableList<SliceValue> = ArrayList();
            for (i in it) {
                if (0.0 < i.rate.toFloat() && i.rate.toFloat() <= 1.0) {
                    r1 += 1
                    list.add(SliceValue(r1, Color.RED))
//                    progressBar1.progress = ((r1.toInt() / it.size) * 100)
//                    tvRate1.text = r1.toInt().toString()

                }
                if (1.0 < i.rate.toFloat() && i.rate.toFloat() <= 2.0) {
                    r2 += 1
                    list.add(SliceValue(r2, Color.RED))
//                    progressBar2.progress = ((r2.toInt() / it.size) * 100)
//                    tvRate2.text = r2.toInt().toString()

                }
                if (2.0 < i.rate.toFloat() && i.rate.toFloat() <= 3.0) {
                    r3 += 1
                    list.add(SliceValue(r3, Color.YELLOW))
//                    progressBar3.progress = ((r3.toInt() / it.size) * 100)
//                    tvRate3.text = r3.toInt().toString()

                }
                if (3.0 < i.rate.toFloat() && i.rate.toFloat() <= 4.0) {
                    r4 += 1
                    list.add(SliceValue(r4, Color.YELLOW))
//                    progressBar4.progress = ((r4.toInt() / it.size) * 100)
//                    tvRate4.text = r4.toInt().toString()

                }
                if (4.0 < i.rate.toFloat() && i.rate.toFloat() <= 5.0) {
                    r5 += 1
                    list.add(SliceValue(r5, Color.GREEN))
//                    progressBar5.progress = ((r5.toInt() / it.size) * 100)
//                    tvRate5.text = r5.toInt().toString()
                }
            }
            val data = PieChartData(list);
            data.setHasCenterCircle(true)
            data.setHasLabels(true)
            pieChartView.pieChartData = data;
        })

        fab.setOnClickListener { v: View? ->
            if (qNumber != 0 && !ToggleItem.equals("")) {
                val id = myId + ":" + product.product!!.productId
                val map: HashMap<String, Any> = HashMap();
                map["ProductId"] = product.product!!.productId;
                map["BuyerId"] = myId;
                map["SellerId"] = product.product!!.adminId;
                map["TotalPrice"] =
                    (qNumber.toDouble() * product.product!!.price.toDouble()).toLong();
                map["Quantity"] = qNumber.toLong();
                map["price"] = product.product!!.price.toLong();
                map["images"] = product.product!!.images;
                map["productName"] = product.product!!.productName;
                map["lastPrice"] = product.product!!.lastPrice
                map["id"] = id;
                map["ToggleItem"] = ToggleItem!!
                reference.child(CART).child(id).setValue(map);
            } else {
                ShowToast(context, "you can't order less than one!");
            }


        }

        yourRate.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            var id = myId + ":" + product.product!!.productId
            if (rating > 0f) {
                var map: HashMap<String, Any> = HashMap();
                map["id"] = id
                map["rate"] = rating.toString()
                map["productId"] = product.product!!.productId
                map["myId"] = myId
                reference.child(RATE).child(id).updateChildren(map);
            }
            if (rating == 0f) {
                reference.child(RATE).child(id).removeValue();

            }
        }

        plus.setOnClickListener {
            qNumber++
            quantity.text = qNumber.toString()
        }

        mins.setOnClickListener {

            if (quantity.text.toString() == "0") {
                qNumber = 1;
                quantity.text = qNumber.toString()
                ShowToast(context, "you can't order less than one!");
                return@setOnClickListener
            } else {
                qNumber--
                quantity.text = qNumber.toString()
            }

        }

        share.setOnClickListener {
            ShareProduct()
        }


        comments.setOnClickListener {
            findNavController().navigate(
                productFragmentDirections.actionProductFragmentToCommentsFragment(
                    product.product!!.productId
                )
            )
        }
        return view;
    }


    fun setBannerSliderViewPager(list: String?) {
        val sliderAdapter = ProductSliderAdapter(list)
        banner_slier_view_pager.adapter = sliderAdapter
        banner_slier_view_pager.clipToPadding = false
        banner_slier_view_pager.pageMargin = 20
    }


    fun ShareProduct() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                "https://www.market.doublethink.com/" + product.product!!.productId
            )
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}