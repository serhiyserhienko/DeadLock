public class ClassA {

    synchronized void first(ClassB b) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод SecondClass.bar()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс SecondClass прерван");
        }

        System.out.println(name + " пытается вызвать метод FirstClass.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("В методе SecondClass.last()");
    }
}
