package com.example.petineuphoria

import android.R.string
import android.net.Uri
import java.io.Serializable
import java.util.Date


data class Animal(
    var uid: String? = null,
    var uriPhoto: Uri? = null,
    var color: Int?= null,
    var name: String? = null,
    var age: String? = null,
    var breed: String? = null,
    // @field:JvmField // use this annotation if your Boolean field is prefixed with 'is'
    var gender: Boolean? = null,
    var dog_or_cat: Boolean? = null,
    var a_color: Int? = null,
    var xmrwld: String? = null,
    var date: Date? = null

) : Serializable
