package id.rafiknurf.wohtify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rafiknurf.wohtify.models.NavPage
import id.rafiknurf.wohtify.models.Routes
import id.rafiknurf.wohtify.ui.theme.LightGray
import id.rafiknurf.wohtify.ui.theme.LightGreen
import id.rafiknurf.wohtify.ui.theme.LightRed
import id.rafiknurf.wohtify.ui.theme.Primary
import id.rafiknurf.wohtify.ui.theme.Secondary

@Composable
fun NavBarItem(page: NavPage, selected:Boolean = false, modifier : Modifier =Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal=12.dp)){
        Image(imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if(selected) Color.White else Color.Gray
            ),
            modifier= Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(
            page.name,
            fontSize=12.sp,
            color=if(selected) Color.White else Color.Gray
        )
    }
}

@Composable
fun NavBar(selectedRoute: String = Routes.AlbumPage.route,
           onChange: (String) -> Unit = {}) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(12.dp)
            .fillMaxWidth()){
        for(page in Routes.pages){
            NavBarItem(page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                })
        }
    }
}