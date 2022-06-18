public class BB extends AAA {
    private int y;

    public BB() {
        super(4);
        y = getX() + 2;
    }

    public BB(int y) {
        super();
        this.y = y;
        System.out.println(toString());
    }

    public void h() {
        System.out.println("B h");
    }

    public void f() {
        System.out.println("B f");
        g();
        h();
    }

    public String toString() {
        return super.toString() + "y " + y;
    }
}
