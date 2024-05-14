package com.example.wazitoecommerce.models

class Cat {
    var catname:String = ""
    var catgender:String = ""
    var catage:String = ""
    var catlocation:String = ""
    var catcolor:String = ""
    var catweight:String = ""
    var catdescription:String = ""
    var catowner:String = ""
    var catcontact:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(
        catname: String,
        catgender: String,
        catage: String,
        catlocation: String,
        catcolor: String,
        catweight: String,
        catdescription: String,
        catowner: String,
        catcontact: String,
        imageUrl: String,
        id: String
    ) {
        this.catname = catname
        this.catgender = catgender
        this.catage = catage
        this.catlocation = catlocation
        this.catcolor = catcolor
        this.catweight = catweight
        this.catdescription = catdescription
        this.catowner = catowner
        this.catcontact = catcontact
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}