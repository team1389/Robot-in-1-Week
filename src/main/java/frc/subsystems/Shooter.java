/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    public final TalonSRX frontShooterLeft;
    public final TalonSRX frontShooterRight;
    public final TalonSRX backShooterLeft;
    public final TalonSRX backShooterRight;




    public Shooter() {
        frontShooterLeft = new TalonSRX(1);
        frontShooterRight = new TalonSRX(2);
        backShooterLeft = new TalonSRX(5);
        backShooterRight = new TalonSRX(6);

        frontShooterRight.setInverted(true);
        backShooterRight.setInverted(true);


    }

    public void periodc() {



    }

}