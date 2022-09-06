package com.damikkg.uicjetpackcompose.ui.compose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.damikkg.uicjetpackcompose.R

@Composable
fun ComposeSecondView(
    navBack:()->Unit
) {
    val context = LocalContext.current
    var openDialog by remember { mutableStateOf(false)  }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            Toast.makeText(context, context.getText(R.string.toast_msg),Toast.LENGTH_LONG).show()
        }) {
            Text(text = stringResource(id = R.string.toast_button))
        }
        Button(onClick = {
            openDialog = true
        }) {
            Text(text = stringResource(id = R.string.show_dialog_button))
        }
        Spacer(modifier = Modifier.weight(0.7f))
        Button(onClick = {
            navBack()
        }) {
            Text(text = stringResource(id = R.string.back_button))
        }
    }

    if(openDialog) {
        AlertDialog(
            onDismissRequest = { openDialog = false },
            title = { Text(text = stringResource(id = R.string.dialog_title)) },
            text = { Text(text = stringResource(id = R.string.dialog_text)) },
            confirmButton = {
                Text(
                    text = stringResource(id = R.string.dialog_btn),
                    modifier = Modifier.clickable {
                        openDialog = false
                    }
                )
            }
        )
    }
}
