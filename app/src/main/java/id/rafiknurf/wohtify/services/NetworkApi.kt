package id.rafiknurf.wohtify.services

import id.rafiknurf.wohtify.data.Category
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetworkApiService{
    @GET("menu.json")
    suspend fun fetchMenu(): List<Category>
}

object API{
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://firtman.github.io/coffeemasters/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val menuService: NetworkApiService by lazy{
        retrofit.create(NetworkApiService::class.java)
    }
}