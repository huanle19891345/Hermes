package com.pince.hermes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pince.hermes.manager.UserManager
import com.pince.hermes.mm.MMActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "MainActivity"

        goToMM.setOnClickListener {
            MMActivity.start(this)
        }

        mainGetUser.setOnClickListener {
            Toast.makeText(this, "获取到的username是${UserManager.getInstance().userName}", Toast.LENGTH_LONG).show()
        }
    }


}
