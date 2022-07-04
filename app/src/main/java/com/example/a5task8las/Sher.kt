package com.example.a5task8las

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Sher :Parcelable {
    var name:String? = null
    var txt:String? = null
    var liked:Boolean? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        txt = parcel.readString()
        liked = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    constructor(name:String?, text:String?, like:Boolean?):this(){
        this.liked = like
        this.name = name
        this.txt = text
    }

    constructor()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(txt)
        parcel.writeValue(liked)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sher> {
        override fun createFromParcel(parcel: Parcel): Sher {
            return Sher(parcel)
        }

        override fun newArray(size: Int): Array<Sher?> {
            return arrayOfNulls(size)
        }
    }
}