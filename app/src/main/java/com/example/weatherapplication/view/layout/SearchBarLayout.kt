package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.view.theme.WeatherApplicationTheme

@Composable
fun SearchBar(
    onTextChangeEvent: (String) -> Unit,
    unfocusedColor: Color,
    focusedColor: Color,
    modifier: Modifier = Modifier,
) {
    val content = remember { mutableStateOf("") }
    val hasFocus = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .onFocusChanged { hasFocus.value = it.hasFocus }
            .fillMaxWidth()
            .padding(5.dp),
        value = content.value,
        onValueChange = {
            content.value = it
            onTextChangeEvent(it)
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.round_search_24),
                contentDescription = null,
                tint = when (hasFocus.value) {
                    true -> focusedColor
                    false -> unfocusedColor
                }
            )
        },
        trailingIcon = {
            if (content.value.isNotEmpty() && hasFocus.value) {
                IconButton(onClick = { content.value = "" }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.round_clear_24),
                        contentDescription = null,
                        tint = unfocusedColor
                    )
                }
            }
        },
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle().copy(
            color = when (hasFocus.value) {
                true -> focusedColor
                false -> unfocusedColor
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WeatherApplicationTheme {
        SearchBar(
            onTextChangeEvent = {},
            unfocusedColor = MaterialTheme.colors.onSurface,
            focusedColor = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(15.dp))
        )
    }
}
