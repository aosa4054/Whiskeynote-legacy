package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.databinding.ScotchesListItemBinding
import kotlinx.android.synthetic.main.activity_scotches.*
import kotlinx.android.synthetic.main.fragment_scotches.view.*

class ScotchesFragment: Fragment(){
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
        以下はonActivityCreatedに記述？
        TODO: setup toolbar
        TODO: setup fab
        TODO: setup RecyclerView (maintain related classes like Adapter)
        TODO: inflate -> return
         */
        
        val view = inflater.inflate(R.layout.fragment_scotches, container, false)

        // Set up the tool bar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, view.product_grid, AccelerateDecelerateInterpolator()))

        // Set up the RecyclerView
        
        // Set cut corner background for API 23+

        return view;

    }

    fun setViewModel(viewModel: ScotchesViewModel){
        mViewModel = viewModel
    }


}