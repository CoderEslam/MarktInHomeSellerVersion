package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.Manifest
import android.animation.Animator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devlomi.record_view.OnRecordListener
import com.devlomi.record_view.RecordButton
import com.devlomi.record_view.RecordView
import com.doubleclick.Api.APIService
import com.doubleclick.ViewModel.ChatViewModel
import com.doubleclick.marktinhome.Adapters.BaseMessageAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.*
import com.doubleclick.marktinhome.Model.Constantes.CHATS
import com.doubleclick.marktinhome.Model.Constantes.USER
import com.doubleclick.marktinhome.Notifications.Client
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.RealmDatabase.ChatRealm
import com.doubleclick.marktinhome.RealmDatabase.RealmBaseAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.vanniktech.emoji.EmojiPopup
import de.hdodenhof.circleimageview.CircleImageView
import io.realm.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.security.SecureRandom
import java.util.*


class ChatFragment : BaseFragment(), OnMapReadyCallback {


    private lateinit var sendText: ImageView
    private lateinit var et_text_message: EditText
    private lateinit var chatRecycler: RecyclerView;
    private lateinit var chatViewModel: ChatViewModel
    private lateinit var chatAdapter: BaseMessageAdapter
    private lateinit var recordView: RecordView
    private lateinit var sendRecord: RecordButton
    private lateinit var mediaRecorder: MediaRecorder
    private lateinit var googleMap: GoogleMap
    var supportMapFragment: SupportMapFragment? = null
    var mLocationRequest: LocationRequest? = null
    var locationManager: LocationManager? = null
    var client: FusedLocationProviderClient? = null
    private var PICK_CONTACT = 100
    private val REQUEST_CODE = 101;
    private lateinit var file: ImageView
    private lateinit var video: ImageView
    private lateinit var contact: ImageView
    private lateinit var image: ImageView
    private lateinit var location: ImageView
    private lateinit var emotion: ImageView
    private lateinit var attach_file: ImageView
    private lateinit var layout_text: ConstraintLayout
    private lateinit var profile_image: CircleImageView
    private lateinit var continer_attacht: ConstraintLayout;
    private lateinit var username: TextView;
    private lateinit var status: TextView;
    private lateinit var apiService: APIService
    private var realm: Realm? = null


    private lateinit var storageReference: StorageReference
    var fileType: String? = null


    private var chats: ArrayList<Chat> = ArrayList();
    var audioPath: String? = null
    private var cklicked = true
    private var user: User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.isEmpty) {
                val User by navArgs<ChatFragmentArgs>()
                user = User.user;
            } else {
                user = it.getSerializable("user") as User?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        realm = Realm.getDefaultInstance();
        var realmBase = RealmBaseAdapter(realm!!.where(ChatRealm::class.java).findAll());
        Log.e("Allllllllll", realm!!.where(ChatRealm::class.java).findAll().asJSON().toString());
        sendText = view.findViewById(R.id.sendText);
        et_text_message = view.findViewById(R.id.et_text_message);
        continer_attacht = view.findViewById(R.id.continer_attacht);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService::class.java)
        supportMapFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        client = LocationServices.getFusedLocationProviderClient(requireContext())
        locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        chatRecycler = view.findViewById(R.id.chatRecycler);
        chatRecycler.setHasFixedSize(true);
        sendRecord = view.findViewById(R.id.sendRecord);
        recordView = view.findViewById(R.id.recordView);
        emotion = view.findViewById(R.id.emotion);
        layout_text = view.findViewById(R.id.layout_text)
        attach_file = view.findViewById(R.id.attach_file);
        sendRecord.setRecordView(recordView)
        file = view.findViewById(R.id.file)
        location = view.findViewById(R.id.location)
        image = view.findViewById(R.id.image)
        video = view.findViewById(R.id.video)
        contact = view.findViewById(R.id.contact)
        profile_image = view.findViewById(R.id.profile_image)
        username = view.findViewById(R.id.username)
        status = view.findViewById(R.id.status)
        chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        chatViewModel.ChatById(user!!.id)
        Glide.with(requireContext()).load(user!!.image).into(profile_image)
        username.text = user!!.name;
        status.text = user!!.status;

//        chatViewModel.myChat.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
////            chats = it;
//        })
        sendText.setOnClickListener {
            sentMessage(et_text_message.text.toString().trim(), "text")
        }
        chatViewModel.newInsertChat().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            chats.add(it)
            chatAdapter = BaseMessageAdapter(chats, myId);
            chatRecycler.adapter = chatAdapter
            chatAdapter.notifyItemInserted((chatRecycler.adapter as BaseMessageAdapter).itemCount - 1)
            chatRecycler.scrollToPosition((chatRecycler.adapter as BaseMessageAdapter).itemCount - 1)
            chatRecycler.smoothScrollToPosition((chatRecycler.adapter as BaseMessageAdapter).itemCount - 1)
        });


        val emojiPopup =
            EmojiPopup.Builder.fromRootView(view.findViewById(R.id.root_view)).build(
                et_text_message
            )
        emotion.setOnClickListener {
            if (cklicked) {
                emojiPopup.toggle()
                cklicked = false
                emotion.setImageDrawable(resources.getDrawable(R.drawable.keyboard))
            } else {
                emojiPopup.dismiss()
                cklicked = true
                emotion.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_insert_emoticon_24))
            }
        }
        attach_file.setOnClickListener {
            if (continer_attacht.visibility == View.GONE) {
                showLayout()
            } else {
                hideLayout()
            }
        }
        et_text_message.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                sendRecord.isListenForRecord = true
                layout_text.visibility = View.VISIBLE
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length == 0) {
                    status("online")
                    sendRecord.visibility = View.VISIBLE
                    sendText.visibility = View.GONE
                    recordView.visibility = View.VISIBLE
                    sendRecord.isListenForRecord = true
                    layout_text.visibility = View.GONE
                    attach_file.visibility = View.VISIBLE
                } else {
                    layout_text.visibility = View.VISIBLE
                    sendRecord.isListenForRecord = true
                    //IMPORTANT
                    sendRecord.visibility = View.GONE
                    sendText.visibility = View.VISIBLE
                    recordView.visibility = View.GONE
                    attach_file.visibility = View.GONE
                    status("typing...")
                    if (sendRecord.isListenForRecord) {
                        sendRecord.isListenForRecord = false
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {
                sendRecord.isListenForRecord = true
                layout_text.visibility = View.VISIBLE
            }
        })
        //Cancel Bounds is when the Slide To Cancel text gets before the timer . default is 8
        //Cancel Bounds is when the Slide To Cancel text gets before the timer . default is 8
        recordView.cancelBounds = 8f
        recordView.setSmallMicColor(Color.parseColor("#FF4081"))
        //prevent recording under one Second
        //prevent recording under one Second
        recordView.setLessThanSecondAllowed(false)
        recordView.setSlideToCancelText("Slide To Cancel")
        recordView.setCustomSounds(R.raw.record_start, R.raw.record_finished, 0)
        recordView.setOnRecordListener(object : OnRecordListener {
            override fun onStart() {
                status("recording...")
                recordView.visibility = View.VISIBLE
                layout_text.visibility = View.INVISIBLE
                setUpRecording()
                try {
                    mediaRecorder.prepare()
                    mediaRecorder.start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                sendText.visibility = View.GONE
                Log.d("RecordView", "onStart")
                Toast.makeText(requireContext(), "OnStartRecord", Toast.LENGTH_SHORT).show()
            }

            override fun onCancel() {
                mediaRecorder.reset()
                mediaRecorder.release()
                status("online")
                val file = audioPath?.let { File(it) }
                if (file != null) {
                    if (file.exists()) {
                        file.delete()
                    }
                }
                layout_text.visibility = View.VISIBLE
            }

            override fun onFinish(recordTime: Long) {
                layout_text.visibility = View.VISIBLE
                status("online")
                try {
                    mediaRecorder.stop()
                    mediaRecorder.release()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                sendText.visibility = View.VISIBLE
                sendRecodingMessage(audioPath)
            }

            override fun onLessThanSecond() {
                mediaRecorder.reset()
                mediaRecorder.release()
                val file = audioPath?.let { File(it) }
                if (file != null) {
                    if (file.exists()) {
                        file.delete()
                    }
                }
                layout_text.visibility = View.VISIBLE
                sendText.visibility = View.VISIBLE
            }
        })
        recordView.setOnBasketAnimationEndListener {
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
            Log.d("RecordView", "Basket Animation Finished")
        }
        image.setOnClickListener {
            fileType = "image"
            openFiles("image/*")
        }
        video.setOnClickListener {
            fileType = "video"
            openFiles("video/*")
        }
        file.setOnClickListener {
            fileType = "file"
            openFiles("application/*")
        }
        location.setOnClickListener {
            getMyLocation()
        }
        contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent, PICK_CONTACT)
        }
        return view;
    }

    private fun sentMessage(text: String, type: String) {
        val map: HashMap<String, Any> = HashMap()
        val id = reference.push().key.toString()
        val time = Date().time;
        map["sender"] = myId
        map["message"] = text
        map["type"] = type
        map["receiver"] = user!!.id // Id of Admin
        map["date"] = time
        map["id"] = id
        map["StatusMessage"] = "Uploaded"
//        reference.child(CHATS).child(id).updateChildren(map)
        upload(id, map);
        et_text_message.setText("")
        makeChatList();
        sendNotifiaction(text);
        realm!!.beginTransaction()
        val chatRealm =
            realm!!.createObject(ChatRealm::class.java, SecureRandom().nextInt(1000000000))
        chatRealm.id = id;
        chatRealm.sender = myId;
        chatRealm.type = type;
        chatRealm.message = text;
        chatRealm.receiver = user!!.id;
        chatRealm.date = time;
        chatRealm.statusMessage = "Uploaded";
        realm!!.commitTransaction()


    }

    private fun upload(id: String, map: HashMap<String, Any>) {
        reference.child(CHATS).child(myId).child(user!!.id.toString())
            .child(id).updateChildren(map);
        reference.child(CHATS).child(user!!.id.toString()).child(myId)
            .child(id).updateChildren(map);
    }

    private fun makeChatList() {
        val map1: HashMap<String, Any> = HashMap();
        map1["id"] = user!!.id
        map1["time"] = -1 * Date().time;
        reference.child(Constantes.CHAT_LIST).child(myId).child(user!!.id).updateChildren(map1)
        val map2: HashMap<String, Any> = HashMap();
        map2["id"] = myId
        map2["time"] = -1 * Date().time;
        reference.child(Constantes.CHAT_LIST).child(user!!.id).child(myId).updateChildren(map2)

    }


    private fun getMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val task = client!!.lastLocation
            task.addOnSuccessListener { location ->
                if (location != null) {
                    supportMapFragment!!.getMapAsync {
                        val latLng = LatLng(
                            location.latitude,
                            location.longitude
                        )
                        val uri =
                            "https://www.google.com/maps/?q=" + location.latitude + "," + location.longitude
                        Log.e("uri", uri)
                        sentMessage(uri, "location")
                    }
                } else {
                    Toast.makeText(requireContext(), "Open your location", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun getFilePath(): String {
        val contextWrapper = ContextWrapper(requireContext())
        val file = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        val date = Date()
        val f = File(file, "chat" + date.time + ".mp3")
        return f.path
    }

    private fun setUpRecording() {
        mediaRecorder = MediaRecorder()
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        val file = File(
            Environment.getExternalStorageDirectory(),
            "Chat"
        ) // String f = "/storage/emulated/0/Download";
        if (!file.exists()) {
            file.mkdirs()
        }
        audioPath =
            getFilePath() //file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".3gp";
        mediaRecorder.setOutputFile(audioPath)
    }


    private fun openFiles(mimeType: String) {
        val intent = Intent()
        intent.type = mimeType
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun status(status: String) {
        val hashMap = HashMap<String, Any>()
        hashMap["status"] = status
        reference.child(USER).child(myId).updateChildren(hashMap)
    }

    override fun onResume() {
        super.onResume()
        status("online")
        currentUser(user!!.id!!)
    }

    override fun onPause() {
        super.onPause()
        status("offline")
        currentUser("none")
    }

    private fun currentUser(userid: String) {
        val editor: SharedPreferences.Editor =
            requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit()
        editor.putString("currentuser", userid)
        editor.apply()
    }


    fun sendRecodingMessage(audioPath: String?) {
        if (audioPath != null) {
            val storageReference = FirebaseStorage.getInstance()
                .getReference("/Media/Recording/" + myId + ":" + user!!.id.toString() + System.currentTimeMillis())
            Log.e("audio path", audioPath)
            val audioFile = Uri.fromFile(File(audioPath))
            Log.e("audioFile = ", audioFile.toString())
            storageReference.putFile(audioFile)
                .addOnSuccessListener { success: UploadTask.TaskSnapshot ->
                    val audioUrl = success.storage.downloadUrl
                    audioUrl.addOnCompleteListener { path: Task<Uri> ->
                        if (path.isSuccessful) {
                            val url = path.result.toString()
                            val map: HashMap<String, Any> = HashMap()
                            val time = Date().time
                            val id = reference.push().key.toString()
                            map["sender"] = myId
                            map["receiver"] = user!!.id.toString()
                            map["message"] = url
                            map["type"] = "voice"
                            map["id"] = id
                            map["date"] = time
                            map["StatusMessage"] = "Uploaded" // "Stored" , "beenSeen"
//                            reference.child(CHATS).child(id).setValue(map)
                            upload(id, map);
                            makeChatList()
                            sendNotifiaction("audio")
                        }
                    }
                }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    override fun getFileExtension(uri: Uri?): String? {
        val contentResolver = requireContext().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            sendFileData(data.data!!)
        } else if (requestCode == PICK_CONTACT && resultCode == Activity.RESULT_OK) {
            PickConact(data!!.data)
        }
    }

    @SuppressLint("Range")
    fun PickConact(contactData: Uri?) {
        val c = requireActivity().managedQuery(contactData, null, null, null, null)
        if (c.moveToFirst()) {
            val id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
            val hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
            if (hasPhone.equals("1", ignoreCase = true)) {
                val phones = requireContext().contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                    null, null
                )
                phones!!.moveToFirst()
                val cNumber = phones.getString(phones.getColumnIndex("data1"))
                val name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.e("NameContact", name + cNumber)
                val message = """
                    $name
                    $cNumber
                    """.trimIndent()
                sentMessage(message, "contact")
            }
        }
    }

    private fun showLayout() {
        val radius = Math.max(continer_attacht.width, continer_attacht.height).toFloat()
        val animator =
            ViewAnimationUtils.createCircularReveal(
                continer_attacht,
                continer_attacht.left,
                continer_attacht.top,
                0f,
                radius * 2
            )
        animator.duration = 500
        continer_attacht.visibility = View.VISIBLE
        animator.start()
    }


    private fun hideLayout() {
        val radius = Math.max(continer_attacht.width, continer_attacht.height).toFloat()
        val animator =
            ViewAnimationUtils.createCircularReveal(
                continer_attacht,
                continer_attacht.left,
                continer_attacht.top,
                radius * 2,
                0f
            )
        animator.duration = 500
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                continer_attacht.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        animator.start()
    }

    fun sendFileData(uri: Uri) {
        val uploadTask: StorageTask<*>
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Uploading")
        progressDialog.show()
        if (uri.toString() != "") {
            storageReference =
                FirebaseStorage.getInstance().getReference("/Media/Recording/ChatData")
            val fileReference = storageReference.child(
                System.currentTimeMillis().toString() + "." + getFileExtension(uri)
            )
            uploadTask = fileReference.putFile(uri)
            uploadTask.continueWithTask(Continuation { task ->
                if (!task.isSuccessful) {
                    throw task.exception!!
                }
                fileReference.downloadUrl
            }).addOnCompleteListener(OnCompleteListener<Uri> { task ->
                if (task.isSuccessful) {
                    val url = task.result.toString()
                    val map = HashMap<String, Any>()
                    val id = reference.push().key.toString()
                    map["sender"] = myId
                    map["receiver"] = user!!.id
                    map["message"] = url
                    map["type"] = fileType.toString()
                    map["id"] = id
                    map["date"] = Date().time
                    map["StatusMessage"] = "Uploaded" // "Stored" , "beenSeen"
//                    reference.child(CHATS).child(id).setValue(hashMap)
                    upload(id, map);
                    progressDialog.dismiss()
                    makeChatList()
                    sendNotifiaction(fileType.toString())
                } else {
                    Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }).addOnFailureListener { e ->
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        } else {
            Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendNotifiaction(message: String) {
        val data = Data(
            myId,
            R.mipmap.ic_launcher,
            "${user!!.name.toString()}: $message",
            "New Message",
            user!!.id.toString()
        )
        val sender = Sender(data, user!!.token.toString())
        apiService.sendNotification(sender)
            .enqueue(object : Callback<MyResponse> {
                override fun onResponse(
                    call: Call<MyResponse>,
                    response: Response<MyResponse>
                ) {
                    if (response.code() == 200) {
                        if (response.body()!!.success != 1) {
                            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

                override fun onFailure(call: Call<MyResponse>, t: Throwable) {}
            })
    }
}