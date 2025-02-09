package io.neurolab.main;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;

import com.felhr.usbserial.UsbSerialDevice;

public class DeviceConnector {

    private UsbManager usbManager;
    private UsbDevice device;
    private UsbSerialDevice serialPort;
    private int baudRate = 9600;
    private int arduinoVid = 0x2341;

    private final String ACTION_USB_PERMISSION = "io.neurolab.USB_PERMISSION";

    public DeviceConnector(UsbManager usbManager) {
        this.usbManager = usbManager;
    }

    public UsbDevice getDevice() {
        return device;
    }

    public void setDevice(UsbDevice device) {
        this.device = device;
    }

    public UsbSerialDevice getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(UsbSerialDevice serialPort) {
        this.serialPort = serialPort;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public int getArduinoVid() {
        return arduinoVid;
    }
}
