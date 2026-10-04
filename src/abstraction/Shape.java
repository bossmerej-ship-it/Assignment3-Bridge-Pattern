package abstraction;

import implementor.Renderer;
import java.util.Objects;

/** Abstraction shared by shapes while delegating representation to a renderer. */
public abstract class Shape {
    private final String id;
    protected Renderer renderer;

    protected Shape(String id, Renderer renderer) {
        this.id = Objects.requireNonNull(id, "id");
        this.renderer = Objects.requireNonNull(renderer, "renderer");
    }

    public final String getId() {
        return id;
    }

    public final void setImplementation(Renderer renderer) {
        this.renderer = Objects.requireNonNull(renderer, "renderer");
    }

    public abstract String execute();
}

