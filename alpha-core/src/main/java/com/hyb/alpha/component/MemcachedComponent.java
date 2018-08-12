package com.hyb.alpha.component;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/11 13:16
 * @Description:
 */
@Component
public class MemcachedComponent {
    private Logger logger = LoggerFactory.getLogger(MemcachedComponent.class);

    @Autowired
    private MemcachedClient memcachedClient;

    /**
     * memcache取值，默认超时时间500MS
     * @Description:
     * @Title: get
     * @param key
     * @return  T
     * @throws
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public <T> T get(final String key) {
        try {
            return memcachedClient.get(key);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache get, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache get, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache get, MemcachedException, param=[key={}]", eArray);
        }
        return null;
    }

    /**
     * memcache取值，会抛出异常
     * @Description:
     * @Title: getWithException
     * @param key
     * @return T
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public <T> T getWithException(final String key) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.get(key);
    }

    /**
     * memcache取值,会抛异常
     * @Description:
     * @Title: get
     * @param key 键
     * @param timeout 超时时间
     * @return object
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException  T
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public <T> T get(final String key, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.get(key, timeout);
    }

    /**
     * 设置值，默认超时时间500MS
     * @Description:
     * @Title: set
     * @param key 键
     * @param exp 单位秒 过期时间
     * @param value 值
     * @return  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean set(final String key, final int exp, final Object value) {
        try {
            return memcachedClient.set(key, exp, value);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache set, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache set, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache set, MemcachedException, param=[key={}]", eArray);
        }
        return false;
    }

    /**
     * 设置值，无响应式的，即不关心是否设置成功的情况下使用此方法
     * @Description:
     * @Title: setNoReply
     * @param key
     * @param exp
     * @param value  void
     * @throws
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public void setNoReply(final String key, final int exp, final Object value) {
        try {
            memcachedClient.setWithNoReply(key, exp, value);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache set, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache set, MemcachedException, param=[key={}]", eArray);
        }
    }

    /**
     * 设置值，会抛异常
     * @Description:
     * @Title: set
     * @param key 键
     * @param exp 过期时间 单位秒
     * @param value 值
     * @param timeout 超时时间
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean set(final String key, final int exp, final Object value, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.set(key, exp, value, timeout);
    }

    /**
     * 根据key删除,默认超时时间
     * @Description:
     * @Title: delete
     * @param key 键
     * @return  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean delete(final String key) {
        try {
            return memcachedClient.delete(key);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache delete, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache delete, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache delete, MemcachedException, param=[key={}]", eArray);
        }
        return false;
    }

    /**
     * 根据key删除，不返回成功或者失败
     * @Description:
     * @Title: deleteNoReply
     * @param key  void
     * @throws
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public void deleteNoReply(final String key) {
        try {
            memcachedClient.deleteWithNoReply(key);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache delete, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[] {key, e};
            logger.error("memcache delete, MemcachedException, param=[key={}]", eArray);
        }
    }

    /**
     * 根据key删除
     * @Description:
     * @Title: delete
     * @param key 键
     * @param timeout 超时时间
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean delete(final String key, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.delete(key, timeout);
    }
    /**
     * 根据key获取对象的原子操作对象
     * @Description:
     * @Title: getResonse
     * @param key 键
     * @return GetsResponse
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public <T>GetsResponse<T> getResonse(String key)throws TimeoutException, InterruptedException, MemcachedException {
        GetsResponse<T> response =  memcachedClient.gets(key);
        return response;
    }

    /**
     * 根据key获取对象的原子操作对象
     * @Description:
     * @Title: getResonse
     * @param key 键
     * @param timeout 超时时间
     * @return GetsResponse
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public <T>GetsResponse<T> getResonse(String key,long timeout)throws TimeoutException, InterruptedException, MemcachedException {
        GetsResponse<T> response =  memcachedClient.gets(key,timeout);
        return response;
    }
    /**
     * 设置值(原子操作，即保证在没有人修改的情况下设值)，会抛异常
     * @Description:
     * @Title: set
     * @param key 键
     * @param exp 过期时间
     * @param value 值
     * @param timeout 超时时间
     * @param casValue 原子操作值
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean setCas(final String key, final int exp, final Object value, final long timeout,final long casValue) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.cas(key,exp,value,timeout,casValue);
    }
    /**
     * 设置值(原子操作，即保证在没有人修改的情况下设值)，会抛异常
     * @Description:
     * @Title: set
     * @param key 键
     * @param exp 过期时间
     * @param value 值
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException  boolean
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public boolean setCas(final String key, final int exp, final Object value,final long casValue) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.cas(key,exp,value,casValue);
    }
    /**
     * 获取memcache实例
     * @Description:
     * @Title: getMemcachedClient
     * @return  MemcachedClient
     * @throws
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }
}
