# Pattern Selection & Justification Document

## Selected Pattern
**Composite Pattern**

## Why Composite Fits the Problem
- Music is naturally hierarchical (note → chord → track → section)
- Client can call `play()` on any component without conditionals
- Supports recursive behavior (composite calls play on children)
- Follows Open/Closed Principle (easy to add `Arpeggio`, `RepeatGroup`)

## SOLID Principles Applied
- **Single Responsibility:** `Note` represents a note, `NoteGroup` manages children.
- **Open/Closed:** New component types added without modifying existing code.
- **Liskov Substitution:** Any `MusicalElement` can replace another.
- **Interface Segregation:** Minimal interface; leaves throw exceptions.
- **Dependency Inversion:** Client depends on abstraction `MusicalElement`.

## Why Not Flyweight?
Flyweight solves memory sharing, which is not our primary challenge. Our compositions have hundreds of notes, not thousands. Adding Flyweight would overcomplicate the solution.