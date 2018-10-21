package io.github.aosa4054.whiskeynote.whiskeys.scotch

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Whiskey


class ScotchRecyclerViewAdapter(var scotches: List<Whiskey>, var mNavigator: ScotchItemNavigator?):
        androidx.recyclerview.widget.RecyclerView.Adapter<ScotchRecyclerViewAdapter.ScotchViewHolder>()/*, View.OnClickListener*/ {

    private var mRecycler: androidx.recyclerview.widget.RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecycler = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecycler = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScotchViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.scotches_list_item, parent, false)
        //v.setOnClickListener(this)
        return ScotchViewHolder(v)
    }

    override fun onBindViewHolder(holder: ScotchViewHolder, position: Int) {
        //viewにデータを割り当てる
    }

    override fun getItemCount(): Int {
        return scotches.size
    }

    fun onDestroy(){
        mNavigator = null
    }

    class ScotchViewHolder(val view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    }
}


