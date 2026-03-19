package com.mediaquest.content.service;

import com.mediaquest.content.dto.CreateContentInput;
import com.mediaquest.content.dto.UpdateContentInput;
import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaContent;
import com.mediaquest.content.model.MediaType;
import com.mediaquest.content.model.SourceType;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

  private final List<MediaContent> contents = new ArrayList<>();

  @PostConstruct
  public void init() {
    contents.add(MediaContent.builder()
        .id("1")
        .title("Beat Making Basics")
        .description("A beginner-friendly introduction to building your first beat.")
        .mediaType(MediaType.VIDEO)
        .mediaUrl("https://example.com/media/beat-making-basics")
        .thumbnailUrl("https://example.com/thumbs/beat-making-basics.jpg")
        .tags(List.of("music", "beat-making", "beginner"))
        .difficulty(DifficultyLevel.BEGINNER)
        .durationSeconds(720)
        .sourceType(SourceType.EXTERNAL)
        .creatorName("Quest Studio")
        .build());

    contents.add(MediaContent.builder()
        .id("2")
        .title("Creative Focus Audio Session")
        .description("A short guided audio session for staying focused while creating.")
        .mediaType(MediaType.AUDIO)
        .mediaUrl("https://example.com/media/creative-focus-session")
        .thumbnailUrl("https://example.com/thumbs/creative-focus-session.jpg")
        .tags(List.of("focus", "audio", "creator-mindset"))
        .difficulty(DifficultyLevel.BEGINNER)
        .durationSeconds(480)
        .sourceType(SourceType.INTERNAL)
        .creatorName("Media Quest")
        .build());
  }

  public List<MediaContent> getAllContents() {
    return contents;
  }

  public MediaContent getContentById(String id) {
    return contents.stream()
        .filter(content -> content.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public List<MediaContent> getContentsByTag(String tag) {
    return contents.stream()
        .filter(content -> content.getTags() != null && content.getTags().contains(tag))
        .toList();
  }

  public List<MediaContent> getContentsByDifficulty(DifficultyLevel level) {
    return contents.stream()
        .filter(content -> content.getDifficulty() == level)
        .toList();
  }

  public MediaContent createContent(CreateContentInput input) {
    MediaContent content = MediaContent.builder()
        .id(input.getId())
        .title(input.getTitle())
        .description(input.getDescription())
        .mediaType(input.getMediaType())
        .mediaUrl(input.getMediaUrl())
        .thumbnailUrl(input.getThumbnailUrl())
        .tags(input.getTags())
        .difficulty(input.getDifficulty())
        .durationSeconds(input.getDurationSeconds())
        .sourceType(input.getSourceType())
        .creatorName(input.getCreatorName())
        .build();

    contents.add(content);
    return content;
  }

  public MediaContent updateContent(UpdateContentInput input) {
    MediaContent content = getContentById(input.getId());

    if (content == null) {
      return null;
    }

    if (input.getTitle() != null) {
      content.setTitle(input.getTitle());
    }
    if (input.getDescription() != null) {
      content.setDescription(input.getDescription());
    }
    if (input.getMediaType() != null) {
      content.setMediaType(input.getMediaType());
    }
    if (input.getMediaUrl() != null) {
      content.setMediaUrl(input.getMediaUrl());
    }
    if (input.getThumbnailUrl() != null) {
      content.setThumbnailUrl(input.getThumbnailUrl());
    }
    if (input.getTags() != null) {
      content.setTags(input.getTags());
    }
    if (input.getDifficulty() != null) {
      content.setDifficulty(input.getDifficulty());
    }
    if (input.getDurationSeconds() != null) {
      content.setDurationSeconds(input.getDurationSeconds());
    }
    if (input.getSourceType() != null) {
      content.setSourceType(input.getSourceType());
    }
    if (input.getCreatorName() != null) {
      content.setCreatorName(input.getCreatorName());
    }

    return content;
  }

  public MediaContent deleteContent(String id) {
    MediaContent content = getContentById(id);
    if (content == null) {
      return null;
    }

    contents.remove(content);
    return content;
  }
}
