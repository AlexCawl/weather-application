package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditText(
    text: String = "",
    onTextChange: (String) -> Unit = {},
    colorScheme: Colors = MaterialTheme.colors
) {
    var iconColor: Color by remember { mutableStateOf(colorScheme.onSurface) }
    var value: String by remember { mutableStateOf(text) }
    val icon = Icons.Filled.Clear

    OutlinedTextField(
        value = value,
        onValueChange = {
            value = it
            onTextChange(it)
        },
        modifier = Modifier
            .onFocusChanged {
                iconColor = when (it.hasFocus) {
                    true -> colorScheme.primary
                    false -> colorScheme.onSurface
                }
            }
            .padding(bottom = 7.dp),
        textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal),
        trailingIcon = {
            IconButton(onClick = {
                value = ""
            }) {
                Icon(
                    imageVector = icon, contentDescription = null, tint = iconColor
                )
            }
        },
        shape = RoundedCornerShape(15.dp),
    )
}

@Preview
@Composable
fun EditTextPreview() {
    EditText()
}