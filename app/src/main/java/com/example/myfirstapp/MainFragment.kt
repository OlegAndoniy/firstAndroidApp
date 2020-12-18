package com.example.myfirstapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_main, container, false)
        var itemlist = arrayListOf<String>()
       // var adapter =  ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_multiple_choice, itemlist)
        view.add.setOnClickListener {
            var text = view.editText.text.toString().trim().isNotEmpty()
            if(text) {
                itemlist.add(view.editText.text.toString())
               // listView.adapter = adapter
               // adapter.notifyDataSetChanged()
                view.editText.text.clear()
            }
            else{
                android.widget.Toast.makeText(context, "Empty item", 1).show()
            }
        }

        view.clear.setOnClickListener {
           // itemlist.clear()
           // adapter.notifyDataSetChanged()
            android.widget.Toast.makeText(context, "Clear", 1).show()
        }

        view.listView.setOnItemClickListener {parent, view, position, id ->
            android.widget.Toast.makeText(context, "You Selected the item", 1).show()
        }

        view.delete.setOnClickListener {
            val checked = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1

            while (item >= 0) {
                if (checked.get(item))
                {
                    itemlist.removeAt(item)
                }
                item--
            }
            checked.clear()
            //adapter.notifyDataSetChanged()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}