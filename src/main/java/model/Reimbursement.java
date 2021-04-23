package model;

import java.sql.Date;

public class Reimbursement {

    //Do you need a timestamp when creating an reimbursement object?
    //I dont believe so..
    //What about they bytea image object?


    private int reimbId;
    private int amount;
    private Date submitted;
    private Date resolved;
    private String description;
    private int author;
    private String strAuthor;
    private int resolver;
    private String strResolver;
    private int statusId;
    private String status;
    private int typeId;
    private String type;


    public Reimbursement() {
    }


    public Reimbursement(int reimbId, int amount, Date submitted, Date resolved, String description, String strAuthor, String status, String type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.strAuthor = strAuthor;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(int amount, Date submitted, Date resolved, String description, String strAuthor, String status, String type) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.strAuthor = strAuthor;
        this.status = status;
        this.type = type;
    }


    public Reimbursement(int amount, String description, int author, int statusId, int typeId) {
        this.amount = amount;
        this.description = description;
        this.author = author;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getStrAuthor() {
        return strAuthor;
    }

    public void setStrAuthor(String strAuthor) {
        this.strAuthor = strAuthor;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public String getStrResolver() {
        return strResolver;
    }

    public void setStrResolver(String strResolver) {
        this.strResolver = strResolver;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", strAuthor='" + strAuthor + '\'' +
                ", resolver=" + resolver +
                ", strResolver='" + strResolver + '\'' +
                ", statusId=" + statusId +
                ", status='" + status + '\'' +
                ", typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}
