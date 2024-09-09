package id.rafiknurf.wohtify.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import id.rafiknurf.wohtify.data.Album
import id.rafiknurf.wohtify.data.CartRepository
import id.rafiknurf.wohtify.data.ItemInCart
import id.rafiknurf.wohtify.ui.theme.LightGray
import id.rafiknurf.wohtify.ui.theme.Primary

@Composable
fun OrderPage(pdValues: PaddingValues, cartRepository: CartRepository) {
    Surface(
        modifier = Modifier
            .padding(vertical = pdValues.calculateTopPadding())
            .fillMaxWidth()) {
        LazyColumn(){
            if(cartRepository.cart.isEmpty()){
                item{
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(),
                        shape= RoundedCornerShape(12.dp),
                        modifier=Modifier.padding(16.dp)
                    ){
                        Text(
                            text = "Your Order is Empty",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(10.dp).fillMaxWidth()
                        )
                    }
                }
            }
            items(cartRepository.cart){
                CartItem(it, onDelete={
                    cartRepository.cartRemove(it)
                })
            }
        }
    }
}

@Composable
fun CartItem(it:ItemInCart, onDelete: (Album) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .border(border = BorderStroke(width = 1.dp, Color.LightGray))
            .background(LightGray)
            .padding(6.dp)
    ){
        Text("${it.quantity}x", textAlign = TextAlign.Left)
        Text(it.album.name)
        Text("${it.album.price.toRupiah()}")
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete the cart",
            colorFilter = ColorFilter.tint(Primary),
            modifier= Modifier.clickable{
                onDelete(it.album)
            }
        )
    }
}