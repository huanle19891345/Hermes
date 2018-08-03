package com.pince.hermes.mm

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pince.hermes.IMainService
import com.pince.hermes.MainService
import com.pince.hermes.R
import com.pince.hermes.manager.UserManager
import kotlinx.android.synthetic.main.activity_mm.*
import kotlinx.android.synthetic.main.activity_mm.view.*

/**
 * mm进程activity，用来作为客户端访问主进程中的单例
 */
class MMActivity : AppCompatActivity() {

    private lateinit var iMainService: IMainService

    private val serviceConnection = object: ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder) {
            iMainService = IMainService.Stub.asInterface(p1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mm)
        title = "MMActivity"

        mmTv.setOnClickListener {
//            UserManager.getInstance().userName = "mm进程设置的用户名"
            iMainService.setUsername("mm进程设置的用户名")
            Toast.makeText(this, "设置的username是mm进程设置的用户名", Toast.LENGTH_LONG).show()
        }


        bindService(Intent(this, MainService::class.java),
                serviceConnection,
                Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MMActivity::class.java)
            context.startActivity(intent)
        }
    }
}