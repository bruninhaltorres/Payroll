package src.payment;

public class CheckMail extends Payment {
    private int idEmployee;
    private String recipient; // Destinatario
    private String sender; // Remetente

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public CheckMail(int id, String recipient, String sender){
        setIdEmployee(id);
        setRecipient(recipient);
        setSender(sender);
    }
}