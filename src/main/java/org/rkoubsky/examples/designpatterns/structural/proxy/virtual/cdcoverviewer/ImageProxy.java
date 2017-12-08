package org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer;

import org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer.state.ImageLoaded;
import org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer.state.ImageNotLoaded;
import org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer.state.ImageState;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImageProxy implements Icon {
    /**
     * The image proxy is dealing with two states for width and height,
     * we are going to use State Pattern here.
     */
    private ImageState imageState = new ImageNotLoaded();
    private ImageIcon imageIcon;
    private final URL imageUrl;
    private Thread retrievalThread;
    private boolean retrieving = false;

    public ImageProxy(final URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        if (this.imageIcon != null) {
            this.imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
            if (!this.retrieving) {
                this.retrieving = true;
                /**
                 * Here is where we load the REAL icom image. Note that
                 * the image loading with IconImage is synchronous:
                 * the ImageIcon constructor does not return until the image
                 * is loaded. That does not give us much of a chance to do
                 * screen updates and have our message displayed, so we are
                 * going to do this asynchronously in a separate thread.
                 * */
                this.retrievalThread = new Thread(() -> {
                    this.imageIcon = new ImageIcon(this.imageUrl, "Cd Cover");
                    this.imageState = new ImageLoaded(this.imageIcon);
                    c.repaint();
                });
                this.retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        return this.imageState.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return this.imageState.getIconHeigth();
    }
}
