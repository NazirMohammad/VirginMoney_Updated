package com.example.virginmoney.data.repository

import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel

interface VirginRepository {

    suspend fun getPeople():  ArrayList<PeopleModelItemModel>
    suspend fun getRooms():  ArrayList<RoomsModelItemModel>

}