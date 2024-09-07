package id.rafiknurf.wohtify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rafiknurf.wohtify.ui.theme.Primary

@Composable
fun AlbumPage(pdValues: PaddingValues){
    Surface(
        modifier = Modifier.padding(vertical =pdValues.calculateTopPadding())) {
        Column{
            Text(
                text = "New Digital Album Releases",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Primary
            )
            ScrollContent(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun ScrollContent(modifier: Modifier) {
    LazyColumn (modifier = Modifier){
        items(50){ index->
            Card(colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                Text("Item ke- $index", modifier = Modifier
                    .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp)
            }

        }
    }
}