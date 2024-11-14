package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class BasicAuto extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {


        yoavitikunim encodersClass = new yoavitikunim();
        encodersClass.init(hardwareMap);

        waitForStart();
        while(opModeIsActive())
        {
            encodersClass.EDrive(14, 0.75); //about 2 tiles
            Thread.sleep(1000);
            encodersClass.Erotate(-4.5, 0.75); //about 90 degrees
            Thread.sleep(1000);
            encodersClass.EDrive(6, 0.75); //about a tile
            Thread.sleep(1000);
            encodersClass.Erotate(4.35, 0.75);
            Thread.sleep(1000);
            encodersClass.EDrive(14, 0.75);
            Thread.sleep(1000);
            encodersClass.Edrone(-8, 0.75); //about a tile
            Thread.sleep(1000);
            encodersClass.EDrive(8, 0.5); //wall.
            Thread.sleep(1000);
            break;
        }
    }
}
