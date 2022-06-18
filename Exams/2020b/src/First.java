public class First {
    public static int count = 0;
    private String _str;

    public First() {
        count++;
        _str = "Empty " + count;
    }

    public First(String s) {
        count++;
        _str = s;
    }

    public First(First g) {
        count++;
        _str = "Copy " + g._str;
    }

    public void setStr(String s) {
        _str = s;
    }
    public void print()
    {
        System.out.println("First " + _str);
    }
}
