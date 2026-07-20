package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.fpt.model.constant.ContractStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_code", length = 50, unique = true, nullable = false)
    private String contractCode; // Mã hợp đồng tự sinh (ví dụ: HD-2026-0001)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student; // Sinh viên thuê phòng (Role: ROLE_STUDENT)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed; // Giường cụ thể được thuê

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester; // Thuộc kỳ học nào

    @Column(name = "price", nullable = false)
    private BigDecimal price; // Giá thuê chốt thực tế (copy từ RoomType)

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30, nullable = false)
    private ContractStatus status; // PENDING_APPROVAL, ACTIVE, CHECKED_OUT, CANCELED

    @Column(name = "checked_out_at")
    private LocalDateTime checkedOutAt; // Thời điểm thực tế sinh viên checkout dọn ra ngoài

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checked_out_by")
    private User checkedOutBy; // Manager thực hiện thủ tục checkout
}
