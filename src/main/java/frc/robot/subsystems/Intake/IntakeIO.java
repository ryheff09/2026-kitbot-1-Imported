package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

/**
 * Initializes the various inputs in a class to store this data
 * as well as creates the default methods to update these inputs and setting
 * speed.
 * 
 * @Author Ryan Hefferon
 */
public interface IntakeIO {

    default void updateInputs(IntakeIOInputs inputs) {

    }

    @AutoLog
    public static class IntakeIOInputs {

        public double intakeVelocityRPM = 0.0;
        public double intakePositionRotations = 0.0;
        public boolean hasFuel = false;
    }

    default void setSpeed(double speed) {

    }

}
