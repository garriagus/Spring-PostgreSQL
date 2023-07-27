package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rfid_keys")
public class RFIDKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "key_serial_number")
    private String keySerialNumber;

    @Column(name = "key_type")
    private String keyType;

	@ManyToOne
	private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "rfid_key_door_mapping",
            joinColumns = @JoinColumn(name = "rfid_key_id"),
            inverseJoinColumns = @JoinColumn(name = "door_id")
    )
    private List<Door> doors;


    
}
