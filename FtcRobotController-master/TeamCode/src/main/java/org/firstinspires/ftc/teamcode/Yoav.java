package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Yoav extends LinearOpMode
{
    // declaration
    private DcMotor FRMotor;
    private DcMotor FLMotor;
    private DcMotor BRMotor;
    private DcMotor BLMotor;

    @Override
    public void runOpMode() throws InterruptedException
    {
        // implementation
        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");

        waitForStart();
        while(opModeIsActive())
        {
            // code
            if(gamepad1.right_trigger > 0)
            {
                FRMotor.setPower(gamepad1.right_trigger);
                FLMotor.setPower(gamepad1.right_trigger);
                BRMotor.setPower(gamepad1.right_trigger);
                BLMotor.setPower(gamepad1.right_trigger);
            }
            else if(gamepad1.left_trigger > 0)
            {
                FRMotor.setPower(-gamepad1.left_trigger);
                FLMotor.setPower(-gamepad1.left_trigger);
                BRMotor.setPower(-gamepad1.left_trigger);
                BLMotor.setPower(-gamepad1.left_trigger);
            }
            else
            {
                FRMotor.setPower(0);
                FLMotor.setPower(0);
                BRMotor.setPower(0);
                BLMotor.setPower(0);
            }
        }
    }
}
