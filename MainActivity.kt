package com.example.project2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the buttons and text views
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnHappy = findViewById<Button>(R.id.btnPlay)
        val txtHunger = findViewById<EditText>(R.id.petHungry)
        val txtClean = findViewById<EditText>(R.id.petClean)
        val txtHappy = findViewById<EditText>(R.id.petClean)
        val petImage = findViewById<ImageView>(R.id.pet_ImageView)

        // Set the initial text values
        txtHunger.setText(petHunger.toString())
        txtClean.setText(petCleanliness.toString())
        txtHappy.setText(petHealth.toString()
        )
        // handle button clicks
        btnFeed.setOnClickListener{
            petHunger-= 10
            petHealth+=10
            petHunger+=5
            txtHunger.setText(petHunger.toString())
            animateImageChange(petImage, R.drawable.img_2)
        }
        btnClean.setOnClickListener{
            petCleanliness -=10
            petHealth+=10
            petHunger+=5
            txtClean.setText(petCleanliness.toString())
            animateImageChange(petImage, R.drawable.img_1)
        }

        btnHappy.setOnClickListener{
            petHealth+= 10
            petHunger+= 5
            petCleanliness-= 5
            txtHappy.setText(petHealth.toString())
            animateImageChange(petImage,R.drawable.img)

    }
}
    private fun animateImageChange(imageView: ImageView,newImageResource:Int){
        val animation = AlphaAnimation(0.0f,1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}