package my.test.spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pengni on 17-8-14.
 */
@Controller
public class FileUploadController {

    @Value("${upload.path}")
    private String path;

    @Value("${upload.gif}")
    private String gifPath;

    @RequestMapping("/upload")
    public @ResponseBody String uploadImg(@RequestParam("files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String imgPath = null;
            if (fileName.endsWith(".gif") || fileName.endsWith(".GIF")) {
                imgPath = gifPath + fileName;
            } else {
                imgPath = path + fileName;
            }
            System.out.println(imgPath);
            file.transferTo(new File(imgPath));
        }
        return "ok";
    }

    @RequestMapping("/file-delete")
    public String deleteImg(HttpServletRequest request) throws Exception {
        String fileName = request.getParameter("filename");
        if (!StringUtils.hasText(fileName)) {
            return "index";
        }
        String dir = null;
        String url = null;
        if (fileName.endsWith(".gif") || fileName.endsWith(".GIF")) {
            dir = gifPath;
            url = "/list-gif";
        } else {
            dir = path;
            url = "/list-image";
        }
        File file = new File(dir + fileName);
        file.delete();
        return "redirect:" + url;
    }

    @RequestMapping("/test")
    public @ResponseBody String test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
