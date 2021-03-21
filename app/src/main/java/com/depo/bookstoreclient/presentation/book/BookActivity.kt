package com.depo.bookstoreclient.presentation.book

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.depo.bookstoreclient.R
import com.depo.bookstoreclient.databinding.ActivityBookBinding
import com.depo.bookstoreclient.presentation.di.Injector
import com.facebook.shimmer.ShimmerFrameLayout
import javax.inject.Inject

class BookActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: BookViewModelFactory
    private lateinit var bookViewModel: BookViewModel
    private lateinit var binding: ActivityBookBinding
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as Injector).createBookSubComponent()
            .inject(this)

        bookViewModel = ViewModelProvider(this, factory)
            .get(BookViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerviewId2.layoutManager = GridLayoutManager(this,4);
        adapter = BookAdapter()
        binding.recyclerviewId2.adapter = adapter
        displayPopularBooks()
    }

    private fun displayPopularBooks() {
        binding.shimer.startShimmer()
        val responseLiveData = bookViewModel.getBooks()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it.popularBooks)
                adapter.notifyDataSetChanged()
                stopShimer()
            } else {
                stopShimer()
                Toast.makeText(applicationContext, "No Data avaliable", Toast.LENGTH_LONG).show()
            }
//            Log.i("MYTAG", it.toString())
        })
    }

    private fun stopShimer() {
            if (binding.shimer.isShimmerVisible) {
                binding.popularLinear.visibility = View.VISIBLE
                binding.shimer.visibility = View.GONE
                binding.shimer.stopShimmer()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateBooks()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateBooks() {
        binding.popularLinear.visibility = View.INVISIBLE
        binding.shimer.visibility = View.VISIBLE
        binding.shimer.startShimmer()
        val response = bookViewModel.updateBooks()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it.popularBooks)
                adapter.notifyDataSetChanged()
                stopShimer()
            } else {
                stopShimer()
            }
        })
    }
}