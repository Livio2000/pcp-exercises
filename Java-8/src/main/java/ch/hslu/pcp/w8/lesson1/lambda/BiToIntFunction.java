/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1.lambda;

@FunctionalInterface
public interface BiToIntFunction<T> {
    
    int doSomething(T t1, T t2);
    
}
