package com.example.standard_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.standard_week2.databinding.FragmentDonutDetailBinding

private const val ARG_INDEX = "param1"
private const val ARG_LIKE = "param2"

class DonutDetailFragment : Fragment() {

    private var index: Int? = null
    private var isLike: Boolean? = null
    lateinit var binding: FragmentDonutDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(ARG_INDEX)
            isLike = it.getBoolean(ARG_LIKE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDonutDetailBinding.inflate(inflater, container, false)
        // 칼 단 지 당
        binding.ivItemDetail.setImageResource(donutList[index?:0].image)
        binding.tvNameDetail.text = donutList[index?:0].name

        binding.customCalories.tvValueCustom.text = nutriList[index?:0].calories
        binding.customCalories.tvTypeCustom.text = nutriType[0]

        binding.customProteins.tvValueCustom.text = nutriList[index?:0].proteins
        binding.customProteins.tvTypeCustom.text = nutriType[1]

        binding.customFats.tvValueCustom.text = nutriList[index?:0].fats
        binding.customFats.tvTypeCustom.text = nutriType[2]

        binding.customSugars.tvValueCustom.text = nutriList[index?:0].sugars
        binding.customSugars.tvTypeCustom.text = nutriType[3]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iv_close = view.findViewById<ImageView>(R.id.iv_close_detail)

        iv_close.setOnClickListener{
            activity?.supportFragmentManager?.apply {
                beginTransaction().remove(this@DonutDetailFragment).commit()
                popBackStack()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: Boolean) =
            DonutDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_INDEX, param1)
                    putBoolean(ARG_LIKE, param2)
                }
            }
    }
}