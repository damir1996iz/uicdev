package com.damikkg.uicjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.damikkg.uicjetpackcompose.ui.compose.ComposeSecondView
import com.damikkg.uicjetpackcompose.ui.compose.ComposeView
import com.damikkg.uicjetpackcompose.ui.fragments.FragmentsActivity
import com.damikkg.uicjetpackcompose.ui.theme.UicJetpackComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UicJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            ScrollInView {
                                MainScreen {
                                    navController.navigate("compose")
                                }
                            }
                        }
                        composable("compose") {
                            ComposeView {
                                navController.navigate("composeSecond")
                            }
                        }
                        composable("composeSecond") {
                            ComposeSecondView {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navToComposeScreen:()->Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_symbol),
            tint = Color.Red,
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.conf_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.theme_name),
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(0.7f))

        MenuCard(
            iconRes = R.drawable.turtle,
            text = stringResource(R.string.fragments_button)
        ){
            startActivity(context, Intent(context, FragmentsActivity::class.java), null)
        }
        MenuCard(
            iconRes = R.drawable.rocket,
            text = stringResource(R.string.compose_button)
        ){
            navToComposeScreen()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScrollInView(
    content: @Composable () -> Unit
) {
    var visibility by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        delay(100)
        visibility = true
    }

    AnimatedVisibility(
        visible = visibility,
        modifier = Modifier.fillMaxSize(),
        enter = slideInVertically(
            initialOffsetY = { 5000 },
            animationSpec = tween(1000)
        )
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuCard(
    iconRes: Int,
    text: String,
    onClick: ()->Unit
) {
    Card(
        onClick = onClick,
        border = BorderStroke(1.dp, color = Color.LightGray),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = iconRes),
                modifier = Modifier.size(64.dp),
                contentDescription = ""
            )
            Text(
                text = text,
                fontSize = 18.sp,
            )
        }
    }
}
