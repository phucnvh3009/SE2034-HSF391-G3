package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "room_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomType extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String typeName; // Ví dụ: "Phòng thường 8 giường", "Phòng VIP 4 giường điều hòa"

    @Column(name = "price", nullable = false)
    private BigDecimal price; // Giá tiền thuê của loại phòng này

    @Column(name = "description", columnDefinition = "NVARCHAR(500)")
    private String description; // Mô tả tiện ích đi kèm (điều hòa, tủ lạnh...)
}
