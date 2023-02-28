package ru.maynim.astonmvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dic_roles", schema = "aston_trainee")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dic_roles_id_seq")
    @SequenceGenerator(name = "dic_roles_id_seq", sequenceName = "dic_roles_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Role(Long id, String name, String description, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }

    private static List<User> $default$users() {
        return new ArrayList<>();
    }

    public static RoleBuilder builder() {
        return new RoleBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Role)) return false;
        final Role other = (Role) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public static class RoleBuilder {
        private Long id;
        private String name;
        private String description;
        private List<User> users$value;
        private boolean users$set;

        RoleBuilder() {
        }

        public RoleBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoleBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RoleBuilder users(List<User> users) {
            this.users$value = users;
            this.users$set = true;
            return this;
        }

        public Role build() {
            List<User> users$value = this.users$value;
            if (!this.users$set) {
                users$value = Role.$default$users();
            }
            return new Role(id, name, description, users$value);
        }

        public String toString() {
            return "Role.RoleBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", users$value=" + this.users$value + ")";
        }
    }
}
