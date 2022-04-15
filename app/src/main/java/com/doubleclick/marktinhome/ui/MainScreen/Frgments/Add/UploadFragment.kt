package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add


import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.divyanshu.colorseekbar.ColorSeekBar
import com.doubleclick.RichEditor.sample.RichEditorActivity
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.ImageAdapter
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
import java.util.*


class UploadFragment : BaseFragment() {


    lateinit var marke: String
    private var IMAGES_REQUEST: Int = 100
    private lateinit var productName: EditText;
    private lateinit var productPrice: EditText;
    private lateinit var productLastPrice: EditText;
    private lateinit var RichTable: FrameLayout;
    private lateinit var description: EditText;
    private lateinit var keywords: EditText
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
    lateinit var addTableRow: ImageView
    lateinit var addView: ImageView
    lateinit var addTableLayout: TableLayout
    private lateinit var builder: AlertDialog.Builder

    val parent_child by navArgs<UploadFragmentArgs>()


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
        var view = inflater.inflate(R.layout.fragment_upload, container, false)
        productName = view.findViewById(R.id.productName);
        productPrice = view.findViewById(R.id.productPrice);
        productLastPrice = view.findViewById(R.id.productLastPrice);
        description = view.findViewById(R.id.description);
        RichTable = view.findViewById(R.id.RichTable);
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
        addTableRow = view.findViewById(R.id.addTableRow);
        addTableLayout = view.findViewById(R.id.addTableLayout);
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
            UploadImages(
                productName.text.toString(),
                productPrice.text.toString().toDouble(),
                productLastPrice.text.toString().toDouble(),
                description.text.toString(),
                keywords.text.toString(),
                marke,
                parent_child.parent!!.pushId,
                parent_child.child!!.pushId,
                parent_child.parent!!.name,
                parent_child.child!!.name
            )
        }
        selectImages.setOnClickListener {
            openImage()
        }

        addView.setOnClickListener {
            builder = AlertDialog.Builder(requireContext())
            var radio = RadioButton(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.add_toggal, null, false)
            val editorder: TextInputEditText = view.findViewById(R.id.editname)
            val color_seek_bar: ColorSeekBar = view.findViewById(R.id.color_seek_bar);
            color_seek_bar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
                override fun onColorChangeListener(color: Int) {
                    //gives the selected color
                    editorder.setBackgroundColor(color)
                }
            })
            builder.setTitle("Add Options")
            builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                radio.setText("" + editorder.text.toString().trim())
                mapToggleButton["" + addToggleButton.childCount] = editorder.text.toString().trim()
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
        addTableRow.setOnClickListener {
            var tableRow = TableRow(context);
            tableRow.orientation = LinearLayout.VERTICAL
            var view = LayoutInflater.from(context).inflate(R.layout.table_row, null, false);
            tableRow.addView(view)
            addTableLayout.addView(tableRow)
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
            val pd = ProgressDialog(requireContext())
            pd.setMessage("Uploading")
            pd.show()
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

            pd.dismiss()
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
        map["description"] = descroiprion.toString()
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


}

