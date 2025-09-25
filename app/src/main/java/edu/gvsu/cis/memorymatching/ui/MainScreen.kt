package edu.gvsu.cis.memorymatching.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(modifier: Modifier = Modifier.Companion) {
    // This list should go into the ViewModel
    var numbers = remember {
        List<Int>(20) { it/2 }.shuffled()
    }
    var message by remember {mutableStateOf("")}

    Column(modifier.fillMaxSize()) {
        Text(message)
        LazyVerticalGrid(modifier = modifier.padding(8.dp),
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemsIndexed(numbers) { idx, value ->

                MemoryCell(key = value, modifier = Modifier.clickable(
                    onClick = {
                        message = "Click at $idx value $value"
                    }).padding(2.dp))
            }

        }
        Text("Add more buttons here")
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text("Your name(s) here", modifier = Modifier.align(Alignment.CenterHorizontally)
            .padding(bottom = 8.dp))
    }
}

@Composable
fun MemoryCell(modifier: Modifier = Modifier, key: Int) {

    Box(modifier = modifier.aspectRatio(1f)
        .border(2.dp, Color.Blue), contentAlignment = Alignment.Center) {
        Text("$key", fontSize = 28.sp )
    }

}

