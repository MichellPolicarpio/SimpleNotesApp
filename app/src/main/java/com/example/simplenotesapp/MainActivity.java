package com.example.simplenotesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.simplenotesapp.databinding.ActivityMainBinding;
import com.example.simplenotesapp.vm.NotesViewModel;

public class MainActivity extends AppCompatActivity {
    private final String ACTIVITY_TITLE = "Simple Notes App";
    private final String PREFERENCES_NAME = "SimpleNotesApp";
    private final String NOTES_KEY = "SavedNotes";
    private final String NOTES_COUNT_KEY = "NotesCount";

    private NotesViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inicializar ViewModel
        viewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        
        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar el título de la actividad
        setTitle(ACTIVITY_TITLE);

        // Cargar datos desde SharedPreferences al iniciar
        loadPreferences();

        // Configurar listeners de botones
        setupButtonListeners();

        // Actualizar la UI inicialmente
        updateUI();
    }

    private void setupButtonListeners() {
        // Botón para guardar nota
        binding.btnSaveNote.setOnClickListener(view -> {
            String noteContent = binding.etNewNote.getText().toString().trim();
            if (!noteContent.isEmpty()) {
                viewModel.addNote(noteContent);
                binding.etNewNote.setText(""); // Limpiar el campo de texto
                updateUI();
                Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Por favor escribe una nota", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para limpiar todas las notas
        binding.btnClearNotes.setOnClickListener(view -> {
            viewModel.clearAllNotes();
            updateUI();
            Toast.makeText(this, "Todas las notas han sido eliminadas", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateUI() {
        // Actualizar contador de notas
        binding.tvNotesCount.setText("📝 Notas guardadas: " + viewModel.getNotesCount());
        
        // Actualizar lista de notas
        binding.tvNotesList.setText(viewModel.getNotesDisplayText());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Restaurar datos del ViewModel
        updateUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Los datos ya están en el ViewModel, no necesitamos hacer nada especial aquí
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Guardar datos en SharedPreferences cuando la actividad se detiene
        savePreferences();
    }

    private void savePreferences() {
        var sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        var editor = sharedPreferences.edit();

        editor.putString(NOTES_KEY, viewModel.notesToPreferenceString());
        editor.putInt(NOTES_COUNT_KEY, viewModel.getNotesCount());
        editor.apply();
    }

    private void loadPreferences() {
        var sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        
        String savedNotes = sharedPreferences.getString(NOTES_KEY, "");
        viewModel.loadNotesFromPreferenceString(savedNotes);
    }
}
