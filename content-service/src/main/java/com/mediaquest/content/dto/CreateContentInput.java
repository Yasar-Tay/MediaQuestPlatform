package com.mediaquest.content.dto;

import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaType;
import com.mediaquest.content.model.SourceType;
import java.util.List;
import lombok.Data;

@Data
public class CreateContentInput {
  private String id;
  private String title;
  private String description;
  private MediaType mediaType;
  private String mediaUrl;
  private String thumbnailUrl;
  private List<String> tags;
  private DifficultyLevel difficulty;
  private Integer durationSeconds;
  private SourceType sourceType;
  private String creatorName;
}
