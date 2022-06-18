public class B extends A {
    private String _st;

    public B() {
        _st = "B";
    }

    public B(String s, int val) {
        super(val);
        _st = s;
    }

    public String get_st() {
        return _st;
    }

    public boolean equals(Object o) {
        System.out.println("BObject ");
        if (o instanceof B)
            return (_st.equals(((B) o)._st) &&
                    (get_val() == ((B) o).get_val()));
        return false;
    }

    public boolean equals(A o) {
        System.out.println("BA ");
        if (o instanceof B)
            return (_st.equals(((B) o)._st) &&
                    (get_val() == ((B) o).get_val()));
        return false;
    }

    public boolean equals(B o) {
        System.out.println("BB ");
        return (_st.equals((o._st)) &&
                (get_val() == o.get_val()));
    }
}
