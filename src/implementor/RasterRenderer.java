package implementor;

/** Describes a shape using a pixel-oriented representation. */
public final class RasterRenderer implements Renderer {
    @Override
    public String renderCircle(int radius) {
        return "RASTER circle radius=" + radius;
    }

    @Override
    public String renderSquare(int side) {
        return "RASTER square side=" + side;
    }
}
