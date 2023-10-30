package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PagesResponseModel {

    String author;
    String content;
    @JsonProperty("created_at")
    String createdAt;
    @JsonProperty("extracted_content_url")
    String extractedContentUrl;
    @JsonProperty("feed_id")
    String feedId;
    String id;
    String published;
    String summary;
    String title;
    String url;
}
