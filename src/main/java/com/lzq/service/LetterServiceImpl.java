package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.mapper.LetterMapper;
import com.lzq.pojo.Letter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LetterServiceImpl implements LetterService{
    @Autowired
    private LetterMapper letterMapper;

    public ResultInfo.Result createLetter(Letter letter){
        ResultInfo.Result ret = ResultInfo.Result.builder().isFailed(true).build();
        try {
            letterMapper.createLetter(letter);
        } catch (Exception e) {
            log.warn("create letter failed", e);
            return ret;
        }
        return ret;
    }

    public List<Letter> getLettersByUserId(int userId){
        List<Letter> letters;
        try {
            letters = letterMapper.getLettersByUserId(userId);
        } catch (Exception e) {
            log.warn("get letters by userId failed", e);
            return null;
        }
        return letters;
    }

    public List<Letter> getLettersByReplyUserId(int userId){
        List<Letter> letters;
        try {
            letters = letterMapper.getLettersByReplyUserId(userId);
        } catch (Exception e) {
            log.warn("get letters by replyUserId failed", e,userId);
            return null;
        }
        return letters;
    }

    public List<Letter> getRandomNewLettersFilterUser(int userId){
        List<Letter> letters;
        try {
            letters = letterMapper.getRandomNewLettersFilterUser(userId);
        } catch (Exception e) {
            log.warn("get random newLetters failed", e,userId);
            return null;
        }
        return letters;
    }

    public Letter getLetterByLetterId(int letterId){
        Letter letter;
        try {
            letter = letterMapper.getLetterByLetterId(letterId);
        } catch (Exception e) {
            log.warn("get letters by letterId failed", e,letterId);
            return null;
        }
        return letter;
    }

    public ResultInfo.Result updateLetter(Letter letter){
        ResultInfo.Result ret = ResultInfo.Result.builder().isFailed(true).build();
        try {
            letterMapper.updateLetter(letter);

        } catch (Exception e) {
            log.warn("update letter failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public ResultInfo.Result deleteLetter(int letterId){
        ResultInfo.Result ret = ResultInfo.Result.builder().isFailed(true).build();
        try {
            letterMapper.deleteLetter(letterId);

        } catch (Exception e) {
            log.warn("delete letter failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }
}
