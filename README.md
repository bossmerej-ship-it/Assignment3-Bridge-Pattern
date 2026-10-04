# Assignment 3 | Bridge Pattern

**Author:** Merey Kuatbay  
**Group:** SE 2537  
**Topic:** A - Shape Drawing Renderer  
**Repository:** https://github.com/bossmerej-ship-it/Assignment3-Bridge-Pattern

## Role map

| Role | Class | Source |
|---|---|---|
| Abstraction | `Shape` | `src/abstraction/Shape.java` |
| A1 | `Circle` | `src/abstraction/Circle.java` |
| A2 | `Square` | `src/abstraction/Square.java` |
| Implementor | `Renderer` | `src/implementor/Renderer.java` |
| I1 | `VectorRenderer` | `src/implementor/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/implementor/RasterRenderer.java` |
| I3 | `AsciiRenderer` | `src/implementor/AsciiRenderer.java` |
| Client | `Main` | `src/Main.java` |

`Shape` stores the interface-typed `Renderer` bridge reference. Its subclasses implement `execute()` by delegating to the renderer. `setImplementation(Renderer)` switches the renderer on the same shape; T5 in `Main.java` checks object identity with `==` and verifies that the ID and radius remain unchanged.

## Build and run

From the project root with JDK 17:

```sh
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

The demo runs T1-T7 without input. It ends with `SUMMARY: 7/7 PASS`; the recorded output is in `demo-output.txt`.
