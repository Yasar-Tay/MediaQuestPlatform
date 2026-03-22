package com.mediaquest.content.repository;

import com.mediaquest.content.model.DifficultyLevel;
import com.mediaquest.content.model.MediaContent;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<MediaContent,String> {
  List<MediaContent> findByTagsContaining(String tag);
  List<MediaContent> findByDifficulty(DifficultyLevel difficulty);
}
