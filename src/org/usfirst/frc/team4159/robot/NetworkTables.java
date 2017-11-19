package org.usfirst.frc.team4159.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NetworkTables {
	
	private NetworkTable table;
	
	public NetworkTables() {
		table = NetworkTable.getTable("datatable");
	}
	
	public void update(String key, double value) {
		table.putNumber(key, value);
	}
}
