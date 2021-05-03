package com.example.hotpizza.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hotpizza.MainActivity
import com.example.hotpizza.LoginContract
import com.example.hotpizza.R
import com.example.hotpizza.presenter.LoginPresenter

class LoginFragment : Fragment(), LoginContract.View {

    private val presenter = LoginPresenter()
    private val listFragment = ListFragment()

    lateinit var buttonLogin: Button
    lateinit var inputUser: EditText
    lateinit var inputPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        buttonLogin = view.findViewById(R.id.buttonLogin)
        inputUser = view.findViewById(R.id.editText_user)
        inputPassword = view.findViewById(R.id.editText_password)

        buttonLogin.setOnClickListener {
            var validateUser = presenter.validateUser(inputUser.text.toString(), inputPassword.text.toString())

            if(validateUser) {
                val activity: MainActivity = activity as MainActivity
                activity.changeFragment(listFragment)
            } else {
                showInfo("Ops! Dados incorretos")
            }
        }

        return view
    }

    override fun showInfo(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}

