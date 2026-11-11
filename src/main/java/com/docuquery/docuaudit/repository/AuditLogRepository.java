package com.docuquery.docuaudit.repository;

import com.docuquery.docuaudit.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    // Spring Data JPA automatically implements standard SQL operations here!
}