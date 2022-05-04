package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add


import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatSpinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.divyanshu.colorseekbar.ColorSeekBar
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.ImageAdapter
import com.doubleclick.marktinhome.Adapters.KeywordAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.PRODUCT
import com.doubleclick.marktinhome.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup
import com.nex3z.togglebuttongroup.button.CircularToggle
import java.util.*
import kotlin.collections.ArrayList


class UploadFragment : BaseFragment(), KeywordAdapter.OnDelete, KeywordBottomSheet.Keywords {


    lateinit var marke: String
    private var IMAGES_REQUEST: Int = 100
    private lateinit var productName: EditText;
    private lateinit var productPrice: EditText;
    private lateinit var productLastPrice: EditText;
    private lateinit var RichTable: FrameLayout;
    private lateinit var description: EditText;
    private lateinit var keywords: ConstraintLayout
    private lateinit var addKeywords: Button
    private lateinit var keys: RecyclerView;
    private lateinit var trademark: AppCompatSpinner;
    private lateinit var Upload: Button;
    private lateinit var tradmarkViewModel: TradmarkViewModel
    private lateinit var uris: MutableList<Uri>
    private lateinit var productImages: RecyclerView
    private lateinit var downloadUri: HashMap<String, Any>
    lateinit var selectImages: Button
    lateinit var ratingSeller: RatingBar
    lateinit var mapToggleButton: HashMap<String, Any>
    var rate: Float = 0f
    lateinit var addToggleButton: LinearLayout
    lateinit var addView: ImageView
    private lateinit var builder: AlertDialog.Builder
    private var colorToggle: Int = 0
    private var texts: ArrayList<String> = ArrayList();
    private lateinit var keywordAdapter: KeywordAdapter;
    private lateinit var groupColor: SingleSelectToggleGroup
    private lateinit var addViewColor:ImageView
    private var colors: ArrayList<Int> = ArrayList();
    val parent_child by navArgs<UploadFragmentArgs>()
    var begin = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <style>\n" +
            "        table,\n" +
            "        th,\n" +
            "        td {\n" +
            "            border: 2px solid black;\n" +
            "            border-collapse: collapse;\n" +
            "        }\n" +
            "      table{\n" +
            "        width: 100%\n" +
            "      }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>";
    var end = "</body>\n" +
            "\n" +
            "</html>";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_upload, container, false)
        productName = view.findViewById(R.id.productName);
        productPrice = view.findViewById(R.id.productPrice);
        productLastPrice = view.findViewById(R.id.productLastPrice);
        description = view.findViewById(R.id.description);
        RichTable = view.findViewById(R.id.RichTable);
        addKeywords = view.findViewById(R.id.addKeywords);
        groupColor = view.findViewById(R.id.groupColor);
        keys = view.findViewById(R.id.keys);
        addViewColor = view.findViewById(R.id.addViewColor);
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(RichTable.id, RichFragment()).commit()
        trademark = view.findViewById(R.id.trademark);
        Upload = view.findViewById(R.id.Upload);
        keywords = view.findViewById(R.id.keywords);
        productImages = view.findViewById(R.id.productImages);
        selectImages = view.findViewById(R.id.selectImages);
        ratingSeller = view.findViewById(R.id.ratingSeller);
        addToggleButton = view.findViewById(R.id.addToggleButton);
        addView = view.findViewById(R.id.addView);
        uris = ArrayList()
        downloadUri = HashMap();
        mapToggleButton = HashMap();
        tradmarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
        tradmarkViewModel.namesMark.observe(viewLifecycleOwner, Observer {
//            var trademarkAdapter  = TrademarkAdapter(it)
            trademark.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    marke = it.get(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    marke = it.get(0)

                }
            }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it)
            trademark.setAdapter(adapter)
        })

        ratingSeller.setOnRatingBarChangeListener({ ratingBar, rating, fromUser ->
            rate = rating;
        })
        Upload.setOnClickListener {
            if (productName.text.toString() == "") {
                productName.error = "input name of product"
            } else if (productPrice.text.toString() == "") {
                productPrice.error = "input price of product"
            } else if (productLastPrice.text.toString() == "") {
                productLastPrice.error = "input last of product"
            } else if (description.text.toString() == "") {
                description.error = "input description of product"
            } else if (texts.size != 0) {
                Toast.makeText(context, "input keywords of product", Toast.LENGTH_LONG).show()
            } else {
                try {
                    UploadImages(
                        productName.text.toString(),
                        productPrice.text.toString().toDouble(),
                        productLastPrice.text.toString().toDouble(),
                        description.text.toString(),
                        texts.toString(),
                        marke,
                        parent_child.parent!!.pushId,
                        parent_child.child!!.pushId,
                        parent_child.parent!!.name,
                        parent_child.child!!.name
                    )
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "" + resources.getString(R.string.cantUploadEmpty),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        selectImages.setOnClickListener {
            openImage()
        }

        addKeywords.setOnClickListener {
            var keywordBottomSheet = KeywordBottomSheet(this);
            keywordBottomSheet.show(requireActivity().supportFragmentManager, "keywords")
        }

        addView.setOnClickListener {
            builder = AlertDialog.Builder(requireContext())
            var radio = RadioButton(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.add_toggal, null, false)
            val cardView: CardView = view.findViewById(R.id.cardView);
            val editorder: TextInputEditText = view.findViewById(R.id.editname)
            val color_seek_bar: ColorSeekBar = view.findViewById(R.id.color_seek_bar);
            color_seek_bar.visibility = View.INVISIBLE
            builder.setTitle("Add Options")
            builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                radio.setText("" + editorder.text.toString().trim())
                mapToggleButton["" + addToggleButton.childCount] = editorder.text.toString().trim()
                mapToggleButton["color"] = colorToggle
                addToggleButton.addView(radio)
                Log.e("addToggleButton", editorder.text.toString())
                dialog.dismiss()
            })
            builder.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.setView(view)
            builder.show()
        }
        addViewColor.setOnClickListener {
            builder = AlertDialog.Builder(requireContext())
            var circuleToggle = CircularToggle(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.add_toggal, null, false)
            val cardView: CardView = view.findViewById(R.id.cardView);
            val editorder: TextInputEditText = view.findViewById(R.id.editname)
            val color_seek_bar: ColorSeekBar = view.findViewById(R.id.color_seek_bar);
            color_seek_bar.visibility = View.VISIBLE
//            editorder.visibility = View.GONE
            color_seek_bar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
                override fun onColorChangeListener(color: Int) {
                    //gives the selected color
                    colorToggle = color;
//                    circuleToggle.setBackgroundColor(color)
                    cardView.setBackgroundColor(color)
                }
            })
            builder.setTitle("Add Options")
            builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                circuleToggle.setText("" + editorder.text.toString().trim())
//                circuleToggle.setBackgroundColor(colorToggle)
                circuleToggle.markerColor = colorToggle
                groupColor.addView(circuleToggle)
                dialog.dismiss()
            })
            builder.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.setView(view)
            builder.show()
        }
        return view;
    }

    override fun openImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, IMAGES_REQUEST)
    }


    fun ShowHTML(html: String) {
        HTMLText = html;
//        Log.e("HTMLLLLLLLLLLLLLL", "" + begin + HTMLText + end);
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGES_REQUEST && resultCode == RESULT_OK) {
            val clip = data!!.clipData
            if (clip != null) {
                for (j in 0 until clip.itemCount) {
                    val item = clip.getItemAt(j)
                    uris.add(item.uri)
                    Log.e("clipData", uris.toString())
                }
                var ImageAdapter = ImageAdapter(uris);
                productImages.adapter = ImageAdapter
            }
        }
    }

    override fun getFileExtension(uri: Uri?): String? {
        val contentResolver = requireContext().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
    }

    fun UploadImages(
        name: String?,
        price: Double,
        LastPrice: Double,
        descroiprion: String,
        keywords: String,
        trademark: String?,
        ParentId: String?,
        ChildId: String?,
        ParentName: String?,
        ChildName: String?
    ) {
        if (uris.size != 0) {
            progress();
            var storageReference = FirebaseStorage.getInstance().getReference("Uploads")
            for (i in 0 until uris.size) {
                val fileReference = storageReference.child(
                    System.currentTimeMillis().toString() + "." + getFileExtension(uris[i])
                )
                val uploadTask: StorageTask<*>
                uploadTask = fileReference.putFile(uris[i])
                uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot?, Task<Uri?>?> { task ->
                    if (!task.isSuccessful) {
                        throw task.exception!!
                    }
                    fileReference.downloadUrl.addOnSuccessListener(OnSuccessListener {
                        downloadUri["" + i + ""] = it
                        Log.e("uri", downloadUri.toString());

                    })
                }).addOnCompleteListener { task ->
                    if (task.isSuccessful()) {
                        if (uris.size == downloadUri.values.size) {
                            UplaodAllData(
                                name,
                                price,
                                LastPrice,
                                descroiprion,
                                keywords,
                                trademark,
                                ParentId,
                                ChildId,
                                ParentName,
                                ChildName,
                            )
                        }
                    }
                }
            }
        }
    }

    fun UplaodAllData(
        name: String?,
        price: Double,
        LastPrice: Double,
        descroiprion: String,
        keywords: String,
        trademark: String?,
        ParentId: String?,
        ChildId: String?,
        ParentName: String?,
        ChildName: String?,
    ) {
        val push = reference.push().key.toString()
        val date = Date()
        val map: HashMap<String, Any> = HashMap()
        var lastMoney = 0.0
        var money = 0.0
        if (price > LastPrice) {
            var helper = LastPrice;
            lastMoney = price
            money = helper;
        } else {
            money = price
            lastMoney = LastPrice
        }
        val discount = (-1 * (100 - ((price / LastPrice) * 100.0)))
        map["productId"] = push.toString()
        map["price"] = money
        if (descroiprion.toString() != "" || HTMLText.toString() != "") {
            map["description"] = descroiprion.toString() + begin + HTMLText + end
        }
        map["date"] = (-1 * (date.time))
        map["adminId"] = myId.toString()
        map["productName"] = name!!.toString()
        map["lastPrice"] = lastMoney
        map["tradeMark"] = trademark!!.toString()
        map["parentCategoryId"] = ParentId!!.toString()
        map["childCategoryId"] = ChildId!!.toString()
        map["parentCategoryName"] = ParentName!!.toString()
        map["childCategoryName"] = ChildName!!.toString()
        map["keywords"] = keywords.toString()
        map["TotalRating"] = 0
        map["discount"] = discount
        map["ratingSeller"] = rate
        map["Images"] = downloadUri.values.toString()
        map["Toggals"] = mapToggleButton.values.toString()
        reference.child(PRODUCT).child(Objects.requireNonNull(push)).updateChildren(map)
    }

    private fun progress() {
        val builder = AlertDialog.Builder(requireContext());
        val view =
            LayoutInflater.from(context).inflate(R.layout.upload_progress_layout, null, false);
//        builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
//
//        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            var intent = requireActivity().intent;
            requireActivity().finish()
            startActivity(intent)
        })
        builder.setView(view)
        builder.show()

    }

    override fun onItemDelete(pos: Int) {
        try {
            texts.removeAt(pos)
            keywordAdapter.notifyItemRemoved(pos)
        } catch (e: IndexOutOfBoundsException) {

        }

    }

    override fun ItemsKeyword(items: ArrayList<String>) {
        texts = items;
        keywordAdapter = KeywordAdapter(items, this)
        keys.adapter = keywordAdapter
    }

}

