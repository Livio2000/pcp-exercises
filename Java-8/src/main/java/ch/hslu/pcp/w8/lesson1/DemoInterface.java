/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1;

public interface DemoInterface {
    
    default int getLuckyNumber() {
        return 7;
    }
    
    static int getEight() {
        return 8;
    }  
}

