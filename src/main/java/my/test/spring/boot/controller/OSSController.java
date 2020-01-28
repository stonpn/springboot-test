//package my.test.spring.boot.controller;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import my.test.spring.boot.thirdparty.OSSThirdPartyService;
////import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.inject.Inject;
//
//@RestController
//public class OSSController {
//
//    @Inject
//    private OSSThirdPartyService ossThirdPartyService;
//
//    @ApiOperation(value = "上传图片", notes = "上传图片", httpMethod = "POST", response = String.class)
//    @RequestMapping(value = "/gateway/save-project", method = RequestMethod.POST)
//    //@PostMapping(headers = "content-type=multipart/form-data")
//    public String upload(@RequestParam("imgFile") MultipartFile multipartFile) {
//        String key = 12345 + "/" + multipartFile.getOriginalFilename();
//        try {
//            ossThirdPartyService.uploadObject(key, multipartFile.getInputStream());
//        } catch (Exception e) {
//
//        }
//        return "ok";
//    }
//
//    @ApiOperation(value = "上传图片", notes = "上传图片", httpMethod = "POST", response = String.class)
//    @RequestMapping(value = "/gateway/image/list", method = RequestMethod.POST)
//    public String list(@RequestParam("") String dir){
//        ossThirdPartyService.list(dir);
//        return "oka";
//    }
//
//}
