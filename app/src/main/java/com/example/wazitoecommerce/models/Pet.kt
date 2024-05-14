package com.example.wazitoecommerce.models

class Pet {
    var petname:String = ""
    var petgender:String = ""
    var petage:String = ""
    var petlocation:String = ""
    var petcolor:String = ""
    var petweight:String = ""
    var petdescription:String = ""
    var petowner:String = ""
    var petcontact:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(
        petname: String,
        petgender: String,
        petage: String,
        petlocation: String,
        petcolor: String,
        petweight: String,
        petdescription: String,
        petowner: String,
        petcontact: String,
        imageUrl: String,
        id: String
    ) {
        this.petname = petname
        this.petgender = petgender
        this.petage = petage
        this.petlocation = petlocation
        this.petcolor = petcolor
        this.petweight = petweight
        this.petdescription = petdescription
        this.petowner = petowner
        this.petcontact = petcontact
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}