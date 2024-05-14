package com.example.wazitoecommerce.models

class Dog {
    var dogname:String = ""
    var doggender:String = ""
    var dogage:String = ""
    var doglocation:String = ""
    var dogcolor:String = ""
    var dogweight:String = ""
    var dogdescription:String = ""
    var dogowner:String = ""
    var dogcontact:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(
        dogname:String,
        doggender:String,
        dogage:String,
        doglocation:String,
        dogcolor:String,
        dogweight:String,
        dogdescription:String,
        dogowner:String,
        dogcontact:String,
        imageUrl:String,
        id:String
    ) {
        this.dogname = dogname
        this.doggender = doggender
        this.dogage = dogage
        this.doglocation = doglocation
        this.dogcolor = dogcolor
        this.dogweight = dogweight
        this.dogdescription = dogdescription
        this.dogowner = dogowner
        this.dogcontact = dogcontact
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}