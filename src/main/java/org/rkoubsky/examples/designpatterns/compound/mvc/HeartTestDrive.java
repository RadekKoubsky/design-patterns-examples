package org.rkoubsky.examples.designpatterns.compound.mvc;

import org.rkoubsky.examples.designpatterns.compound.mvc.heart.HeartController;
import org.rkoubsky.examples.designpatterns.compound.mvc.heart.HeartModel;
import org.rkoubsky.examples.designpatterns.compound.mvc.heart.HeartModelInterface;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HeartTestDrive {
    public static void main(final String[] args) {
        final HeartModelInterface heartModel = new HeartModel();
        final HeartController heartController = new HeartController(heartModel);
    }
}
