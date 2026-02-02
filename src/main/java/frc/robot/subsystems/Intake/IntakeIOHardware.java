package frc.robot.subsystems.Intake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This class contains all of the physical hardware objects, including a Spark Max motor
 * and corresponding encoder. It also implements the methods specified in
 * the IO interface to set the speed of the physical motor as well as update the
 * values of the inputs using the encoder.
 * 
 * @Author Ryan Hefferon
 */
public class IntakeIOHardware implements IntakeIO {

    private final SparkMax intakeMotor = new SparkMax(0, MotorType.kBrushed);
    private final RelativeEncoder intakeMotorEncoder = intakeMotor.getEncoder();
    private final SparkMaxConfig intakeMotorConfig;
    private final DigitalInput sensor = new DigitalInput(0);

    public IntakeIOHardware() {
        intakeMotorConfig = new SparkMaxConfig();
        intakeMotor.configure(intakeMotorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    @Override
    public void setSpeed(double speed) {
        intakeMotor.set(speed);
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.intakeVelocityRPM = intakeMotorEncoder.getVelocity();
        inputs.intakePositionRotations = intakeMotorEncoder.getPosition();
        inputs.hasFuel = sensor.get();
    }
}
