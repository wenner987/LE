package com.wenner.github.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.wenner.github.server.Server
import com.wenner.github.bean.LocalUser
import database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity

class StartActivity : AppCompatActivity() {
    val TAG = "StartActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        var flag: Boolean = true
        doAsync {
            database.use{
                val res = select("Users").whereSimple("(id = ?)", 0.toString()).parseSingle(classParser<LocalUser>())
                val result = Server.login(res.username, res.password)
                Log.i(TAG, result.Id.toString())
                when (result.Id){
                    0 -> {
                        flag = false
                    }
                }
            }
        }
        Thread.sleep(3000)
        if (flag){
            startActivity<MainActivity>()
        }else {
            startActivity<LoginActivity>()
        }
        finish()
    }
}
