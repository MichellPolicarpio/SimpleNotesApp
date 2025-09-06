package com.example.simplenotesapp.vm;

import androidx.lifecycle.ViewModel;

import com.example.simplenotesapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesViewModel extends ViewModel {
    
    private List<Note> notes;
    private int notesCount;
    
    public NotesViewModel() {
        notes = new ArrayList<>();
        notesCount = 0;
    }
    
    public List<Note> getNotes() {
        return notes;
    }
    
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        this.notesCount = notes.size();
    }
    
    public int getNotesCount() {
        return notesCount;
    }
    
    public void addNote(String content) {
        if (content != null && !content.trim().isEmpty()) {
            Note note = new Note(content.trim());
            notes.add(note);
            notesCount = notes.size();
        }
    }
    
    public void clearAllNotes() {
        notes.clear();
        notesCount = 0;
    }
    
    public String getNotesDisplayText() {
        if (notes.isEmpty()) {
            return "📋 No hay notas guardadas\n\n¡Empieza escribiendo tu primera nota!";
        }
        
        StringBuilder displayText = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            displayText.append("📌 ").append((i + 1)).append(". ").append(notes.get(i).getContent());
            if (i < notes.size() - 1) {
                displayText.append("\n\n");
            }
        }
        return displayText.toString();
    }
    
    // Método para convertir todas las notas a formato de SharedPreferences
    public String notesToPreferenceString() {
        if (notes.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append(notes.get(i).toPreferenceString());
            if (i < notes.size() - 1) {
                sb.append("###"); // Separador entre notas
            }
        }
        return sb.toString();
    }
    
    // Método para cargar notas desde formato de SharedPreferences
    public void loadNotesFromPreferenceString(String preferenceString) {
        notes.clear();
        if (preferenceString != null && !preferenceString.trim().isEmpty()) {
            String[] noteStrings = preferenceString.split("###");
            for (String noteString : noteStrings) {
                Note note = Note.fromPreferenceString(noteString);
                if (note != null) {
                    notes.add(note);
                }
            }
        }
        notesCount = notes.size();
    }
}
