package id.rafiknurf.wohtify.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel(){
    private val _name: MutableLiveData<String> = MutableLiveData("")
    val name: LiveData<String> = _name;

    fun onNameChange(newName: String){
        _name.value = newName
    }
}