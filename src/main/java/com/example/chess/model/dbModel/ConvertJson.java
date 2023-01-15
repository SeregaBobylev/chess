package com.example.chess.model.dbModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConvertJson {
    @Autowired
    private ObjectMapper objectMapper;


    public String fromJSON(Object object){
        String result;
        try {
            result =  objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
