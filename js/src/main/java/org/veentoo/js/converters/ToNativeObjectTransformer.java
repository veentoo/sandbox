package org.veentoo.js.converters;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeObject;

import java.util.Set;

public class ToNativeObjectTransformer {
    private static final Logger log = Logger.getLogger(ToNativeObjectTransformer.class);

    private static ToNativeObjectTransformer transformer;

    private ToNativeObjectTransformer(){ }

    public static ToNativeObjectTransformer getInstance() {
        if (transformer == null) {
            synchronized (ToNativeObjectTransformer.class) {
                if (transformer == null) {
                    transformer = new ToNativeObjectTransformer();
                }
            }
        }
        return transformer;
    }

    @SuppressWarnings("unused")
    public NativeObject transformJsonToNative(JSONObject jsonObj) {
        return transformObject(jsonObj);
    }

    public NativeObject transformXmlToNative(String xmlString) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        log.debug("Resulting json: " + jsonObject);
        return transformObject(jsonObject);
    }

    private Object transformObject(Object obj) {
        if (obj instanceof JSONObject) {
            return transformObject((JSONObject)obj);
        } else if (obj instanceof JSONArray) {
            return transformArray((JSONArray) obj);
        } else if (obj instanceof String){
            return obj;
        } else {
            throw new IllegalStateException("unknown java type to transform: " + obj.getClass().getName());
        }
    }

    @SuppressWarnings("unchecked")
    private NativeObject transformObject(JSONObject json) {
        if (json.length() == 0) {
            log.debug("Zero length json object, return empty native");
            return new NativeObject();
        }
        NativeObject nativeObj = new NativeObject();
        Set<String> keys = json.keySet();
        for (String key : keys) {
            Object obj = json.get(key);
            log.debug("obj type: " + obj.getClass().getName());
            if (obj instanceof JSONObject) {
                log.debug("object: " + obj);
                nativeObj.put(key, nativeObj, transformObject((JSONObject)obj));
            } else if (obj instanceof JSONArray) {
                log.debug("array: " + obj);
                nativeObj.put(key, nativeObj, transformArray((JSONArray)obj));
            } else {
                log.debug("value: " + obj);
                nativeObj.put(key, nativeObj, json.get(key).toString());
            }
        }
        return nativeObj;
    }

    @SuppressWarnings("CollectionAddedToSelf")
    private NativeArray transformArray(JSONArray array) {
        NativeArray nativeArray = new NativeArray(array.length());
        for (int i = 0; i < array.length(); i++) {
            nativeArray.put(i, nativeArray, transformObject(array.get(i)));
        }
        return nativeArray;
    }

}