package com.damikkg.uicjetpackcompose.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.sp
import com.damikkg.uicjetpackcompose.R

@Composable
fun ComposeView(
    navNext:()->Unit
) {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize(),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = counter.toString(),
            fontSize = 32.sp,
            modifier = Modifier.semantics {
                testTag = "counter"
            }
        )
        Button(onClick = {
            counter++
        }, modifier = Modifier.semantics {
            testTag = "counterUpTestTag"
        }) {
            Text(text = stringResource(id = R.string.counter_button),)
        }
        Spacer(modifier = Modifier.weight(0.7f))
        Button(onClick = { navNext() }) {
            Text(text = stringResource(id = R.string.nextscreen_button))
        }
    }
}
