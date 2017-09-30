package my.test.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(ImgListController.class);

    @Value("${upload.path}")
    private String path;

    @Value("${upload.gif}")
    private String gifPath;

    @Value("${upload.sex.gif}")
    private String sexGifPath;

    @Value("${upload.other.sex}")
    private String sexOtherPath;

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

    @RequestMapping("/list-s")
    public String ListSex(Model model) {
        List<String> fileList = getFileNameList(sexGifPath);

        LOGGER.info("list-s size:{},memory:{}",fileList == null ? 0 : fileList.size(), fileList.toString().getBytes().length);
        model.addAttribute("fileList", fileList);
        return "gif-s";
    }

    @RequestMapping("/other-s")
    public String OtherSex(Model model) {
        List<String> fileList = getFileNameList(sexOtherPath);
        LOGGER.info("other-s size:{},memory:{}",fileList == null ? 0 : fileList.size(), fileList.toString().getBytes().length);
        model.addAttribute("fileList", fileList);
        return "other-s";
    }

    private List<String> getFileNameList(String url) {
        File dir = new File(url);
        List<String> resultList = new ArrayList<String>();
        if (dir.isDirectory()) {
            File[] images = dir.listFiles();
            for (File img : images) {
                resultList.add(img.getName());
            }
        }
        return resultList;
    }
}
