package com.ruicai.education.server.impl;

import com.ruicai.education.server.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by wy on 2017/4/21.
 */
@Service
public class UploadServerImpl implements UploadService {
    @Override
    public String uploadPic(HttpServletRequest request) {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        String path;
        boolean flag = resolver.isMultipart(request);
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multiRequest.getFileNames();
            while (fileNames.hasNext()) {
                MultipartFile file = multiRequest.getFile(fileNames.next());
                if (file != null) {
                    String FileName = file.getOriginalFilename();
                    if (!FileName.trim().equals("")) {
                        try {
                            String suffix = FileName.substring(FileName.lastIndexOf("."));
                            String upLoadName = UUID.randomUUID().toString();
                            file.transferTo(new File("D:\\Tomcat\\Tomcat-7.0.75\\webapps\\Upload\\" + upLoadName + suffix));
                            path = upLoadName + suffix;
                            return path;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
