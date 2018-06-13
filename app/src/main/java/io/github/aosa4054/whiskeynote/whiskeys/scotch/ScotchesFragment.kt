package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aosa4054.whiskeynote.databinding.ScotchesListItemBinding

class ScotchesFragment: Fragment(){
    private lateinit var mViewModel: ScotchesViewModel
    private lateinit var mListItemBinding: ScotchesListItemBinding
    private lateinit var mhRecyclerViewAdapter: ScotchRecyclerViewAdapter

    companion object {
        fun newInstance(): ScotchesFragment{return ScotchesFragment()}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mListItemBinding = ScotchesListItemBinding.inflate(inflater, container, false)
        mListItemBinding.viewModel = mViewModel
        val root: View = mListItemBinding.root
        return root
    }

    fun setViewModel(viewModel: ScotchesViewModel){
        mViewModel = viewModel
    }
}