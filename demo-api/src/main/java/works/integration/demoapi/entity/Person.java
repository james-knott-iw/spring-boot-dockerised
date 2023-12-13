package works.integration.demoapi.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = AccessMode.READ_ONLY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Address cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Schema(accessMode = AccessMode.READ_ONLY)
    private Set<Pet> pets;

}
