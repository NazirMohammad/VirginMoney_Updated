package com.example.virginmoney

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.virginmoney.data.model.people.DataModel
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.FragmentDetailsBinding
import com.example.virginmoney.databinding.FragmentPeopleBinding
import com.example.virginmoney.ui.people.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel =
            ViewModelProvider(this)[DetailsViewModel::class.java]
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)


        val people = arguments?.getSerializable("datamodel") as PeopleModelItemModel?

        binding.people1.text = people?.id.toString()
        binding.people2.text= people?.firstName
        binding.people3.text= people?.lastName
        binding.people4.text= people?.jobtitle
        binding.people5.text= people?.email

        return binding.root






    }

}