package id.rafiknurf.wohtify.data

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import id.rafiknurf.wohtify.services.API
import kotlinx.coroutines.launch

class CartRepository(app: Application) : AndroidViewModel(app){
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    private fun fetchData(){
        try{
            viewModelScope.launch{
                menu = API.menuService.fetchMenu()
            }
        }catch(ex: Exception){
            // todo
            println(ex)
        }
    }
    init{
        fetchData()
    }

    fun cartAdd(album: Album){
        // its not adding to the array but create array everyTime
        var found =  false
        cart.forEach{
            if(album.id == it.album.id){
                it.quantity++
                found = true
            }
        }
        // its a state, we have to changet the whole list, not mutate its
        if(!found){
//            *cart.toTypedArray() => is to clone the list, create copy
            cart = listOf(*cart.toTypedArray(),ItemInCart(album, 1))
        }
    }

    fun cartRemove(album: Album){
        val aux = cart.toMutableList()
        aux.removeAll{it.album.id == album.id}
        // its a state, we have to change the whole list, not mutate its
        cart = listOf(*aux.toTypedArray())
    }

    fun cartClear(){
        // its a state, we have to change the whole list, not mutate its
        cart = listOf()
    }
    fun cartTotal(): Double{
        var sum = 0.0
        for(item in cart){
            sum += item.quantity*item.album.price
        }
        return sum
    }
}