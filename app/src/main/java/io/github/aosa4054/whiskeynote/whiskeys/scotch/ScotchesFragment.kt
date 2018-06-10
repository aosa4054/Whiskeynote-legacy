package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.support.v4.app.Fragment
import io.github.aosa4054.whiskeynote.databinding.ScotchesListItemBinding

class ScotchesFragment: Fragment(){
    private lateinit var mViewModel: ScotchesViewModel
    private lateinit var mListItemBinding: ScotchesListItemBinding
    private lateinit var mhRecyclerViewAdapter: ScotchRecyclerViewAdapter

    companion object {
        fun newInstance(): ScotchesFragment{return ScotchesFragment()}
    }
}