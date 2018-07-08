package io.github.aosa4054.whiskeynote.top

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.aosa4054.whiskeynote.R

class MainFragment: Fragment() {

    private lateinit var adapter: TopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun setupListView(){
        val texts: Array<String> = arrayOf("Scotch Whiskies", "Japanese Whiskies", "American Whiskeys", "Others")
        val images: Array<Int> = arrayOf(R.drawable.scotch, R.drawable.japanese, R.drawable.american, R.drawable.others)

        lateinit var data: MutableList<TopListItem>
        for (i in 0 until 4){
            val item = TopListItem(texts[i], images[i])
            data.add(i, item)
        }
        adapter = TopListAdapter(requireContext(), data, R.layout.top_list_item)
    }
}
