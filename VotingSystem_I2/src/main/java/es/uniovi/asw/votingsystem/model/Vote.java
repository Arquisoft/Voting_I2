package es.uniovi.asw.votingsystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vote")
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "option_option_id")
    private int option;
    @Column(name = "pollingstation_polling_station_code")
    private int pollingStationCode = 1;

    public Vote() {
    }

    public Vote(String option) {
        switch (option) {
            case "PP":
                this.option = 1;
                break;
            case "PSOE":
                this.option = 2;
                break;
            case "CIUDADANOS":
                this.option = 3;
                break;
            case "PODEMOS":
                this.option = 4;
                break;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getPollingStationCode() {
        return pollingStationCode;
    }

    public void setPollingStationCode(int pollingStation) {
        this.pollingStationCode = pollingStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        return id == vote.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Vote{" +
                "option=" + option +
                ", pollingStation=" + pollingStationCode +
                '}';
    }
}

