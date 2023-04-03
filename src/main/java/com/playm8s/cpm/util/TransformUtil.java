package com.playm8s.cpm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.internal.Primitives;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TransformUtil {

    private static final Logger log = LoggerFactory.getLogger(TransformUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getJsonString(Object o)  {
        try {
            return  objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            log.error("evnt=ErrorConvertingObjectToJSON objectData={}",o.toString());
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        Object object = null;
        try {
            object = objectMapper.readValue(json,classOfT);
            return Primitives.wrap(classOfT).cast(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> List<T> convertQueueToArray(ConcurrentLinkedQueue<T> concurrentLinkedQueue) {
        if(concurrentLinkedQueue == null) {
            return null;
        }

        List<T> list = new ArrayList<>();
        while (true) {
            T obj = concurrentLinkedQueue.poll();
            if(obj == null) {
                break;
            }
            list.add(obj);
        }
        return list;
    }

    public static JsonNode convertToJsonNode(String s) {
        JsonNode jsonNode = null;
        try {
             jsonNode = objectMapper.readTree(s);
        } catch (Exception e) {
            log.error("event=ErrorConvertingToJsonNode stringData={}",s);
            e.printStackTrace();
        }
        return jsonNode;
    }

    public static Map<String,String> getCifAdditionalFields(String jobId, Map<String,String> actualJobAdditionalFields, Map<String,String> filedToCifMapping) {

        Map<String,String> cifAdditionalFields;
        if(actualJobAdditionalFields == null) {
            return new HashMap<>();
        }
        try {
            cifAdditionalFields = new HashMap<>();
            Map<String, String> finalCifAdditionalFields = cifAdditionalFields;
            actualJobAdditionalFields
                    .keySet()
                    .stream()
                    .forEach((field) -> {
                        if (filedToCifMapping.containsKey(field)) {
                            finalCifAdditionalFields.put(filedToCifMapping.get(field), actualJobAdditionalFields.get(field));
                        } else {
                            log.error("event=CifMappingNotFoundForField field={} jobId={}", field, jobId);
                        }
                    });
        } catch (Exception e){
            log.error("event=errorFindingCifAdditionalFields jobId={}", jobId);
            return  null;
        }
        return cifAdditionalFields;
    }

    public static Document getDocument(Object obj) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(obj);
        return Document.parse(json);
    }

}
