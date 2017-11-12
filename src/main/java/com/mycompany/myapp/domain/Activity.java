package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.mycompany.myapp.domain.enumeration.Type;

import com.mycompany.myapp.domain.enumeration.City;

import com.mycompany.myapp.domain.enumeration.Level;

/**
 * A Activity.
 */
@Entity
@Table(name = "activity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Activity implements Serializable {

    /*
ABBEVILLE,LILLE_LESQUIN,PTE_DE_LA_HAGUE,CAEN_CARPIQUET,ROUEN_BOOS,REIMS_PRUNAY,BREST_GUIPAVAS,PLOUMANACH,RENNES_ST_JACQUES,ALENCON,ORLY,TROYES_BARBEREY,NANCY_OCHEY,STRASBOURG_ENTZHEIM,BELLE_ILE_LE_TALUT,NANTES_BOUGUENAIS,TOURS,BOURGES,DIJON_LONGVIC,BALE_MULHOUSE,PTE_DE_CHASSIRON,POITIERS_BIARD,LIMOGES_BELLEGARDE,CLERMONT_FD,LE_PUY_LOUDES,LYON_ST_EXUPERY,BORDEAUX_MERIGNAC,GOURDON,MILLAU,MONTELIMAR,EMBRUN,MONT_DE_MARSAN,TARBES_OSSUN,ST_GIRONS,TOULOUSE_BLAGNAC,MONTPELLIER,MARIGNANE,CAP_CEPET,NICE,PERPIGNAN,AJACCIO,BASTIA,GLORIEUSES,JUAN_DE_NOVA,EUROPA,TROMELIN,GILLOT_AEROPORT,NOUVELLE_AMSTERDAM,CROZET,KERGUELEN,PAMANDZI,ST_PIERRE,LA_DESIRADE_METEO,ST_BARTHELEMY_METEO,LE_RAIZET_AERO,TRINITE_CARAVEL,LAMENTIN_AERO,SAINT_LAURENT,CAYENNE_MATOURY,SAINT_GEORGES,MARIPASOULA,DUMONT_DURVILLE
*/

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private Type type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "city", nullable = false)
    private City city;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_level", nullable = false)
    private Level level;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @NotNull
    @JoinTable(name = "activity_user",
               joinColumns = @JoinColumn(name="activities_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="users_id", referencedColumnName="id"))
    private Set<User> users = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public Activity type(Type type) {
        this.type = type;
        return this;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public Activity city(City city) {
        this.city = city;
        return this;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Level getLevel() {
        return level;
    }

    public Activity level(Level level) {
        this.level = level;
        return this;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Activity users(Set<User> users) {
        this.users = users;
        return this;
    }

    public Activity addUser(User user) {
        this.users.add(user);
        //user.getActivities().add(this);
        return this;
    }

    public Activity removeUser(User user) {
        this.users.remove(user);
       // user.getActivities().remove(this);
        return this;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Activity activity = (Activity) o;
        if (activity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Activity{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", city='" + getCity() + "'" +
            ", level='" + getLevel() + "'" +
            "}";
    }
}
