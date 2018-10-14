package io.github.aosa4054.whiskeynote.top

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.Navigation

import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.whiskeys.scotch.ScotchesActivity

class MainFragment: androidx.fragment.app.Fragment() {

    private lateinit var adapter: TopListAdapter
    lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        setupListView(view)

        listView.onItemClickListener =
                AdapterView.OnItemClickListener {parent, v, pos, id ->
                    when(pos){
                        0 -> startActivity(Intent(activity, ScotchesActivity::class.java))
                        1 -> Toast.makeText(activity, "じゃ", Toast.LENGTH_SHORT).show()
                        2 -> Toast.makeText(activity, "あめ", Toast.LENGTH_SHORT).show()
                        3 -> Toast.makeText(activity, "他", Toast.LENGTH_SHORT).show()
                    }
                }

        return view
    }

    private fun setupListView(v: View){
        val texts: Array<String> = arrayOf("Scotch Whiskies", "Japanese Whiskies", "American Whiskeys", "Others")
        val images: Array<Int> = arrayOf(R.drawable.scotch, R.drawable.japanese, R.drawable.american, R.drawable.others)

        val data = mutableListOf<TopListItem>()
        for (i in 0 until 4){
            val item = TopListItem(texts[i], images[i])
            data.add(i, item)
        }
        adapter = TopListAdapter(requireContext(), data, R.layout.top_list_item)
        listView = v.findViewById(R.id.topList)
        listView.adapter = adapter
    }

    fun toScotch(){
        val intent = Intent(activity, ScotchesActivity::class.java)
        startActivity(intent)
    }

}
