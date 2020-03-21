package a.suman.redditandroid.Data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RedTable(
    @PrimaryKey
    val id:String,
    val title:String,
    val thumbnail:String,
    val selftext:String,
    val url:String
)