package org.rkoubsky.examples.designpatterns.compound.mvc.model;

import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BeatModel implements BeatModelInterface, MetaEventListener {
    private final Logger log = LoggerFactory.getLogger(BeatModel.class);

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private final List<BeatObserver> beatObservers = new LinkedList<>();
    private final List<BPMObserver> bpmObservers = new LinkedList<>();
    private int bpm = 90;

    @Override
    public void meta(final MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            this.sequencer.start();
            setBPM(getBPM());
        }
    }

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void off() {
        setBPM(0);
        this.sequencer.stop();
    }

    @Override
    public void on() {
        this.sequencer.start();
        setBPM(90);
    }

    @Override
    public void setBPM(final int bpm) {
        this.bpm = bpm;
        this.sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return this.bpm;
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

    public void beatEvent() {
        notifyBeatObservers();
    }

    private void setUpMidi() {
        try {
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.open();
            this.sequencer.addMetaEventListener(this);
            this.sequence = new Sequence(Sequence.PPQ, 4);
            this.track = this.sequence.createTrack();
            this.sequencer.setTempoInBPM(getBPM());
        } catch (final Exception e) {
            this.log.error("An Error occurred during initialization.", e);
        }
    }

    private void buildTrackAndStart() {
        final int[] trackList = {35, 0, 46, 0};
        this.sequence.deleteTrack(null);
        this.track = this.sequence.createTrack();
        makeTracks(trackList);
        this.track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            this.sequencer.setSequence(this.sequence);
        } catch (final InvalidMidiDataException e) {
            this.log.error("Error while setting sequence on sequencer.");
        }
    }

    private void makeTracks(final int[] trackList) {
        for (int i = 0; i < trackList.length; i++) {
            final int key = trackList[i];
            if (key != 0) {
                this.track.add(makeEvent(144, 9, key, 100, i));
                this.track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    private MidiEvent makeEvent(final int comd, final int chan, final int one, final int two, final int tick) {
        MidiEvent event = null;
        try {
            final ShortMessage message = new ShortMessage();
            message.setMessage(comd, chan, one, two);
            event = new MidiEvent(message, tick);
        } catch (final InvalidMidiDataException e) {
            this.log.error("An Error while creating a track", e);
        }
        return event;
    }
}
