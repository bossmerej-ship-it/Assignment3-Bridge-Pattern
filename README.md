# Assignment 3 | Bridge Pattern

- **Author:** Merey Kuatbay
- **Program:** 6B06102 Software Engineering (the instruction PDF does not give a separate group number)
- **Topic:** A — Shape Drawing Renderer
- **Repository:** https://github.com/bossmerej-ship-it/Assignment3-Bridge-Pattern
- **Submitted source commit:** `276269d14e29dc35d963890acc68e2d9ac83ce46`
- **Base I1/I2 commit:** `30798a7b83e3050f9795afaf0ecacc3d05fd74b4`

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

`Shape.renderer` is the interface-typed bridge field and is initialized by the `Shape` constructor. `execute()` is declared by `Shape` and implemented by each shape; both implementations delegate through `Renderer`. `setImplementation(Renderer)` enables runtime replacement. T5 in `Main.java` retains both references and compares them with `==`, then checks the ID, radius, and output before and after the switch.

## Build and run

From the extracted project root, using JDK 17:

```sh
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

`demo-output.txt` records the program output. Expected results are T1 Circle/Vector, T2 Circle/Raster, T3 Square/Vector, T4 Square/Raster, T5 the same Circle object and domain state with Vector before and Raster after, T6 Circle/ASCII, and T7 Square/ASCII. Each row is computed from the actual returned value/state; the successful run ends with `SUMMARY: 7/7 PASS`.

## Bridge and Adapter

Bridge separates the shape abstraction hierarchy from the renderer implementation hierarchy and connects them with composition. This lets either dimension gain variants without a subclass for each shape-renderer pair. Adapter has a different intent: it wraps an existing incompatible interface so a client can use the interface it expects. Here the `Renderer` contract is designed as the abstraction's implementation interface rather than adapting a pre-existing incompatible API.

## References

- Gamma, E., Helm, R., Johnson, R., and Vlissides, J. *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley, 1994, “Bridge” and “Adapter”.
- Oracle. *Java Language Specification, Java SE 17 Edition*. https://docs.oracle.com/javase/specs/jls/se17/jls17.pdf
- Assignment 3 | Bridge Pattern, Astana IT University, 2026–2027, supplied course instructions.
