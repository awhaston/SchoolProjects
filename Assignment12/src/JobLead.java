/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 12
*/

public class JobLead {
    private String companyName;
    private String contactName;
    private String contactPhone;
    private String jobTitle;
    private String jobDescription;

    public JobLead(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return  "companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
