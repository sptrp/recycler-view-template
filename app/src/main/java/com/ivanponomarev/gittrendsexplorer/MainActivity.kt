package com.ivanponomarev.gittrendsexplorer

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanponomarev.gittrendsexplorer.databinding.ActivityMainBinding
import com.ivanponomarev.gittrendsexplorer.ui.main.MainViewModel
import com.ivanponomarev.gittrendsexplorer.ui.main.MainViewModelFactory
import com.ivanponomarev.gittrendsexplorer.ui.main.MyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory(this)
    }

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding.lifecycleOwner = this
        setContentView(activityMainBinding.root)

        val testDataSet = arrayOf("Dorime", "Interimo", "Adapare", "Latire", "Ameno", "Ameno", "Latire", "Latire mo", "Dorime",
                "Ameno", "Imperavi", "Ameno", "Dimere", "Mantiro", "Mantiremo", "Ameno")

        val recyclerView = activityMainBinding.content.recyclerView
        recyclerView.adapter = MyAdapter(testDataSet)

        val fab: FloatingActionButton = activityMainBinding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}