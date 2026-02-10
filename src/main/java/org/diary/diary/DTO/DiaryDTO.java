package org.diary.diary.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDTO {
  
  private Long no;

  private String title;

  private String content;

  private String weather;

  private LocalDateTime wdate;

}
