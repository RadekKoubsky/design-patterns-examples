package org.rkoubsky.examples.designpatterns.compound.mvc;

import org.rkoubsky.examples.designpatterns.compound.mvc.controller.BeatController;
import org.rkoubsky.examples.designpatterns.compound.mvc.controller.ControllerInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModel;
import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModelInterface;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DJTestDrive {
    public static void main(final String[] args) {
        final BeatModelInterface model = new BeatModel();
        final ControllerInterface controller = new BeatController(model);
    }
}
