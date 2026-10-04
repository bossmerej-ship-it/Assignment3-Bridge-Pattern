# Assignment 3 | Bridge Pattern

- **Author:** Merey Kuatbay
- **Group / program:** 6B06102 Software Engineering (the assignment PDF does not state a separate group number)
- **Topic:** A — Shape Drawing Renderer
- **Repository:** https://github.com/bossmerej-ship-it/Assignment3-Bridge-Pattern
- **Base commit:** recorded after the initial I1/I2 implementation is committed

## Role map

| Role | Class | Source |
|---|---|---|
| Abstraction | `Shape` | `src/abstraction/Shape.java` |
| A1 | `Circle` | `src/abstraction/Circle.java` |
| A2 | `Square` | `src/abstraction/Square.java` |
| Implementor | `Renderer` | `src/implementor/Renderer.java` |
| I1 | `VectorRenderer` | `src/implementor/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/implementor/RasterRenderer.java` |
| I3 | `AsciiRenderer` | `src/implementor/AsciiRenderer.java` (extension) |
| Client | `Main` | `src/Main.java` |

The interface-typed bridge field and constructor are in `Shape.java`; `execute()` is declared there and implemented by `Circle` and `Square`. `setImplementation(Renderer)` replaces the implementor on the existing shape. The identity and state check is T5 in `Main.java`.

## Build and run

```sh
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

Expected results: T1 Circle/Vector; T2 Circle/Raster; T3 Square/Vector; T4 Square/Raster; T5 same Circle object and ID/radius, with Vector before the switch and Raster after; T6 Circle/ASCII; T7 Square/ASCII. A complete run ends with `SUMMARY: 7/7 PASS`.
