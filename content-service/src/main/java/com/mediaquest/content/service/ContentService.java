package com.mediaquest.content.service;

import com.mediaquest.content.dto.CreateContentInput;
import com.mediaquest.content.dto.UpdateContentInput;
import com.mediaquest.content.exception.ContentNotFoundException;
import com.mediaquest.content.model.ContentProvider;
import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaContent;
import com.mediaquest.content.model.MediaType;
import com.mediaquest.content.payload.ErrorMessages;
import com.mediaquest.content.repository.ContentRepository;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {

  private final ContentRepository contentRepository;

  @PostConstruct
  public void init() {

    if (contentRepository.count() > 0) {
      return;
    }

    contentRepository.save(MediaContent.builder()
        .id("1")
        .title("Beat Making Basics")
        .description("A beginner-friendly introduction to building your first beat.")
        .provider(ContentProvider.YOUTUBE)
        .mediaType(MediaType.VIDEO)
        .mediaUrl("https://example.com/media/beat-making-basics")
        .thumbnailUrl("https://example.com/thumbs/beat-making-basics.jpg")
        .tags(List.of("music", "beat-making", "beginner"))
        .difficulty(DifficultyLevel.BEGINNER)
        .durationSeconds(720)
        .creatorName("Quest Studio")
        .build());

    contentRepository.save(MediaContent.builder()
        .id("2")
        .title("Creative Focus Audio Session")
        .description("A short guided audio session for staying focused while creating.")
        .provider(ContentProvider.INTERNAL)
        .mediaType(MediaType.PODCAST)
        .mediaUrl("https://example.com/media/creative-focus-session")
        .thumbnailUrl("https://example.com/thumbs/creative-focus-session.jpg")
        .tags(List.of("focus", "audio", "creator-mindset"))
        .difficulty(DifficultyLevel.BEGINNER)
        .durationSeconds(480)
        .creatorName("Media Quest")
        .build());
  }

  public List<MediaContent> getAllContents() {
    return contentRepository.findAll();
  }

  public MediaContent getContentById(String id) {
    return contentRepository.findById(id)
        .orElseThrow(() -> new ContentNotFoundException(
            String.format(ErrorMessages.CONTENT_NOT_FOUND_BY_ID, id)));
  }

  public List<MediaContent> getContentsByTag(String tag) {
    List<MediaContent> contents = contentRepository.findByTagsContaining(tag);
    if (contents.isEmpty()) {
      throw new ContentNotFoundException(
          String.format(ErrorMessages.CONTENT_NOT_FOUND_BY_TAG, tag));
    }
    return contents;
  }

  public List<MediaContent> getContentsByDifficulty(DifficultyLevel level) {
    List<MediaContent> contents = contentRepository.findByDifficulty(level);
    if (contents.isEmpty()) {
      throw new ContentNotFoundException(
          String.format(ErrorMessages.CONTENT_NOT_FOUND_BY_DIFFICULTY, level));
    }
    return contents;
  }

  public MediaContent createContent(CreateContentInput input) {
    MediaContent content = MediaContent.builder()
        .id(input.getId())
        .title(input.getTitle())
        .description(input.getDescription())
        .provider(input.getProvider())
        .mediaType(input.getMediaType())
        .mediaUrl(input.getMediaUrl())
        .thumbnailUrl(input.getThumbnailUrl())
        .tags(input.getTags())
        .difficulty(input.getDifficulty())
        .durationSeconds(input.getDurationSeconds())
        .creatorName(input.getCreatorName())
        .build();

    return contentRepository.save(content);
  }

  public MediaContent updateContent(UpdateContentInput input) {
    MediaContent content = getContentById(input.getId());

    if (input.getTitle() != null) {
      content.setTitle(input.getTitle());
    }
    if (input.getDescription() != null) {
      content.setDescription(input.getDescription());
    }
    if (input.getProvider() != null) {
      content.setProvider(input.getProvider());
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
    if (input.getCreatorName() != null) {
      content.setCreatorName(input.getCreatorName());
    }

    return contentRepository.save(content);
  }

  public MediaContent deleteContent(String id) {
    MediaContent content = getContentById(id);

    contentRepository.delete(content);
    return content;
  }
}
