// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;


public class Chassis extends SubsystemBase {
  private WPI_TalonFX leftLeader, leftFollower, rightLeader, rightFollower;
  private MotorControllerGroup leftMotorControllerGroup, rightMotorControllerGroup;
  private DifferentialDrive differentialDrive;

  /** Creates a new Chassis. */
  public Chassis() {
    leftLeader = new WPI_TalonFX(Constants.Chassis.LEFT_LEADER_ID);
    leftFollower = new WPI_TalonFX(Constants.Chassis.LEFT_FOLLOWER_ID);
    rightLeader = new WPI_TalonFX(Constants.Chassis.RIGHT_LEADER_ID);
    rightFollower = new WPI_TalonFX(Constants.Chassis.RIGHT_FOLLOWER_ID);

    leftLeader.setNeutralMode(NeutralMode.Coast);
    leftFollower.setNeutralMode(NeutralMode.Coast);
    rightLeader.setNeutralMode(NeutralMode.Coast);
    rightFollower.setNeutralMode(NeutralMode.Coast);

    leftLeader.setInverted(TalonFXInvertType.Clockwise);
    leftFollower.setInverted(TalonFXInvertType.Clockwise);

    leftMotorControllerGroup = new MotorControllerGroup(leftLeader, leftFollower);
    rightMotorControllerGroup = new MotorControllerGroup(rightLeader, rightFollower);

    differentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  }

  public void drive(double leftJoystick, double rightJoystick){
    differentialDrive.tankDrive(Math.pow(leftJoystick, Constants.Chassis.JOYSTICK_EXP), Math.pow(rightJoystick,Constants.Chassis.JOYSTICK_EXP));
  }

  public void driveStraight(double leftJoystick, double rightJoystick){
    double joystickAvg = (leftJoystick + rightJoystick)/2;
    differentialDrive.tankDrive(Math.pow(joystickAvg,Constants.Chassis.JOYSTICK_EXP), Math.pow(joystickAvg,Constants.Chassis.JOYSTICK_EXP));
  }

  public void slowMode(double leftJoystick, double rightJoystick){
    double joystickAvg = (leftJoystick + rightJoystick)/2;
    differentialDrive.tankDrive(Math.pow((joystickAvg*Constants.Chassis.SLOW_MODE_FACTOR), Constants.Chassis.JOYSTICK_EXP), Math.pow((joystickAvg*Constants.Chassis.SLOW_MODE_FACTOR), Constants.Chassis.JOYSTICK_EXP));
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
