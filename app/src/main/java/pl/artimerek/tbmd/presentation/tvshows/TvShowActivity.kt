package pl.artimerek.tbmd.presentation.tvshows

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pl.artimerek.tbmd.R
import pl.artimerek.tbmd.databinding.ActivityTvShowBinding
import pl.artimerek.tbmd.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private  lateinit var adapter: TvAdapter
    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        initRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
            }
        })
    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }


}