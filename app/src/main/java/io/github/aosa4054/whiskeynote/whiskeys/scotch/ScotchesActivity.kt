package io.github.aosa4054.whiskeynote.whiskeys.scotch

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.aosa4054.whiskeynote.R
import io.github.aosa4054.whiskeynote.addeditwhiskey.AddEditWhiskeyActivity
import io.github.aosa4054.whiskeynote.data.entity.Scotch
import io.github.aosa4054.whiskeynote.databinding.ScotchesListItemBinding

import kotlinx.android.synthetic.main.activity_scotches.*

class ScotchesActivity : AppCompatActivity(), ScotchesNavigator, ScotchItemNavigator{

    lateinit var mViewModel: ScotchesViewModel
    lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit var mAdapter: ScotchRecyclerViewAdapter
    lateinit var binding: ScotchesListItemBinding

    var fragment: ScotchesFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scotches)

    }

    override fun onDestroy() {
        mViewModel.onActivityDestroyed()
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
