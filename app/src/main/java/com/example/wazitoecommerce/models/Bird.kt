package com.example.wazitoecommerce.models

class Bird {
    var birdname:String = ""
    var birdgender:String = ""
    var birdage:String = ""
    var birdlocation:String = ""
    var birdcolor:String = ""
    var birdweight:String = ""
    var birddescription:String = ""
    var birdowner:String = ""
    var birdcontact:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(
        birdname: String,
        birdgender: String,
        birdage: String,
        birdlocation: String,
        birdcolor: String,
        birdweight: String,
        birddescription: String,
        birdowner: String,
        birdcontact: String,
        imageUrl: String,
        id: String
    ) {
        this.birdname = birdname
        this.birdgender = birdgender
        this.birdage = birdage
        this.birdlocation = birdlocation
        this.birdcolor = birdcolor
        this.birdweight = birdweight
        this.birddescription = birddescription
        this.birdowner = birdowner
        this.birdcontact = birdcontact
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}