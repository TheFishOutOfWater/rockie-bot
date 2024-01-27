// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  private Talon m_lmoter1 = new Talon(robotMap.lmoter1ID);
  private Talon m_lmoter2 = new Talon(robotMap.lmoter2ID);
  private Talon m_rmoter1 = new Talon(robotMap.rmoter1ID);
  private Talon m_rmoter2 = new Talon(robotMap.rmoter2ID);

  private Talon m_climbmoter1 = new Talon(robotMap.climbmoter1ID);
  private Talon m_climbmoter2 = new Talon(robotMap.climbmoter2ID);
  private Talon m_ampmoter1 = new Talon(robotMap.ampmoter1ID);
  private Talon m_ampmoter2 = new Talon(robotMap.ampmoter2ID);
  private Talon m_spmoter1 = new Talon(robotMap.spmoter1ID);
  private Talon m_spmoter2 = new Talon(robotMap.spmoter2ID);

  private MotorControllerGroup m_lmotor = new MotorControllerGroup(m_lmoter1, m_lmoter2);
  private MotorControllerGroup m_rmotor = new MotorControllerGroup(m_rmoter1, m_rmoter2);

  private DifferentialDrive diffDrive = new DifferentialDrive(m_lmotor, m_rmotor);

  private XboxController driver = new XboxController(robotMap.driverControllerPort);

  Timer timer = new Timer();

  private boolean speakermode = (false);
  private boolean redteam = (true);
  private int station;
  

  @Override
  public void robotInit() {
    if(driver.getRightBumper() && speakermode==false){
      speakermode = true;
    }else if(driver.getRightBumper() && speakermode){
      speakermode = false;
    }
    //for(int i=1;driver.getLeftBumper()==true;i++){}
    while(driver.getLeftBumper()==true){
      int i=0;
      if(driver.getLeftBumper()==false){
        i++;
        if(i==1){
          station = 1;
        }else if(i==2){
          station = 2;
        }else if(i==3){
          station = 3;
        }else if(i==4){
          station = 4;
        }else if(i>4){
          i=1;
        }
      }

    }

  }
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit(){
    if(speakermode){
      if(redteam){
        if(station==1){
          if(timer.get()<=2){
            diffDrive.arcadeDrive(robotMap.wheelsMaxSpeed, -robotMap.rotationMaxSpeed);
          }else if(timer.get()>2&&timer.get()<=5){
            m_spmoter1.set(robotMap.shootSpeakerMaxSpeed);
            m_spmoter2.set(robotMap.shootSpeakerMaxSpeed);
          }else if (timer.get()>5&&timer.get()<=7){
            diffDrive.arcadeDrive(-robotMap.wheelsMaxSpeed, 0);
            m_spmoter1.set(0);
            m_spmoter2.set(0);
          }else{
            diffDrive.arcadeDrive(0,0);
          }
        }else if(station==2){
          
        }else if(station==3){
        
        }else if(station==4){
        
        }
      }else{
        if(station==1){
          //station speaker auto code goes here
         }else if(station==2){
           
         }else if(station==3){
         
         }else if(station==4){
         
         }
      }
    }else{
      if(redteam){
        if(station==1){
         //station speaker auto code goes here
        }else if(station==2){
          
        }else if(station==3){
        
        }else if(station==4){
        
        }
      }else{
        if(station==1){
          //station speaker auto code goes here
         }else if(station==2){
           
         }else if(station==3){
         
         }else if(station==4){
         
         }
      }
    }
  }
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    
    if(speakermode){
      //speaker code goes here
      diffDrive.arcadeDrive(driver.getRawAxis(4)*robotMap.wheelsMaxSpeed, driver.getRawAxis(1)*robotMap.wheelsMaxSpeed);
      
    }else{
      //amp code goes here
      diffDrive.arcadeDrive(driver.getRawAxis(4)*robotMap.wheelsMaxSpeed, driver.getRawAxis(1)*robotMap.wheelsMaxSpeed);
    }
    if(driver.getRawButton(4)){
      //climber code goes here
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
