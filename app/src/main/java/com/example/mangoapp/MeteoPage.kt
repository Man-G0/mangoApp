package com.example.mangoapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mangoapp.ui.theme.MangoAppTheme
import com.example.mangoapp.ui.theme.Purple0
import com.example.mangoapp.ui.theme.Purple1
import com.example.mangoapp.ui.theme.baseWhited
import com.example.mangoapp.ui.theme.grey

@Composable
fun MeteoPage(cityName : String?, temp: Int?, meteo:String?,hightemp : Int?, lowtemp:Int?,navController: NavHostController) {
    var grad = Brush.verticalGradient(listOf(Purple0, Purple1))
    /*when(cityMeteo.meteo.lowercase()){
        "cloudy" -> iconMet = R.drawable.sun_cloud_angled_rain
        "fast wind" -> iconMet = R.drawable.moon_cloud_fast_wind
        "mid rain" -> iconMet = R.drawable.moon_clou_id_rain
        "thunderstorm" -> iconMet = R.drawable.cloud_3_zap
    }*/
    Box(
        Modifier
            .fillMaxSize()
            .background(grad))
    {
        Image(painter = painterResource(id = R.drawable.starry_mountain), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        Box(Modifier.fillMaxWidth().padding(start = 25.dp, top = 25.dp),contentAlignment = Alignment.TopStart){
            Icon(imageVector = Icons.Default.ArrowBack,contentDescription = null, tint = baseWhited, modifier = Modifier.scale(2f).clickable {
                navController.popBackStack()
            } )

        }

                Box(
            Modifier
                .fillMaxSize()
                .padding(bottom = 250.dp),contentAlignment = Alignment.BottomCenter){
            Image(painter = painterResource(id = R.drawable.house), contentDescription = null, modifier = Modifier.scale(3.1f))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

            var ville = cityName
            var im = R.drawable.ic_launcher_foreground
            when(meteo.toString().lowercase()){
                "cloudy" -> im = R.drawable.property_now_bitrain4
                "fast wind" -> im = R.drawable.property_now_windy
                "mid rain" -> im = R.drawable.property_now_rainnight
                "thunderstorm" -> im = R.drawable.property_now_rain
            }
            var meteoCitiesList : List<Int> = listOf(
                R.drawable.property_twelveam,
                im,
                R.drawable.property_onepm,
                R.drawable.property_twelvepm,
                R.drawable.property_oneam,
                R.drawable.property_twelvepm,

            )
            Spacer(Modifier.height(70.dp))
            Text(text = ville.toString(),style = androidx.compose.ui.text.TextStyle(fontSize = 34.sp,color = baseWhited))
            Text(text = " ${temp}°",style = androidx.compose.ui.text.TextStyle(fontSize = 96.sp,color = baseWhited),modifier = Modifier.offset(y=-20.dp))
            Text(text = "${meteo}",style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp,color = grey.copy(alpha = 0.6f)),modifier = Modifier.offset(y=-35.dp))
            Text(text = "H:${hightemp}°  L:${lowtemp}°",style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp,color = baseWhited),modifier = Modifier.offset(y=-35.dp))
            Spacer(modifier = Modifier.height(195.dp))
            Box(modifier = Modifier
                .fillMaxSize()
                .offset(y = 30.dp)){
                Image(painter = painterResource(id = R.drawable.model), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                Image(painter = painterResource(id = R.drawable.segmented_control), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Fit, alignment = Alignment.TopCenter )
                LazyRow(state = rememberLazyListState(), modifier = Modifier
                    //.background(Color.Blue)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(55.dp), contentPadding = PaddingValues(start =  35.dp, end = 50.dp)){
                    items(meteoCitiesList,itemContent = { item -> Image(
                        painter = painterResource(id = item),
                        contentDescription = null,
                        Modifier.scale(3.3f)
                    )
                    })
                }
            }
        }
    }

}

@Preview(showBackground = false)
@Composable
fun GreetingPreview3() {
    MangoAppTheme {
        var met = CityMeteoClass(Modifier,"Thunderstorm",19,"Bengaluru,France",21,10)
        var ville = met.lieu.substringBefore(',')
        MeteoPage(ville,met.temperature,met.meteo,met.hightemp,met.lowtemp,navController= rememberNavController())

    }
}