package com.example.wazitoecommerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Fish
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class FishViewModel(var navController:NavHostController, var context: Context) {
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

    fun uploadFish(fishname: String,
                   fishgender: String,
                   fishage: String,
                   fishlocation: String,
                   fishcolor: String,
                   fishweight: String,
                   fishdescription: String,
                   fishowner: String,
                   fishcontact: String,
                   filePath:Uri){
        val fishId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Fishs/$fishId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var fish = Fish(fishname,fishgender,fishage,fishlocation,fishcolor,fishweight,fishdescription,fishowner,fishcontact,imageUrl,fishId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Fishs/$fishId")
                    databaseRef.setValue(fish).addOnCompleteListener {
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

    fun allFishs(
        fish:MutableState<Fish>,
        fishs:SnapshotStateList<Fish>):SnapshotStateList<Fish>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Products")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                fishs.clear()
                for (snap in snapshot.children){
                    var retrievedFish = snap.getValue(Fish::class.java)
                    fish.value = retrievedFish!!
                    fishs.add(retrievedFish)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return fishs
    }

    fun deleteFish(fishId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Fishs/$fishId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}