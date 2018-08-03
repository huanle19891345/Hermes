package com.pince.hermes.manager

class UserManager {

    private constructor()

    companion object {
        var mInstance: UserManager? = null
        fun getInstance(): UserManager {
            if (null == mInstance) {
                synchronized(UserManager::class.java) {
                    if(null == mInstance) {
                        mInstance = UserManager()
                    }
                }
            }
            return mInstance!!
        }
    }

    var userName:String = "默认的用户名"



}