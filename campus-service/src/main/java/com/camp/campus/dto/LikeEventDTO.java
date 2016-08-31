package com.camp.campus.dto;

public class LikeEventDTO extends EventDTO {

    private Long likeProfileId;

    public LikeEventDTO() {
        super();
    }

    public LikeEventDTO(Long profileId, Long likeProfileId) {
        this.setProfileId(profileId);
        this.likeProfileId = likeProfileId;
    }

    public Long getLikeProfileId() {
        return likeProfileId;
    }

    public void setLikeProfileId(Long likeProfileId) {
        this.likeProfileId = likeProfileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LikeEventDTO that = (LikeEventDTO) o;

        return likeProfileId != null ? likeProfileId.equals(that.likeProfileId) : that.likeProfileId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (likeProfileId != null ? likeProfileId.hashCode() : 0);
        return result;
    }
}
