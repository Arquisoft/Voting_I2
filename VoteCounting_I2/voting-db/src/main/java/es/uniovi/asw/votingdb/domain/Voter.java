package es.uniovi.asw.votingdb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voter")
public class Voter implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(unique = true, length = 9, nullable = false)
    private String nif;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    private PollingStation pollingStation;

    private String password;
    private String salt;

    private boolean has_evoted; //electronically voted
    private boolean has_pvoted; //phisically voted

    public Voter() {
    }

   public Voter(String name, String nif, String email) {
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.password = "plain";
    }

    public Voter(String name, String nif, String email, PollingStation pollingStation, String password) {
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.pollingStation = pollingStation;
        this.password = password;
        this.has_evoted = false;
        this.has_pvoted = false;

        Association.Belong.link(this,pollingStation);
    }
    public Voter(long id, String name, String nif, String email, PollingStation pollingStation, String password, boolean has_evoted, boolean has_pvoted) {
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.pollingStation = pollingStation;
        this.password = password;
        this.has_evoted = has_evoted;
        this.has_pvoted = has_pvoted;

        Association.Belong.link(this,pollingStation);
    }

    /**
     * Solo para los tests de modelo
     */
    public void setId(Long id) { this.id=id; }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PollingStation getPollingStation() {
        return pollingStation;
    }

    public void setPollingStation(PollingStation pollingStation) {
        this.pollingStation = pollingStation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHas_evoted() {return has_evoted;}

    public boolean isHas_pvoted() {return has_pvoted;}

    public void setHas_evoted(boolean has_evoted) {this.has_evoted = has_evoted;}

    public void setHas_pvoted(boolean has_pvoted) {this.has_pvoted = has_pvoted;}

    public String getSalt() { return salt; }

    public void setSalt(String salt) { this.salt = salt;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;

        return nif.equals(voter.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", pollingStationCode='" + pollingStation + '\'' +
                ", password='" + password + '\'' +
                ", has_evoted=" + has_evoted +
                ", has_pvoted=" + has_pvoted +
                '}';
    }
}
