package com.mediaquest.content.dto;

import com.mediaquest.content.model.ContentProvider;
import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaType;
import java.util.List;
import lombok.Data;

@Data
public class CreateContentInput {
  private String id;
  private String title;
  private String description;
  private ContentProvider provider;
  private MediaType mediaType;
  private String mediaUrl;
  private String thumbnailUrl;
  private List<String> tags;
  private DifficultyLevel difficulty;
  private Integer durationSeconds;
  private String creatorName;
}
