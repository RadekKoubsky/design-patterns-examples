package org.rkoubsky.examples.designpatterns.compound.mvc.heart;

import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HeartModel implements HeartModelInterface, Runnable {
    private final Logger log = LoggerFactory.getLogger(HeartModel.class);
    private final List<BeatObserver> beatObservers = new LinkedList<>();
    private final List<BPMObserver> bpmObservers = new LinkedList<>();
    private int time = 1000;
    private final Random random = new Random(System.currentTimeMillis());
    private final Thread thread;

    public HeartModel() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        int lastrate = -1;
        while (true) {
            int change = this.random.nextInt(10);
            if (this.random.nextInt(2) == 0) {
                change = 0 - change;
            }
            final int rate = 60000 / (this.time + change);
            if (rate < 120 && rate > 50) {
                this.time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    this.log.debug("Rate {} is not equal to lastrate {}, notifying observers (updating view).", rate, lastrate);
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(this.time);
            } catch (final InterruptedException e) {
                this.log.error("Expcetion during sleep...", e);
            }
        }
    }

    @Override
    public int getHeartRate() {
        return 60000 / this.time;
    }

    @Override
    public void registerObserver(final BeatObserver beatObserver) {
        this.beatObservers.add(beatObserver);
    }

    @Override
    public void notifyBeatObservers() {
        this.beatObservers.forEach(BeatObserver::updateBeat);
    }

    @Override
    public void removeObserver(final BeatObserver beatObserver) {
        this.beatObservers.remove(beatObserver);
    }

    @Override
    public void notifyBPMObservers() {
        this.bpmObservers.forEach(BPMObserver::updateBPM);
    }

    @Override
    public void registerObserver(final BPMObserver bpmObserver) {
        this.bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(final BPMObserver bpmObserver) {
        this.bpmObservers.remove(bpmObserver);
    }
}
