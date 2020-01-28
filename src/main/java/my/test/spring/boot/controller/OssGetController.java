//package my.test.spring.boot.controller;
//
//import io.swagger.annotations.ApiOperation;
//import my.test.spring.boot.thirdparty.OSSThirdPartyService;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedInputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//@Controller
//public class OssGetController {
//
//    @Inject
//    private OSSThirdPartyService ossThirdPartyService;
//
//    @ApiOperation(value = "获取文件流", notes = "获取文件流", httpMethod = "GET")
//    @RequestMapping(value = "/get-object", method = RequestMethod.GET)
//    public void getObject(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        InputStream inputStream = ossThirdPartyService.getFileStream("12345", "test1123.sb3");
//        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        OutputStream os = response.getOutputStream();
//        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
//        response.setHeader("Content-Disposition","filename="+"test1123.sb3");
//        byte[] data = new byte[1];
//        int length = 0;
//        while ((length = bis.read(data, 0 ,1)) > -1) {
//            os.write(data, 0, 1);
//        }
//        os.flush();
//        os.close();
//    }
//}
