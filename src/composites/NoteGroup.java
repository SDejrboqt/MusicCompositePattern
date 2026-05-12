package composites;

import components.MusicalElement;
import java.util.ArrayList;
import java.util.List;

public class NoteGroup implements MusicalElement {
    private String name;
    private List<MusicalElement> children = new ArrayList<>();
    
    public NoteGroup(String name) {
        this.name = name;
    }
    
    @Override
    public void play() {
        System.out.println("Playing group: " + name);
        for (MusicalElement child : children) {
            child.play();
        }
    }
    
    @Override
    public void add(MusicalElement element) {
        children.add(element);
    }
    
    @Override
    public void remove(MusicalElement element) {
        children.remove(element);
    }
    
    @Override
    public MusicalElement getChild(int index) {
        return children.get(index);
    }
}