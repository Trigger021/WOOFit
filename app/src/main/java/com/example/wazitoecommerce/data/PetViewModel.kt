package com.example.wazitoecommerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Pet
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class PetViewModel(var navController:NavHostController, var context: Context) {
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

    fun uploadPet(petname: String,
                  petgender: String,
                  petage: String,
                  petlocation: String,
                  petcolor: String,
                  petweight: String,
                  petdescription: String,
                  petowner: String,
                  petcontact: String,
                  filePath:Uri){
        val petId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Pets/$petId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var pet = Pet(petname,petgender,petage,petlocation,petcolor,petweight,petdescription,petowner,petcontact,imageUrl,petId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Pets/$petId")
                    databaseRef.setValue(pet).addOnCompleteListener {
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

    fun allPets(
        pet:MutableState<Pet>,
        pets:SnapshotStateList<Pet>):SnapshotStateList<Pet>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Pets")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                pets.clear()
                for (snap in snapshot.children){
                    var retrievedPet = snap.getValue(Pet::class.java)
                    pet.value = retrievedPet!!
                    pets.add(retrievedPet)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return pets
    }

    fun deletePet(petId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Pets/$petId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}