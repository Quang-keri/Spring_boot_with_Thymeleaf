package hsf302.mvc.demothymeleaf.model;

import lombok.Data;

@Data
public class BookModel {

  private String title;
  private Integer year;

    public BookModel(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
