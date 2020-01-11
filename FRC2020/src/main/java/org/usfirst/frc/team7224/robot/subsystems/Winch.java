
   package org.usfirst.frc.team7224.robot.subsystems;
   import org.usfirst.frc.team7224.robot.RobotConstants;
   import org.usfirst.frc.team7224.robot.RobotMap;
   
   import com.ctre.phoenix.motorcontrol.ControlMode;
   import com.ctre.phoenix.motorcontrol.FeedbackDevice;
   import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
   import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
   
   import edu.wpi.first.wpilibj.command.Subsystem;
   import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
   
   import org.usfirst.frc.team7224.robot.commands.*;
   
   public class Winch extends Subsystem {
    private final WPI_TalonSRX winchmotor1 = RobotMap.winchTalonSRX9;
    private final WPI_TalonSRX winchmotor2 = RobotMap.winchTalonSRX10;
       StringBuilder _sb = new StringBuilder();
       int _loops = 0;
   
       
       
         public void winchSetup() {
               /* lets grab the 360 degree position of the MagEncoder's absolute position */
               int absolutePosition = winchmotor1.getSelectedSensorPosition(RobotConstants.kTimeoutMs_w) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
               /* use the low level API to set the quad encoder signal */
               winchmotor1.setSelectedSensorPosition(absolutePosition, RobotConstants.kPIDLoopIdx_w, RobotConstants.kTimeoutMs_w);
               
               /* choose the sensor and sensor direction */
               winchmotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotConstants.kPIDLoopIdx_w, RobotConstants.kTimeoutMs_w);
                       // setup second motor				
               /* Configure the Remote Talon's selected sensor as a remote sensor for the second Talon */
               winchmotor2.follow(winchmotor1);
               winchmotor2.setInverted(true);
   
           
               
               
                  /* Configure output and sensor direction */
               winchmotor1.setInverted(false);
               winchmotor1.setSensorPhase(true);
               
               
               /* set the peak and nominal output */
               winchmotor1.configNominalOutputForward(RobotConstants.kStopSpeed_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.configNominalOutputReverse(RobotConstants.kStopSpeed_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.configPeakOutputForward(RobotConstants.kMaxSpeed_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.configPeakOutputReverse(-RobotConstants.kMaxSpeed_w, RobotConstants.kTimeoutMs_w);
               
   
               /* set the allowable closed-loop error,
                * Closed-Loop output will be neutral within this range.
                * 
                * 
                */
               winchmotor1.configAllowableClosedloopError( RobotConstants.kPIDLoopIdx_w,RobotConstants.kallowableCloseLoopError_w, RobotConstants.kTimeoutMs_w); /* always servo */
               /* set closed loop gains in slot0 */
               winchmotor1.config_kF(RobotConstants.kPIDLoopIdx_w,RobotConstants.kwinchPIDF_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.config_kP(RobotConstants.kPIDLoopIdx_w, RobotConstants.kwinchPIDP_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.config_kI(RobotConstants.kPIDLoopIdx_w, RobotConstants.kwinchPIDI_w, RobotConstants.kTimeoutMs_w);
               winchmotor1.config_kD(RobotConstants.kPIDLoopIdx_w, RobotConstants.kwinchPIDD_w, RobotConstants.kTimeoutMs_w);
   
        
   
   
               }
   
         
          public void winchPosReset () {
              winchmotor1.setSelectedSensorPosition(0, 0, 10);
       
              RobotConstants.targetPositionRotations_w= RobotConstants.kwinch_Zero_HT_w;
        //      SmartDashboard.putNumber("Reseting", RobotConstants.targetPositionRotations_w);
          }
   
         @Override
           public void initDefaultCommand() {
               // Set the default command for a subsystem here.winch
               setDefaultCommand(new WinchAction());
           }
   
           @Override
           public void periodic() {
   
               /* if Talon is in position closed-loop, print some more info */
               if( winchmotor1.getControlMode() == ControlMode.Position) {
                   /* append more signals to print when in speed mode. */
                   _sb.append("\terrNative:");
                   _sb.append(winchmotor1.getClosedLoopError(0));
                   _sb.append("\ttrg:");
                   _sb.append(RobotConstants.targetPositionRotations_w);
                   
               }
               /* print every ten loops, printing too much too fast is generally bad for performance */ 
               if(++_loops >= 100) {
                   _loops = 0;
                   System.out.println(_sb.toString());
               }
               _sb.setLength(0);
   
           }
           public void winchControl() {
               winchmotor1.set(ControlMode.Position, RobotConstants.targetPositionRotations_w); 
       
           }
       }