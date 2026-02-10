package org.diary.diary.service;

import java.util.List;

import org.diary.diary.DTO.DiaryDTO;
import org.diary.diary.entity.Diary;

public interface DiaryService {
  
//목록가져오기
List<DiaryDTO>getList();

//일기 추가
void register(DiaryDTO diaryDTO);

//상세 하나 읽기
DiaryDTO read(long no);

//삭ㅈㅔ
void delete(long no);



//dto to entitiy
default Diary dtoToEntity(DiaryDTO diaryDTO){
  Diary diary =  Diary.builder()
                      .no(diaryDTO.getNo())
                      .title(diaryDTO.getTitle())
                      .content(diaryDTO.getContent())
                      .weather(diaryDTO.getWeather())
                      .wdate(diaryDTO.getWdate())
                      .build();
  return diary;
}

//entity to dto
default DiaryDTO entityToDto(Diary diary){
  DiaryDTO dto = DiaryDTO.builder()
                          .no(diary.getNo())
                          .title(diary.getTitle())
                          .content(diary.getContent())
                          .weather(diary.getWeather())
                          .wdate(diary.getWdate())
                          .build();
  return dto;
}
}
