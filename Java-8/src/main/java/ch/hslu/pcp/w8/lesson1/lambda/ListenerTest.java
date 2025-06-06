/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1.lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ListenerTest {

    public static void main(String[] args) {

        JButton testButton = new JButton("Test Button");
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click Detected by Anonymous Class");
            }
        });

        testButton.addActionListener(
                e -> System.out.println("Click Detected by Lambda Listener")
        );
        
        Consumer<ActionEvent> c = e -> System.out.println("Click Detected by Lambda Listener");

        // Swing stuff
        JFrame frame = new JFrame("Listener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(testButton, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}
