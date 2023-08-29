package com.spring.demo.system.captcha;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import com.google.code.kaptcha.Producer;
import com.spring.demo.config.properties.SysConfig;
import com.spring.demo.core.cache.util.CacheUtil;
import com.spring.demo.core.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class CaptchaImage {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;
    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private SysConfig sysConfig;
    @Autowired
    private CacheUtil cacheUtil;

    public Map<String, Object> creatCaptchaImage() {
        if (!sysConfig.isCaptchaEnabled()) {
            return new HashMap<String, Object>() {{
                put("captchaEnabled", false);
            }};
        }
        String uuid = IdUtil.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String capStr = null, code = null;
        BufferedImage image = null;
        // 生成验证码
        if ("math".equals(sysConfig.getCaptchaType())) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else if ("char".equals(sysConfig.getCaptchaType())) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }
        cacheUtil.cacheManager(sysConfig.getCacheType()).setObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        Map<String, Object> result = new HashMap<>();

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
            result.put("captChaId", uuid);
            result.put("captchaEnabled", sysConfig.isCaptchaEnabled());
            result.put("captChaImg", Base64.encode(os.toByteArray()));

        } catch (IOException e) {
            log.error("验证码生成错误", e);
        } finally {
            os.close();
        }

        return result;
    }

}