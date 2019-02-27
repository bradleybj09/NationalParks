package com.example.nationalparks.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.nationalparks.model.room.Site

@Dao
interface SiteDao {

    @Query("SELECT * FROM site WHERE campgroundId = :campgroundId")
    fun getSitesByCampgroundId(campgroundId: Long): LiveData<List<Site>>

    @Query("SELECT * FROM site JOIN campground ON site.campgroundId = campground.campgroundId WHERE parkId = :parkId")
    fun getSitesByParkId(parkId: Long): LiveData<List<Site>>
}