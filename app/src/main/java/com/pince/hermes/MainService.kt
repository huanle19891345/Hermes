package com.pince.hermes

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.pince.hermes.manager.UserManager

class MainService: Service() {

    override fun onBind(p0: Intent): IBinder {
      return object : IMainService.Stub() {
          override fun getUserName(): String {
             return UserManager.getInstance().userName
          }

          override fun setUsername(userName: String) {
              UserManager.getInstance().userName = userName
          }
      }
    }
}