package com.example.flixsterplus

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity(){
    private lateinit var imageImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        imageImageView = findViewById(R.id.show_image)
        nameTextView = findViewById(R.id.show_name)
        dateTextView = findViewById(R.id.show_air_date)
        ratingTextView = findViewById(R.id.show_rating)
        descriptionTextView = findViewById(R.id.show_description)

        val show = intent.getSerializableExtra(SHOW_EXTRA) as? Show

        nameTextView.text = show?.name
        dateTextView.text = show?.date
        ratingTextView.text = show?.rating
        descriptionTextView.text = show?.description

        val fullImage: String = "https://image.tmdb.org/t/p/w500/" + show?.image

        Glide.with(this)
            .load(fullImage)
            .into(imageImageView)
    }

}