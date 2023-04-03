package com.example.virginmoney

import androidx.lifecycle.ViewModel
import com.example.virginmoney.data.repository.VirginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class DetailsViewModel @Inject constructor(
    repository: VirginRepository
) : ViewModel() {


}