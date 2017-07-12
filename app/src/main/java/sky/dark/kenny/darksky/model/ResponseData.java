package sky.dark.kenny.darksky.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by desarrollo-carlos on 12/07/17.
 */

public class ResponseData implements Serializable {

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("currently")
    private Currently currently;

    public ResponseData(String timezone, Currently currently) {
        this.timezone = timezone;
        this.currently = currently;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }
}
