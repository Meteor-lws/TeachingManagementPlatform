package com.ruicai.education.server;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wy on 2017/4/21.
 */
public interface UploadService {
    /**
     * 上传图片
     *
     * @return
     */
    public String uploadPic(HttpServletRequest request);
}
