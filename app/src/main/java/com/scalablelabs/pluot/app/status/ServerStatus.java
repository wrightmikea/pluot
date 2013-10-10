package com.scalablelabs.pluot.app.status;

import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public abstract class ServerStatus {

  private static ServerStatus _status;

  private ServerDescription _description;
  Map<String, Statistic> _stats = new HashMap<>();

  protected ServerStatus(ServerDescription description) {
    _description = description;
    loadAppProperties(_description);
    String propPrefix = _description.getPropPrefix();
    _description.setVersion(System.getProperty(propPrefix + ".app.version", propPrefix + ".app.version *not found*"));
    String built = System.getProperty(propPrefix + ".app.built", propPrefix + ".app.built *not found*");
    try {
      long epochTime = Long.parseLong(built);
      _description.setBuilt(new DateTime(epochTime).toString());
    } catch (Exception ignored) {
      _description.setBuilt(propPrefix + ".app.built *not found*");
    }
  }

  public static ServerStatus getStatus() {
    return _status;
  }

  public static void loadAppProperties(ServerDescription description) {
    String propFilePrefix = description.getPropFilePrefix();
    InputStream is = ServerStatus.class.getClassLoader().getResourceAsStream(propFilePrefix + ".properties");
    if (null != is) {
      try {
        System.getProperties().load(is);
      } catch (IOException e) {
        System.err.println("not able to load " + propFilePrefix + ".properties resource from classpath");
        e.printStackTrace(System.err);
      } finally {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace(System.err);
        }
      }
    } else {
      System.err.println("not able to load " + propFilePrefix + ".properties resource from classpath (null)");
    }
  }

  public static void setStatus(ServerStatus status) {
    _status = status;
  }

  public ServerDescription getServerDescription() {
    return _description;
  }

  public Map<String,Statistic> getStats() {
    return _stats;
  }

  public static void updateStats(String statName) {
    Map<String, Statistic> stats = ServerStatus.getStatus().getStats();
    Statistic statistic = stats.get(statName);
    if (null != statistic) {
      statistic.markNewEvent();
    } else {
      statistic = new Statistic(statName, 1, new DateTime());
      stats.put(statName, statistic);
    }
  }

}
