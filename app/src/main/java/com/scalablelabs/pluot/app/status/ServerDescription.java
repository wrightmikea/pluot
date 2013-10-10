package com.scalablelabs.pluot.app.status;

import org.joda.time.DateTime;

/**
 *
 */
public class ServerDescription {
  private String _built;
  private String _description;
  private String _name;
  private String _propFilePrefix;
  private String _propPrefix;
  private DateTime _started;
  private String _statusSeparator;
  private String _version;

  public String getBuilt() {
    return _built;
  }

  public String getDescription() {
    return _description;
  }

  public String getPropFilePrefix() {
    return _propFilePrefix;
  }

  public String getPropPrefix() {
    return _propPrefix;
  }

  public String getName() {
    return _name;
  }

  public DateTime getStarted() {
    return _started;
  }

  public String getStatusSeparator() {
    return _statusSeparator;
  }

  public String getVersion() {
    return _version;
  }

  public void setBuilt(String built) {
    _built = built;
  }

  public void setDescription(String description) {
    _description = description;
  }

  public void setName(String name) {
    _name = name;
  }

  public void setPropFilePrefix(String propFilePrefix) {
    _propFilePrefix = propFilePrefix;
  }

  public void setPropPrefix(String propPrefix) {
    _propPrefix = propPrefix;
  }

  public void setStarted(DateTime started) {
    _started = started;
  }

  public void setStatusSeparator(String statusSeparator) {
    _statusSeparator = statusSeparator;
  }

  public void setVersion(String version) {
    _version = version;
  }
}
