package frc.robot.subsystems.Intake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class IntakeIOHardware implements IntakeIO {

    private final SparkMax intakeMotor = new SparkMax(0, MotorType.kBrushless);
    private final RelativeEncoder intakeMotorEncoder = intakeMotor.getEncoder();
    private final SparkMaxConfig intakeMotorConfig;

    public IntakeIOHardware() {
        intakeMotorConfig = new SparkMaxConfig();
        intakeMotor.configure(intakeMotorConfig, null, null);
    }

    @Override
    public void setSpeed(double speed) {
        intakeMotor.set(speed);
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.intakeVelocityRPM = intakeMotorEncoder.getVelocity();
        inputs.intakePositionRotations = intakeMotorEncoder.getPosition();
    }
}
