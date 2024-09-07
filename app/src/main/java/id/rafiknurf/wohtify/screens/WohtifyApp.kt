package id.rafiknurf.wohtify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.rafiknurf.wohtify.R
import id.rafiknurf.wohtify.components.NavBar
import id.rafiknurf.wohtify.models.Routes
import id.rafiknurf.wohtify.ui.theme.Secondary


@Composable
fun WohtifyApp() {
    var selectedRoute = remember { mutableStateOf(Routes.AlbumPage.route)}
    Scaffold(
        topBar = {
            AppBar()
        }, content =  {
            when(selectedRoute.value){
                Routes.AlbumPage.route -> AlbumPage(pdValues = it)
                Routes.OfferPage.route -> OfferPage(pdValues = it)
                Routes.OrderPage.route -> OrderPage(pdValues = it)
                Routes.ProfilePage.route -> ProfilePage(pdValues = it)
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute=selectedRoute.value,
                onChange = { newRoute->
                // `it`(default) / `newRoute` is the route that user click
                selectedRoute.value = newRoute
            })
        }
//        floatingActionButton = { FabBtn(onClick = {println("Hello")}) }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Secondary,
        titleContentColor = Color.White,
    ),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
        title = {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Image(modifier= Modifier.size(45.dp),contentScale = ContentScale.Fit,painter = painterResource(R.drawable.music_player), contentDescription = "Logo")
                Text("Bandcamp Pre-order")
            }
        })
}

//@Composable
//fun FabBtn(onClick: () -> Unit) {
//    FloatingActionButton(onClick = {onClick()},
//        contentColor = Color.White,
//        containerColor = Primary) {
//        Icon(Icons.Filled.Add, "Add")
//    }
//}