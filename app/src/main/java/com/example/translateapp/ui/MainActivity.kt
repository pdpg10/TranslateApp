package com.example.translateapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import com.example.translateapp.R
import com.example.translateapp.ui.adapter.WordAdapter
import com.example.translateapp.vm.WordVm
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val vm: WordVm by lazy { ViewModelProviders.of(this)[WordVm::class.java] }
    private val cd = CompositeDisposable()

    private val adapter by lazy(LazyThreadSafetyMode.NONE) { WordAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rv.adapter = adapter
        et_search.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query == null) {
            return false
        } else {
             vm.searchWord(this, query)
                .subscribe { adapter.submitList(it) }
                 .let { cd.add(it) }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?) = false

    override fun onDestroy() {
        super.onDestroy()
        cd.clear()
    }
}
