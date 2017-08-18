package my.test.spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengni on 17-8-17.
 */
@Controller
public class ImgListController {

    @Value("${upload.path}")
    private String path;

    @Value("${upload.gif}")
    private String gifPath;

    @RequestMapping("/list-image")
    public String ListCommonImg(Model model) {
        List<String> fileList = getFileNameList(path);
        model.addAttribute("fileList", fileList);
        return "common-image";
    }

    @RequestMapping("/list-gif")
    public String ListGifImg(Model model) {
        List<String> fileList = getFileNameList(gifPath);
        model.addAttribute("fileList", fileList);
        return "gif-image";
    }

    private List<String> getFileNameList(String url) {
        File dir = new File(url);
        List<String> resultList = new ArrayList<String>();
        if (dir.isDirectory()) {
            File[] images = dir.listFiles();
            for (File img : images) {
                System.out.println(img.getName());
                resultList.add(img.getName());
            }
        }
        return resultList;
    }
}
