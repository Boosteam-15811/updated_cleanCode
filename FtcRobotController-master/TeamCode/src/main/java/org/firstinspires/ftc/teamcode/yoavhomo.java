package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
@Autonomous
public class yoavhomo extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        yoavitikunim encodersClass = new yoavitikunim();
        encodersClass.init(hardwareMap);
        waitForStart();
        while (opModeIsActive())
        {
            encodersClass.Edrone(-78, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(-2, 0.5);
            Thread.sleep(500);
            encodersClass.EDrive(85, 1);
            Thread.sleep(500);
            encodersClass.Erotate(23, 0.5);
            Thread.sleep(500);
            break;
        }
     }
}

