package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
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
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.size
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.devlomi.record_view.OnRecordListener
import com.devlomi.record_view.RecordButton
import com.devlomi.record_view.RecordView
import com.doubleclick.ViewModel.ChatViewModel
import com.doubleclick.marktinhome.Adapters.BaseMessageAdapter
import com.doubleclick.marktinhome.Adapters.ChatAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Chat
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Constantes.CHATS
import com.doubleclick.marktinhome.Model.Constantes.USER
import com.doubleclick.marktinhome.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import com.vanniktech.emoji.EmojiPopup
import kotlinx.android.synthetic.main.fragment_menu_profile.*
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList


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
    private lateinit var supportMapFragment: SupportMapFragment
    private lateinit var mLocationRequest: LocationRequest
    private lateinit var locationManager: LocationManager
    private lateinit var client: FusedLocationProviderClient
    private var PICK_CONTACT = 100
    private val REQUEST_CODE = 101;
    private var openFile = true
    private lateinit var file: ImageView
    private lateinit var video: ImageView
    private lateinit var contact: ImageView
    private lateinit var image: ImageView
    private lateinit var location: ImageView
    private lateinit var emotion: ImageView
    private lateinit var attach_file: ImageView
    private lateinit var layout_text: ConstraintLayout
    private var chats: ArrayList<Chat> = ArrayList();
    var audioPath: String? = null
    private var cklicked = true
    val user by navArgs<ChatFragmentArgs>()

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
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        sendText = view.findViewById(R.id.sendText);
        et_text_message = view.findViewById(R.id.et_text_message);
//        supportMapFragment = (requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!
        chatRecycler = view.findViewById(R.id.chatRecycler);
        chatRecycler.setHasFixedSize(true);
        sendRecord = view.findViewById(R.id.sendRecord);
        recordView = view.findViewById(R.id.recordView);
        emotion = view.findViewById(R.id.emotion);
        layout_text = view.findViewById(R.id.layout_text)
        attach_file = view.findViewById(R.id.attach_file);
        sendRecord.setRecordView(recordView)
        chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        chatViewModel.ChatById(user.user.id)

        chatViewModel.myChat.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            chats = it;

        })
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

        return view;
    }

    private fun sentMessage(text: String, type: String) {
        val map: HashMap<String, Any> = HashMap()
        val id = reference.push().key.toString()
        map["sender"] = myId
        map["message"] = text
        map["type"] = type
        map["receiver"] = user.user.id // Id of Admin
        map["date"] = Date().time
        map["id"] = id
        reference.child(CHATS).child(id).updateChildren(map)
        et_text_message.setText("")
        makeChatList();
    }

    private fun makeChatList() {
        val map1: HashMap<String, Any> = HashMap();
        map1["id"] = user.user.id
        map1["time"] = Date().time;
        reference.child(Constantes.CHAT_LIST).child(myId).child(user.user.id).updateChildren(map1)
        val map2: HashMap<String, Any> = HashMap();
        map2["id"] = myId
        map2["time"] = Date().time;
        reference.child(Constantes.CHAT_LIST).child(user.user.id).child(myId).updateChildren(map2)

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
            val task = client.lastLocation
            task.addOnSuccessListener { location ->
                if (location != null) {
                    supportMapFragment.getMapAsync {
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
        currentUser(user.user.id!!)
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
                .getReference("/Media/Recording/" + myId + ":" + user.user.id.toString() + System.currentTimeMillis())
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
                            map["receiver"] = user.user.id.toString()
                            map["message"] = url
                            map["type"] = "voice"
                            map["id"] = id
                            map["date"] = time
//                            map["StatusMessage"] = "Uploaded" // "Delivered" , "beenSeen"
                            reference.child(CHATS).child(id).setValue(map)
                            makeChatList()
                        }
                    }
                }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        mLocationRequest = LocationRequest()
        mLocationRequest.interval = 1000
        mLocationRequest.fastestInterval = 1000
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
//            sendingData.sendFileData(
//                requireContext(), FirebaseAuth.getInstance().currentUser!!
//                    .uid, user.user!!.id, data.data, fileType
//            )
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

}