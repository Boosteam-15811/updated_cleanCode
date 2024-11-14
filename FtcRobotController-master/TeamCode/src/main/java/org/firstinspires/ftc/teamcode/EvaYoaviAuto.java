package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous
public class EvaYoaviAuto extends LinearOpMode
{
    ElapsedTime elapsedTime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException
    {
        elapsedTime.reset();
        yoavitikunim encodersClass = new yoavitikunim();
        encodersClass.init(hardwareMap);
        waitForStart();
        while (opModeIsActive())
        {
            encodersClass.EDrive(24.5, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(25.5, 0.5);
            Thread.sleep(500);
            encodersClass.EDrive(76, 0.5);
            Thread.sleep(500);
            encodersClass.EdiagonalPositive(43, 0.5);
            Thread.sleep(500);
            encodersClass.EdiagonalPositive(-44, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(-25.25,0.5);
            Thread.sleep(500);
            encodersClass.EDrive(157.5, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(61.5, 0.5);
            Thread.sleep(500);
            encodersClass.EDrive(-26, 0.5);
            Thread.sleep(500);
            encodersClass.EDrive(27, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(13, 0.5);
            Thread.sleep(500);
            encodersClass.EDrive(155, 0.5);
            Thread.sleep(500);
            encodersClass.Erotate(47, 0.5);
            Thread.sleep(500);
            encodersClass.EdiagonalPositive(-42, 0.5);
            Thread.sleep(500);
            encodersClass.EdiagonalPositive(45, 0.5);
            Thread.sleep(500);
            encodersClass.Edrone(177, 0.3);
            Thread.sleep(500);
            encodersClass.Erotate(-24, 0.5);
            Thread.sleep(500);
            encodersClass.EdiagonalPositive(-25, 0.5);
            Thread.sleep(500);
            //elapsedTime.startTime();
            //encodersClass.Edrone(80, Math.min(elapsedTime.now(TimeUnit.MILLISECONDS)/1000000, 1));
            //Thread.sleep(1000);
            break;
        }
    }
}
