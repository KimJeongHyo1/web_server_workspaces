package com.sh.mvc.board.model.entity;

import java.time.LocalDateTime;

public class Attachment {
    private long id;
    private long boardId;
    private String originalFilename;
    private String renameFilename;
    private LocalDateTime regDate;

    public Attachment() {
    }

    public Attachment(long id, long boardId, String originalFilename, String renameFilename, LocalDateTime regDate) {
        this.id = id;
        this.boardId = boardId;
        this.originalFilename = originalFilename;
        this.renameFilename = renameFilename;
        this.regDate = regDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getRenameFilename() {
        return renameFilename;
    }

    public void setRenameFilename(String renameFilename) {
        this.renameFilename = renameFilename;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", boardId=" + boardId +
                ", originalFilename='" + originalFilename + '\'' +
                ", renameFilename='" + renameFilename + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}