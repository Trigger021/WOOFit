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
import com.example.wazitoecommerce.data.CatViewModel
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCatsScreen(navController:NavHostController){
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
            text = "Add Cat",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Orange
        )

        var catname by remember { mutableStateOf("") }
        var catgender by remember { mutableStateOf("") }
        var catage by remember { mutableStateOf("") }
        var catlocation by remember { mutableStateOf("") }
        var catcolor by remember { mutableStateOf("") }
        var catweight by remember { mutableStateOf("") }
        var catdescription by remember { mutableStateOf("") }
        var catowner by remember { mutableStateOf("") }
        var catcontact by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = catname,
            onValueChange = { catname = it },
            label = { Text(text = "Cat's name *") },
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
            value = catgender,
            onValueChange = { catgender = it },
            label = { Text(text = "Cat's Gender *") },
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
            value = catage,
            onValueChange = { catage = it },
            label = { Text(text = "Cat's age *") },
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
            value = catlocation,
            onValueChange = { catlocation = it },
            label = { Text(text = "Cat's Location *") },
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
            value = catcolor,
            onValueChange = { catcolor = it },
            label = { Text(text = "Cat's Color *") },
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
            value = catweight,
            onValueChange = { catweight = it },
            label = { Text(text = "Cat's Weight *") },
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
            value = catdescription,
            onValueChange = { catdescription = it },
            label = { Text(text = "Cat's Description *") },
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
            value = catowner,
            onValueChange = { catowner = it },
            label = { Text(text = "Cat's Owner *") },
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
            value = catcontact,
            onValueChange = { catcontact = it },
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
        CatImagePicker(modifier,context, navController, catname.trim(), catgender.trim(), catage.trim(), catlocation.trim(), catcolor.trim(), catweight.trim(), catdescription.trim(), catowner.trim(), catcontact.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun CatImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController,
                   catname: String,
                   catgender: String,
                   catage: String,
                   catlocation: String,
                   catcolor: String,
                   catweight: String,
                   catdescription: String,
                   catowner: String,
                   catcontact: String,
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
                var catRepository = CatViewModel(navController,context)
                catRepository.uploadCat(catname,catgender,catage,catlocation,catcolor,catweight,catdescription,catowner,catcontact,imageUri!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddCatsScreenPreview(){
    WazitoECommerceTheme {
        AddCatsScreen(navController = rememberNavController())
    }
}