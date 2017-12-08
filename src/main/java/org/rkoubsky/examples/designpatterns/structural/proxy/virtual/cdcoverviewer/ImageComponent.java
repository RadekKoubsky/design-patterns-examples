package org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImageComponent extends JComponent {
    private Icon icon;

    public ImageComponent(final Icon icon) {
        this.icon = icon;
    }

    public void setIcon(final Icon icon) {
        this.icon = icon;
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        this.icon.paintIcon(this, graphics, countX(), countY());
    }

    private int countX() {
        return (800 - this.icon.getIconWidth()) / 2;
    }

    private int countY() {
        return (600 - this.icon.getIconHeight()) / 2;
    }
}
