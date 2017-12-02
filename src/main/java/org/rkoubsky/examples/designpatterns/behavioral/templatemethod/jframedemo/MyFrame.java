package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.jframedemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MyFrame extends JFrame {
    public MyFrame(final String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(final Graphics graphics) {
        super.paint(graphics);
        graphics.drawString("The Template Method Rules!", 100, 100);
    }

    public static void main(final String[] args) {
        final JFrame myframe = new MyFrame("Head First Design Patterns");
    }
}
