package com.example.mangoapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mangoapp.ui.theme.MangoAppTheme


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangoAppTheme(darkTheme = true){
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}