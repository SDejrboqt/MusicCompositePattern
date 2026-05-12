package leaves;

import components.MusicalElement;

public class Note implements MusicalElement {
    private String pitch;
    private double duration;
    
    public Note(String pitch, double duration) {
        this.pitch = pitch;
        this.duration = duration;
    }
    
    @Override
    public void play() {
        System.out.println("Playing note " + pitch + " for " + duration + " seconds");
    }
    
    @Override
    public void add(MusicalElement element) {
        throw new UnsupportedOperationException("A single note cannot have children");
    }
    
    @Override
    public void remove(MusicalElement element) {
        throw new UnsupportedOperationException("A single note cannot remove children");
    }
    
    @Override
    public MusicalElement getChild(int index) {
        return null;
    }
}