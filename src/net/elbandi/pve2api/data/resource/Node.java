package net.elbandi.pve2api.data.resource;

import org.json.JSONException;
import org.json.JSONObject;

import net.elbandi.pve2api.data.Resource;

public class Node extends Resource {
	private String node;
	private int maxcpu;
	private long maxmem;
	private long maxdisk;
	private int uptime;
	private long mem;
	private long disk;
	private float cpu;
	public Node(JSONObject data) throws JSONException {
		super(data);
		node = data.getString("node");
		maxcpu = data.getInt("maxcpu");
		maxmem = data.getLong("maxmem");
		maxdisk = data.getLong("maxdisk");
		uptime = data.optInt("uptime");
		cpu = (float) data.optDouble("cpu");
		mem = data.optLong("mem");
		disk = data.optLong("disk");
	}

	public String getNode() {
		return node;
	}

	public int getMaxcpu() {
		return maxcpu;
	}

	public long getMaxmem() {
		return maxmem;
	}

	public long getMaxdisk() {
		return maxdisk;
	}

	public int getUptime() {
		return uptime;
	}

	public long getMem() {
		return mem;
	}

	public long getDisk() {
		return disk;
	}

	public float getCpu() {
		return cpu;
	}

}
