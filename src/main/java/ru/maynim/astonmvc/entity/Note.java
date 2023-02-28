package ru.maynim.astonmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "dat_notes", schema = "aston_trainee")
public class Note {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dat_notes_id_seq")
    @SequenceGenerator(name = "dat_notes_id_seq", sequenceName = "dat_notes_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dat_users_id", nullable = false)
    private User user;

    public Note(Long id, String name, String content, User user) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.user = user;
    }

    public Note() {
    }

    public static NoteBuilder builder() {
        return new NoteBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public User getUser() {
        return this.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Note)) return false;
        final Note other = (Note) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Note;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public static class NoteBuilder {
        private Long id;
        private String name;
        private String content;
        private User user;

        NoteBuilder() {
        }

        public NoteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NoteBuilder name(String name) {
            this.name = name;
            return this;
        }

        public NoteBuilder content(String content) {
            this.content = content;
            return this;
        }

        public NoteBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Note build() {
            return new Note(id, name, content, user);
        }

        public String toString() {
            return "Note.NoteBuilder(id=" + this.id + ", name=" + this.name + ", content=" + this.content + ", user=" + this.user + ")";
        }
    }
}
