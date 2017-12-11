package org.rkoubsky.examples.designpatterns.compound.mvc.view;

import org.rkoubsky.examples.designpatterns.compound.mvc.BeatBar;
import org.rkoubsky.examples.designpatterns.compound.mvc.controller.ControllerInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.model.BeatModelInterface;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BPMObserver;
import org.rkoubsky.examples.designpatterns.compound.mvc.observer.BeatObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {
    private final BeatModelInterface model;
    private final ControllerInterface controller;
    private JFrame viewFrame;
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;
    private JFrame controllerFrame;
    private JPanel controllerPanel;
    private JLabel bpmLabel;
    private JTextField bpmTextField;
    private JButton setBpmButton;
    private JButton increaseBPMBUtton;
    private JButton decreaseBPMBUtton;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;

    public DJView(final BeatModelInterface model, final ControllerInterface controller) {
        this.model = model;
        this.controller = controller;
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    public void createView() {
        this.viewPanel = new JPanel(new GridLayout(1, 2));
        this.viewFrame = new JFrame("View");
        this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.viewFrame.setSize(new Dimension(100, 80));
        this.bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        this.beatBar = new BeatBar();
        this.beatBar.setValue(0);
        final JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(this.beatBar);
        bpmPanel.add(this.bpmOutputLabel);
        this.viewPanel.add(bpmPanel);
        this.viewFrame.getContentPane().add(this.viewPanel, BorderLayout.CENTER);
        this.viewFrame.pack();
        this.viewFrame.setVisible(true);
    }

    public void createControlls() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.controllerFrame = new JFrame("Control");
        this.controllerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controllerFrame.setSize(new Dimension(100, 80));
        this.controllerPanel = new JPanel(new GridLayout(1, 2));
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("DJ Control");
        this.startMenuItem = new JMenuItem("Start");
        this.menu.add(this.startMenuItem);
        this.startMenuItem.addActionListener(event -> this.controller.start());
        this.stopMenuItem = new JMenuItem("Stop");
        this.menu.add(this.stopMenuItem);
        this.stopMenuItem.addActionListener(event -> this.controller.stop());
        final JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(event -> System.exit(0));
        this.menu.add(exit);
        this.menuBar.add(this.menu);
        this.controllerFrame.setJMenuBar(this.menuBar);

        this.bpmTextField = new JTextField(2);
        this.bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        this.setBpmButton = new JButton("Set");
        this.setBpmButton.setSize(new Dimension(10, 40));
        this.increaseBPMBUtton = new JButton(">>");
        this.decreaseBPMBUtton = new JButton("<<");
        this.setBpmButton.addActionListener(this);
        this.increaseBPMBUtton.addActionListener(this);
        this.decreaseBPMBUtton.addActionListener(this);

        final JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(this.decreaseBPMBUtton);
        buttonPanel.add(this.increaseBPMBUtton);

        final JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(this.bpmLabel);
        enterPanel.add(this.bpmTextField);
        final JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(this.setBpmButton);
        insideControlPanel.add(buttonPanel);
        this.controllerPanel.add(insideControlPanel);

        this.bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.controllerFrame.getRootPane().setDefaultButton(this.setBpmButton);
        this.controllerFrame.getContentPane().add(this.controllerPanel, BorderLayout.CENTER);

        this.controllerFrame.pack();
        this.controllerFrame.setVisible(true);
    }

    public void enableStopMenuItem() {
        this.stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem() {
        this.stopMenuItem.setEnabled(false);
    }

    public void enableStartMenuItem() {
        this.startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        this.startMenuItem.setEnabled(false);
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == this.setBpmButton) {
            final int bpm = Integer.parseInt(this.bpmTextField.getText());
            this.controller.setBPM(bpm);
        } else if (event.getSource() == this.increaseBPMBUtton) {
            this.controller.increaseBPM();
        } else if (event.getSource() == this.decreaseBPMBUtton) {
            this.controller.decreaseBPM();
        }

    }

    @Override
    public void updateBPM() {
        final int bpm = this.model.getBPM();
        if (bpm == 0) {
            this.bpmOutputLabel.setText("offline");
        } else {
            this.bpmOutputLabel.setText(String.format("Current BPM: %s", bpm));
        }
    }

    @Override
    public void updateBeat() {
        this.beatBar.setValue(100);
    }
}
