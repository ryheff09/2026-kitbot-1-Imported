// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** This class contains an instance of the IO interface, which it uses to run the motor 
 * in commands, both forward and backward. It also updates the inputs periocially and 
 * stores the values of the inputs using the Logger. 
 * @Author Ryan Hefferon
*/
public class Intake extends SubsystemBase {

  private final IntakeIO io;
  private final IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();

  public Trigger fuelIntook = new Trigger(()->true);

  /** Creates a new Intake. */
  public Intake(IntakeIO io) {
    this.io = io;
  }

  public Command runIntake() {
    return Commands.startEnd(
      () -> io.setSpeed(0.5),
      () -> io.setSpeed(0),
      this
    ).until(fuelIntook);
  }

  public Command reverseIntake() {
    return Commands.startEnd(
      () -> io.setSpeed(-0.5),
      () -> io.setSpeed(0), 
      this
    );
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Intake", inputs);

    // This method will be called once per scheduler run
  }
}
