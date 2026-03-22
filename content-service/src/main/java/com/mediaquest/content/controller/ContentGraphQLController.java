package com.mediaquest.content.controller;

import com.mediaquest.content.dto.CreateContentInput;
import com.mediaquest.content.dto.UpdateContentInput;
import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaContent;
import com.mediaquest.content.service.ContentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ContentGraphQLController {

  private final ContentService contentService;

  @QueryMapping
  public List<MediaContent> getContents() {
    return contentService.getAllContents();
  }

  @QueryMapping
  public MediaContent getContentById(@Argument String id) {
    return contentService.getContentById(id);
  }

  @QueryMapping
  public List<MediaContent> getContentsByTag(@Argument String tag) {
    return contentService.getContentsByTag(tag);
  }

  @QueryMapping
  public List<MediaContent> getContentsByDifficulty(@Argument DifficultyLevel level) {
    return contentService.getContentsByDifficulty(level);
  }

  @MutationMapping
  public MediaContent createContent(@Argument CreateContentInput input) {
    return contentService.createContent(input);
  }

  @MutationMapping
  public MediaContent updateContent(@Argument UpdateContentInput input) {
    return contentService.updateContent(input);
  }

  @MutationMapping
  public MediaContent deleteContent(@Argument String id) {
    return contentService.deleteContent(id);
  }
}
