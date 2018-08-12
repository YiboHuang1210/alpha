package com.hyb.alpha.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/11 13:28
 * @Description:
 */
@Component
public class RedisComponent {

    private final static String SYSTEM_NAME = "alpha";


    /**
     * 系统日志配置.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private StringRedisTemplate redisTemplate;



    public <T> T get(Object key, Class<T> type) {
        // TODO Auto-generated method stub
        final String keyf = (String) key + "-" + SYSTEM_NAME;
        Object object = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);

            }
        });
        return (T)object;
    }
    public Object get(Object key) {
        // TODO Auto-generated method stub
        final String keyf = (String) key + "-" + SYSTEM_NAME;
        Object object = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);

            }
        });
        return object;
    }

    public void put(Object key, Object value, long seconds) {
        // TODO Auto-generated method stub
        final String keyf = key + "-" + SYSTEM_NAME;
        final Object valuef = value;
        final long expireSeconds = seconds;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                connection.setEx(keyb, expireSeconds, valueb);
                return 1L;
            }
        });
    }

    public boolean putIfAbsent(Object key, Object value, long seconds) {
        // TODO Auto-generated method stub
        final String keyf = key + "-" + SYSTEM_NAME;
        final Object valuef = value;
        final long expireSeconds = seconds;

        final Boolean b = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {

                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                boolean r = connection.setNX(keyb, valueb);
                if (r) { // 设置成功,进行超时时间设置
                    connection.expire(keyb, expireSeconds);
                }
                return r;
            }
        });
        return b;
    }

    public void evict(Object key) {
        final String keyf = key + "-" + SYSTEM_NAME;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }

    public long pTtl(Object key) {
        final String keyf = key + "-" + SYSTEM_NAME;
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.pTtl(keyf.getBytes());
            }
        });
    }

    /**
     * 描述 : <Object转byte[]>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param obj
     * @return
     */
    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return bytes;
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

}
