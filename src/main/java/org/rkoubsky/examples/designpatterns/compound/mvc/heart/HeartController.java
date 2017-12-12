package org.rkoubsky.examples.designpatterns.compound.mvc.heart;

import org.rkoubsky.examples.designpatterns.compound.mvc.controller.ControllerInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.heart.adapter.HeartAdapter;
import org.rkoubsky.examples.designpatterns.compound.mvc.view.DJView;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HeartController implements ControllerInterface {
    private final HeartModelInterface model;
    private final DJView view;

    public HeartController(final HeartModelInterface model) {
        this.model = model;
        this.view = new DJView(new HeartAdapter(model), this);
        this.view.createView();
        this.view.createControlls();
        this.view.disableStopMenuItem();
        this.view.disableStartMenuItem();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM(final int bpm) {

    }
}
