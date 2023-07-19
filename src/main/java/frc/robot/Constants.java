// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final double FALCON_TICKS_PER_REVOLUTION = 2048;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class Chassis {
    //joystick sensitivity
    public static final int JOYSTICK_EXP = 1;

    //simple vs pid chassis switch
    public static final boolean USE_SIMPLE_CHASSIS = false;

    //chassis motor ids
    public static final int LEFT_LEADER_ID = 4; 
    public static final int LEFT_FOLLOWER_ID = 6; 
    public static final int RIGHT_LEADER_ID = 5; 
    public static final int RIGHT_FOLLOWER_ID = 7; 

    //pid
    public static final int kPIDLoopIdx = 0;
    public static final int K_TIMEOUT_MS = 75;
    public static final double kP = 0.0; //jankybot- 0.061574, compbot 0.031812, 0.7
    public static final double kI = 0.0; 
    public static final double kD = 0.0; //0.2, 0.155
    public static final double kF = 0.15; //0.05

    //speed factor
    public static final double SLOW_MODE_FACTOR = 0.5;

    //conversion factor
    public static final double MAX_RPM_NORMAL = 2000.0;
    public static final double MAX_RPM_SLOW = 1000.0;
    public static final double JOYSTICK_TO_UNITSPER100MS_FACTOR = FALCON_TICKS_PER_REVOLUTION / 600.0;
        //600 is for conversion to per 100ms
}
}
