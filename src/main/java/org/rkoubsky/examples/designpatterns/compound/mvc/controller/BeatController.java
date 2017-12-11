package org.rkoubsky.examples.designpatterns.compound.mvc.controller;

import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModelInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.view.DJView;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BeatController implements ControllerInterface {
    private final BeatModelInterface model;
    private final DJView view;

    public BeatController(final BeatModelInterface model) {
        this.model = model;
        this.view = new DJView(model, this);
        this.view.createView();
        this.view.createControlls();
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
        model.initialize();
    }

    @Override
    public void start() {
        this.model.on();
        this.view.disableStartMenuItem();
        this.view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        this.model.off();
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {
        this.model.setBPM(this.model.getBPM() + 1);
    }

    @Override
    public void decreaseBPM() {
        this.model.setBPM(this.model.getBPM() - 1);
    }

    @Override
    public void setBPM(final int bpm) {
        this.model.setBPM(bpm);
    }
}
