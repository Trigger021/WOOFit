package com.example.wazitoecommerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Cat
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class CatViewModel(var navController:NavHostController, var context: Context) {
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

    fun uploadCat(catname: String,
                  catgender: String,
                  catage: String,
                  catlocation: String,
                  catcolor: String,
                  catweight: String,
                  catdescription: String,
                  catowner: String,
                  catcontact: String,
                  filePath:Uri){
        val catId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Cats/$catId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var cat = Cat(catname,catgender,catage,catlocation,catcolor,catweight,catdescription,catowner,catcontact,imageUrl,catId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Cats/$catId")
                    databaseRef.setValue(cat).addOnCompleteListener {
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

    fun allCats(
        cat:MutableState<Cat>,
        cats:SnapshotStateList<Cat>):SnapshotStateList<Cat>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Cats")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                cats.clear()
                for (snap in snapshot.children){
                    var retrievedCat = snap.getValue(Cat::class.java)
                    cat.value = retrievedCat!!
                    cats.add(retrievedCat)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return cats
    }

    fun deleteCat(catId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Cats/$catId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}