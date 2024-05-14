package com.example.wazitoecommerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Bird
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class BirdViewModel(var navController:NavHostController, var context: Context) {
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

    fun uploadBird(birdname: String,
                   birdgender: String,
                   birdage: String,
                   birdlocation: String,
                   birdcolor: String,
                   birdweight: String,
                   birddescription: String,
                   birdowner: String,
                   birdcontact: String,
                   filePath:Uri){
        val birdId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Birds/$birdId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var bird = Bird(birdname, birdgender, birdage, birdlocation, birdcolor, birdweight, birddescription, birdowner, birdcontact,imageUrl,birdId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Birds/$birdId")
                    databaseRef.setValue(bird).addOnCompleteListener {
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

    fun allBirds(
        bird:MutableState<Bird>,
        birds:SnapshotStateList<Bird>):SnapshotStateList<Bird>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Birds")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                birds.clear()
                for (snap in snapshot.children){
                    var retrievedBird = snap.getValue(Bird::class.java)
                    bird.value = retrievedBird!!
                    birds.add(retrievedBird)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return birds
    }

    fun deleteBird(birdId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Birds/$birdId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}