package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.databinding.ScotchesListItemBinding
import kotlinx.android.synthetic.main.activity_scotches.*
import kotlinx.android.synthetic.main.fragment_scotches.*
import kotlinx.android.synthetic.main.fragment_scotches.view.*

class ScotchesFragment: androidx.fragment.app.Fragment(){
    private lateinit var mViewModel: ScotchesViewModel
    private lateinit var mListItemBinding: ScotchesListItemBinding
    private lateinit var mhRecyclerViewAdapter: ScotchRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /*
        //要チェック
        mListItemBinding = ScotchesListItemBinding.inflate(inflater, container, false)
        mListItemBinding.viewModel = mViewModel
        val root: View = mListItemBinding.root
        return root
        */

        /*
        以下はonActivityCreatedに記述？ (TODOs)
        TODO: setup toolbar
        TODO: setup fab
        TODO: setup RecyclerView (maintain related classes like Adapter)
        TODO: inflate -> return
         */
        
        val view = inflater.inflate(R.layout.fragment_scotches, container, false)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            it.findNavController().navigate(
                    ScotchesFragmentDirections.action_scotchesFragment_to_addEditWhiskeyFragment().
                            apply { setFlag(1) }
            )
            /*
            val bundle = bundleOf("flag" to 1)
            Navigation.findNavController(it).navigate(
                    R.id.action_scotchesFragment_to_addEditWhiskeyFragment,
                    bundle)
                    */
            //Navigation.createNavigateOnClickListener(R.id.action_scotchesFragment_to_addEditWhiskeyFragment)
        }

        // Set up the tool bar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        //TODO: remove this comment out and activate following NavigationOnClickListener
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
                activity!!, view.product_grid, view.fab, AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.baseline_menu_white_24dp),
                ContextCompat.getDrawable(context!!, R.drawable.baseline_close_white_24dp)))


        //TODO: remove following NavigationOnClickListener
        //view.app_bar.setNavigationOnClickListener { Toast.makeText(context, "この機能は現在のbeta版では実装されていません", Toast.LENGTH_LONG).show() }


        //setupExpandedListView(view)
        //TODO: disable clickable of parent group and change it to checkbox
        //TODO: make expandablelistview not able to collapse list
        //TODO: change its font to raleway

        // Set up the RecyclerView
        
        // Set cut corner background for API 23+

        return view

    }

    fun setViewModel(viewModel: ScotchesViewModel){
        mViewModel = viewModel
    }

    //<editor-fold desc="setupExpandableListView">
    /*
    private fun setupExpandedListView(v: View){
        val parentTitle: MutableList<String> = mutableListOf("Scotch")
        val children: MutableList<String> = mutableListOf("Brended", "Single", "Uncategolised")
        val elv = v.findViewById<ExpandableListView>(R.id.elv)

        val parentList: MutableList<Map<String, String>> = mutableListOf()
        val childList: MutableList<Map<String, String>> = mutableListOf()
        val allChildList: MutableList<MutableList<Map<String, String>>> = mutableListOf()

        val parentMap: Map<String, String> = mapOf("Scotch" to parentTitle[0])
        parentList.add(0, parentMap)
        for (i in 0 until 3){
            val childMap: Map<String, String> = mapOf("type" to children[i])
            childList.add(i, childMap)
        }
        allChildList.add(0, childList)
        //3 maps(names of whiskey type) in child list
        //TODO make types correctly according to Sketch

        val adapter: SimpleExpandableListAdapter = SimpleExpandableListAdapter(context,
                parentList,
                R.layout.elv_main,
                arrayOf("Scotch"),
                intArrayOf(R.id.chx_scotch),
                allChildList,
                R.layout.elv_sub,
                arrayOf("type"),
                intArrayOf(R.id.chx_scotch_type))
        /*{
            override fun getChildView(groupPosition: Int, childPosition: Int,
                                      isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
                val itemRender : View = super.getChildView(
                        groupPosition, childPosition, isLastChild, convertView, parent)
                val type = itemRender.findViewById<TextView>(android.R.id.text1)
                val typeface: Typeface = Typeface.createFromAsset(activity?.assets, "")
                type.setTextColor(0xffffff)
                return itemRender
            }

            override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
                val itemRender: View = super.getGroupView(groupPosition, isExpanded, convertView, parent)
                val scotch = itemRender.findViewById<TextView>(android.R.id.text1)
                val typeface: Typeface = Typeface.createFromAsset(activity?.assets, "")
                scotch.setTextColor(0xffffff)
                return itemRender
            }
        }*/

        elv.setAdapter(adapter)
    }
    */
    //</editor-fold>

}