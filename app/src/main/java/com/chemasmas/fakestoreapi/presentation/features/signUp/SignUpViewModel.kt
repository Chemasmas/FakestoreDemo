package com.chemasmas.fakestoreapi.presentation.features.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    //TODO inject the repository
) : ViewModel() {

    private val _formData = MutableLiveData<FormDataClass>(FormDataClass())
    val formData = _formData.value

    fun setUserName(username: String){
        _formData.value?.username = username
    }
    fun setEmail(email: String){
        _formData.value?.email = email
    }
    fun setPassword(password: String){
        _formData.value?.password = password
    }
    fun setConfirmPassword(confirmPassword: String){
        _formData.value?.confirmPassword = confirmPassword
    }
    fun setFirstName(firstName: String){
        _formData.value?.fullName?.firstName = firstName
    }
    fun setLastName(lastName: String){
        _formData.value?.fullName?.lastName = lastName
    }
    fun setCity(city: String){
        _formData.value?.address?.city = city
    }
    fun setStreet(street: String){
        _formData.value?.address?.street = street
    }
    fun setNumber(number: Int){
        _formData.value?.address?.number = number
    }
    fun setZipCode(zipCode: String){
        _formData.value?.address?.zipCode = zipCode
    }

    fun sendForm() {
        TODO("Not yet implemented")
        // TODO call the repository to send the form
    }
}