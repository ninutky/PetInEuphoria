package com.example.petineuphoria

import android.net.Uri
import java.io.Serializable

data class Animal(
    var uriPhoto : Uri? = null,
    var name: String? = null,
    var age: String? = null,
    var breed: String? = null,
    // @field:JvmField // use this annotation if your Boolean field is prefixed with 'is'
    var gender: Boolean? = null,
    var dog_or_cat: Boolean? = null,
    var a_color: Int? = null,
    var xmrwld: String? = null
) : Serializable