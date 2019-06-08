package com.wenner.github.activity

import android.Manifest
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import com.beardedhen.androidbootstrap.TypefaceProvider
import com.example.myapplication.R
import com.wenner.github.server.Server
import database
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TypefaceProvider.registerDefaultIconSets()
        setContentView(R.layout.activity_login)
        val permissions = arrayOf(Manifest.permission.INTERNET)
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)
        btnlogin.setOnClickListener {
            if ("".equals(login_account.text.toString()) || "".equals(login_password.text.toString())){
                toast("Please input correct username or password")
            }
            else {
                doAsync {
                    var result = Server.login(login_account.text.toString(), login_password.text.toString())

                    uiThread {
                        when (result.Id){
                            0 -> {
                                toast("Invalid account or password!")
                            }
                            else -> {
                                toast("Login successful!")
                                startActivity<MainActivity>()
                                database.use {
                                    execSQL("update Users set username = '${login_account.text.toString()}', password = '${login_password.text.toString()}'" +
                                            " where id = 0")
                                }
                                finish()
                            }
                        }
                    }
                }
            }
        }
        btnregister.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }
}
