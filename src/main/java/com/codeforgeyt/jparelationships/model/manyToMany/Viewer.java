package com.codeforgeyt.jparelationships.model.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Viewer")
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    @ManyToMany
    @JoinTable(
            name = "followed_streams",
            joinColumns = @JoinColumn(name = "viewer_id"),
            inverseJoinColumns = @JoinColumn(name = "stream_id")
    )
    private List<Stream> followedStreams = new ArrayList<>();

    public Viewer(String nickname) {
        this.nickname = nickname;
    }

    public void followStream(Stream stream){
        followedStreams.add(stream);
    }
}
