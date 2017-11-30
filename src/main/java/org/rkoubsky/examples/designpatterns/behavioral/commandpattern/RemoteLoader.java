package org.rkoubsky.examples.designpatterns.behavioral.commandpattern;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.CeilingFanHighCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.CeilingFanMediumCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.CeilingFanOffCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.Command;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.GarageDoorDownCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.GarageDoorUpCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.LightOffCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.LightOnCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.MacroCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.NoCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.StereoOffCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.StereoOnCommand;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.invoker.RemoteControl;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.CeilingFan;
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
        final CeilingFan ceilingFan = new CeilingFan("Living Room");
        final Command[] onCommands = new Command[]{new LightOnCommand(
                new Light("Living Room")), new GarageDoorUpCommand(new GarageDoor()), new StereoOnCommand(
                new Stereo("Living Room")), new CeilingFanMediumCommand(ceilingFan), new MacroCommand(
                getOnCommandsForMacroCommand()), new NoCommand()};
        final Command[] offCommands = new Command[]{new LightOffCommand(
                new Light("Living Room")), new GarageDoorDownCommand(
                new GarageDoor()), new StereoOffCommand(
                new Stereo("Living Room")), new CeilingFanOffCommand(ceilingFan), new MacroCommand(
                getOffCommandsForMacroCommand()), new NoCommand()};
        final RemoteControl remoteControl = new RemoteControl(onCommands, offCommands);

        System.out.println(remoteControl);
        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);
        remoteControl.onButtonPressed(2);
        remoteControl.offButtonPressed(2);
        remoteControl.onButtonPressed(3);
        remoteControl.offButtonPressed(3);

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        System.out.println("--- Pushing MacroCommand ---");
        remoteControl.onButtonPressed(4);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }

    private static Command[] getOffCommandsForMacroCommand() {
        return new Command[]{new LightOffCommand(
                new Light("Bedroom")), new StereoOffCommand(new Stereo("Bedroom")), new CeilingFanOffCommand(
                new CeilingFan("Bedroom"))};
    }

    private static Command[] getOnCommandsForMacroCommand() {
        return new Command[]{new LightOnCommand(
                new Light("Bedroom")), new StereoOnCommand(new Stereo("Bedroom")), new CeilingFanHighCommand(
                new CeilingFan("Bedroom"))};
    }
}
