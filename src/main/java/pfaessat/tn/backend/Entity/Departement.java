package pfaessat.tn.backend.Entity;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "departements",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title"),
                @UniqueConstraint(columnNames = "description")
        })
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;




    private String description;

  /*  @OneToMany(mappedBy="departement")
    @JsonManagedReference
    private Collection<User> user;



    @OneToMany(mappedBy="departementt")
    @JsonManagedReference
    private Collection<Project> project;*/


    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<User> users;
/*
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Project> projects;*/


    public Departement() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Departement(String title,String description) {
        this.title = title;
        this.description=description;
    }

    public Departement(Long id) {
        this.id = id;
    }


}
