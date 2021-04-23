package model;

public class TicketStatus {

    private int reimbId;
    private int reimb_status_id;

    public TicketStatus() {
    }

    public TicketStatus(int reimbId, int reimb_status_id) {
        this.reimbId = reimbId;
        this.reimb_status_id = reimb_status_id;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public int getReimb_status_id() {
        return reimb_status_id;
    }

    public void setReimb_status_id(int reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    @Override
    public String toString() {
        return "TicketStatus{" +
                "reimbId=" + reimbId +
                ", reimb_status_id=" + reimb_status_id +
                '}';
    }
}
