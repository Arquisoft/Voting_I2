package es.uniovi.asw.votingdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "polling_station")
public class PollingStation implements Serializable {
    @Id
    @GeneratedValue
    private long polling_station_code;

    private String province;
    private String city;
    private String district;
    private String country;

    @OneToMany(mappedBy = "pollingStation")
    private Set<Voter> voters=new HashSet<Voter>();

    @OneToMany(mappedBy = "pollingStation")
    private Set<Vote> votes=new HashSet<Vote>();

    public PollingStation() {
    }

    public PollingStation(String province, String city, String district, String country) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.country = country;
    }

    /**
     * Solo para los tests de modelo
     */
    public void setPolling_station_code(Long id) { this.polling_station_code=id; }

    public long getPolling_station_code() {
        return polling_station_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    protected Set<Voter> _getVoters() { return voters; }

    public Set<Voter> getVoters() {
        return new HashSet<Voter>(voters);
    }

   /* public void addVoter(Voter v)
    {
        Association.Belong.link(v,this);
    }

    public void removeVoter(Voter v) { Association.Belong.unlink(v,this); }*/

    public void setVoters(Set<Voter> voters) {
        this.voters = voters;
    }

    protected Set<Vote> _getVotes() {
        return votes;
    }

    public Set<Vote> getVotes() {
        return new HashSet<Vote>(votes);
    }

   /* public void addVote(Vote v)
    {
        Association.Exercise.link(this,v);
    }

    public void removeVote(Vote v)
    {
        Association.Exercise.unlink(this,v);
    }*/

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        PollingStation that = (PollingStation) object;

        if (polling_station_code != that.polling_station_code) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (polling_station_code ^ (polling_station_code >>> 32));
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PollingStation{" +
                "polling_station_code=" + polling_station_code +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
