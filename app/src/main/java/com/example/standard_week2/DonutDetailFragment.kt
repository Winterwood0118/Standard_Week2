package com.example.standard_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.standard_week2.databinding.FragmentDonutDetailBinding

private const val ARG_INDEX = "param1"

class DonutDetailFragment : Fragment() {

    private var index: Int? = null
    lateinit var binding: FragmentDonutDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(ARG_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDonutDetailBinding.inflate(inflater, container, false)
        // 칼 단 지 당
        binding.ivItemDetail.setImageResource(donutList[index ?: 0].image)
        binding.tvNameDetail.text = donutList[index ?: 0].name

        binding.customCalories.tvValueCustom.text = nutriList[index ?: 0].calories
        binding.customCalories.tvTypeCustom.text = nutriType[0]

        binding.customProteins.tvValueCustom.text = nutriList[index ?: 0].proteins
        binding.customProteins.tvTypeCustom.text = nutriType[1]

        binding.customFats.tvValueCustom.text = nutriList[index ?: 0].fats
        binding.customFats.tvTypeCustom.text = nutriType[2]

        binding.customSugars.tvValueCustom.text = nutriList[index ?: 0].sugars
        binding.customSugars.tvTypeCustom.text = nutriType[3]

        binding.ibLikeDetail.setImageResource(
            if (likeList[index ?: 0]) R.drawable.ic_heart_filled
            else R.drawable.ic_heart_empty
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iv_close = view.findViewById<ImageView>(R.id.iv_close_detail)

        iv_close.setOnClickListener {
            activity?.supportFragmentManager?.apply {
                beginTransaction().remove(this@DonutDetailFragment).commit()
                popBackStack()
            }
        }
        binding.ibLikeDetail.apply {
            setOnClickListener {
                if (likeList[index!!]) {
                    likeList[index!!] = false
                    setImageResource(R.drawable.ic_heart_empty)
                } else {
                    likeList[index!!] = true
                    setImageResource(R.drawable.ic_heart_filled)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            DonutDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_INDEX, param1)
                }
            }
    }
}