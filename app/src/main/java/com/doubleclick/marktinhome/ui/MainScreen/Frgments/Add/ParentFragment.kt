package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnItem
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.marktinhome.Adapters.ParentAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Constantes.PARENTS
import com.doubleclick.marktinhome.Model.ParentCategory
import com.doubleclick.marktinhome.R
import com.google.android.material.textfield.TextInputEditText


class ParentFragment : BaseFragment(), OnItem {


    private lateinit var productViewModel: ProductViewModel
    private lateinit var ParentRecyceler: RecyclerView;
    private lateinit var toolbar: Toolbar;
    private lateinit var addParent: Button;
    private lateinit var builder: AlertDialog.Builder


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
        var view = inflater.inflate(R.layout.fragment_parent, container, false)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        ParentRecyceler = view.findViewById(R.id.ParentRecyceler);
        toolbar = view.findViewById(R.id.toolbar);
        addParent = view.findViewById(R.id.addParent);
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        toolbar.title = ""
        productViewModel.parent.observe(viewLifecycleOwner, Observer {
            var parentAdapter = ParentAdapter(it, this)
            ParentRecyceler.adapter = parentAdapter;
        })
        addParent.setOnClickListener {
//            builder = context.let { it1 -> AlertDialog.Builder(it1!!) };
            builder = AlertDialog.Builder(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.layout_upload, null, false)
            val upload = view.findViewById<TextView>(R.id.upload)
            val name: EditText = view.findViewById(R.id.name)
            upload.setOnClickListener {
                openImage(name.getText().toString(), Constantes.PARENTS, "")
            }
            builder.setView(view)
            builder.show()
        }
        return view;
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ParentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_item, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> ShowToast(context, "gooood")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItem(parentCategory: ParentCategory?) {
        if (parentCategory != null) {
            findNavController().navigate(
                ParentFragmentDirections.actionParentFragmentToChildFragment(
                    parentCategory
                )
            )
        }
    }

    override fun onItemLong(parentCategory: ParentCategory?) {
        builder = AlertDialog.Builder(requireContext())
        val view = LayoutInflater.from(context).inflate(R.layout.edit_on_product, null, false)
        val editnameProduct: TextInputEditText = view.findViewById(R.id.editProduct)
        val editorder: TextInputEditText = view.findViewById(R.id.editorder)
        val ok: TextView = view.findViewById(R.id.ok)
        ok.setOnClickListener {
            val map = HashMap<String, Any>()
            if (!editorder.text.toString().equals("")) {
                map.put("order", "-" + editorder.text.toString());
                editorder.setText("")
            }
            if (!editnameProduct.text.toString().equals("")) {
                map.put("name", editnameProduct.text.toString());
                editnameProduct.setText("")
            }
            if (!editnameProduct.text.toString().equals("") || !editorder.text.toString().equals("")
            ) {
                reference.child(PARENTS).child(parentCategory!!.pushId).updateChildren(map);
                view.visibility = View.GONE
                ShowToast(context, "Done")
            }

        }
        builder.setView(view)
        builder.show()

    }


}