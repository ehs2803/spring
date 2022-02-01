package hellojpa.jpashop.domain;

import javax.persistence.*;

@Entity
@NamedQuery(
	 name = "Member.findByUsername",
 	query="select m from Member m where m.username = :username")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Period period;

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
