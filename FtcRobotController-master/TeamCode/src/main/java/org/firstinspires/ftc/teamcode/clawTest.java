package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

//@TeleOp
public class clawTest extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        Servo clawServo = hardwareMap.servo.get("clawServo");

        double servoClosed = 0.1;
        double servoOpen = 0.5;
        clawServo.setPosition(1);

        waitForStart();
        while(opModeIsActive())
        {
            if(gamepad1.right_bumper)
            {
                clawServo.setPosition(servoOpen);
            }
            else if(gamepad1.left_bumper)
            {
                clawServo.setPosition(servoClosed);
            }
        }
    }
}
