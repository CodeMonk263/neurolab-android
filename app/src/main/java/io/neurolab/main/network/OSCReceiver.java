package io.neurolab.main.network;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCPortIn;

import java.net.SocketException;
import java.util.ArrayList;

public class OSCReceiver {
    protected OSCPortIn receiver;
    protected ArrayList<String> senderList;
    protected boolean listening = false;
    private String address;
    private OSCListener oscListener;

    public static void run(String fileName) throws SocketException {
        ArrayList<String> senderList = new ArrayList<>();
        senderList.add("/dev/rfcomm0/");
        senderList.add("/dev/rfcomm1/");
        OSCReceiver or = new OSCReceiver(7009, senderList);

        OSCListener listener = (time, message) -> {

            System.out.println("received " + message.getAddress() + ":");
            for (Object argument : message.getArguments())
                System.out.println(argument.toString());

        };
        or.addOSCListener("/sayhello1", listener);
        or.addOSCListener("/sayhello2", listener);
        or.startListening();

    }

    public void addOSCListener(String address, OSCListener oscListener) {
        this.address = address;
        this.oscListener = oscListener;
    }

    public void startListening() {
        receiver.startListening();
        listening = true;
    }

    public void stopListening() {
        receiver.stopListening();
        listening = false;
    }

    public OSCReceiver(int port, ArrayList<String> senderList) throws SocketException {
        receiver = new OSCPortIn(port);

    }

    public OSCPortIn getReceiver() {
        return receiver;
    }

    public void setReceiver(OSCPortIn receiver) {
        this.receiver = receiver;
    }

    public ArrayList<String> getSenderList() {
        return senderList;
    }

    public void setSenderList(ArrayList<String> senderList) {
        this.senderList = senderList;
    }
}
