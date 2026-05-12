# Problem Analysis & Trade-offs Report

## Real-world Problem
Music composition software treats individual notes and groups (chords, tracks) differently. The client must know the object type to call the correct method (`playNote` vs `playChord`). This leads to complex conditionals and difficulty adding new group types.

## Main Design Challenges
- Part-whole hierarchy (note inside chord inside track)
- Uniform treatment of leaf and composite objects
- Extensibility without modifying existing code
- Memory is **not** a critical constraint – a typical composition contains hundreds of notes, not thousands or millions.

## Pattern Comparison: Composite vs Flyweight

| Criteria | Composite | Flyweight |
|----------|-----------|-----------|
| Primary intent | Part-whole hierarchy + uniform interface | Share intrinsic state to save memory |
| Solves hierarchy? | ✅ Yes | ❌ No |
| Solves uniform treatment? | ✅ Yes | ❌ No |
| Fits music domain? | ✅ Natural (tree structure) | ❌ Not natural |
| Adding new group types? | ✅ Easy (Open/Closed) | ❌ Hard |
| Memory optimization | ❌ No | ✅ Yes |
| Best when | Moderate objects + hierarchy essential | Massive identical objects |

## Why Composite Satisfies SOLID Principles
- **Open/Closed**: New group types (e.g., `Arpeggio`, `RepeatGroup`) can be added without modifying existing code.
- **Liskov Substitution**: Any `MusicalElement` (a `Note` or a `NoteGroup`) can be used interchangeably.
- **Interface Segregation**: The interface is minimal; leaves throw exceptions for unsupported operations (`add`, `remove`).
- **Dependency Inversion**: The client depends on the `MusicalElement` abstraction, not on concrete classes.

## Trade-offs & Final Decision
We choose **Composite** because our core problem is hierarchical structure and uniform treatment, not memory. Flyweight would add complexity (factory, intrinsic/extrinsic state separation) without solving the main requirement. Given the moderate number of notes in typical compositions, memory optimization is unnecessary, making Composite the clear winner.
