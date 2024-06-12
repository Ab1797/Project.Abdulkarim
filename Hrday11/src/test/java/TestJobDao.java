import org.example.dao.JobDAO;
import org.example.modle.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJobDao {

    @InjectMocks
    JobDAO dao;

    @Mock
    Job job;

    @Test
    public void updateJob() throws SQLException , ClassNotFoundException{
        when(job.getJob_id()).thenReturn(1);
        when(job.getJob_title()).thenReturn("SOFT");
        when(job.getMax_salary()).thenReturn(2032.5);
        when(job.getMin_salary()).thenReturn(8796.0);

        Assertions.assertDoesNotThrow(() -> dao.updateJob(job));

        Job newA = dao.selectJob(job.getJob_id());

        Assertions.assertEquals(newA.getJob_id(), job.getJob_id());
        Assertions.assertEquals(newA.getJob_title(), job.getJob_title());
        Assertions.assertEquals(newA.getMin_salary(), job.getMin_salary());
        Assertions.assertEquals(newA.getMax_salary(), job.getMax_salary());
    }
}