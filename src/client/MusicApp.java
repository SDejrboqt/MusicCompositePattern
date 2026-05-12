package client;

import leaves.Note;
import composites.NoteGroup;

public class MusicApp {
    public static void main(String[] args) {
        // Individual notes
        Note c = new Note("C4", 0.5);
        Note e = new Note("E4", 0.5);
        Note g = new Note("G4", 0.5);
        
        // Chord
        NoteGroup chord = new NoteGroup("C major chord");
        chord.add(c);
        chord.add(e);
        chord.add(g);
        
        // Melody notes
        Note d = new Note("D4", 0.25);
        Note e2 = new Note("E4", 0.25);
        Note f = new Note("F4", 0.25);
        
        // Melody group
        NoteGroup melody = new NoteGroup("Melody");
        melody.add(d);
        melody.add(e2);
        melody.add(f);
        
        // Track
        NoteGroup track = new NoteGroup("Piano Track");
        track.add(chord);
        track.add(melody);
        
        System.out.println("=== Starting Music Playback ===");
        track.play();
    }
}