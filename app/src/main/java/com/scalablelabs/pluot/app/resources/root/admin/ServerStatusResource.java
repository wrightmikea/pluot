/**
 Copyright (c) 2013 Michael A. Wright.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.scalablelabs.pluot.app.resources.root.admin;

import com.scalablelabs.pluot.app.status.ServerDescription;
import com.scalablelabs.pluot.app.status.ServerStatus;
import com.scalablelabs.pluot.app.status.Statistic;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 */
@Path("/status")
public class ServerStatusResource {

  @GET()
  @Produces(MediaType.TEXT_PLAIN)
  public Response serverStatus(@Context UriInfo uriInfo) {

    URI loc = uriInfo.getBaseUriBuilder().build();
    final DateTime NOW = new DateTime();
    ServerStatus serverStatus = ServerStatus.getStatus();
    ServerDescription serverDescription = serverStatus.getServerDescription();
    String status = serverDescription.getName() + " - " +
            serverDescription.getDescription() + " is running\n" +
            "\n version: " + serverDescription.getVersion() +
            ", built: " + serverDescription.getBuilt() +
            "\n\n" + header(serverStatus, NOW) +
            serverDescription.getStatusSeparator() +
            "\n";
    SortedSet<String> keys = new TreeSet<>(serverStatus.getStats().keySet());
    for (Object key : keys) {
      status += formatStat(serverStatus.getStats().get(key), NOW, "");
    }

    return Response.ok(status).contentLocation(loc).build();
  }

  private static String formatStat(Statistic stat, DateTime currentTime, String statusSeparator) {
    return "\n " + maybePadOrTruncate(stat.getName()) +
            "\t(" + stat.getCount() + " invocations) last requested:\t" +
            stat.getLastChangeAt() + "\t\t which was " +
            elapsedTime(stat.getLastChangeAt(), currentTime) + " ago" +
            "\n" + statusSeparator;
  }

  private static String elapsedTime(DateTime sooner, DateTime later) {
    Period period = new Period(sooner, later);
    return PeriodFormat.getDefault().print(period);
  }

  private static String header(ServerStatus serverStatus, DateTime requestTime) {
    DateTime started = serverStatus.getServerDescription().getStarted();
    return "\n\n Server Start Time:\t" + started +
            "\n Current Time:      \t" + requestTime +
            "\n Server Up Time:    \t" + elapsedTime(started, requestTime) +
            "\n";
  }

  private static String maybePadOrTruncate(String source) {
    final int width = 30;
    for (int i = 0; i < width; ++i) {
      source += " ";
    }
    return source.substring(0, width - 1);
  }
}

