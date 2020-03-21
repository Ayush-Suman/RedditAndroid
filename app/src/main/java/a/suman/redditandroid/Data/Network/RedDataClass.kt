package a.suman.redditandroid.Data.Network

import a.suman.redditandroid.Data.Local.RedTable

data class RedDataClass(
    var data:Data1
)

data class Data1(
    var children:List<Data2>
)

data class Data2(
    var data: RedTable
)
