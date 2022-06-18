public class A {
    private int _val;

    public A() {
        _val = 1;
    }

    public A(int val) {
        _val = val;
    }

    public int get_val() {
        return _val;
    }


    public boolean equals(Object o) {
        System.out.println("AObject ");
        if (o instanceof A)
            return (_val == ((A) o)._val);
        return false;
    }
}
