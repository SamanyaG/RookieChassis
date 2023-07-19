// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class DriveStraight extends CommandBase {
  Chassis chassis;
  double leftJoystick, rightJoystick;
  /** Creates a new DriveStraight. */
  public DriveStraight(double leftJoystick, double rightJoystick, Chassis chassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
    this.chassis = chassis;
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassis.driveStraight(leftJoystick, rightJoystick);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
