package com.shubhamvashishth5.data.datasource.remote.request.movie

sealed class MovieRequest {

    data class PopularRequestQuery(
        val language:String,
        val page:Int,
        val region:String?=null
    ){
        fun toQuery():Map<String,String>{
            return mutableMapOf(
                "language" to language,
                "page" to page.toString(),
            ).apply {
                region?.let {
                    this["region"] = region
                }
            }
        }
    }

}