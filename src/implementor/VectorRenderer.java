package implementor;

/** Describes a circle using a vector-oriented representation. */
public final class VectorRenderer implements Renderer {
    @Override
    public String renderCircle(int radius) {
        return "VECTOR circle radius=" + radius;
    }

    @Override
    public String renderSquare(int side) {
        return "VECTOR square side=" + side;
    }
}
