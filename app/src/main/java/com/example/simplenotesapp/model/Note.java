package com.example.simplenotesapp.model;

import java.util.UUID;

public class Note {
    private String id;
    private String content;
    private long timestamp;

    public Note(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public Note(String id, String content, long timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return content;
    }

    // Método para convertir la nota a formato de SharedPreferences
    public String toPreferenceString() {
        return id + "|" + content + "|" + timestamp;
    }

    // Método estático para crear una nota desde formato de SharedPreferences
    public static Note fromPreferenceString(String preferenceString) {
        String[] parts = preferenceString.split("\\|", 3);
        if (parts.length == 3) {
            return new Note(parts[0], parts[1], Long.parseLong(parts[2]));
        }
        return null;
    }
}
