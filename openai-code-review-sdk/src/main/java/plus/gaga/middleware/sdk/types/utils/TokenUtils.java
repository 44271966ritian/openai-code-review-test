package plus.gaga.middleware.sdk.types.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TokenUtils {
    //过期时间
    //私有+静态+final常量+long等于过期时间
    //三十分钟，六十秒，一千毫秒
    private static final Long expireMills = 30 * 60 * 1000L;

    //缓存服务
    public static Cache<String,String> cache = CacheBuilder.newBuilder()
            //设置缓存过期时间
            //提前一分钟失效，是为了留一点时间去处理缓存项
            .expireAfterWrite(expireMills - (60 * 1000L), TimeUnit.MILLISECONDS)
            .build();

    public static String getToken(String apiKey,String apiSecret) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("sign_type","SIGN");

        HashMap<String, Object> payload  = new HashMap<>();
        payload.put("api_key",apiKey);
        payload.put("exp",expireMills + System.currentTimeMillis());
        payload.put("timestamp",System.currentTimeMillis());

        //签名算法，传入Secret
        Algorithm algorithm = Algorithm.HMAC256(apiSecret.getBytes(StandardCharsets.UTF_8));
        //签名算法是一定要指定的
        String token = JWT.create().withHeader(header).withPayload(payload).sign(algorithm);

        return token;
    }

    public static String getToken(String apiKeySecret){
        //这个是返回id+key的数组的，重载方法得到真正的token
        //apiKeySecret例如f324acfa09bb651124bb4ba4f59485b6.JbRNoQBp4ZC8AWS4
        //由两部分组成
        String[] split = apiKeySecret.split("\\.");//转义字符
        return getToken(split[0],split[1]);



    }
}
