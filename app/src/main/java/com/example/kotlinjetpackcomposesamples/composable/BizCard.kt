package com.example.kotlinjetpackcomposesamples.composable

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinjetpackcomposesamples.R

@Composable
fun BizCard(name: String) {
    val buttonClickedState= remember {
        mutableStateOf(value = false)
    }
    Surface(modifier =
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(8.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White,
            elevation = 4.dp) {
            Column(modifier = Modifier
                .height(300.dp) ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,) {
                CreateImageProfile()
                Divider( )
                CreateContactInfo()
                Button(onClick = {
                   buttonClickedState.value=!buttonClickedState.value
                }) {
                    Text(text = "Portfolio",
                    style = MaterialTheme.typography.button)
                }
                if(buttonClickedState.value){
                    Content()
                }else{
                    Box() {
                        
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxWidth()
        .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(3.dp),
             shape = RoundedCornerShape(corner = CornerSize(6.dp)),
             border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Protfolio(data= listOf("Project 1","Project 2","Project 3",
                "Project 1","Project 2","Project 3"));
        }
    }
}

@Composable
fun Protfolio(data: List<String>) {
    LazyColumn(){
        items(data) { item->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
            shape = RectangleShape) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)
                    ) {
                    CreateImageProfile(modifier = Modifier.size(75.dp))
                    Column(modifier = Modifier.padding(7.dp).align(CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "This is a good project", style = MaterialTheme.typography.body2)
                    }
                }

            }
        }
    }
}


@Composable
private fun CreateContactInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Ahmad Aghazadeh",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Programmer",
            Modifier.padding(3.dp)
        )
        Text(
            text = "Ahmad.Aghazadeh.a@gmail.com",
            Modifier.padding(3.dp)
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier =
        modifier
            .size(150.dp)
            .padding(8.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSecondary.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.download),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCard("Android")
}