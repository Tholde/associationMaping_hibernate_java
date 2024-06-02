package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "association")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //    @OneToMany(cascade = CascadeType.PERSIST)
    @OneToMany(cascade = CascadeType.ALL) //tsy mampiasa session.save(member) sasy nao mampiasa anio cascade io
    @JoinTable(name = "association_member", joinColumns = @JoinColumn(name = "association_id"),
            inverseJoinColumns = @JoinColumn(name = "members_id"))
    private List<Member> members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
