package com.figgo.cabs.figgodriver.UI

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.figgo.cabs.R
import com.figgo.cabs.db.SharedPreferences
import com.figgo.cabs.ui.activities.AuthActivity
import com.figgo.cabs.ui.activities.MainActivity
import com.figgo.cabs.ui.activities.OnBoardingActivity

class SplashActivity : AppCompatActivity() {

    lateinit var  sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sp = SharedPreferences.getInstance()


        // if logedd in dashboard else login
        Handler().postDelayed({

            // MMM Code

//            if (sp.isFirstInstall()){
//                startActivity(Intent(this, OnBoardingActivity::class.java))
//            }else
//            if (sp.isLoggedIn()){
//                startActivity(Intent(this, LoginActivity::class.java))
//            }else{
//                startActivity(Intent(this, AuthActivity::class.java))
//            }

            startActivity(Intent(this, LoginActivity::class.java))
           // startActivity(Intent(this,DriverDashBoard::class.java))
        },3000)
        var become_the_luxury=findViewById<TextView>(R.id.become_the_luxury)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_side)
        become_the_luxury.startAnimation(slideAnimation)
    }
}