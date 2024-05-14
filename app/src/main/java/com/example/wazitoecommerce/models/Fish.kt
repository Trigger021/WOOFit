package com.example.wazitoecommerce.models

class Fish {
    var fishname: String = ""
    var fishgender: String = ""
    var fishage: String = ""
    var fishlocation: String = ""
    var fishcolor: String = ""
    var fishweight: String = ""
    var fishdescription: String = ""
    var fishowner: String = ""
    var fishcontact: String = ""
    var imageUrl: String = ""
    var id: String = ""

    constructor(
        fishname: String,
        fishgender: String,
        fishage: String,
        fishlocation: String,
        fishcolor: String,
        fishweight: String,
        fishdescription: String,
        fishowner: String,
        fishcontact: String,
        imageUrl: String,
        id: String
    ) {
        this.fishname = fishname
        this.fishgender = fishgender
        this.fishage = fishage
        this.fishlocation = fishlocation
        this.fishcolor = fishcolor
        this.fishweight = fishweight
        this.fishdescription = fishdescription
        this.fishowner = fishowner
        this.fishcontact = fishcontact
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}