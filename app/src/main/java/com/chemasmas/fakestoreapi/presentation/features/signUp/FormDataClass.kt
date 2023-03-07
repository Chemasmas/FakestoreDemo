package com.chemasmas.fakestoreapi.presentation.features.signUp

data class FormDataClass(
    var username: String="",
    var email: String="",
    var password: String="",
    var confirmPassword: String="",
    var fullName: FullNameUserDataClass = FullNameUserDataClass(),
    var address: AddressUserDataClass = AddressUserDataClass()
)

data class FullNameUserDataClass(
    var firstName: String="",
    var lastName: String="",
)

data class AddressUserDataClass(
    var city: String="",
    var street: String="",
    var number: Int= 0,
    var zipCode: String="",
)