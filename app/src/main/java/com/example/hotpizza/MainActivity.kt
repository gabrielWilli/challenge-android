package com.example.hotpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hotpizza.ui.LoginFragment

class MainActivity() : AppCompatActivity() {

    private val loginFragment = LoginFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(loginFragment)
    }

    fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}
