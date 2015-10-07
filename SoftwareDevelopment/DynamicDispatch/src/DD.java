public class DD{
public static class A{
public void f(A a) {System.out.println("A.f(A)");}
public void f(B b) {System.out.println("A.f(B)");}
public void g(A a) {System.out.println("A.g(A)");}
}
public static class B extends A {
     public void f(A a) {System.out.println("B.f(A)");}
     public void f(B b) {System.out.println("B.f(B)");}
public void g(B b) {System.out.println("B.g(B)");}
public static void h(A a) {System.out.println("B.h(A)");}
}
public static void main (String[] args){
A a = new A();
B b = new B();
A c = new B();
a.g(b);
}
}