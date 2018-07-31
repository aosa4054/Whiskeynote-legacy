package io.github.aosa4054.whiskeynote.whiskeys.scotch

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.aosa4054.whiskeynote.R


class FrontLayerRecyclerViewAdapter(): androidx.recyclerview.widget.RecyclerView.Adapter<FrontLayerRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(var item: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(item){
        init {
            var view: View = item
            var whiskeyName = view.findViewById<TextView>(R.id.recyclerview_whiskey_name)
            var whiskeyType = view.findViewById<TextView>(R.id.recyclerview_whiskey_type)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}