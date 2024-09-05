package id.rafiknurf.wohtify

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rafiknurf.wohtify.ui.theme.Purple40
import id.rafiknurf.wohtify.ui.theme.Purple80

@Preview(showBackground = true, widthDp = 400)
@Composable
fun Playlists(modifier: Modifier = Modifier) {
    val txtStyle = TextStyle(
        color = Color.White,
        fontFamily= FontFamily.Default,
        fontWeight= FontWeight.Normal,
        fontSize=16.sp
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier.padding(16.dp)) {
        Text("Contoh Judul1",
            style= MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier=Modifier
                .background(Purple80)
                .padding(16.dp)
        )
        Spacer(modifier=Modifier.height(16.dp))
        Text("Deskripsi Banyak banget",style=txtStyle,
            modifier=Modifier
                .background(Purple40)
                .padding(16.dp)
        )
    }
}