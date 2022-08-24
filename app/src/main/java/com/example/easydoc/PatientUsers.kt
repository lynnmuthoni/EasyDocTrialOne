package com.example.easydoc

import android.media.Image

class User {
    var name:String = ""
    var email:String = ""
    var phoneNumber:String = ""
    var profilepic:Int = ""
    constructor(name:String,email:String,Number:String,Image:Int){
        this.name = name
        this.email = email
        this.phoneNumber = Number
        this.profilepic = Image
    }
    constructor()
}