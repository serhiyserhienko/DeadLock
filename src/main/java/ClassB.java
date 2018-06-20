public class ClassB {
    synchronized void first(ClassA a) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод ClassB.first()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс ClassB прерван");
        }

        System.out.println(name + " пытается вызвать метод ClassA.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("В методе SecondClass.last()");
    }
}
