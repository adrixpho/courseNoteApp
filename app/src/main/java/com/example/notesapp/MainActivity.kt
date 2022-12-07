package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.screen.NoteViewModel
import com.example.notesapp.screen.NotesScreen
import com.example.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    NotesScreen(notes = noteViewModel.noteList.collectAsState().value,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) })
}