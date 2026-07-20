package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.fpt.model.constant.BillStatus;
import vn.edu.fpt.model.constant.BillType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_code", length = 50, unique = true, nullable = false)
    private String billCode; // Mã hóa đơn tự sinh (ví dụ: HD-101-2026-0001)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student; // Sinh viên phải đóng tiền (nhận hóa đơn)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester; // Thuộc kỳ học nào

    @Enumerated(EnumType.STRING)
    @Column(name = "bill_type", length = 20, nullable = false)
    private BillType billType; // ROOM_BILL, UTILITY_BILL, PUNISH_BILL

    @Column(name = "amount", nullable = false)
    private BigDecimal amount; // Số tiền phải đóng

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private BillStatus status; // UNPAID, PAID, OVERDUE, REFUNDED

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate; // Ngày phát hành hóa đơn

    @Column(name = "payment_deadline", nullable = false)
    private LocalDate paymentDeadline; // Hạn chót phải đóng tiền

    @Column(name = "description", columnDefinition = "NVARCHAR(500)")
    private String description; // Mô tả (lưu lý do phạt nếu là PUNISH_BILL)
}
