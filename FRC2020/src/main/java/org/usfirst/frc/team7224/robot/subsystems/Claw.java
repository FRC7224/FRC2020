package org.usfirst.frc.team7224.robot.subsystems;


import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.ClawAction;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Claw extends Subsystem {


    private final Solenoid Pan_down_up = RobotMap.pneumaticsSolenoid1;
    private final Solenoid Claw_out_in = RobotMap.pneumaticsSolenoid2_claw_out;
    private final Solenoid Claw_on_off = RobotMap.pneumaticsSolenoid3_claw_on;

    



      public void initDefaultCommand() {
       setDefaultCommand(new ClawAction());
    }
     // *******************  Claw  on off ********
     public void Claw_on() {
        //
        // pan down
        Claw_on_off.set(true);
    }
     public void Claw_off() {
        //
        // closes claw
        Claw_on_off.set(false);
    }

        public void Pan_down() {
        //
        // pan down
        	Pan_down_up.set(true);
         }
        public void Pan_up() {
        //
        // closes up
         Pan_down_up.set(false);
        }

        // *******************  Claw  in out ********
         public void Claw_in() {
            //
            // pan down
         Claw_out_in.set(true);
        }
         public void Claw_out() {
            //
            // closes claw
            Claw_out_in.set(false);
        }
   






}
