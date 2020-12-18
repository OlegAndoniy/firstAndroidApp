package com.example.myfirstapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment= MainFragment()
        val secondFragment= AboutFragment()
        val thirdFragment= TermAndLicenseFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.about->setCurrentFragment(secondFragment)
                R.id.term->setCurrentFragment(thirdFragment)

            }
            true
        }


        /*about.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

        term_of_use.setOnClickListener {
            val intent = Intent(this, TermActivity::class.java)
            startActivity(intent)
        }*/

//        var itemlist = arrayListOf<String>()
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)
//        add.setOnClickListener {
//            var text = editText.text.toString().trim().isNotEmpty()
//            if(text) {
//                itemlist.add(editText.text.toString())
//                listView.adapter = adapter
//                adapter.notifyDataSetChanged()
//                editText.text.clear()
//            }
//            else{
//                android.widget.Toast.makeText(this, "Empty item", 1).show()
//            }
//        }
//
//        clear.setOnClickListener {
//            itemlist.clear()
//            adapter.notifyDataSetChanged()
//        }
//
//        listView.setOnItemClickListener {parent, view, position, id ->
//            android.widget.Toast.makeText(this, "You Selected the item", 1).show()
//        }
//
//        delete.setOnClickListener {
//            val checked = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//
//            while (item >= 0) {
//                if (checked.get(item))
//                {
//                    itemlist.removeAt(item)
//                }
//                item--
//            }
//            checked.clear()
//            adapter.notifyDataSetChanged()
//        }


    }

  private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}


