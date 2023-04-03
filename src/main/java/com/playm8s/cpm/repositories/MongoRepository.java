package com.playm8s.cpm.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.playm8s.cpm.constants.MongoTablesEnum;
import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.runners.TestRunner;
import com.playm8s.cpm.util.TransformUtil;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
supported tables

user,user_settings
arena,court,courtinventory,game,location
matchrequest
 */
@Repository
public class MongoRepository {

    Logger log = LoggerFactory.getLogger(TestRunner.class);
    MongoClient mongoClient;

    MongoDatabase mongoDatabase;
    Map<MongoTablesEnum,MongoCollection<Document>> mongoCollectionMap;

    public MongoRepository(@Autowired MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = mongoClient.getDatabase("playmates");
        mongoCollectionMap = new HashMap<>();
        for(MongoTablesEnum mongoTablesEnum :  MongoTablesEnum.values()) {
            mongoCollectionMap.put(mongoTablesEnum,mongoDatabase.getCollection(mongoTablesEnum.toString()));
        }
    }
    public String saveMatchMakeRequest(MatchMakeRequest matchMakeRequest) throws JsonProcessingException {
        Document doc = TransformUtil.getDocument(matchMakeRequest);
        MongoCollection<Document> matchRequests = mongoCollectionMap.get(MongoTablesEnum.MATCH_REQUESTS);
        InsertOneResult insertOneResult = matchRequests.insertOne(doc);
        String requestId  = insertOneResult.getInsertedId().asString().toString();
        return requestId;
    }
    public List<MatchMakeRequest> fetchAllActiveMatchRequests() {
        List<MatchMakeRequest> matchMakeRequests = new ArrayList<>();
        MongoCollection<Document> matchRequests = mongoCollectionMap.get(MongoTablesEnum.MATCH_REQUESTS);
        FindIterable<Document> documents = matchRequests.find();
        documents.forEach(doc -> matchMakeRequests.add(TransformUtil.fromJson(doc.toJson(),MatchMakeRequest.class)));
        return matchMakeRequests;
    }

    public Document fetchDocument(String id, MongoTablesEnum mongoTablesEnum) {
        MongoCollection<Document> collection = mongoCollectionMap.get(mongoTablesEnum);
        BasicDBObject whereQuery = new BasicDBObject("_id",id);
        FindIterable<Document> docs = collection.find(whereQuery);
        return docs.first();
    }

    public <T> T fetchObject(String id, MongoTablesEnum mongoTablesEnum,Class<T> classOfT) {
        MongoCollection<Document> collection = mongoCollectionMap.get(mongoTablesEnum);
        BasicDBObject whereQuery = new BasicDBObject("_id",id);
        FindIterable<Document> docs = collection.find(whereQuery);
        if(docs.first() == null) return null;
        try {
            return TransformUtil.fromJson(docs.first().toJson(),classOfT);
        } catch(Exception e) {
            log.error("evnt=ErroConvertingToObject object={} class={}",docs.first().toJson(),classOfT);
        }
        return null;
    }

    public void saveDocument(MongoTablesEnum mongoTablesEnum,Object docObj) {
        if(docObj.getClass().equals(mongoTablesEnum.getKlass())) {
            MongoCollection<Document> mongoCollection = mongoCollectionMap.get(mongoTablesEnum);
            try {
                mongoCollection.insertOne(TransformUtil.getDocument(docObj));
            } catch (Exception e) {
                log.error("evnt=PutObjectFailed collection={} obj={}"
                        ,mongoTablesEnum.getTableName(),docObj);
            }
        }
        else throw new RuntimeException("event=PutObjectFailed object= "+docObj.toString()
                + " collection = " + mongoTablesEnum.getTableName());
    }





}
