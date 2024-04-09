package com.example.firebaseapp.loginActivity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.example.firebaseapp.activity.MainActivity
import com.example.firebaseapp.base.BaseActivity
import com.example.firebaseapp.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity<ActivityIntroBinding>(ActivityIntroBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        mBinding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}