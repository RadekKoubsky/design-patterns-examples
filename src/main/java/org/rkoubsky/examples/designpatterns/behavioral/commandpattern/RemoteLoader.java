package org.rkoubsky.examples.designpatterns.behavioral.commandpattern;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.Command;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.GarageDoorDownCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.GarageDoorUpCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.LightOffCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.LightOnCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.NoCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.StereoOffCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.StereoOnCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.invoker.RemoteControl;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.GarageDoor;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.Light;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.Stereo;

/**
 * The client is responsible for creating a ConcreteCommand and its receiver.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class RemoteLoader {
    public static void main(final String[] args) {
        final Command[] onCommands = new Command[]{new LightOnCommand(
                new Light("Living Room")), new GarageDoorUpCommand(new GarageDoor()), new StereoOnCommand(
                new Stereo("Living Room")), new NoCommand()};
        final Command[] offCommands = new Command[]{new LightOffCommand(
                new Light("Living Room")), new GarageDoorDownCommand(
                new GarageDoor()), new StereoOffCommand(
                new Stereo("Living Room")), new NoCommand()};
        final RemoteControl remoteControl = new RemoteControl(onCommands, offCommands);

        System.out.println(remoteControl);
        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);
        remoteControl.onButtonPressed(2);
        remoteControl.offButtonPressed(2);
    }
}
