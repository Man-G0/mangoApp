package com.example.mangoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mangoapp.ui.theme.baseWhited
import com.example.mangoapp.ui.theme.grey
import com.example.mangoapp.ui.theme.ui.theme.MangoAppTheme

@Composable
fun MeteoElementAff(cityMeteo:CityMeteoClass, navController: NavHostController){
    var iconMet = R.drawable.ic_launcher_foreground

    when(cityMeteo.meteo.lowercase()){
        "cloudy" -> iconMet = R.drawable.sun_cloud_angled_rain
        "fast wind" -> iconMet = R.drawable.moon_cloud_fast_wind
        "mid rain" -> iconMet = R.drawable.moon_clou_id_rain
        "thunderstorm" -> iconMet = R.drawable.cloud_3_zap
    }
    var ville = cityMeteo.lieu.substringBefore(',')
    var meteo = cityMeteo.meteo
    var temp = cityMeteo.temperature
    var hightemp =cityMeteo.hightemp
    var lowtemp = cityMeteo.lowtemp
    Box(cityMeteo.modifier){
        Image(painter = painterResource(R.drawable.rectangle), contentDescription = null, modifier = Modifier.clickable {
            navController.navigate(route = "meteo_screen/$ville/$temp/$meteo/$hightemp/$lowtemp") })

        Image(painter = painterResource(iconMet), contentDescription = null,modifier = Modifier
            .offset(100.dp - 35.dp, -18.dp)
            .wrapContentSize())
        Column(Modifier.offset(6.dp))
        {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${cityMeteo.temperature}°",style = androidx.compose.ui.text.TextStyle(fontSize = 22.sp,color = baseWhited))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "H:${cityMeteo.hightemp}°  L:${cityMeteo.lowtemp}° ",style = androidx.compose.ui.text.TextStyle(fontSize = 5.sp,color = grey.copy(alpha = 0.6f)))
            Row(modifier = Modifier.width(110.dp),horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "${cityMeteo.lieu}",style = androidx.compose.ui.text.TextStyle(fontSize = 7.sp,color = baseWhited))//modifier = Modifier.offset(6.dp,100.dp - 53.dp))
                Text(
                    text = "${cityMeteo.meteo}",
                    style = androidx.compose.ui.text.TextStyle(fontSize = 5.sp, color = baseWhited),
                    //modifier = Modifier.offset(95.dp, 100.dp - 53.dp)
                )
            }
        }

    }

    }




@Preview(showBackground = false)
@Composable
fun GreetingPreview2() {
    MangoAppTheme {
        var met = CityMeteoClass(Modifier,"Thunderstorm",18,"Paris,France",21,10)
        MeteoElementAff(met, navController = rememberNavController())
    }
}
