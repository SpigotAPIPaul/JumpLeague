package de.spigotpaul.methods.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.spigotpaul.JumpLeague;

public class Stats {
	
	public static boolean playerExists(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");

		try {
			if (rs.next()) {
				if (rs.getString("UUID") != null) {
					MySQL.closeResultset(rs);
					return true;
				}
			}
		} catch (SQLException e) {
		}

		MySQL.closeResultset(rs);
		return false;
	}

	public static void createPlayer(String uuid) {
		JumpLeague.getInstance().getMysql().update("INSERT INTO JumpLeague(UUID, KILLS, DEATHS, BETTEN, GSPIELE, VSPIELE, GESPIELE) VALUES ('"
				+ uuid + "', '0', '0', '0', '0', '0', '0');");
	}
	
	public static Integer getVerloreneSpiele(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("VSPIELE");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static Integer getWonneneSpiele(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("GESPIELE");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static Integer getGespielteSpiele(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("GSPIELE");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static Integer getBetten(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("BETTEN");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static Integer getDeaths(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("DEATHS");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static Integer getKills(String uuid) {
		ResultSet rs = JumpLeague.getInstance().getMysql().query("select * from JumpLeague where UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				Integer i = rs.getInt("KILLS");
				MySQL.closeResultset(rs);
				return i;
			}
		} catch (SQLException e) {
		}
		MySQL.closeResultset(rs);
		return 0;
	}

	public static void setBetten(String uuid, Integer kills) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET BETTEN= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}

	public static void setGespielteSpiele(String uuid, Integer kills) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET GSPIELE= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}

	public static void setVerloreneSpiele(String uuid, Integer kills) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET VSPIELE= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}

	public static void setGewonneSpiele(String uuid, Integer kills) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET GESPIELE= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}

	public static void setKills(String uuid, Integer kills) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET KILLS= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}

	public static void setDeaths(String uuid, Integer deaths) {
		JumpLeague.getInstance().getMysql().update("UPDATE JumpLeague SET DEATHS= '" + deaths + "' WHERE UUID= '" + uuid + "';");
	}

	public static void addBetten(String uuid, Integer kills) {
		setBetten(uuid, Integer.valueOf(getBetten(uuid).intValue() + kills.intValue()));
	}

	public static void addGespielteSpiele(String uuid, Integer kills) {
		setGespielteSpiele(uuid, Integer.valueOf(getGespielteSpiele(uuid).intValue() + kills.intValue()));
	}

	public static void addGewonneSpiele(String uuid, Integer kills) {
		setGewonneSpiele(uuid, Integer.valueOf(getWonneneSpiele(uuid).intValue() + kills.intValue()));
	}

	public static void addVerloreneSpiele(String uuid, Integer kills) {
		setVerloreneSpiele(uuid, Integer.valueOf(getVerloreneSpiele(uuid).intValue() + kills.intValue()));
	}

	public static void addKills(String uuid, Integer kills) {
		setKills(uuid, Integer.valueOf(getKills(uuid).intValue() + kills.intValue()));
	}

	public static void addDeaths(String uuid, Integer deaths) {
		setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() + deaths.intValue()));
	}

	public void removeKills(String uuid, Integer kills) {
		setKills(uuid, Integer.valueOf(getKills(uuid).intValue() - kills.intValue()));
	}

	public void removeDeaths(String uuid, Integer deaths) {
		setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() - deaths.intValue()));
	}

}
