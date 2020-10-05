package home;

public class Rectagle  implements Figure{
    private Integer a;
    private Integer b;

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public void setA( Integer a ) {
        this.a = a;
    }

    public void setB( Integer b ) {
        this.b = b;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer perimetr() {
        return (a + b) *2;
    }

    @Override
    public Integer square() {
        return null;
    }
}
