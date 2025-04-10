/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1;

public class InterfaceDemo implements DemoInterface, OtherInterface {

    @Override
    public int getLuckyNumber() {
        return DemoInterface.super.getLuckyNumber();
    } 
}
