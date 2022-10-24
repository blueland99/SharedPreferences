package com.blueland.sharedpreferences.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.blueland.sharedpreferences.util.PreferenceManager
import com.blueland.sharedpreferences.R
import com.blueland.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }
    private val preferenceManager: PreferenceManager by lazy { PreferenceManager(this) }

    companion object {
        const val PREFERENCE_KEY_ID = "id"
        const val PREFERENCE_KEY_PW = "pw"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.apply {

            // SharedPreference 저장된 아이디, 비밀번호 가져오기
            etId.setText(preferenceManager.getString(PREFERENCE_KEY_ID))
            etPw.setText(preferenceManager.getString(PREFERENCE_KEY_PW))

            btnLogin.setOnClickListener {
                // 로그인 시, SharedPreference 아이디 비밀번호 저장

                val id = etId.text.toString().trim()
                val pw = etPw.text.toString().trim()
                if (id.isBlank()) {
                    Toast.makeText(this@MainActivity, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (pw.isBlank()) {
                    Toast.makeText(this@MainActivity, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                preferenceManager.put(PREFERENCE_KEY_ID, id)
                preferenceManager.put(PREFERENCE_KEY_PW, pw)

                Toast.makeText(this@MainActivity, "아이디, 비밀번호 저장 완료", Toast.LENGTH_SHORT).show()
            }
        }
    }
}