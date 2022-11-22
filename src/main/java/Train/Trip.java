package Train;

public class Trip {
    private String stationStart,stationEnd;
    private Long startedJourneyAt,costInCents;
            private Integer zoneFrom,zoneTo;

    public Trip() {
    }

    public String getStationStart() {
        return stationStart;
    }

    public void setStationStart(String stationStart) {
        this.stationStart = stationStart;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(String stationEnd) {
        this.stationEnd = stationEnd;
    }

    public Long getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public void setStartedJourneyAt(Long startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public Long getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(Long costInCents) {
        this.costInCents = costInCents;
    }



    public void setZoneFrom(Integer zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public Integer getZoneFrom() {
        return zoneFrom;
    }

    public Integer getZoneTo() {
        return zoneTo;
    }

    public void setZoneTo(Integer zoneTo)
    {
        this.zoneTo = zoneTo;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "stationStart='" + stationStart + '\'' +
                ", stationEnd='" + stationEnd + '\'' +
                ", startedJourneyAt=" + startedJourneyAt +
                ", costInCents=" + costInCents +
                ", zoneFrom=" + zoneFrom +
                ", zoneTo=" + zoneTo +
                '}';
    }
}
