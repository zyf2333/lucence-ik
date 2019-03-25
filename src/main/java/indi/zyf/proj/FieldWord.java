package indi.zyf.proj;

public class FieldWord {

    private Integer fieldId;

    private String word;

    public FieldWord() {
    }

    public FieldWord(Integer fieldId, String word) {
        this.fieldId = fieldId;
        this.word = word;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "FieldWord{" +
                "fieldId=" + fieldId +
                ", word='" + word + '\'' +
                '}';
    }
}
