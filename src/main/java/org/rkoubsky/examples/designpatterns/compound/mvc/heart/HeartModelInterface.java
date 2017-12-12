package org.rkoubsky.examples.designpatterns.compound.mvc.heart;

import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface HeartModelInterface {
    int getHeartRate();

    void registerObserver(BeatObserver beatObserver);

    void notifyBeatObservers();

    void removeObserver(BeatObserver beatObserver);

    void registerObserver(BPMObserver bpmObserver);

    void notifyBPMObservers();

    void removeObserver(BPMObserver bpmObserver);
}
