package my.test.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.security.SecureRandom;
import java.util.*;

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

    @Value("${img.view.url}")
    private String imgUrl;

    @RequestMapping("/list-image")
    public String ListCommonImg(Model model) {
        List<String> fileList = getFileNameList(path);
        fileList = sortList(fileList);
        model.addAttribute("fileList", fileList);
        model.addAttribute("imgUrl", imgUrl);
        return "common-image";
    }

    @RequestMapping("/list-gif")
    public String ListGifImg(Model model) {
        List<String> fileList = getFileNameList(gifPath);
        fileList = sortList(fileList);
        model.addAttribute("fileList", fileList);
        model.addAttribute("imgUrl", imgUrl);
        return "gif-image";
    }

    @RequestMapping("/list-s")
    public String ListSex(Model model) {
        List<String> fileList = getFileNameList(sexGifPath);

        LOGGER.info("list-s size:{},memory:{}",fileList == null ? 0 : fileList.size(), fileList.toString().getBytes().length);
        fileList = sortList(fileList);
        model.addAttribute("fileList", fileList);
        model.addAttribute("imgUrl", imgUrl);
        return "gif-s";
    }

    @RequestMapping("/other-s")
    public String OtherSex(Model model) {
        List<String> fileList = getFileNameList(sexOtherPath);
        LOGGER.info("other-s size:{},memory:{}",fileList == null ? 0 : fileList.size(), fileList.toString().getBytes().length);
        fileList = sortList(fileList);
        model.addAttribute("fileList", fileList);
        model.addAttribute("imgUrl", imgUrl);
        return "other-s";
    }

    private List<String> getFileNameList(String url) {
        File dir = new File(url);
        List<String> resultList = new ArrayList<String>();
        if (dir.isDirectory()) {
            File[] images = dir.listFiles();
            for (File img : images) {
                if (img.isDirectory()) {
                    continue;
                }
                resultList.add(img.getName());
            }
        }
        return resultList;
    }

    private List<String> sortList(List<String> list) {
        int listSize = list.size();
        List<String> newList = new ArrayList<String>(listSize);
        for (int k = 0;k < listSize; k++) {
            newList.add("1");
        }
        Random random = new SecureRandom();
        for (String path : list) {
            int randomNumber = random.nextInt(listSize);
            if (randomNumber % 10 == 0 && newList.get(0).equals("1")) {
                newList.set(0, path);
            }
            if (newList.get(randomNumber).equals("1")) {
                newList.set(randomNumber, path);
            } else {
                boolean found = false;
                for (int i = randomNumber;i < listSize;i++) {
                    if (newList.get(i).equals("1")) {
                        newList.set(i, path);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    continue;
                }
                for (int j = randomNumber; j >= 0; j--) {
                    if (newList.get(j).equals("1")) {
                        newList.set(j, path);
                        break;
                    }
                }
            }
        }
        return newList;
    }



}
