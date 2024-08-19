package pfaessat.tn.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Project",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})

public class Project {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    //private String members;

    private String ProjectCreator;
    private LocalDate startDate;
    private LocalDate endDate;
   // private float progress;

    /*
    @ManyToOne
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    private Departement departementt;*/
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    private Departement departement;*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_User",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();
    public Project() {
        super();
    }

    public Project(String ProjectName, String ProjectCreator, LocalDate startDate, LocalDate endDate) {
        this.name = ProjectName;
     //   this.members = members;
        this.ProjectCreator = ProjectCreator;
        this.startDate = startDate;
        this.endDate = endDate;


    }


}
