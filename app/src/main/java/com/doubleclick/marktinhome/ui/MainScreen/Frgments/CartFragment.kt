package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnCartLisnter
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.marktinhome.Adapters.CartAdapter
import com.doubleclick.marktinhome.Adapters.CartAdapter.CartViewHolder
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes.CART
import com.doubleclick.marktinhome.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : BaseFragment(), OnCartLisnter {


    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartRecycler: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var Continue: TextView
    private lateinit var totalPrice: TextView
    private var Total = 0.0
    lateinit var MyOrder: TextView

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
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        cartRecycler = view.findViewById(R.id.cartRecycler)
        Continue = view.findViewById(R.id.Continue)
        totalPrice = view.findViewById(R.id.totalPrice)
        MyOrder = view.findViewById(R.id.MyOrder);

        cartViewModel.CartLiveData().observe(viewLifecycleOwner) { carts: ArrayList<Cart> ->
            if (carts.size != 0) {
                Total = 0.0
                cartAdapter = CartAdapter(carts, this)
                cartRecycler.adapter = cartAdapter
                for (i in carts.indices) {
                    Total += carts[i].price.toDouble() * carts[i].quantity.toDouble()
                    totalPrice.text = Total.toString()
                }
            }
        }
        Continue.setOnClickListener { v ->
            try {
                findNavController().navigate(CartFragmentDirections.actionMenuCartToAddressFragment())
            } catch (e: Exception) {

            }

        }



        MyOrder.setOnClickListener {
            findNavController().navigate(CartFragmentDirections.actionMenuCartToOrderSelllerFragment())
        }

        return view
    }


    override fun onPause() {
        super.onPause()
        Total = 0.0
    }

    override fun OnAddItemOrder(cart: Cart?) {
        var quantity: Int = cart!!.quantity.toInt()
        quantity++;
        var map: HashMap<String, Any> = HashMap();
        map.put("Quantity", quantity)
        map.put("TotalPrice", (cart.price.toInt() * quantity).toLong())
        reference.child(CART).child(cart!!.buyerId + ":" + cart.productId).updateChildren(map)
    }

    override fun OnMinsItemOrder(cart: Cart?) {
        var quantity: Int = cart!!.quantity.toInt()
        quantity--;
        var map: HashMap<String, Any> = HashMap();
        map.put("Quantity", quantity)
        map.put("TotalPrice", (cart.price.toInt() * quantity).toLong())
        reference.child(CART).child(cart!!.buyerId + ":" + cart.productId).updateChildren(map)
    }

    override fun OnDeleteItemOrder(cart: Cart?) {
        reference.child(CART).child(cart!!.buyerId + ":" + cart.productId).removeValue()
    }

}