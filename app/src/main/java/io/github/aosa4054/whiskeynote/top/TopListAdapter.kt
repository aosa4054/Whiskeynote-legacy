package io.github.aosa4054.whiskeynote.top

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.support.annotation.ColorRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import io.github.aosa4054.whiskeynote.R

class TopListAdapter(private var context: Context, private var data: MutableList<TopListItem>, private var resource: Int):
        BaseAdapter() {

    class ViewHolder{
        lateinit var imageView: ImageView
        lateinit var textView: TextView
    }

    private var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        lateinit var holder: ViewHolder
        val item: TopListItem = getItem(position) as TopListItem

        if (view == null){
            view = inflater.inflate(resource, parent, false)
            holder = ViewHolder()
            holder.imageView = view.findViewById(R.id.topListImg)
            holder.textView = view.findViewById(R.id.topListTxt)
            view.tag = holder

            when (position){
                0 -> view.setBackgroundColor(R.color.colorPrimary300)
                1 -> view.setBackgroundColor(R.color.colorPrimary500)
                2 -> view.setBackgroundColor(R.color.colorPrimary700)
                3 -> view.setBackgroundColor(R.color.colorPrimary)
            }

        }else{
            holder = view.tag as ViewHolder
        }

        holder.imageView.setImageResource(item.topImgId)
        holder.textView.text = item.topTxt

        return view!!
    }

}
