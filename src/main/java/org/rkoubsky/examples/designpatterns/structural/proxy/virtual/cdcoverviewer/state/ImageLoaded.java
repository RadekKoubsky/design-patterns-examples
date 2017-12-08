package org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer.state;

import javax.swing.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImageLoaded implements ImageState {
    private final ImageIcon imageIcon;

    public ImageLoaded(final ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public int getIconWidth() {
        return this.imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeigth() {
        return this.imageIcon.getIconHeight();
    }
}
