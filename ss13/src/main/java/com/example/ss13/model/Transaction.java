package com.example.ss13.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Transaction {
    private Integer id;

    @NotBlank(message = "{transaction.description.notblank}")
    private String description;

    @NotNull(message = "{transaction.amount.notnull}")
    private BigDecimal amount;

    @NotBlank(message = "{transaction.type.notblank}")
    private String type;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
