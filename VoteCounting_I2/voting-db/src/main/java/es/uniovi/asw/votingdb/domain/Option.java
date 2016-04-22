package es.uniovi.asw.votingdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "toption")
public class Option implements Serializable {
    @Id
    @GeneratedValue
    private long option_id;

    @Column//pendiente de confirmar con el otro grupo
    private String name;

    private String comment;

    @OneToMany(mappedBy = "option")
    private Set<Vote> votes=new HashSet<Vote>();

    public Option() {
    }

    public Option(String name,String comment) {
        this.comment = comment;
        this.name = name;
    }

    /**
     * Solo para los tests de modelo
     */
    public void setOption_id(Long id) { this.option_id=id; }

    public long getOption_id() {
        return option_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    protected Set<Vote> _getVotes() {
        return votes;
    }

    public Set<Vote> getVotes() {
        return new HashSet(votes);
    }
/**
    public void addVote(Vote v)
    {
        Association.InFavorOf.link(this,v);
    }

    public void removeVote(Vote v)
    {
        Association.InFavorOf.unlink(this,v);
    }
**/
    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        return option_id == option.option_id;

    }

    @Override
    public int hashCode() {
        return (int) (option_id ^ (option_id >>> 32));
    }

    @Override
    public String toString() {
        return "Option{" +
                "option_id=" + option_id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
