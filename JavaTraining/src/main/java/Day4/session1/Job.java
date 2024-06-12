package Day4.session1;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Job {





        private int jobId;
        private String jobName;
        private int locationId;

        public Job() {
        }

        public Job(int jobId, String jobName, int locationId) {
            this.jobId = jobId;
            this.jobName = jobName;
            this.locationId = locationId;
        }

        public Job(ResultSet rs) throws SQLException {
            jobId = rs.getInt("job_id");
            jobName = rs.getString("job_name");
            locationId = rs.getInt("location_id");
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public int getLocationId() {
            return locationId;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "jobId=" + jobId +
                    ", jobName='" + jobName + '\'' +
                    ", locationId=" + locationId +
                    '}';
        }
    }

