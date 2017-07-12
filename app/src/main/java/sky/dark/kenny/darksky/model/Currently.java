package sky.dark.kenny.darksky.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by desarrollo-carlos on 12/07/17.
 */

public class Currently implements Serializable {

    @SerializedName("time")
    private String time;

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;

    @SerializedName("temperature")
    private String temperature;

    @SerializedName("uvIndex")
    private String uvIndex;

    @SerializedName("windSpeed")
    private String windSpeed;

    public Currently(String time, String summary, String icon, String temperature, String uvIndex, String windSpeed) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.temperature = temperature;
        this.uvIndex = uvIndex;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
