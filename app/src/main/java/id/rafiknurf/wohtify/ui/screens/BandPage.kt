package id.rafiknurf.wohtify.ui.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun BandPage(pdValues : PaddingValues) {
    var url = "https://toe-music.bandcamp.com/merch"
    Surface(
        modifier = Modifier.padding(top = pdValues.calculateTopPadding())) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = pdValues.calculateBottomPadding())
        ) {
            AndroidView(factory = {
                WebView(it).apply{
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient() //customize the web view
                    loadUrl(url)
                }
            }, update = {
                it.loadUrl(url)
            })
        }
    }
//    val txtStyle = TextStyle(
//        color = Color.White,
//        fontFamily= FontFamily.Default,
//        fontWeight= FontWeight.Normal,
//        fontSize=16.sp
//    )
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(pdValues.calculateTopPadding())) {
//        val profileViewModel : ProfileViewModel = viewModel()
//        val name : String by profileViewModel.name.observeAsState("")
//        Spacer(Modifier.height(16.dp))
//        Text(name,
//            style= MaterialTheme.typography.headlineMedium.copy(color= Color.White),
//            fontWeight = FontWeight.Bold,
//            modifier= Modifier
//                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
//                .background(Primary)
//                .padding(16.dp)
//        )
//        Spacer(Modifier.height(16.dp))
//        Text("Deskripsi Banyak banget",style=txtStyle,
//            modifier= Modifier
//                .background(Secondary)
//                .padding(16.dp)
//        )
//        Spacer(Modifier.height(16.dp))
//        Card(modifier=Modifier.size(height = 240.dp, width = 480.dp)){
//            Image(painter = painterResource(R.drawable.pattern), contentDescription = "image pattern",
//                modifier=Modifier.fillMaxSize(), contentScale = ContentScale.FillWidth)
//        }
//        Spacer(Modifier.height(16.dp))
//    }
}