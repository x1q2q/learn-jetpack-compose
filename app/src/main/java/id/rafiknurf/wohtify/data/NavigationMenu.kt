package id.rafiknurf.wohtify.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

// data model for navigation
data class NavPage(var name: String, var icon : ImageVector,
                    var route: String)
object Routes{
    var AlbumPage = NavPage(name="Album", icon = Icons.Outlined.PlayArrow, route = "album" )
    var BandPage = NavPage(name="Band", icon = Icons.Outlined.Face, route = "band")
    var OrderPage = NavPage(name = "My Orders", icon = Icons.Outlined.ShoppingCart, route = "order")
    var ProfilePage = NavPage(name="Profile", icon = Icons.Outlined.Person, route = "profile")

    var pages = listOf(AlbumPage, OrderPage, BandPage, ProfilePage)
}
