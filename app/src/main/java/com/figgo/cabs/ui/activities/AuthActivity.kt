package com.figgo.cabs.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.figgo.cabs.R
import com.figgo.cabs.databinding.ActivityAuthBinding
import com.figgo.cabs.db.SharedPreferences
import com.figgo.cabs.figgodriver.Fragment.WelcomeFragment
import com.figgo.cabs.viewmodels.AuthViewModel

class AuthActivity : AppCompatActivity() {
    lateinit var  binding: ActivityAuthBinding
    lateinit var authViewModel: AuthViewModel

    lateinit var  sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = SharedPreferences.getInstance()

        initViewModel()
        observeViewModel()

        if (sp.isLoggedIn()){

            //Dashboard Fragment
        }else if (sp.isLoggedIn()){

            //Login Fragment
        }

    }


    private fun observeViewModel() {

        authViewModel.getOpenWelcomeFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(WelcomeFragment.newInstance(), "")
            }
        }



    }

    private fun openFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        setFragmentTransactionAnimation(transaction, tag)
        transaction.replace(R.id.authContainer, fragment, tag)
        transaction.addToBackStack(tag)
        transaction.commit()
    }

    private fun setFragmentTransactionAnimation(transaction: FragmentTransaction, tag: String) {
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
    }


    private fun initViewModel() {

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
    }
}