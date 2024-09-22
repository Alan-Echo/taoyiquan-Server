package com.microservices.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ConvertUtils {
    private static Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

    public ConvertUtils() {
    }

    public static <T> T sourceToTarget(Object source, Class<T> target) {
        if (source == null) {
            return null;
        } else {
            T targetObject = null;

            try {
                targetObject = target.newInstance();
                BeanUtils.copyProperties(source, targetObject);
            } catch (Exception var4) {
                logger.error("convert error ", var4);
            }
            return targetObject;
        }
    }

    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        } else {
            ArrayList targetList = new ArrayList(sourceList.size());

            try {
                Iterator var3 = sourceList.iterator();

                while(var3.hasNext()) {
                    Object source = var3.next();
                    T targetObject = target.newInstance();
                    BeanUtils.copyProperties(source, targetObject);
                    targetList.add(targetObject);
                }
            } catch (Exception var6) {
                logger.error("convert error ", var6);
            }

            return targetList;
        }
    }
}

