public class B1 extends A1 {
    private String s2 = "ghi";

    public B1(String s) {
        s2 = s;
    }

    public B1() {
        super("def");
    }

    public String getS2() {
        return s2;
    }

    public String getS1() {
        return s1;
    }
}
