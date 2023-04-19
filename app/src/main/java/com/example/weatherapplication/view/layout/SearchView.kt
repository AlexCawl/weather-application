package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.model.data.Location

@Composable
fun SearchEditText(
    query: MutableState<String>,
    onSearchPressedEvent: (String) -> Unit = {},
    onClearPressedEvent: (String) -> Unit = {},
    onTextChangedEvent: (String) -> Unit = {},
) {
    TextField(
        value = query.value,
        onValueChange = {
            query.value = it
            onTextChangedEvent(it)
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
        leadingIcon = {
            IconButton(onClick = {
                onSearchPressedEvent(query.value)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            if (query.value != "") {
                IconButton(onClick = {
                    query.value = ""
                    onClearPressedEvent(query.value)
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape,
    )
}

@Composable
fun SearchItemView(
    location: Location, onClickEvent: (Location) -> Unit
) {
    Box(modifier = Modifier
        .padding(5.dp)
        .background(shape = RoundedCornerShape(5.dp), color = Color.LightGray)
        .fillMaxWidth()
        .wrapContentHeight()
        .clickable { onClickEvent(location) }
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = location.name, fontSize = 20.sp, color = Color.Black)
            Row {
                Text(
                    text = String.format("%.2f", location.latitude),
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .background(shape = RoundedCornerShape(5.dp), color = Color.White)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = String.format("%.2f", location.longitude),
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .background(
                            shape = RoundedCornerShape(5.dp), color = Color.White
                        )
                        .padding(5.dp)
                )
            }
            Text(text = location.country, fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Composable
fun SearchItemListView(
    hints: SnapshotStateList<Location>, onClickEvent: (Location) -> Unit
) {
    LazyColumn {
        items(hints) { item: Location ->
            SearchItemView(location = item, onClickEvent)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val query: MutableState<String> = remember { mutableStateOf("Example City") }
    val hints = remember {
        mutableStateListOf<Location>(
            Location("Example City 1", mapOf(), 0.0, 0.0, "EX1", null),
            Location("Example City 2", mapOf(), 0.0, 0.0, "EX2", null),
            Location("Example City 3", mapOf(), 0.0, 0.0, "EX3", null),
            Location("Example City 4", mapOf(), 0.0, 0.0, "EX4", null),
        )
    }

    Column {
        SearchEditText(query, {}, {}, {})
        SearchItemListView(hints) {}
    }
}