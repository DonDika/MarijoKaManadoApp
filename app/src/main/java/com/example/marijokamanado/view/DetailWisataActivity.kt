package com.example.marijokamanado.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.marijokamanado.R

class DetailWisataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Wisata"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvOverview: TextView = findViewById(R.id.tv_set_overview)
        val tvIntro: TextView = findViewById(R.id.tv_item_intro)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tOverview = intent.getStringExtra(EXTRA_OVERVIEW)
        val tIntro = intent.getStringExtra(EXTRA_INTRO)



        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvOverview.text = tOverview
        tvIntro.text = tIntro
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_INTRO = "extra_intro"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}