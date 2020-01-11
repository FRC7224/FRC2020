package org.usfirst.frc.team7224.robot;


/**
 * This class contains all the variables and constants used by the developers for the robot.
 *
 * 
 */

public class RobotConstants {

	// IMPORTANT NOTICE
	//
	// Please make sure, that all the constants you insert here, are in the
	// right area. If no matches, you create your own one.
	
	
	// Joystick 1 constants
	public static double kdeadzone = 0.1; // updated by MG
	public static int kclawbutton = 1;
	public static int kshiftbutton = 2;
	public static int kintakeinbutton = 3;
    public static int kintakeoutbutton= 4;
//	public static int kzeroResetbutton = 4;
	public static int kclawgraboutbutton = 9;
	public static int kclawgrabonbutton = 6; 
//	public static int kWinchButtonA = 9;
    public static int kpreButton = 7;
	public static int kArmOverideButton = 8;
//	public static int kWinchButtonB = 10;
	
	// Simple Drive
//	public static double simpleDriveTime = 0.0;
	
	// Chassis 
	public static boolean kenablePID = true;
	public static double Kp = 0.0002; //.005 0.012
	public static double Ki = 0.0; //.1 0.0025
	public static double Kd = 0.05;  // .1
	public static double kgyroPIDErrorTolerance = 1.0; // in degrees
	public static double gyroPIDOutput = 0.0;
	public static double kshiftRateUp = 1200;
	public static double kshiftRateDown = 800;
	public static boolean shiftOpenState = false;
	

		
	// Claw 
	public static boolean clawOpenState = false;
	public static double kclawcloseTimer_timer = .3;

	// Autonomous 
	public static int TrajectorySegments;
	public static boolean isTrajectory = false;
	public static int kencodermode = 0;

	// Winch 
	public static double kmaxWinchSpeed = 1.0;
	public static double kminWinchSpeed = 0.0;
	public static boolean WinchState = false;
	// 
	public static final int kSlotIdx_w = 0;
	public static final int kallowableCloseLoopError_w = 300;
	public static final int kPIDLoopIdx_w = 0;
	public static final int kTimeoutMs_w = 10;
	public static final double kSlowwinch_w = 0.5;
	public static final double kNormalwinch_w = 2.5;
	public static double kMaxSpeed_w = kNormalwinch_w;
	public static final double kStopSpeed_w = 0.0;
	public static double targetPositionRotations_w = 0;
	public static double kwinchManualSensitivity_w = 2000;
	public static double kwinch_Zero_HT_w = 0;
	public static double kwinch_FieldHT_w = 5000;
	public static double kwinch_SwitchHT_w = 130000;
	public static double kwinch_ScaleHT_w = 280000; 
	public static double kwinchMinHt_w = 0;
	public static double kwinchpreHt_w = 320000;
	public static double kwinchMaxHt_w = 320000;
	public static double kwinchPIDF_w = 0.0;
	public static double kwinchPIDP_w = 0.045;
	public static double kwinchPIDI_w = 0.0001;
	public static double kwinchPIDD_w = 0.4;
	public static int kREMOTE_1_w = 0;
	
	// Intake 
	public static double kmaxIntakeSpeed =  0.5;
	public static double kminIntakeSpeed = -0.5;
	
	// Driverstation
	public static String gameData = "XXX";
	
	// Shifter
	public static double kcloseTimer_timer = .3;

	// arm
	public static final int kSlotIdx_a = 0;
	public static final int kallowableCloseLoopError_a = 300;
	public static final int kPIDLoopIdx_a = 0;
	public static final int kTimeoutMs_a = 10;
	public static final double kSlowArm_a = 0.5;   //0.5
	public static final double kNormalArm_a = 0.5; //2.5
	public static double kMaxSpeed_a = kNormalArm_a;
	public static final double kStopSpeed_a = 0.0;
	public static double targetPositionRotations_a = 0;
	public static double kArmManualSensitivity_a = 2000;
	public static double kArm_Zero_HT_a = 0;
	public static double kArm_FieldHT_a = 5000;
	public static double kArm_SwitchHT_a = 130000;
	public static double kArm_ScaleHT_a = 280000; 
	public static double kArmMinHt_a = -430000;
	public static double kArmMaxHt_a = 500000;
	public static double kArmpreHt_a = -219829;
	public static double kArmPIDF_a = 0.0;
	public static double kArmPIDP_a = 0.045;
	public static double kArmPIDI_a = 0.0001;
	public static double kArmPIDD_a = 0.4;
	
}
	