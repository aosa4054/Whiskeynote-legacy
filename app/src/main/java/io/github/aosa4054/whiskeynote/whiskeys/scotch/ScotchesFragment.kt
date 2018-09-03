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
        
        val view = inflater.inflate(R.layout.fragment_scotches, container, false)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            it.findNavController().navigate(
                    ScotchesFragmentDirections.action_scotchesFragment_to_addEditWhiskeyFragment().
                            apply { setFlag(1) }
            )
        }

        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)


        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
                activity!!, view.product_grid, view.fab, AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.baseline_menu_white_24dp),
                ContextCompat.getDrawable(context!!, R.drawable.baseline_close_white_24dp)))

        return view

    }

    fun setViewModel(viewModel: ScotchesViewModel){
        mViewModel = viewModel
    }
}