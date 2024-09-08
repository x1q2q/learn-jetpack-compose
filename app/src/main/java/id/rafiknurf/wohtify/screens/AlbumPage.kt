package id.rafiknurf.wohtify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rafiknurf.wohtify.R
import id.rafiknurf.wohtify.models.Album
import id.rafiknurf.wohtify.models.CartRepository
import id.rafiknurf.wohtify.ui.theme.LightGray
import id.rafiknurf.wohtify.ui.theme.Primary

fun Double.format(digits:Int) = "%.${digits}f".format(this)


 @Composable
fun AlbumPage(pdValues: PaddingValues, cartRepository: CartRepository){
    Surface(
        modifier = Modifier.padding(top = pdValues.calculateTopPadding())) {
        Column(modifier = Modifier.padding(bottom= pdValues.calculateBottomPadding())){
            Text(
                text = "New Digital Album Releases",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                color = Primary
            )
            LazyColumn{
                items(5){
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(),
                        shape= RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .background(LightGray)
                            .padding(12.dp)
                    ){
                        AlbumItem(album = Album(1, "Now I See The Light",2000.0, ""), onAdd = {})
                    }
                }
            }
        }
    }
}

@Composable
fun AlbumItem(album: Album, onAdd:(Album)->Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)){
        Image(
            painter= painterResource(id = R.drawable.toe_nistl),
            contentDescription = "Image for ${album.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            ){
            Column{
                Text(album.name, fontWeight = FontWeight.Bold)
                Text("Rp. ${album.price.format(2)}")
            }
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = Color.White
                ),
                onClick={
                    onAdd(album)
                }
            ){
                Text("Tambah")
            }
        }
    }
    
}


//@Composable
//fun ScrollContent(modifier: Modifier) {
//    LazyColumn (modifier = Modifier){
//        items(50){ index->
//            Card(colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surfaceVariant,
//            ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)) {
//                Text("Item ke- $index", modifier = Modifier
//                    .padding(16.dp),
//                    textAlign = TextAlign.Center,
//                    fontSize = 22.sp)
//            }
//
//        }
//    }
//}
