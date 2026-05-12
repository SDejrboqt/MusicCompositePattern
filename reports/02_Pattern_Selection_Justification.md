# Pattern Selection & Justification Document

## Selected Pattern
**Composite Pattern**

## Why Composite Fits the Problem
- Music is naturally hierarchical (note → chord → track → section). The composite structure naturally mirrors how music is organized in real life.
- Client can call `play()` on any component without conditionals.
- Supports recursive behavior (composite calls `play()` on all children).
- Follows Open/Closed Principle (easy to add `Arpeggio`, `RepeatGroup`).

## SOLID Principles Applied
- **Single Responsibility**: `Note` represents a note, `NoteGroup` manages children.
- **Open/Closed**: New component types added without modifying existing code.
- **Liskov Substitution**: Any `MusicalElement` can replace another.
- **Interface Segregation**: Minimal interface; leaves throw exceptions for unsupported operations.
- **Dependency Inversion**: Client depends on abstraction `MusicalElement`, not concrete classes.

## Why Not Flyweight?
Flyweight solves memory sharing, which is not our primary challenge. Our compositions contain hundreds of notes, not thousands. Adding Flyweight would introduce a factory, intrinsic/extrinsic state separation, and extra complexity without solving the core hierarchical requirement.
