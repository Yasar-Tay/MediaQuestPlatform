package com.mediaquest.content.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "media_contents")
public class MediaContent {

  @Id
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
