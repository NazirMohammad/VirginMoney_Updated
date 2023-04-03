package com.example.virginmoney.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.data.repository.VirginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel  @Inject constructor(
    val repository: VirginRepository
): ViewModel() {


    val  people = MutableLiveData<ArrayList<PeopleModelItemModel>>()


fun getPeople(){
    viewModelScope.launch {
        people.postValue(repository.getPeople())
    }
}

}
