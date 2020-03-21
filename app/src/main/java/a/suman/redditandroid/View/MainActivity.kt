package a.suman.redditandroid.View

import a.suman.redditandroid.Adapter.RecyclerViewAdapter
import a.suman.redditandroid.Adapter.onClickRed
import a.suman.redditandroid.R
import a.suman.redditandroid.ViewModel.RedViewModel
import a.suman.redditandroid.ViewModel.networkFail
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onClickRed, networkFail {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=RecyclerViewAdapter(this)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val viewModel =ViewModelProviders.of(this).get(RedViewModel::class.java)

        viewModel.refresh(this)
        viewModel.redData.observe(this, Observer { adapter.setData(it) })

        recyclerview.adapter=adapter

        imageView.setOnClickListener {
            viewModel.refresh(this)
            imageView.animate().rotation(180f).setDuration(500).setInterpolator(AccelerateDecelerateInterpolator()).withEndAction{
                imageView.rotation=0f
            }

        }
    }

    override fun onRedClick(url:String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun Failed() {
        runOnUiThread { Snackbar.make(imageView, "No Internet Connection", Snackbar.LENGTH_LONG).show()}
    }

}
