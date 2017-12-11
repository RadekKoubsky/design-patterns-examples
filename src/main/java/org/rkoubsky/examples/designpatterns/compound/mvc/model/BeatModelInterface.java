package org.rkoubsky.examples.designpatterns.compound.mvc.model;

import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface BeatModelInterface {
    void initialize();

    void off();

    void on();

    void setBPM(int bpm);

    int getBPM();

    void registerObserver(BeatObserver beatObserver);

    void notifyBeatObservers();

    void removeObserver(BeatObserver beatObserver);

    void registerObserver(BPMObserver bpmObserver);

    void notifyBPMObservers();

    void removeObserver(BPMObserver bpmObserver);
}
