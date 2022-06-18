public class Second extends First{
    private First _f;
    public Second(First f1, First f2)
    {
        super(f1);
        _f = f2;
    }
    public void setStr(String s)
    {
        super.setStr(s);
        _f = new First(s);
    }
    public void print()
    {
        System.out.println("Second");
        super.print();
        _f.print();
    }
}
