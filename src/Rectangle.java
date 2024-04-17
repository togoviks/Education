public class Rectangle extends Figure {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        super("Прямоугольник");
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return super.getName() + " Длина: " + length + " Ширина: " + width;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return length == rectangle.length && width == rectangle.width;
    }

    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
