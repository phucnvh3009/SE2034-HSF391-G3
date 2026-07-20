package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_key", nullable = false, unique = true, length = 100)
    private String permissionKey; // E.g., "CAN_APPROVE_BOOKING", "CAN_VIEW_REPORT"

    @Column(name = "description", nullable = false, columnDefinition = "NVARCHAR(500)")
    private String description;
}
