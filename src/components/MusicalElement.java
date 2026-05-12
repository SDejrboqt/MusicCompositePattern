package components;

public interface MusicalElement {
    void play();
    void add(MusicalElement element);
    void remove(MusicalElement element);
    MusicalElement getChild(int index);
}