package id.rafiknurf.wohtify.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CartRepository{
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())
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