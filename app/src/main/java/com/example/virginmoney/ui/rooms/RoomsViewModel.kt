package com.example.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import com.example.virginmoney.data.repository.VirginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    val  repository: VirginRepository
)
    : ViewModel() {


    val rooms = MutableLiveData<ArrayList<RoomsModelItemModel>>()


    fun getRooms(){
        viewModelScope.launch {
            rooms.postValue(repository.getRooms())

        }

    }
}