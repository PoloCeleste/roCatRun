package com.eeos.rocatrun.login

import android.app.Application
import android.util.Log
import com.eeos.rocatrun.R
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.eeos.rocatrun.login.data.RetrofitClient
import com.eeos.rocatrun.api.RetrofitInstance

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initialize(this)
        RetrofitInstance.initialize(this)
    }
}