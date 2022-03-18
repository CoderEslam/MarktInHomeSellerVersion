package com.doubleclick.marktinhome.ui.MainScreen.Comments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doubleclick.ViewModel.CommentsViewModel
import com.doubleclick.ViewModel.UserViewModel
import com.doubleclick.marktinhome.Adapters.CommentAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.COMMENTS
import com.doubleclick.marktinhome.Model.User
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.ProductActivity.productFragmentArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*
import kotlin.collections.HashMap

class CommentsFragment : BaseFragment() {

    lateinit var cartRate: CardView
    lateinit var imageUser: CircleImageView;
    lateinit var yourRateText: EditText;
    lateinit var send: ImageView
    lateinit var starRate: RatingBar
    lateinit var userViewModel: UserViewModel
    lateinit var user: User
    lateinit var putRate: FloatingActionButton
    private var open = false
    private var rating: Float = 0.0f
    private lateinit var commentsViewModel: CommentsViewModel

    private val idproduct by navArgs<CommentsFragmentArgs>()

    lateinit var commentsRecycler: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comments, container, false)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        commentsViewModel = ViewModelProvider(this)[CommentsViewModel::class.java]
        commentsRecycler = view.findViewById(R.id.commentsRecycler);
        cartRate = view.findViewById(R.id.cartRate);
        imageUser = view.findViewById(R.id.imageUser);
        putRate = view.findViewById(R.id.putRate);
        yourRateText = view.findViewById(R.id.yourRateText);
        send = view.findViewById(R.id.send);
        starRate = view.findViewById(R.id.starRate);
        commentsViewModel.getCommentsById(idproduct.idProduct)
        commentsViewModel.commentsLiveDate.observe(viewLifecycleOwner, Observer {
            var commentAdapter = CommentAdapter(it);
            commentsRecycler.adapter = commentAdapter
        })
        userViewModel.user.observe(viewLifecycleOwner, Observer {
            user = it
            Glide.with(requireContext()).load(user.image).into(imageUser)
        })

        starRate.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            this.rating = rating;
        }
        send.setOnClickListener {
            SendRate(yourRateText.text.toString(), rating);
            var animation = AnimationUtils.loadAnimation(context,R.anim.righttoleft)
            cartRate.animation = animation
            cartRate.visibility = View.GONE
            open = true
        }
        putRate.setOnClickListener {
            if (!open) {
                cartRate.visibility = View.VISIBLE
                var animation = AnimationUtils.loadAnimation(context,R.anim.lefttoright)
                cartRate.animation = animation
                open = true
            } else {
                var animation = AnimationUtils.loadAnimation(context,R.anim.righttoleft)
                cartRate.animation = animation
                cartRate.visibility = View.GONE
                open = false
            }
        }

        return view
    }

    private fun SendRate(comment: String, rating: Float) {
        var map: HashMap<String, Any> = HashMap();
        var id = myId + ":" + idproduct.idProduct!!
        map["rateStar"] = rating
        map["comment"] = comment
        map["id"] = id
        map["image"] = user.image
        map["date"] = Date().time
        map["userName"] = user.name
        map["idProduct"] = idproduct.idProduct!!

        reference.child(COMMENTS).child(id).updateChildren(map)

    }


}