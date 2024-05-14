package com.example.wazitoecommerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Dog
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class DogViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadDog(dogname:String,
                  doggender:String,
                  dogage:String,
                  doglocation:String,
                  dogcolor:String,
                  dogweight:String,
                  dogdescription:String,
                  dogowner:String,
                  dogcontact:String,
                  filePath:Uri){
        val dogId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Dogs/$dogId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var dog = Dog(dogname,doggender,dogage,doglocation,dogcolor,dogweight,dogdescription,dogowner,dogcontact,imageUrl,dogId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Dogs/$dogId")
                    databaseRef.setValue(dog).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allDogs(
        dog:MutableState<Dog>,
        dogs:SnapshotStateList<Dog>):SnapshotStateList<Dog>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Dogs")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dogs.clear()
                for (snap in snapshot.children){
                    var retrievedDog = snap.getValue(Dog::class.java)
                    dog.value = retrievedDog!!
                    dogs.add(retrievedDog)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return dogs
    }

    fun deleteDog(dogId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Dogs/$dogId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}