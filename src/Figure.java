public abstract class Figure {

    private final String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPerimeter();
    public abstract double getArea();
}
