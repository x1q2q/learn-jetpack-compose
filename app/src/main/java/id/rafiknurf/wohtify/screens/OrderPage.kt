package id.rafiknurf.wohtify.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun OrderPage(pdValues: PaddingValues) {
    Surface(
        modifier = Modifier.padding(vertical =pdValues.calculateTopPadding()).fillMaxWidth()) {
        Text("Order Page", textAlign = TextAlign.Center)
    }
}