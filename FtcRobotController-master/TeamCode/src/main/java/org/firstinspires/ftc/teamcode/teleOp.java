package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp
public class teleOp  extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        DcMotor FRMotor = hardwareMap.dcMotor.get("FRMotor");
        DcMotor FLMotor = hardwareMap.dcMotor.get("FLMotor");
        DcMotor BRMotor = hardwareMap.dcMotor.get("BRMotor");
        DcMotor BLMotor = hardwareMap.dcMotor.get("BLMotor");

        FLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        IMU imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));

        imu.initialize(parameters);


        DriveClass driveClass = new DriveClass(FRMotor, FLMotor, BRMotor, BLMotor);

        waitForStart();
        while(opModeIsActive())
        {
            if (gamepad1.options)
            {
                imu.resetYaw();
            }
            if(gamepad1.right_trigger > 0)
            {
                driveClass.drive(gamepad1.right_trigger);
            }
            else if(gamepad1.left_trigger > 0)
            {
                driveClass.drive(-gamepad1.left_trigger);
            }
            else
            {
                driveClass.fieldArcade(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x, imu);
            }
        }
    }
}
