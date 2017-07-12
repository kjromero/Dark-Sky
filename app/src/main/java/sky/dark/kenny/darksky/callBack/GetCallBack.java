package sky.dark.kenny.darksky.callBack;

import sky.dark.kenny.darksky.model.ResponseData;

/**
 * Created by desarrollo-carlos on 12/07/17.
 */

public interface GetCallBack {

    void getCallback(ResponseData body, boolean success);
}
