package com.figgo.cabs.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.figgo.cabs.common.toggle
import com.figgo.cabs.databinding.ActivityOnBoardingBinding
import com.figgo.cabs.db.SharedPreferences
import com.figgo.cabs.figgodriver.UI.LoginActivity
import com.figgo.cabs.utils.ViewUtils

class OnBoardingActivity : AppCompatActivity() {

    lateinit var binding: ActivityOnBoardingBinding

    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = SharedPreferences.getInstance()

        /**
         *  Ask  Basic permissions Here
         * **/


        binding.tvTermsAndConditions.setOnClickListener {

            binding.layoutWelcome.toggle()
            binding.layoutTermsAndConditions.toggle()
        }


        binding.accept.setOnClickListener {
            if (!binding.cbTermsAndConditions.isChecked) {
                ViewUtils.showToast(this, "Accept Terms and Conditions")
                return@setOnClickListener
            }
            sp.setFirstInstall(false)
            startActivity(Intent(this, LoginActivity::class.java))
        }

        /**
         *  Show All On Boarding Screens Here
         *  and set the IS FIRST INSTALL FALSE
         * **/

//        sp.setFirstInstall(false)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.layoutWelcome.visibility == View.GONE) {

            binding.layoutWelcome.toggle()
            binding.tvTermsAndConditions.visibility = View.GONE
        }
    }
}