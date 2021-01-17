import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    @Test
    public void isUrgentTrue() {
        Patient patient = new Patient("Atanas Avramov", Diagnosis.BRONCHITIS, 20);
        assertTrue(patient.isUrgent());
    }
}
