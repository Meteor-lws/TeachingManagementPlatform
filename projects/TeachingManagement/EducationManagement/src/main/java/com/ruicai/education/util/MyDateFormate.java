package com.ruicai.education.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by wy on 2017/4/22.
 */
public class MyDateFormate {

    public static String timeStampToString(Timestamp t) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return simpleDateFormat.format(t);
    }

}
