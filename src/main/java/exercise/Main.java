package exercise;

public class Main {
    public static class Super {
        public void fn() {System.out.println("i'm super!");}
    }

    public static class Child extends  Super {
        public void fn() {
            super.fn();
        }
    }
    public static void main(String[] args) {
        Child c = new Child();
        c.fn();
    }
}
