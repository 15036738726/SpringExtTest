package com.example.demo.spi.PropertySourceLoader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现可以读取json格式的配置文件
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {

        ReadableByteChannel readableByteChannel = resource.readableChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) resource.contentLength());

        //将文件内容读到 ByteBuffer 中
        readableByteChannel.read(byteBuffer);
        //将读出来的字节转换成字符串
        String content = new String(byteBuffer.array());
        // 将字符串转换成 JSONObject
        JSONObject jsonObject = JSON.parseObject(content);

        Map<String, Object> map = new HashMap<>(jsonObject.size());
        //将 json 的键值对读出来，放入到 map 中
        for (String key : jsonObject.keySet()) {
            map.put(key, jsonObject.getString(key));
        }

        return Collections.singletonList(new MapPropertySource("jsonPropertySource", map));
    }
}
