package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "utility_usages",
       uniqueConstraints = @UniqueConstraint(columnNames = {"room_id", "semester_id", "recorded_month", "recorded_year"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilityUsage extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room; // Phòng được ghi điện nước

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester; // Ghi cho học kỳ nào

    @Column(name = "recorded_month", nullable = false)
    private Integer recordedMonth; // Tháng ghi nhận (1 - 12)

    @Column(name = "recorded_year", nullable = false)
    private Integer recordedYear; // Năm ghi nhận (ví dụ: 2026)

    @Column(name = "start_electricity", nullable = false)
    private Integer startElectricity; // Số điện đầu tháng

    @Column(name = "end_electricity", nullable = false)
    private Integer endElectricity; // Số điện cuối tháng (để tính số tiêu thụ)

    @Column(name = "start_water", nullable = false)
    private Integer startWater; // Số nước đầu tháng

    @Column(name = "end_water", nullable = false)
    private Integer endWater; // Số nước cuối tháng

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recorded_by")
    private User recordedBy; // Nhân viên ghi số

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt; // Thời điểm ghi
}
