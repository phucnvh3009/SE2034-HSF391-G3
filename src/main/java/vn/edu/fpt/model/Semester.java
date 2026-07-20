package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "semesters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semester extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "NVARCHAR(50)")
    private String name; // Ví dụ: "Summer2026", "Fall2026"

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate; // Ngày bắt đầu kỳ ở

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate; // Ngày kết thúc kỳ ở

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false; // Đánh dấu kỳ học hiện tại đang diễn ra
}
