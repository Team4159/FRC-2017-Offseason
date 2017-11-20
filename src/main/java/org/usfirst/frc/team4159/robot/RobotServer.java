package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.Timer;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class RobotServer extends WebSocketServer {

    public RobotServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public RobotServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        new Thread(() -> {
            continuousBroadcast();
        }).start();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        broadcast("New connection: " + handshake.getResourceDescriptor());
        System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " has connected!");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println(conn + ": " + message);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message) {
        // message.array
        System.out.println(conn + ": " + message);
    }

    @Override
    public void onFragment(WebSocket conn, Framedata fragment) {
        System.out.println("Received fragment: " + fragment);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + " has disconnected");
        System.out.println(conn + "has disconnected");
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific websocket
        }
    }

    private void continuousBroadcast() {
        while (true) {
            broadcast("Match time:" + Timer.getMatchTime());
            broadcast("Total Voltage:" + Robot.pdp.getTotalCurrent());
            broadcast("Total Current:" + Robot.pdp.getVoltage());
            broadcast("Port 0:" + Robot.pdp.getVoltage());
            Timer.delay(1 / 8);
        }
    }

}
