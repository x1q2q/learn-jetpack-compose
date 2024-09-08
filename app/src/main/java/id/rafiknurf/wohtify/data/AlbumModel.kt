package id.rafiknurf.wohtify.data

class Album(var id: Int, var name: String,
            var price: Double, var image: String){
    val imageUrl  get() ="https://firtman.github.io/coffeemasters/api/images/${this.image}"
}

class Category(var name: String, var album: MutableList<Album>)

class ItemInCart(var album: Album, var quantity: Int)