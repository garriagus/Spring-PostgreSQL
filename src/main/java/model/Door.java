package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doors")
public class Door {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ip_address", unique = true)
    private String ipAddress;

    @Column(name = "door_name")
    private String doorName;

    @ManyToMany(mappedBy = "doors")
    private List<RFIDKey> rfidKeys;

    public Door(String ipAddress, String doorName) {
        this.ipAddress = ipAddress;
        this.doorName = doorName;
    }

}
