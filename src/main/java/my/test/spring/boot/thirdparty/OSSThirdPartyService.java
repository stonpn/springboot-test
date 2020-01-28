//package my.test.spring.boot.thirdparty;
//
//import com.aliyun.oss.model.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.aliyun.oss.OSSClient;
//import org.springframework.util.StringUtils;
//
//import javax.inject.Inject;
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class OSSThirdPartyService {
//
//    @Value("${oss.aliyun.bucket.name}")
//    private String ossBucketName;
//
//    @Inject
//    private OSSClient ossClient;
//
//    //图片链接访问地址的有效时间一个星期
//    private final static Long URL_VALID_TIME = 3600L * 24L * 7L;
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(OSSThirdPartyService.class);
//
//    public void uploadObject(String key, InputStream inputStream) {
//        ossClient.putObject(ossBucketName, key, inputStream);
//    }
//
//    public void list(String dir) {
//        ObjectListing objectListing = ossClient.listObjects(ossBucketName, dir);
//        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
//        for (OSSObjectSummary s : sums) {
//            System.out.println("\t" + s.getKey());
//        }
//    }
//
//    public String uploadImage(String key, InputStream inputStream, String imgType) {
//        ObjectMetadata metadata = constructImageMetaData(imgType);
//        ossClient.putObject(ossBucketName, key, inputStream, metadata);
//        Date expiration = new Date(System.currentTimeMillis() + URL_VALID_TIME);
//        URL url = ossClient.generatePresignedUrl(ossBucketName, key, expiration);
//        ossClient.shutdown();
//        if (url == null) {
//            LOGGER.info("创建阿里云图片链接地址失败，key:{}", key);
//            return null;
//        }
//        String originalUrl = url.toString();
//        //把url的参数去掉再返回
//        String[] params = originalUrl.split("\\?");
//        return params[0];
//    }
//
//    public InputStream getFileStream(String dir, String fileName) throws Exception {
//        String filePath;
//        if (StringUtils.hasText(dir)) {
//            filePath = dir + "/" + fileName;
//        } else {
//            filePath = fileName;
//        }
//        OSSObject ossObject = ossClient.getObject(ossBucketName, filePath);
//        return ossObject.getObjectContent();
//    }
//
//    private ObjectMetadata constructImageMetaData(String contentType) {
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setContentType(contentType);
//        //公有访问可读权限
//        objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
//        return objectMetadata;
//    }
//
//
//
//
//
//}
