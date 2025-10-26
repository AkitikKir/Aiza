package com.akitik.aiza.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ChatScreen(vm: ChatViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f).padding(8.dp)) {
            items(state.messages) { msg ->
                if (msg.role == "user") {
                    Text(text = "You: ${msg.content}", modifier = Modifier.fillMaxWidth())
                } else {
                    val suffix = if (msg.isPartial) " ▌" else ""
                    Text(text = "Assistant: ${msg.content}$suffix", modifier = Modifier.fillMaxWidth())
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        if (state.error != null) {
            Text("Error: ${state.error}", color = MaterialTheme.colors.error, modifier = Modifier.padding(8.dp))
        }

        var text by remember { mutableStateOf("") }
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                vm.sendMessage(text)
                text = ""
            }) {
                Text("Send")
            }
        }
    }
}
