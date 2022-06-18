public class BB1 extends AA1 {
    private String str2;

    public BB1() {
        str2 = "Good Job!";
        System.out.println("in BB's" + "constructor\n" + str2);
    }

    public BB1(AA1 a) {
        if (a instanceof BB1) {
            str2 = ((BB1) a).str2;
            System.out.println(str2);
            a.f();
        } else
            str2 = "Done";
    }

    public void h() {
        super.h();
        System.out.println("in BB's h");
    }

    public void f() {
        System.out.println("in BB's f");
    }

    public String toString() {
        return str2;
    }

}
