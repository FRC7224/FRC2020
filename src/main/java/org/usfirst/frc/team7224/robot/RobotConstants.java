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
	public static int kinitShooter = 1;
	public static int kshiftbutton = 2;
	public static int kintakeinbutton = 9;
    public static int kintakeoutbutton= 4;
//	public static int kzeroResetbutton = 4;
	public static int kclawgraboutbutton = 9;
	public static int kclawgrabonbutton = 6; 
//	public static int kWinchButtonA = 9;
    public static int kpreButton = 7;
	public static int kShootOverideButton = 8;
	public static int kclawbutton = 10;
	
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
	public static double kmaxIntakeSpeed =  0.9;
	public static double kminIntakeSpeed = 0.0	;
	
	// Turn
	public static double kturnspeed =  0.18;

	// Driverstation
	public static String gameData = "XXX";
	
	// Shifter
	public static double kcloseTimer_timer = .3;

//  Elevator 
    public static double kelvspeed = 0.5;


	// Shooter Constants
	/**
	 * Velocity is measured in change in native units per TvelMeas= 100ms.
	 * Example: (1366 Rotations / min) X (1 min / 60 sec) X (1 sec / 10
	 * TvelMeas) X (4096 native units / rotation) = 9326 native units per 100ms
	 * Now lets calculate a Feed-forward gain so that 100% motor output is
	 * calculated when the requested speed is 9328 native units per 100ms.
	 * F-gain = (100% X 1023) / 9326 F-gain = 0.1097 Lets check our math, if the
	 * target speed is 9326 native units per 100ms, Closed-loop output will be
	 * (0.1097 X 9326) => 1023 (full forward).
	 */
	public static double shootertargetRPM = 675; // Desired RPM
	// public static double shootertargetspeed = (shootertargetRPM * 1/60 *1/10
	// * 4096); // Desired RPM
	public static double shootertargetspeed1 = 24000;
	public static double shootertargetspeed2 = 14000;
	public static double shooterTolerance = 300.0;
//	public static double shooterPIDKp = 0.4;
//	public static double shooterPIDKi = 0.00004;
//	public static double shooterPIDKd = 0.0;
//	public static double shooterPIDKf = 1023.0 / 13000.0; // 1023/maximumspeed
//	public static int shooterPIDIZone = 2000;
//	public static double shooterPIDRampRate = 0.0;
	public static double shooterTimer_timer = 1.2;
	public static boolean shooterMode = false;
	public static int kPIDLoopIdx = 0;
	public static int kTimeoutMs = 30;
	public static double kshoot1P = 0.25;
	public static double kshoot1I = 0.001;
	public static double kshoot1D = 20;
	public static double kshoot1F = 1023.0/7200.0;
	//
	public static double kshoot2P = 0.25;
	public static double kshoot2I = 0.001;
	public static double kshoot2D = 20;
	public static double kshoot2F = 1023.0/7200.0;
//	public static double kshootF = 0.25;

	//* PID Gains may have to be adjusted based on the responsiveness of control loop.
	// kF: 1023 represents output value to Talon at 100%, 7200 represents Velocity units at 100% output


	//	                                    			  kP   kI   kD   kF          Iz    PeakOut */

   //public final static Gains kGains_Velocit = new Gains( 0.25, 0.001, 20, 1023.0/7200.0,  300,  1.00);
	
	
}
	