package org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer.state;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImageNotLoaded implements ImageState {
    private static final int DEFAUlT_WIDTH = 800;
    private static final int DEFAULT_HEIGTH = 600;

    @Override
    public int getIconWidth() {
        return DEFAUlT_WIDTH;
    }

    @Override
    public int getIconHeigth() {
        return DEFAULT_HEIGTH;
    }
}
