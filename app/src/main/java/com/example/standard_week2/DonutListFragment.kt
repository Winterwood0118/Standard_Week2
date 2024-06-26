package com.example.standard_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.standard_week2.adepter.DonutItemAdapter
import com.example.standard_week2.databinding.FragmentDonutListBinding

class DonutListFragment : Fragment() {
    lateinit var binding: FragmentDonutListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDonutListBinding.inflate(inflater, container, false)

        val listManager = GridLayoutManager(context,2)
        val listAdapter = DonutItemAdapter(donutList)

        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = listManager
            adapter = listAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {
        @JvmStatic
        fun newInstance() = DonutListFragment()
    }
}