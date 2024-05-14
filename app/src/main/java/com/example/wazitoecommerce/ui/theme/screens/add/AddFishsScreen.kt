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
import com.example.wazitoecommerce.data.FishViewModel
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddFishsScreen(navController:NavHostController){
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
            text = "Add Fish",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Orange
        )

        var fishname by remember { mutableStateOf("") }
        var fishgender by remember { mutableStateOf("") }
        var fishage by remember { mutableStateOf("") }
        var fishlocation by remember { mutableStateOf("") }
        var fishcolor by remember { mutableStateOf("") }
        var fishweight by remember { mutableStateOf("") }
        var fishdescription by remember { mutableStateOf("") }
        var fishowner by remember { mutableStateOf("") }
        var fishcontact by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = fishname,
            onValueChange = { fishname = it },
            label = { Text(text = "Fish's Name *") },
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
            value = fishgender,
            onValueChange = { fishgender = it },
            label = { Text(text = "Fish's Gender *") },
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
            value = fishage,
            onValueChange = { fishage = it },
            label = { Text(text = "Fish's age *") },
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
            value = fishlocation,
            onValueChange = { fishlocation = it },
            label = { Text(text = "Fish's Location *") },
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
            value = fishcolor,
            onValueChange = { fishcolor = it },
            label = { Text(text = "Fish's Color *") },
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
            value = fishweight,
            onValueChange = { fishweight = it },
            label = { Text(text = "Fish's Weight *") },
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
            value = fishdescription,
            onValueChange = { fishdescription = it },
            label = { Text(text = "Fish's Description *") },
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
            value = fishowner,
            onValueChange = { fishowner = it },
            label = { Text(text = "Fish's Owner *") },
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
            value = fishcontact,
            onValueChange = { fishcontact = it },
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
        FishImagePicker(modifier,context, navController,fishname.trim(),fishgender.trim(),fishage.trim(),fishlocation.trim(),fishcolor.trim(),fishweight.trim(),fishdescription.trim(),fishowner.trim(),fishcontact.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun FishImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController,
                    fishname: String,
                    fishgender: String,
                    fishage: String,
                    fishlocation: String,
                    fishcolor: String,
                    fishweight: String,
                    fishdescription: String,
                    fishowner: String,
                    fishcontact: String,
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
                var fishRepository = FishViewModel(navController,context)
                fishRepository.uploadFish(fishname,fishgender,fishage,fishlocation,fishcolor,fishweight,fishdescription,fishowner,fishcontact,imageUri!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddFishsScreenPreview(){
    WazitoECommerceTheme {
        AddFishsScreen(navController = rememberNavController())
    }
}