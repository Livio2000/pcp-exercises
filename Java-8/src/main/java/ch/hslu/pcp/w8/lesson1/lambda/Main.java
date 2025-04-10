/*
 * HSLU I Module PCP ruedi.arnold@hslu.ch
 */
package ch.hslu.pcp.w8.lesson1.lambda;

public class Main {

    public static void main(String[] args) {
        doRunnableTests();
        ComparatorDemo.main(args);
        ListenerTest.main(args);
        StreamAndLambdaDemos sald = new StreamAndLambdaDemos();
        sald.doDemo1();
    }

    private static void doRunnableTests() {
        System.out.println("=== RunnableTest ===");

        // Anonymous Runnable
        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        // Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        // Run em!
        r1.run();
        r2.run();
    }

}
