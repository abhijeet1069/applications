package manning.assumptions;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

    private boolean isDatabaseAvailable() {
        try (Connection conn =
                     DriverManager.getConnection("jdbc:h2:mem:testdb")) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    void shouldFetchUserFromDatabase() {

        // 🔥 Skip test if DB not available
        assumeTrue(isDatabaseAvailable(), "Database is not available");

        // Actual test logic
        String user = "Satyam"; // imagine fetching from DB

        assertEquals("Satyam", user);
    }
}
