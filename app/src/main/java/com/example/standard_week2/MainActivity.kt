package com.example.standard_week2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.standard_week2.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy{ ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, DonutListFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }

    }
    fun showDetail(position: Int, like: Boolean){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, DonutDetailFragment.newInstance(position, like))
            addToBackStack(null)
            commit()
        }
    }
}