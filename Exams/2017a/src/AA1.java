public class AA1 {
    private String str1;

    public AA1() {
        this.str1 = "Hello";
        System.out.println("in AA's" + "constructor\n" + str1);
    }

    public String getStr1() {
        return str1;
    }

    public void h() {
        System.out.println("in AA's h");
    }

    public void f() {
        System.out.println("in AA's f");
    }

    public void g() {
        System.out.println("in AA's g");
    }

    public String toString() {
        return str1;
    }

}
