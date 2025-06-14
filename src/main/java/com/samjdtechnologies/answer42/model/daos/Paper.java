package com.samjdtechnologies.answer42.model.daos;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Entity representing a research paper in the system.
 * Maps to the 'papers' table in the answer42 schema.
 */
@Entity
@Table(name = "papers", schema = "answer42")
@NoArgsConstructor
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "authors", columnDefinition = "jsonb")
    private List<String> authors;

    @Column(name = "journal")
    private String journal;

    @Column(name = "year")
    private Integer year;

    @Column(name = "file_path")
    private String filePath;

    // UPDATED: Change to text type
    @Column(name = "text_content", columnDefinition = "text")
    private String textContent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private JsonNode metadata;

    @Column(name = "status")
    private String status = "PENDING";

    // UPDATED: Add proper timestamp annotations
    @CreationTimestamp
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "is_public")
    private Boolean isPublic = false;

    @Column(name = "paper_abstract", columnDefinition = "text")
    private String paperAbstract;

    @Column(name = "doi")
    private String doi;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "key_findings", columnDefinition = "jsonb")
    private JsonNode keyFindings;
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "methodology_details", columnDefinition = "jsonb")
    private JsonNode methodologyDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "topics", columnDefinition = "jsonb")
    private List<String> topics;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "research_questions", columnDefinition = "jsonb")
    private JsonNode researchQuestions;

    @Column(name = "summary_brief", columnDefinition = "text")
    private String summaryBrief;

    @Column(name = "summary_standard", columnDefinition = "text")
    private String summaryStandard;

    @Column(name = "summary_detailed", columnDefinition = "text")
    private String summaryDetailed;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "glossart", columnDefinition = "jsonb")
    private JsonNode glossary;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "main_concepts", columnDefinition = "jsonb")
    private JsonNode mainConcepts;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "citations", columnDefinition = "jsonb")
    private JsonNode citations;

    @Column(name = "references_count")
    private Integer referencesCount = 0;

    @Column(name = "quality_score")
    private Double qualityScore;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "quality_feedback", columnDefinition = "jsonb")
    private JsonNode qualityFeedback;

    @Column(name = "crossref_doi")
    private String crossrefDoi;

    @Column(name = "crossref_verified")
    private Boolean crossrefVerified = false;

    @Column(name = "crossref_score")
    private Double crossrefScore = 0.0;

    @Column(name = "crossref_last_verified")
    private ZonedDateTime crossrefLastVerified;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "crossref_metadata", columnDefinition = "jsonb")
    private JsonNode crossrefMetadata;

    @Column(name = "metadata_source")
    private String metadataSource;

    @Column(name = "metadata_confidence")
    private Double metadataConfidence = 0.0;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata_source_details", columnDefinition = "jsonb")
    private JsonNode metadataSourceDetails;

    @Column(name = "semantic_scholar_id")
    private String semanticScholarId;

    @Column(name = "semantic_scholar_verified")
    private Boolean semanticScholarVerified = false;

    @Column(name = "semantic_scholar_score")
    private Double semanticScholarScore = 0.0;

    @Column(name = "semantic_scholar_last_verified")
    private ZonedDateTime semanticScholarLastVerified;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "semantic_scholar_metadata", columnDefinition = "jsonb")
    private JsonNode semanticScholarMetadata;

    @Column(name = "arxiv_id")
    private String arxivId;

    @Column(name = "processing_status")
    private String processingStatus = "PENDING";


    /**
     * Constructor with required fields for creating a new paper.
     * 
     * @param title The title of the paper
     * @param authors The list of authors of the paper
     * @param filePath The path to the paper file
     * @param user The user who uploaded the paper
     */
    public Paper(String title, List<String> authors, String filePath, User user) {
        this();
        this.title = title;
        this.authors = authors;
        this.filePath = filePath;
        this.user = user;
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public JsonNode getMetadata() {
        return metadata;
    }

    public void setMetadata(JsonNode metadata) {
        this.metadata = metadata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public JsonNode getKeyFindings() {
        return keyFindings;
    }

    public void setKeyFindings(JsonNode keyFindings) {
        this.keyFindings = keyFindings;
    }

    public JsonNode getMethodologyDetails() {
        return methodologyDetails;
    }

    public void setMethodologyDetails(JsonNode methodologyDetails) {
        this.methodologyDetails = methodologyDetails;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public JsonNode getResearchQuestions() {
        return researchQuestions;
    }

    public void setResearchQuestions(JsonNode researchQuestions) {
        this.researchQuestions = researchQuestions;
    }

    public String getSummaryBrief() {
        return summaryBrief;
    }

    public void setSummaryBrief(String summaryBrief) {
        this.summaryBrief = summaryBrief;
    }

    public String getSummaryStandard() {
        return summaryStandard;
    }

    public void setSummaryStandard(String summaryStandard) {
        this.summaryStandard = summaryStandard;
    }

    public String getSummaryDetailed() {
        return summaryDetailed;
    }

    public void setSummaryDetailed(String summaryDetailed) {
        this.summaryDetailed = summaryDetailed;
    }

    public JsonNode getGlossary() {
        return glossary;
    }

    public void setGlossary(JsonNode glossary) {
        this.glossary = glossary;
    }

    public JsonNode getMainConcepts() {
        return mainConcepts;
    }

    public void setMainConcepts(JsonNode mainConcepts) {
        this.mainConcepts = mainConcepts;
    }

    public JsonNode getCitations() {
        return citations;
    }

    public void setCitations(JsonNode citations) {
        this.citations = citations;
    }

    public Integer getReferencesCount() {
        return referencesCount;
    }

    public void setReferencesCount(Integer referencesCount) {
        this.referencesCount = referencesCount;
    }

    public Double getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(Double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public JsonNode getQualityFeedback() {
        return qualityFeedback;
    }

    public void setQualityFeedback(JsonNode qualityFeedback) {
        this.qualityFeedback = qualityFeedback;
    }

    public String getCrossrefDoi() {
        return crossrefDoi;
    }

    public void setCrossrefDoi(String crossrefDoi) {
        this.crossrefDoi = crossrefDoi;
    }

    public Boolean getCrossrefVerified() {
        return crossrefVerified;
    }

    public void setCrossrefVerified(Boolean crossrefVerified) {
        this.crossrefVerified = crossrefVerified;
    }

    public Double getCrossrefScore() {
        return crossrefScore;
    }

    public void setCrossrefScore(Double crossrefScore) {
        this.crossrefScore = crossrefScore;
    }

    public ZonedDateTime getCrossrefLastVerified() {
        return crossrefLastVerified;
    }

    public void setCrossrefLastVerified(ZonedDateTime crossrefLastVerified) {
        this.crossrefLastVerified = crossrefLastVerified;
    }

    public JsonNode getCrossrefMetadata() {
        return crossrefMetadata;
    }

    public void setCrossrefMetadata(JsonNode crossrefMetadata) {
        this.crossrefMetadata = crossrefMetadata;
    }

    public String getMetadataSource() {
        return metadataSource;
    }

    public void setMetadataSource(String metadataSource) {
        this.metadataSource = metadataSource;
    }

    public Double getMetadataConfidence() {
        return metadataConfidence;
    }

    public void setMetadataConfidence(Double metadataConfidence) {
        this.metadataConfidence = metadataConfidence;
    }

    public JsonNode getMetadataSourceDetails() {
        return metadataSourceDetails;
    }

    public void setMetadataSourceDetails(JsonNode metadataSourceDetails) {
        this.metadataSourceDetails = metadataSourceDetails;
    }

    public String getSemanticScholarId() {
        return semanticScholarId;
    }

    public void setSemanticScholarId(String semanticScholarId) {
        this.semanticScholarId = semanticScholarId;
    }

    public Boolean getSemanticScholarVerified() {
        return semanticScholarVerified;
    }

    public void setSemanticScholarVerified(Boolean semanticScholarVerified) {
        this.semanticScholarVerified = semanticScholarVerified;
    }

    public Double getSemanticScholarScore() {
        return semanticScholarScore;
    }

    public void setSemanticScholarScore(Double semanticScholarScore) {
        this.semanticScholarScore = semanticScholarScore;
    }

    public ZonedDateTime getSemanticScholarLastVerified() {
        return semanticScholarLastVerified;
    }

    public void setSemanticScholarLastVerified(ZonedDateTime semanticScholarLastVerified) {
        this.semanticScholarLastVerified = semanticScholarLastVerified;
    }

    public JsonNode getSemanticScholarMetadata() {
        return semanticScholarMetadata;
    }

    public void setSemanticScholarMetadata(JsonNode semanticScholarMetadata) {
        this.semanticScholarMetadata = semanticScholarMetadata;
    }

    public String getArxivId() {
        return arxivId;
    }

    public void setArxivId(String arxivId) {
        this.arxivId = arxivId;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", journal='" + journal + '\'' +
                ", year=" + year +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return Objects.equals(id, paper.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
