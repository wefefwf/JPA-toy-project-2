package org.diary.diary.controller;

import java.util.List;

import org.diary.diary.DTO.DiaryDTO;
import org.diary.diary.service.DiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
  
private final DiaryService diaryService;

//기본
@GetMapping({"/",""})
public String index(){
  return "redirect:/diary/list"; //아직 view안만들어서 미정 
}
//기본 리스트 페이지 가기
@GetMapping("/list")
public void list(Model model){
  List<DiaryDTO> list = diaryService.getList();
  model.addAttribute("list",list);
}
//글 쓰기 가기
@GetMapping("/register")
public void register(){}
//글 등록 받기
@PostMapping("/register")
public String register(DiaryDTO diaryDTO){

  diaryService.register(diaryDTO);
  return"redirect:/diary/list";
}
//글 상세보기 가기,수정 가기 
@GetMapping({"/read","/modify"})
public void read(@RequestParam("no") long no,Model model){
  DiaryDTO diaryDTO = diaryService.read(no);
  model.addAttribute("dto",diaryDTO);
}
//글 삭제 
@GetMapping("/delete")
public String delete(@RequestParam("no") long no){
diaryService.delete(no);
return"redirect:/diary/list";
}

}
