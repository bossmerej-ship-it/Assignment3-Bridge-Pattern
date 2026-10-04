import abstraction.Circle;
import abstraction.Shape;
import abstraction.Square;
import implementor.AsciiRenderer;
import implementor.RasterRenderer;
import implementor.Renderer;
import implementor.VectorRenderer;

/** Runs the required Bridge pattern demonstration without interactive input. */
public final class Main {
    private static int passed;
    private static int total;

    private Main() { }

    public static void main(String[] args) {
        if (args.length != 1 || !"--demo".equals(args[0])) {
            System.out.println("Usage: java -cp out Main --demo");
            return;
        }
        runBaseChecks();
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void runBaseChecks() {
        Circle vectorCircle = new Circle("C-1", 2, new VectorRenderer());
        check("T1", "Circle + VectorRenderer", "VECTOR circle radius=2", vectorCircle.execute());

        Circle rasterCircle = new Circle("C-1", 2, new RasterRenderer());
        check("T2", "Circle + RasterRenderer", "RASTER circle radius=2", rasterCircle.execute());

        Square vectorSquare = new Square("S-1", 3, new VectorRenderer());
        check("T3", "Square + VectorRenderer", "VECTOR square side=3", vectorSquare.execute());

        Square rasterSquare = new Square("S-1", 3, new RasterRenderer());
        check("T4", "Square + RasterRenderer", "RASTER square side=3", rasterSquare.execute());

        Circle switchedShape = new Circle("C-SWITCH", 2, new VectorRenderer());
        String originalId = switchedShape.getId();
        int originalRadius = switchedShape.getRadius();
        String before = switchedShape.execute();
        Shape originalReference = switchedShape;
        switchedShape.setImplementation(new RasterRenderer());
        Shape afterReference = switchedShape;
        String after = switchedShape.execute();
        boolean sameObject = originalReference == afterReference;
        boolean stateUnchanged = originalId.equals(switchedShape.getId())
                && originalRadius == switchedShape.getRadius();
        boolean passedSwitch = sameObject && stateUnchanged
                && "VECTOR circle radius=2".equals(before)
                && "RASTER circle radius=2".equals(after);
        report("T5", passedSwitch,
                "sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged
                        + " | before=" + before + " | after=" + after,
                "same object, same ID and radius, Vector before and Raster after");

        Circle asciiCircle = new Circle("C-1", 2, new AsciiRenderer());
        check("T6", "Circle + AsciiRenderer", "ASCII circle radius=2", asciiCircle.execute());

        Square asciiSquare = new Square("S-1", 3, new AsciiRenderer());
        check("T7", "Square + AsciiRenderer", "ASCII square side=3", asciiSquare.execute());
    }

    private static void check(String id, String classes, String expected, String actual) {
        report(id, expected.equals(actual), classes + " | result=" + actual, "result=" + expected);
    }

    private static void report(String id, boolean success, String actual, String expected) {
        total++;
        if (success) {
            passed++;
        }
        System.out.println(id + " " + (success ? "PASS" : "FAIL") + " | " + actual
                + (success ? "" : " | expected=" + expected));
    }
}


