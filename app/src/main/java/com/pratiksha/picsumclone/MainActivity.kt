package com.pratiksha.picsumclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.pratiksha.picsumclone.databinding.MainActivityBinding
import com.pratiksha.picsumclone.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: MainActivityBinding
//    private var mainActivityBinding: MainActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(mainActivityBinding.root)

// to check if lateinit is initialized or not        if(::mainActivityBinding.isInitialized)

//  using a scoped function to safe access nullable variable

//        mainActivityBinding?.let { binding ->
//
//            setContentView(binding.root)
//        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}