package com.example.mangoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mangoapp.ui.theme.MangoAppTheme
import com.example.mangoapp.ui.theme.Purple0
import com.example.mangoapp.ui.theme.Purple1
import com.example.mangoapp.ui.theme.baseWhited

@Composable
fun HomePage (navController: NavHostController){
    var modifier = Modifier
        .fillMaxWidth(0.87f)
        .fillMaxHeight(0.4f)
        .scale(2.7f)
    var meteoCitiesList : List<CityMeteoClass> = listOf(
        CityMeteoClass(modifier, "Mid Rain",19,"Bengaluru,India",24,18),
        CityMeteoClass(modifier, "Fast Wind",22,"Chennai,India",26,18),
        CityMeteoClass(modifier, "Cloudy",22,"Delhi,India",32,27),
        CityMeteoClass(modifier, "Thunderstorm",20,"Mumbai,India",23,16)
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LinearGradient(modifier)
        Box(modifier = modifier){

            Ellipse(modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth(3f)
                .fillMaxHeight(0.6f))
            Ellipse(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .offset(0.dp, 450.dp))
        }


    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 30.dp, end = 15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Text(text = "Weather",style = TextStyle(fontSize = 33.sp,color = baseWhited))
        Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxWidth()){
            searchBar(Modifier.scale(1.45f))
        }
        var query by remember{ mutableStateOf("") }
        var active by remember{ mutableStateOf(false) }

        /*SearchBar(

            modifier = Modifier.height(35.dp).defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = {
                active = true
            },
            placeholder = {
                Text(text = "Search for a city of airport",style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp,color = baseWhited), modifier = Modifier.height(10.dp)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = MaterialTheme.colorScheme.onSurface,
                    contentDescription = null
                )
            },
            trailingIcon = {},
            content = {},
            active = active,
            onActiveChange = {},
            tonalElevation = 0.dp
        )*/


        //Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(state = rememberLazyListState(), modifier = Modifier
            //.background(Color.Blue)
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(140.dp), contentPadding = PaddingValues(top =  83.dp, bottom = 65.dp)
        ){

            items(meteoCitiesList,itemContent = { item -> MeteoElementAff(item, navController)})

        }
    }






}

@Composable
fun LinearGradient(modifier: Modifier){
    var grad = Brush.verticalGradient(listOf(Purple0, Purple1))
    Box(modifier = Modifier.background(grad))
}
@Composable
fun Ellipse(modifier: Modifier){

    Image(
        painter = painterResource(R.drawable.ellipse),
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        alignment = Alignment.Center,
        modifier = modifier,
    )



}
@Composable
fun searchBar(modifier: Modifier){
    Image(painter = painterResource(R.drawable.searchfield),
        alignment = Alignment.Center,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MangoAppTheme {
        HomePage(navController = rememberNavController())
    }
}