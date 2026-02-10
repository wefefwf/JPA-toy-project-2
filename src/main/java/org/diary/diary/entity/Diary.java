package org.diary.diary.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "diary")
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long no;

  private String title;

  private String content;

  private String weather;

  private LocalDateTime wdate;

  public void ChangeTitle(String title){
    this.title = title;
  }

  public void ChangeContent(String content){
    this.content = content;
  }

  public void ChangeWeather(String weather){
    this.weather = weather;
  }

  public void ChangeLocalDateTime(LocalDateTime wdate){
    this.wdate = wdate;
  }
}
