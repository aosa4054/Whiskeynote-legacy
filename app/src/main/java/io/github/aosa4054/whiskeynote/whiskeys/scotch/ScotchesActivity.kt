package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.aosa4054.whiskeynote.R

class ScotchesActivity : AppCompatActivity(), ScotchesNavigator, ScotchItemNavigator{

    lateinit var mViewModel: ScotchesViewModel
    lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit var mAdapter: ScotchRecyclerViewAdapter
    //lateinit var binding: ScotchesListItemBinding

    var fragment: ScotchesFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scotches)
    }

    override fun onDestroy() {
        //mViewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun addNewScotch() {
    }

    override fun openScotchDetails(whiskeyId: String) {
    }
}
