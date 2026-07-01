package vn.edu.fpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill; // Thuộc hóa đơn nào

    @Column(name = "payment_method", length = 30, nullable = false)
    private String paymentMethod; // E.g., "VNPAY", "MOMO", "BANK_TRANSFER_QR"

    @Column(name = "txn_ref", length = 100, unique = true, nullable = false)
    private String txnRef; // Mã giao dịch trả về từ cổng thanh toán

    @Column(name = "amount", nullable = false)
    private BigDecimal amount; // Số tiền giao dịch thực tế

    @Column(name = "status", length = 20, nullable = false)
    private String status; // "SUCCESS", "FAILED", "PENDING"

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate; // Thời điểm giao dịch thành công
}
