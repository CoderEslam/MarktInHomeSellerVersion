package com.doubleclick.marktinhome.Seller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnOrder
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.ViewModel.OrderViewModel
import com.doubleclick.marktinhome.Adapters.OrderAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Constantes.*
import com.doubleclick.marktinhome.Model.Orders
import com.doubleclick.marktinhome.R
import java.util.*
import kotlin.collections.HashMap


class OrderSelllerFragment : BaseFragment(), OnOrder {

    lateinit var MyOrder: RecyclerView;
    lateinit var cartViewModel: CartViewModel
    lateinit var orderViewModel: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_order_selller, container, false)
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        orderViewModel = ViewModelProvider(this)[OrderViewModel::class.java]
        orderViewModel.myOrderLiveData.observe(viewLifecycleOwner, Observer {
            var orderAdapter: OrderAdapter = OrderAdapter(it, this)
            MyOrder.adapter = orderAdapter;
        })
        MyOrder = view.findViewById(R.id.MyOrder);

        return view;
    }


    override fun OnOKItemOrder(orders: Orders?) {
        var time = Date().time;
        val pushId = myId + ":" + orders!!.productId + ":" + time
        val map: HashMap<String, Any> = HashMap();
        map["ProductId"] = orders.productId;
        map["BuyerId"] = orders.buyerId;
        map["SellerId"] = myId;
        map["TotalPrice"] = orders.totalPrice;
        map["Quantity"] = orders.quantity;
        map["price"] = orders.price;
        map["images"] = orders.images;
        map["productName"] = orders.productName;
        map["id"] = pushId;
        map["date"] = time;
        map["address"] = orders.address;
        map["phone"] = orders.phone;
        map["anotherPhone"] = orders.anotherPhone;
        map["locationUri"] = orders.locationUri;
        map["ToggleItem"] = orders.toggleItem;
        reference.child(RECENTORDER).child(pushId).updateChildren(map);
        reference.child(ORDERS).child(orders.id)
            .removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    ShowToast(context, "Deliverd")
                }
            }
    }

    override fun OnCancelItemOrder(orders: Orders?) {
        reference.child(ORDERS).child(orders!!.id)
            .removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    ShowToast(context, "Deleted")
                }
            }
    }

}