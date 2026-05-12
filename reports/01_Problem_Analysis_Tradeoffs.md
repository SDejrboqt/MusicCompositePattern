# Problem Analysis & Trade-offs Report

## Real-world Problem
Music composition software treats individual notes and groups (chords, tracks) differently. The client must know the object type to call the correct method (playNote vs playChord). This leads to complex conditionals and difficulty adding new group types.

## Main Design Challenges
- Part-whole hierarchy (note inside chord inside track)
- Uniform treatment of leaf and composite objects
- Extensibility without modifying existing code
- Memory is not a critical constraint (hundreds of notes)

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

## Trade-offs & Final Decision
We choose **Composite** because our core problem is hierarchical structure and uniform treatment, not memory. Flyweight would add complexity without solving the main requirement.