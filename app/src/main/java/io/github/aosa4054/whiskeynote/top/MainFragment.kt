package io.github.aosa4054.whiskeynote.top

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import io.github.aosa4054.whiskeynote.R

class MainFragment: Fragment() {

    private lateinit var adapter: TopListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        setupListView(view)
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
        val listView: ListView = v.findViewById(R.id.topList)
        listView.adapter = adapter
    }

}
