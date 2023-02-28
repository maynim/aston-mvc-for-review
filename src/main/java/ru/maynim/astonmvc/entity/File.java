package ru.maynim.astonmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "dat_files", schema = "aston_trainee")
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dat_files_id_seq")
    @SequenceGenerator(name = "dat_files_id_seq", sequenceName = "dat_files_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dat_notes_id", nullable = false)
    private Note note;

    public File(Long id, String name, String url, Note note) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.note = note;
    }

    public File() {
    }

    public static FileBuilder builder() {
        return new FileBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public Note getNote() {
        return this.note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof File)) return false;
        final File other = (File) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof File;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        return result;
    }

    public static class FileBuilder {
        private Long id;
        private String name;
        private String url;
        private Note note;

        FileBuilder() {
        }

        public FileBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FileBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FileBuilder url(String url) {
            this.url = url;
            return this;
        }

        public FileBuilder note(Note note) {
            this.note = note;
            return this;
        }

        public File build() {
            return new File(id, name, url, note);
        }

        public String toString() {
            return "File.FileBuilder(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", note=" + this.note + ")";
        }
    }
}
