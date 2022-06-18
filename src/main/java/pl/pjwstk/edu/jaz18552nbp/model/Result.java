package pl.pjwstk.edu.jaz18552nbp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@ApiModel("Data about your inquiry")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1, value = "unique id of your inquiry")
    private Long id;
    @ApiModelProperty(position = 2, value = "provided catgeory (GOLD)")
    @Enumerated(EnumType.STRING)
    private Category category;
    @ApiModelProperty(position = 3, value = "start of the time period")
    private LocalDate startDate;
    @ApiModelProperty(position = 4, value = "end of the time period")
    private LocalDate endDate;
    @ApiModelProperty(position = 5, value = "calculated average prize")
    private double price;
    @ApiModelProperty(position = 6, value = "date of the query")
    private LocalDateTime executeQuestion;

    public Result() {
    }

    public Result(Long id, Category category, LocalDate startDate, LocalDate endDate, double price, LocalDateTime executeQuestion) {
        this.id = id;
        this.category = Category.GOLD;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.executeQuestion = executeQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getExecuteQuestion() {
        return executeQuestion;
    }

    public void setExecuteQuestion(LocalDateTime executeQuestion) {
        this.executeQuestion = executeQuestion;
    }
}
