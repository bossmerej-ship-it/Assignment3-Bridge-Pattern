package implementor;

/** Low-level drawing operations supplied by a renderer. */
public interface Renderer {
    String renderCircle(int radius);

    String renderSquare(int side);
}
