public class AAA {
    private int x;
    public AAA()
    {
        this.x=3;
    }
    public AAA(int x)
    {
        this.x=x;
        System.out.println(toString());
    }

    public int getX() {
        return x;
    }
    public void f()
    {
        if(x%2 == 0)
            System.out.println("Even");
        System.out.println("In A's f");
        g();
    }
    public void g(){
        System.out.println("In A's g");
    }
    public String toString()
    {
        return "x" + this.x;
    }
}
