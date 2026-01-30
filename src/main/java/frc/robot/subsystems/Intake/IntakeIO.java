package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {

    default void updateInputs(IntakeIOInputs inputs) {

    }

    @AutoLog
    public static class IntakeIOInputs {

        public double intakeVelocityRPM = 0.0;
        public double intakePositionRotations = 0.0;
    }

    default void setSpeed(double speed) {

    }

}
