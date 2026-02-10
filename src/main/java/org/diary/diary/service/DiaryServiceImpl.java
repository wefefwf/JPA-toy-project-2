package org.diary.diary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.diary.diary.DTO.DiaryDTO;
import org.diary.diary.entity.Diary;
import org.diary.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
  
  private final DiaryRepository diaryRepository;

  //목록가져오기
  @Override
  public List<DiaryDTO> getList() {
    List<Diary> list = diaryRepository.findAll();
    //dto 변환
    List<DiaryDTO> dtoList = new ArrayList<>();
    for(Diary diary : list){
      dtoList.add(entityToDto(diary));
    }
    return dtoList;
  }
//일기추가
  @Override
  public void register(DiaryDTO diaryDTO) {
    Diary diary = dtoToEntity(diaryDTO);
    diaryRepository.save(diary);
  }
//글 하나 읽어오기
  @Override
  public DiaryDTO read(long no) {
    Optional<Diary> result = diaryRepository.findById(no);
    DiaryDTO diaryDTO = null;
    if(result.isPresent()){
      diaryDTO = entityToDto(result.get());
    }
    return diaryDTO;
  }
  //삭제
  @Override
  public void delete(long no) {
    diaryRepository.deleteById(no);
  }

  


}
