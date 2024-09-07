package id.rafiknurf.wohtify.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ProfilePage(pdValues: PaddingValues) {
    Surface(
        modifier = Modifier.padding(vertical =pdValues.calculateTopPadding())) {
        Text("Profile Page")
    }
}