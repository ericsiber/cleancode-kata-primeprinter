import java.time.LocalDate;

public class Exercise1 {

    private final LocalDate expirationDate;
    private final Boolean approvedForConsumption;
    private final Integer inspectorId;

    public Exercise1(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return this.expirationDate.isAfter(LocalDate.now()) &&
                this.approvedForConsumption &&
                this.inspectorId != null;
    }
}