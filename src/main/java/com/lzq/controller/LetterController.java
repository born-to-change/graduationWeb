package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.Letter;
import com.lzq.service.LetterService;
import com.lzq.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/letter")
public class LetterController {

    @Autowired
    private LetterService letterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/createLetter", method = RequestMethod.POST)
@ResponseBody
public ResultInfo.Result createLetter(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        Gson gson = new Gson();
        String letterInfo = gson.toJson(keyMap.get("data"));
        Letter letter= gson.fromJson(letterInfo, Letter.class);
        letter.setLetterTime(new Timestamp(System.currentTimeMillis()));
        return letterService.createLetter(letter);
        }

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/updateLetter", method = RequestMethod.POST)
@ResponseBody
public ResultInfo.Result updateLetter(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        Gson gson = new Gson();
        String bookInfo = gson.toJson(keyMap.get("data"));
        Letter letter= gson.fromJson(bookInfo, Letter.class);
        return letterService.updateLetter(letter);
        }

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/deleteLetter", method = RequestMethod.POST)
@ResponseBody
public ResultInfo.Result deleteLetter(@RequestBody String data) {
        Map<String,Integer> keyMap = JSON.parseObject(data,Map.class);
        return letterService.deleteLetter(keyMap.get("data"));
        }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getLettersByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<Letter> getLettersByUserId(@RequestBody String data){
        Map<String,Integer> keyMap = JSON.parseObject(data,Map.class);
        int userId = keyMap.get("data");
        return letterService.getLettersByUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getLettersByReplyUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<Letter> getLettersByReplyUserId(@RequestBody String data){
        Map<String,Integer> keyMap = JSON.parseObject(data,Map.class);
        int userId = keyMap.get("data");
        return letterService.getLettersByReplyUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getRandomNewLettersFilterUser", method = RequestMethod.POST)
    @ResponseBody
    public List<Letter> getRandomNewLettersFilterUser(@RequestBody String data){
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        Integer userId = Integer.valueOf(keyMap.get("data"));
        return letterService.getRandomNewLettersFilterUser(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getLetterByLetterId", method = RequestMethod.POST)
    @ResponseBody
    public Letter getLetterByLetterId(@RequestBody String data){
        Map<String,Integer> keyMap = JSON.parseObject(data,Map.class);
        int letterId = keyMap.get("data");
        return letterService.getLetterByLetterId(letterId);
    }

}
