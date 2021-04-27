package com.dev.autocompletesearch.controller;

import com.dev.autocompletesearch.redis.manager.AutoCompleteManager;
import com.dev.autocompletesearch.utils.URLUtils;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/auto-complete", produces = "application/json; charset=UTF-8")
public class AutoCompleteApiController {

    @GetMapping("/api/get")
    public JSONObject complete(@RequestParam String keyword) throws UnsupportedEncodingException {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", "200");
            jsonObject.put("message", "success");
            jsonObject.put("autoCompleteResult", AutoCompleteManager.complete(URLUtils.decode(keyword)));
        } catch (Exception e) {
            jsonObject.put("code", "500");
            jsonObject.put("message", "fail");
        }

        return jsonObject;
    }
}
