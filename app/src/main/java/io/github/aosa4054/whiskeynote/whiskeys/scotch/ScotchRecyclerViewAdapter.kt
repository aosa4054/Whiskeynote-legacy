package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.data.entity.Scotch


class ScotchRecyclerViewAdapter(var scotches: List<Scotch>):
        RecyclerView.Adapter<ScotchRecyclerViewAdapter.ScotchViewHolder>()/*, View.OnClickListener*/ {

    private var mRecycler: RecyclerView? = null
    //private var mListener: AdapterView.OnItemClickListener? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecycler = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
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

    /*
    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
        mListener = listener
    }

    override fun onClick(v: View?) {
        if (mRecycler == null){ return }
        if (mListener != null){
            val position: Int = mRecycler!!.getChildAdapterPosition(v)
            val scotch: Scotch = scotches.get(position)
            mListener!!.onItemClick(this, position, scotch)
        }
    }
    */

    class ScotchViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }
}


