package io.github.aosa4054.whiskeynote.whiskeys.scotch

import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        /*
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            addNewScotch()
        }
        */

        /*
        mViewModel = ViewModelProviders.of(this).get(ScotchesViewModel::class.java)
        mViewModel.setNavigators(this, this)

        //to use databinding
        binding = DataBindingUtil.setContentView(this, R.layout.scotches_list_item)
        binding.setLifecycleOwner(this)
        binding.viewModel = mViewModel

        //setup RecyclerView
        recyclerView = findViewById<RecyclerView>(R.id.scotchRecyclerView)
        recyclerView.setHasFixedSize(true)
        val manager: LinearLayoutManager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        mAdapter = ScotchRecyclerViewAdapter(ArrayList<Scotch>(), this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = mAdapter
        */

    }

    override fun onDestroy() {
        mViewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //mViewModel.handleActivityResult(requestCode, resultCode)
    }


    override fun addNewScotch() {
        val intent: Intent = Intent(this, AddEditWhiskeyActivity::class.java)
        intent.putExtra("TYPE_FRAG", 1)
        startActivityForResult(intent, AddEditWhiskeyActivity.REQUEST_CODE)
    }

    override fun openScotchDetails(whiskeyId: String) {
    }
}
