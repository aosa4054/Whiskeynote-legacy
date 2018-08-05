package io.github.aosa4054.whiskeynote.top

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
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

    //@SuppressLint("ResourceAsColor")
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
                0 -> view.setBackgroundColor(Color.parseColor("#e568ab"))
                1 -> view.setBackgroundColor(Color.parseColor("#d1257e"))
                2 -> view.setBackgroundColor(Color.parseColor("#a4226f"))
                3 -> view.setBackgroundColor(Color.parseColor("#5b1049"))
            }

        }else{
            holder = view.tag as ViewHolder
        }

        holder.imageView.setImageResource(item.topImgId)
        holder.textView.text = item.topTxt

        return view!!
    }

}
