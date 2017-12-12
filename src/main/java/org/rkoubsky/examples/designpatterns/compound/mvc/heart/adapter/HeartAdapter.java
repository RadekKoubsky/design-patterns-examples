package org.rkoubsky.examples.designpatterns.compound.mvc.heart.adapter;

import org.rkoubsky.examples.designpatterns.compound.mvc.heart.HeartModel;
import org.rkoubsky.examples.designpatterns.compound.mvc.heart.HeartModelInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModel;
import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModelInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.view.DJView;

/**
 * An Adapter for {@link HeartModelInterface}. It adapts the {@link HeartModel} to the {@link BeatModel}.
 * The {@link DJView} only knows how to get BPM by calling the {@link BeatModelInterface#getBPM()} method.
 * The equivalent method within the heart model is {@link HeartModelInterface#getHeartRate()}.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HeartAdapter implements BeatModelInterface {
    private final HeartModelInterface heart;

    public HeartAdapter(final HeartModelInterface heart) {
        this.heart = heart;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void off() {

    }

    @Override
    public void on() {

    }

    @Override
    public void setBPM(final int bpm) {

    }

    @Override
    public int getBPM() {
        return this.heart.getHeartRate();
    }

    @Override
    public void registerObserver(final BeatObserver beatObserver) {
        this.heart.registerObserver(beatObserver);
    }

    @Override
    public void notifyBeatObservers() {
        this.heart.notifyBeatObservers();
    }

    @Override
    public void removeObserver(final BeatObserver beatObserver) {
        this.heart.removeObserver(beatObserver);
    }

    @Override
    public void registerObserver(final BPMObserver bpmObserver) {
        this.heart.registerObserver(bpmObserver);
    }

    @Override
    public void notifyBPMObservers() {
        this.heart.notifyBPMObservers();
    }

    @Override
    public void removeObserver(final BPMObserver bpmObserver) {
        this.heart.removeObserver(bpmObserver);
    }
}
