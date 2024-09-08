package id.rafiknurf.wohtify.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.rafiknurf.wohtify.data.ProfileViewModel


@Composable
fun ProfilePage(pdValues: PaddingValues) {
    Surface(
        modifier = Modifier
            .padding(vertical = pdValues.calculateTopPadding())
            .fillMaxWidth()) {
        Column(modifier= Modifier
            .padding(16.dp)
            .fillMaxWidth()){
            AppInput()
        }
    }
}

@Composable
fun AppInput(profileViewModel: ProfileViewModel = viewModel()) {
//    var name : String by rememberSaveable { mutableStateOf("") }
    val name : String by profileViewModel.name.observeAsState("")
    InputField(name = name, onNameChange = {profileViewModel.onNameChange(it)})
}

@Composable
fun InputField(name: String, onNameChange: (String) -> Unit){
    if(name.isNotEmpty()){
        Text(text="Hello, $name",modifier=Modifier.padding(bottom=8.dp),
            style=MaterialTheme.typography.headlineSmall)
    }
    OutlinedTextField(value = name,
        onValueChange = onNameChange,
        label={Text("Nama")},
        modifier = Modifier.fillMaxWidth())
}