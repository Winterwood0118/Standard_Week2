package com.example.standard_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DonutListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_donut_list, container, false)
        val rv_list = view.findViewById<RecyclerView>(R.id.rv_list)
        val listManager = GridLayoutManager(context,2)
        val listAdapter = RecyclerViewAdapter(donutList)

        rv_list.apply {
            setHasFixedSize(true)
            layoutManager = listManager
            adapter = listAdapter
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = DonutListFragment()
    }
}