package com.example.wazitoecommerce.ui.theme.screens.add

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.data.DogViewModel
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDogsScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.petback3),
                contentScale = ContentScale.FillBounds
            )
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Dog",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Orange
        )

        var dogname by remember { mutableStateOf("") }
        var doggender by remember { mutableStateOf("") }
        var dogage by remember { mutableStateOf("") }
        var doglocation by remember { mutableStateOf("") }
        var dogcolor by remember { mutableStateOf("") }
        var dogweight by remember { mutableStateOf("") }
        var dogdescription by remember { mutableStateOf("") }
        var dogowner by remember { mutableStateOf("") }
        var dogcontact by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = dogname,
            onValueChange = { dogname = it },
            label = { Text(text = "Dog's name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = doggender,
            onValueChange = { doggender = it },
            label = { Text(text = "Dog's Gender *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogage,
            onValueChange = { dogage = it },
            label = { Text(text = "Dog's age *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = doglocation,
            onValueChange = { doglocation = it },
            label = { Text(text = "Dog's Location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogcolor,
            onValueChange = { dogcolor = it },
            label = { Text(text = "Dog's Color *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogweight,
            onValueChange = { dogweight = it },
            label = { Text(text = "Dog's Weight *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogdescription,
            onValueChange = { dogdescription = it },
            label = { Text(text = "Dog's Description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogowner,
            onValueChange = { dogowner = it },
            label = { Text(text = "Dog's Owner *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = dogcontact,
            onValueChange = { dogcontact = it },
            label = { Text(text = "owner's Contact *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))




        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        DogImagePicker(modifier,context, navController,dogname.trim(),doggender.trim(),dogage.trim(),doglocation.trim(),dogcolor.trim(),dogweight.trim(),dogdescription.trim(),dogowner.trim(),dogcontact.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun DogImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController,
                   dogname:String,
                   doggender:String,
                   dogage:String,
                   doglocation:String,
                   dogcolor:String,
                   dogweight:String,
                   dogdescription:String,
                   dogowner:String,
                   dogcontact:String,
) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var dogRepository = DogViewModel(navController,context)
                dogRepository.uploadDog(dogname,doggender,dogage,doglocation,dogcolor,dogweight,dogdescription,dogowner,dogcontact,imageUri!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddDogsScreenPreview(){
    WazitoECommerceTheme {
        AddDogsScreen(navController = rememberNavController())
    }
}